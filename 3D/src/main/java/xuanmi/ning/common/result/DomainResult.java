package xuanmi.ning.common.result;

import lombok.Data;
import xuanmi.ning.common.events.DomainEvent;

import java.util.ArrayList;
import java.util.List;

@Data
public class DomainResult {
    List<DomainEvent> events = new ArrayList<>();
}
