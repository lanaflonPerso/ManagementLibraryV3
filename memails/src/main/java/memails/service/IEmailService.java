package memails.service;



import memails.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> findAll();
    void save(Email email);
}
