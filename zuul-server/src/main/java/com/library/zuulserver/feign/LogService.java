package com.library.zuulserver.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import com.library.zuulserver.model.Log;


@FeignClient("log-service")
public interface LogService {

    @PostMapping(value = "/log")
    void recordZuulInteractions(Log log);
}
