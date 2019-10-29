package mbooks.controller;



import mbooks.controller.dto.email.EmailCreateDto;
import mbooks.controller.dto.email.EmailUpdateDto;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.Email;
import mbooks.service.email.IEmailService;
import mbooks.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private IEmailService emailService;


    @GetMapping("/all")
    public List<Email> emailList(){

        List<Email> emailList = emailService.findAll();
        if (emailList.isEmpty()) throw new ResourceNotFoundException( "Aucun email trouvé");

        return emailList;
    }



    @PostMapping
    public void newEmail(@DTO(EmailCreateDto.class) Email email) {
        emailService.save( email );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateEmail(@DTO(EmailUpdateDto.class) Email email ){
        emailService.save( email );
    }
}
