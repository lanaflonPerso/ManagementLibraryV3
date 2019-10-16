package com.library.controller.books;

import com.library.beans.mbooks.book.LanguageBean;
import com.library.beans.mbooks.cover.CoverBean;
import com.library.beans.mbooks.cover.CoverCreateBean;
import com.library.config.ApplicationPropertiesConfig;
import com.library.proxies.IMicroserviceBooksProxy;
import com.library.service.books.cover.ICoverService;
import com.library.technical.uploadfile.UploadFileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cover")
public class CoverController {

    @Autowired
    private ICoverService coverService;

    @Autowired
    private IMicroserviceBooksProxy mBooksProxy;

    @Autowired
    private ApplicationPropertiesConfig appPropertiesConfig;

    @ModelAttribute
    private CoverBean coverBean(){return new  CoverBean(); }

    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") String id,Model model){

       CoverBean coverBean =  mBooksProxy.getCover( id );

       model.addAttribute( coverBean );

        return "books/cover/info-cover";
    }

    @GetMapping("/all")
    public String coverAll(Model model){
        List<CoverBean> coverBeanList = mBooksProxy.coverList();

        model.addAttribute( coverBeanList);

        return "books/cover/list-cover";
    }

    @GetMapping("/add")
    public String add(Model model){ return "books/cover/add-cover";}

    @PostMapping("/save")
    public String update(@ModelAttribute @Valid CoverBean coverBean, BindingResult result,Model model){

        if ( result.hasErrors() )
            return "books/cover/add-cover";

         mBooksProxy.save( coverBean );

        return "redirect:/cover/info/" + coverBean.getId();

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id,Model model){
        CoverBean coverBean =  mBooksProxy.getCover( id );
        model.addAttribute( coverBean );
        return "/books/cover/update-cover";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id,@Valid CoverBean coverBean, BindingResult result){
        if ( result.hasErrors() )
            return "/books/cover/update-cover";

        mBooksProxy.update( coverBean );

        return "redirect:/cover/info/" + id ;

    }

    @GetMapping("/delete/{id]")
    public String delete(@PathVariable("id") String id,Model model){
        if ( mBooksProxy.delete( id ) )
            model.addAttribute("delete","delete");
        else
            model.addAttribute("delete","err");
        return "redirect: /cover/all";
    }



    @PostMapping("/uploadCover")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file)  {
        CoverBean coveBeanCreate = coverService.storeFile( file );

        CoverBean coverBean = mBooksProxy.save( coveBeanCreate );

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(appPropertiesConfig.getCoverPath())
                .path(coverBean.getId())
                .toUriString();

        return new UploadFileResponse(coverBean.getId(),coverBean.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }
/*
    @GetMapping("/photo/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {

        Photo photo = photoService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(photo.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photo.getFileName() + "\"")
                .body(new ByteArrayResource(photo.getData()));
    }

 */





}
