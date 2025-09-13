package xuanmi.ning.user.infrastructure.repository;

import org.springframework.stereotype.Component;
import xuanmi.ning.user.domain.model.aggregate.UserAgg;

@Component
public class UserCommandRepository {
    public void save(UserAgg userAgg){
        System.out.println("save userAgg");
    }
}
