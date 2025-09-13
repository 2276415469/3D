package xuanmi.ning.pay.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Money {
    BigDecimal value;
    Integer unit;
}
