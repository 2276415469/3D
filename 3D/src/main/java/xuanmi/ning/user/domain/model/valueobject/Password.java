package xuanmi.ning.user.domain.model.valueobject;

import lombok.Data;

@Data
public class Password {
    public String value;
    public Boolean matches(String username){
        return true;
    }
}
