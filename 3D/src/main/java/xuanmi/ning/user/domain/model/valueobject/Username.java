package xuanmi.ning.user.domain.model.valueobject;

import lombok.Data;

@Data
public class Username {

    public String value;
    public Boolean matches(String username){
        return true;
    }
}
