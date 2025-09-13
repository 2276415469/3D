package xuanmi.ning.user.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xuanmi.ning.user.application.command.LoginCommand;
import xuanmi.ning.user.application.command.PayCommand;
import xuanmi.ning.common.events.DomainEvent;
import xuanmi.ning.common.events.EventBus;
import xuanmi.ning.common.result.DomainResult;
import xuanmi.ning.user.domain.model.aggregate.UserAgg;
import xuanmi.ning.user.domain.service.UserDomainService;
import xuanmi.ning.user.infrastructure.acl.PayAclService;
import xuanmi.ning.user.infrastructure.acl.PayApiParam;
import xuanmi.ning.user.infrastructure.repository.UserCommandRepository;
import xuanmi.ning.user.infrastructure.repository.UserQueryRepository;

@Component
public class UserAppApplication {
    @Autowired
    private UserDomainService userDomainService;
    @Autowired
    private PayAclService payAclService;
    @Autowired
    private UserQueryRepository userQueryRepository;
    @Autowired
    private UserCommandRepository userCommandRepository;
    @Autowired
    private EventBus eventBus;
    //如果逻辑简单 只涉及单个聚合根 可以不经过域服务对象
    public Object login(LoginCommand loginCommand){
        // 传入领域服务就已经需要是聚合根了 也就是说把需要的组装好 让领域只去处理逻辑
        UserAgg userAgg = userQueryRepository.query(loginCommand.getPassword() + loginCommand.getUsername());

        //调用领域服务
        DomainResult domainResult = userDomainService.login(userAgg);

        //持久化聚合根 这里的聚合根已经是修改过的了
        userCommandRepository.save(userAgg);

        //发布事件
        for (DomainEvent event : domainResult.getEvents()) {
            eventBus.publish(event);
        }

        return domainResult;

    }

    public Object pay(PayCommand payCommand){

        UserAgg userAgg = userQueryRepository.query("seek");

        //调用领域服务
        DomainResult domainResult = userDomainService.pay(userAgg);

        //防腐层与外部域交互
        PayApiParam payApiParam = PayApiParam.builder().build();
        payAclService.pay(payApiParam);

        //持久化聚合根 这里的聚合根已经是修改过的了
        userCommandRepository.save(userAgg);

        //发布事件 只发布自己的事件
        for (DomainEvent event : domainResult.getEvents()) {
            eventBus.publish(event);
        }


        return null;
    }
}
