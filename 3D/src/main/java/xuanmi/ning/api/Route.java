package xuanmi.ning.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xuanmi.ning.user.application.command.LoginCommand;
import xuanmi.ning.user.application.command.PayCommand;
import xuanmi.ning.common.result.Result;
import xuanmi.ning.user.application.UserAppApplication;

@RestController
public class Route {
    //暴露api 使用restApi webApi grpc dubbo feign都可以 看你的使用方是哪里

    @Autowired
    private UserAppApplication userAppApplication;

    @GetMapping("/login")
    public Object home(LoginCommand command) {
        userAppApplication.login(command);
        return Result.success();
    }

    @GetMapping("/pay")
    public Object pay(PayCommand payCommand) {
        userAppApplication.pay(payCommand);
        return Result.success();
    }
}
