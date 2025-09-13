package xuanmi.ning.common.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventBus {
    @Autowired
    private ApplicationEventPublisher publisher;


    public void publish(DomainEvent event) {
        publisher.publishEvent(event);
    }
}
