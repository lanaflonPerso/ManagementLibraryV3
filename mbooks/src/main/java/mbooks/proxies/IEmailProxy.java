package mbooks.proxies;

import mbooks.technical.email.EmailWrapper;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "zuul-server",contextId = "emailProxy")
@RibbonClient(name = "microservice-emails")
@RequestMapping("/microservice-emails/email")
public interface IEmailProxy {

    @PostMapping("/sendRevival")
    String sendAgainEmail(@RequestBody List<EmailWrapper> emailWrapperList);
}
