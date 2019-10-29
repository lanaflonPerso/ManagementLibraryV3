package memails.service;



import memails.model.Email;

import javax.mail.MessagingException;
import java.util.List;

public interface IEmailService {
    List<Email> findAll();
    void save(Email email);

    void sendSimpleMessage(String to, String subject, String text);
    void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException;
}
