package xuanmi.ning.user.domain.service;

import org.springframework.stereotype.Component;
import xuanmi.ning.common.result.DomainResult;
import xuanmi.ning.user.domain.model.aggregate.UserAgg;

/**
 * 领域服务应该只负责逻辑
 */
@Component
public class UserDomainService {
    //修改了聚合根就认为是修改了数据库 难怪需要直接更新这里的数据
    public DomainResult login(UserAgg userAgg){
        userAgg.login();
        DomainResult result = new DomainResult();
        result.setEvents(userAgg.getEvents());
        return result;
    }

    public DomainResult pay(UserAgg userAgg){
        userAgg.pay();
        DomainResult result = new DomainResult();
        result.setEvents(userAgg.getEvents());
        return result;
    }
}
