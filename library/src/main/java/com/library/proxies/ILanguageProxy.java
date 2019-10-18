package com.library.proxies;

import com.library.beans.mbooks.book.language.LanguageBean;
import com.library.beans.mbooks.book.language.LanguageCreateBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "zuul-server",contextId = "languageProxy")
@RibbonClient(name = "microservice-books")
@RequestMapping("/microservice-books/language")
public interface ILanguageProxy {

    @GetMapping("/{id}")
    LanguageBean find(@PathVariable("id") Long id);

    @GetMapping("/all")
    List<LanguageBean> list();

    @PostMapping("/save")
    LanguageBean save( @RequestBody LanguageCreateBean language);

    @PutMapping("/update")
    LanguageBean update( @RequestBody LanguageBean language);

    @DeleteMapping("/{id}")
    boolean delete(@PathVariable("id") Long id);
}
