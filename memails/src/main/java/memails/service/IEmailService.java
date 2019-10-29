package memails.service;



import memails.model.Email;

import javax.mail.MessagingException;
import java.util.List;

public interface IEmailService {
    List<Email> findAll();
    void save(Email email);
    void sendAgainEmail(String to,String book, String endDate);

}
