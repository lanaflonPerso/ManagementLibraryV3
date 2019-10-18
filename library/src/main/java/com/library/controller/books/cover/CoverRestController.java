package com.library.controller.books.cover;

import com.library.beans.mbooks.cover.CoverBean;
import com.library.beans.mbooks.cover.CoverCreateBean;
import com.library.proxies.ICoverProxy;
import com.library.service.books.cover.ICoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class CoverRestController {
    @Autowired
    private ICoverService coverService;

    @Autowired
    private ICoverProxy coverProxy;

    @PostMapping( "/cover/upload")
    public String uploadCover(@RequestParam("file") MultipartFile file) {
        CoverCreateBean coverCreateBean = coverService.storeFile( file );

        CoverBean coverBean = coverProxy.save( coverCreateBean );

        return coverBean.getId();
    }


    @GetMapping("/cover/img/{id}")
    public ResponseEntity<Resource> downloadCover(@PathVariable("id") String id){

        CoverBean cover = coverProxy.find( id );
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(cover.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + cover.getFileName() + "\"")
                .body(new ByteArrayResource(cover.getData()));

    }
}
