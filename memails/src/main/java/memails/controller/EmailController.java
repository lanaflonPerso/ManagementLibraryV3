package memails.controller;


import memails.controller.dto.EmailCreateDto;
import memails.controller.dto.EmailUpdateDto;
import memails.exceptions.ResourceNotFoundException;
import memails.model.Email;
import memails.service.IEmailService;
import memails.technical.dto.DTO;
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

    @GetMapping("/send/{to}/{book}/{endDate}")
    public String sendAgainEmail(@PathVariable("to") String to,@PathVariable("book") String book,@PathVariable("endDate")String endDate){

            emailService.sendAgainEmail( to, book, endDate );
           return "Email envoyé";
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
