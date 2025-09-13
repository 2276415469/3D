package xuanmi.ning.user.application.command;

import lombok.Data;

@Data
public class PayCommand {
    Long userId;
    String money;
}
