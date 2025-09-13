package xuanmi.ning.common.events;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import xuanmi.ning.pay.domain.event.PayEvent;
import xuanmi.ning.user.domain.event.UserEvent;

@Component
public class Listener {
    @EventListener
    public void listen(DomainEvent event) {
        if (event instanceof UserEvent) {
            System.out.println("handler userevent");
        } else if (event instanceof PayEvent) {
            System.out.println("handler payevent");
        }
    }
}
