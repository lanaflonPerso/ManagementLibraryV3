package memails.service;



import memails.beans.EmailBean;
import memails.model.Email;

import javax.mail.MessagingException;
import java.util.List;

public interface IEmailService {
    List<Email> findAll();
    void save(Email email);
    void sendAgainEmail(List<EmailBean> emailBeanList);

}
