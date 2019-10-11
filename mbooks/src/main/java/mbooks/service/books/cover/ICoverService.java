package mbooks.service.books.cover;

import mbooks.model.books.Cover;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ICoverService {

    List<Cover> findAll();

    Cover save(String fileName, String contentType, byte[] data);
    Cover storeFile(MultipartFile file);
    Cover getFile(String fileId);
    Long getCarousselInterval();
}
