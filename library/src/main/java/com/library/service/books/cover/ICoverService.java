package com.library.service.books.cover;


import com.library.beans.mbooks.cover.CoverBean;
import com.library.beans.mbooks.cover.CoverCreateBean;
import org.springframework.web.multipart.MultipartFile;

public interface ICoverService {




    CoverCreateBean storeFile(MultipartFile file);
    Long getCarousselInterval();
}
