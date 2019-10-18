package com.library.proxies;

import com.library.beans.mbooks.book.author.AuthorBean;
import com.library.beans.mbooks.book.author.AuthorCreateBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "zuul-server",contextId = "authorProxy")
@RibbonClient(name = "microservice-books")
@RequestMapping("/microservice-books/author")
public interface IAuthorProxy {

    @GetMapping("/{id}")
    AuthorBean find(@PathVariable("id") Long id);

    @GetMapping("/all")
    List<AuthorBean> list();

    @PostMapping("/save")
    AuthorBean save( @RequestBody AuthorCreateBean author);

    @PutMapping("/update")
    AuthorBean update( @RequestBody AuthorBean author);

    @DeleteMapping("/{id}")
    boolean delete(@PathVariable("id") Long id);
}
