package com.library.controller.mbooks;

import com.library.beans.mbooks.cover.CoverBean;
import com.library.beans.mbooks.cover.CoverCreateBean;
import com.library.config.ApplicationPropertiesConfig;
import com.library.proxies.ICoverProxy;
import com.library.service.mbooks.cover.ICoverService;
import com.library.technical.uploadfile.UploadFileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CoverRestController {
    @Autowired
    private ICoverService coverService;

    @Autowired
    private ICoverProxy coverProxy;

    @Autowired
    private ApplicationPropertiesConfig appPropertiesConfig;

    @PostMapping( "/cover/upload")
    public UploadFileResponse uploadCover(@RequestParam("file") MultipartFile file) {
        CoverCreateBean coverCreateBean = coverService.storeFile( file );

        CoverBean coverBean = coverProxy.save( coverCreateBean );

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(appPropertiesConfig.getCoverPath())
                .path(coverBean.getId().toString())
                .toUriString();

        return new UploadFileResponse(coverBean.getId(),coverBean.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
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
