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

    @GetMapping("/send")
    public void sendEmail(){
        String to= "romaindavid.sergeant@gmail.com";
        String subject="Relance pour livre non rendu";
        String text=" Bonjour,\nVous deviez rendre le livre pour le 30/11/2019. A ce jour noous n'avons toujours pas enregistré ce retour.\nMerci de faire le nécessaire";

           emailService.sendSimpleMessage(to,subject,text);
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
