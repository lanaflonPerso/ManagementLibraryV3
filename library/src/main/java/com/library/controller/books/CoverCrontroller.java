package com.library.controller.books;

import com.library.beans.mbooks.book.CoverBean;
import com.library.proxies.IMicroserviceBooksProxy;
import com.library.technical.uploadfile.UploadFileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;

@Controller
@RequestMapping("/cover")
public class CoverCrontroller {

    @Autowired
    private IMicroserviceBooksProxy mBooksProxy;

    @GetMapping("/info")
    public String info(Model model){

        model.addAttribute("cover",1   );
        return "/books/cover/info-cover";
    }


    @GetMapping("photo/{fileId}")
    ResponseEntity<Resource> downloadFile(@PathVariable("fileId") String fileId){
        return mBooksProxy.downloadFile( fileId );
    }

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file")MultipartFile file, @RequestParam("use") String use){

        return mBooksProxy.uploadFile( file, use );


    }

}
