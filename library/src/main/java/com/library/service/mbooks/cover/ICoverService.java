package com.library.service.mbooks.cover;


import com.library.beans.mbooks.cover.CoverCreateBean;
import org.springframework.web.multipart.MultipartFile;

public interface ICoverService {




    CoverCreateBean storeFile(MultipartFile file);
    Long getCarousselInterval();
}
