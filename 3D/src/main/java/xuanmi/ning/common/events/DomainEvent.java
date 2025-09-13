package xuanmi.ning.common.events;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DomainEvent {
    private final LocalDateTime occurredOn = LocalDateTime.now();
    private final String type;
    private final String label;
    public DomainEvent(String type, String label){
        this.type = type;
        this.label = label;
    }
}
