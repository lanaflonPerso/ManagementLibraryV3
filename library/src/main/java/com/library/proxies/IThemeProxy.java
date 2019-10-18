package com.library.proxies;

import com.library.beans.mbooks.book.theme.ThemeBean;
import com.library.beans.mbooks.book.theme.ThemeCreateBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "zuul-server",contextId = "themeProxy")
@RibbonClient(name = "microservice-books")
@RequestMapping("/microservice-books/theme")
public interface IThemeProxy {

    @GetMapping("/{id}")
    ThemeBean find(@PathVariable("id") Long id);

    @GetMapping("/all")
    List<ThemeBean> list();

    @PostMapping("/save")
    ThemeBean save( @RequestBody ThemeCreateBean theme);

    @PutMapping("/update")
    ThemeBean update( @RequestBody ThemeBean theme);

    @DeleteMapping("/{id}")
    boolean delete(@PathVariable("id") Long id);
}
