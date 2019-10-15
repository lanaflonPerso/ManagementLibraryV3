package mbooks.controller.book;


import mbooks.controller.dto.books.cover.CoverCreateDto;
import mbooks.controller.dto.books.cover.CoverUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.books.Cover;
import mbooks.service.books.cover.ICoverService;
import mbooks.technical.dto.DTO;
import mbooks.technical.uploadfile.UploadFileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cover")
public class CoverController {

    @Autowired
    private ICoverService coverService;

    @GetMapping("/all")
    public List<Cover> coverList(){

        List<Cover> coverList = coverService.findAll();
        if (coverList.isEmpty()) throw new ResourceNotFoundException( "Aucune couverture de livre trouvée");

        return coverList;
    }
    @GetMapping("/photo/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {

        Cover cover = coverService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(cover.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + cover.getFileName() + "\"")
                .body(new ByteArrayResource(cover.getData()));
    }

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("use")  String use)  {
        Cover cover = coverService.storeFile( file, use );

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/photo/")
                .path(cover.getId())
                .toUriString();

        return new UploadFileResponse(cover.getId(),cover.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize(),use);
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files, String use) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file, use))
                .collect(Collectors.toList());
    }


}
