package xuanmi.ning.pay.domain.event;

import lombok.Data;
import xuanmi.ning.common.events.DomainEvent;
import xuanmi.ning.user.domain.model.valueobject.UserAggId;
import xuanmi.ning.pay.domain.model.Money;

@Data
public class PayEvent extends DomainEvent {
    UserAggId userAggId;
    Money money;

    public PayEvent() {
        super("none","none");
    }

    public PayEvent(Money money, UserAggId userAggId, String type,String  label) {
        super(type,label);
        this.money = money;
        this.userAggId = userAggId;
    }
}
