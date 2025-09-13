package xuanmi.ning.user.domain.event;

import lombok.Data;
import xuanmi.ning.common.events.DomainEvent;

@Data
public class UserEvent extends DomainEvent {
    public String username;
    public String password;

    public UserEvent() {
        super("none","none");
    }

    public UserEvent(String username, String password, String type,String  label) {
        super(type,label);
        this.username = username;
        this.password = password;
    }
}
