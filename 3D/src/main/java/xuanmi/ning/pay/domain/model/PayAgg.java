package xuanmi.ning.pay.domain.model;

import lombok.Builder;
import lombok.Data;
import xuanmi.ning.user.domain.model.valueobject.UserAggId;
import xuanmi.ning.common.events.DomainEvent;
import xuanmi.ning.pay.domain.event.PayEvent;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class PayAgg {
    UserAggId userAggId;
    Money money;
    List<DomainEvent> events = new ArrayList<>();

    void addEvent(DomainEvent event) {
        events.add(event);
    }

    public void pay(){
        PayEvent payEvent = new PayEvent(money, userAggId, "c", "c");
        addEvent(payEvent);
    }
}
