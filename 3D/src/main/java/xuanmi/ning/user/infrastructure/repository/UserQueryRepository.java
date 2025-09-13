package xuanmi.ning.user.infrastructure.repository;

import org.springframework.stereotype.Component;
import xuanmi.ning.user.domain.model.aggregate.UserAgg;

@Component
public class UserQueryRepository {
    public UserAgg query(String query){
        System.out.println("query user");
        // 正常这里就是去数据库查询 然后组装出聚合根
        //涉及到多个数据库底层屏蔽等操作
        UserAgg userAgg = new UserAgg();
        return userAgg;
    }
}
