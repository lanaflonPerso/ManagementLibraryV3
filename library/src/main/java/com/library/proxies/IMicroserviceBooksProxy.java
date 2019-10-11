package com.library.proxies;

import com.library.beans.mbooks.book.LanguageBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "microservice-books",url = "localhost:9001")
public interface IMicroserviceBooksProxy {

    @GetMapping("/Language/all")
    List<LanguageBean> languageList();
}
