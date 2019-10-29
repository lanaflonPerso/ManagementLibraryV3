package mbooks.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "zuul-server",contextId = "emailProxy")
@RibbonClient(name = "microservice-emails")
@RequestMapping("/microservice-emails/email")
public interface IEmailProxy {

    @GetMapping("/send/{to}/{book}/{endDate}")
    String sendAgainEmail(@PathVariable("to") String to, @PathVariable("book") String book, @PathVariable("endDate")String endDate);
}
