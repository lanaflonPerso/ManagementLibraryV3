package com.library.proxies;

import com.library.beans.mbooks.book.CoverBean;
import com.library.beans.mbooks.book.LanguageBean;
import com.library.technical.uploadfile.UploadFileResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient(name = "zuul-server",contextId = "booksProxy")
@RibbonClient(name = "microservice-books")
@RequestMapping("/microservice-books")
public interface IMicroserviceBooksProxy {

    @GetMapping(value = "/language/all")
    List<LanguageBean> languageList();


    @GetMapping("/cover/photo/{fileId}")
    ResponseEntity<Resource> downloadFile(@PathVariable("fileId") String fileId);

    @PostMapping("/cover/uploadFile")
    UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("use") String use);
}
