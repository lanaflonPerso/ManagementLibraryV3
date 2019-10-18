package com.library.proxies;

import com.library.beans.mbooks.cover.CoverBean;
import com.library.beans.mbooks.cover.CoverCreateBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "zuul-server",contextId = "coverProxy")
@RibbonClient(name = "microservice-books")
@RequestMapping("/microservice-books/cover")
public interface ICoverProxy {

    @GetMapping("/{id}")
    CoverBean find(@PathVariable("id") String id);

    @GetMapping("/all")
    List<CoverBean> list();

    @PostMapping("/save")
    CoverBean save( @RequestBody CoverCreateBean cover);

    @PutMapping("/update")
    CoverBean update( @RequestBody CoverBean cover);

    @DeleteMapping("/{id}")
    boolean delete(@PathVariable("id") Long id);
}
