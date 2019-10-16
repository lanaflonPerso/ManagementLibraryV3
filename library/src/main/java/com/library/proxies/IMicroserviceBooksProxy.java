package com.library.proxies;


import com.library.beans.mbooks.book.LanguageBean;
import com.library.beans.mbooks.cover.CoverBean;
import com.library.beans.mbooks.cover.CoverCreateBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "zuul-server",contextId = "booksProxy")
@RibbonClient(name = "microservice-books")
@RequestMapping("/microservice-books")
public interface IMicroserviceBooksProxy {



    @GetMapping(value = "/language/all")
    List<LanguageBean> languageList();


    @GetMapping("/cover/{id}")
    CoverBean getCover(@PathVariable("id") String id);

    @GetMapping("/cover/all")
     List<CoverBean> coverList();

    @PostMapping("/cover/save")
    CoverBean save(@RequestBody CoverCreateBean cover);

    @PutMapping("/cover/update")
    void update(@RequestBody CoverBean cover);

    @DeleteMapping("/cover/{id}")
    boolean delete(@PathVariable String id);

}
