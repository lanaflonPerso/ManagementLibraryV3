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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/cover")
public class CoverController {

    @Autowired
    private ICoverProxy coverProxy;

    @Autowired
    private ICoverService coverService;

    @Autowired
    private ApplicationPropertiesConfig appPropertiesConfig;

    @ModelAttribute("coverPath")
    public String coverPath(){return appPropertiesConfig.getCoverPath();}

    @ModelAttribute
    private CoverCreateBean coverCreateBean(){return new CoverCreateBean(); }

    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") String id,Model model){

       CoverBean coverBean =  coverProxy.find(id );

       model.addAttribute( coverBean );

        return "books/cover/info-cover";
    }

    @GetMapping("/all")
    public String list(Model model){
        List<CoverBean> coverBeanList = coverProxy.list();

        model.addAttribute( coverBeanList);

        return "books/cover/list-cover";
    }

    @PostMapping( "/upload")
    @ResponseBody
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


    @GetMapping("/img/{id}")
    @ResponseBody
    public ResponseEntity<Resource> downloadCover(@PathVariable("id") String id){

        CoverBean cover = coverProxy.find( id );
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(cover.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + cover.getFileName() + "\"")
                .body(new ByteArrayResource(cover.getData()));

    }


}
