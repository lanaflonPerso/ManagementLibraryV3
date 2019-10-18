package com.library.proxies;

import com.library.beans.mbooks.book.edition.EditionBean;
import com.library.beans.mbooks.book.edition.EditionCreateBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "zuul-server",contextId = "editionProxy")
@RibbonClient(name = "microservice-books")
@RequestMapping("/microservice-books/edition")
public interface IEditionProxy {

    @GetMapping("/{id}")
    EditionBean find(@PathVariable("id") Long id);

    @GetMapping("/all")
    List<EditionBean> list();

    @PostMapping("/save")
    EditionBean save( @RequestBody EditionCreateBean edition);

    @PutMapping("/update")
    EditionBean update( @RequestBody EditionBean edition);

    @DeleteMapping("/{id}")
    boolean delete(@PathVariable("id") Long id);
}
