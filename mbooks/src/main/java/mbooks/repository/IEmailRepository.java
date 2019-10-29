package mbooks.repository;



import mbooks.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmailRepository extends JpaRepository<Email,Long> {
    Email findByName(String name);
}
