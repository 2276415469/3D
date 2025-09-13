package xuanmi.ning.pay.domain.service;

import org.springframework.stereotype.Component;
import xuanmi.ning.pay.domain.model.PayAgg;

@Component
public class PayDomainService {

    public void pay(PayAgg payAgg) {
        payAgg.pay();
    }

}
