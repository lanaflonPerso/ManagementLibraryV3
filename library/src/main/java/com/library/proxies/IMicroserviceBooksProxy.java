package com.library.proxies;

import com.library.beans.mbooks.book.LanguageBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "zuul-server",contextId = "booksProxy")
@RibbonClient(name = "microservice-books")
@RequestMapping("/microservice-books")
public interface IMicroserviceBooksProxy {

    @GetMapping(value = "/language/all")
    List<LanguageBean> languageList();
}
