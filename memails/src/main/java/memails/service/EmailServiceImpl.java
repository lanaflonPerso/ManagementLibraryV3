package memails.service;


import memails.beans.EmailBean;
import memails.model.Email;
import memails.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private IEmailRepository emailRepository;

    @Autowired
    public SimpleMailMessage template;

    public List<Email> findAll(){
        return emailRepository.findAll();
    }

    public void save(Email email){
        emailRepository.save(email);
    }

    @Autowired
    public JavaMailSender emailSender;



   private void sendSimpleMessage(String to, String subject, String text) {

        //String text = String.format(template.getText(), templateArgs);
        //sendSimpleMessage(to, subject, text);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    private void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException {


        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text);

        FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
        helper.addAttachment("Invoice", file);

        emailSender.send(message);

    }
    public void sendAgainEmail(List<EmailBean> emailBeanList){

       Email email = emailRepository.findByName("relance");

        for (EmailBean e: emailBeanList) {
            String text = email.getContent()
                    .replace("[BOOK_TITLE]", e.getTitle())
                    .replace("[END_DATE]", e.getEndDate());
            sendSimpleMessage(e.getEmail(),email.getSubject(),text);
        }
    }

}
