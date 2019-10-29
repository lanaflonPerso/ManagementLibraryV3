package mbooks.service.lending;


import mbooks.beans.musers.user.UsersBean;
import mbooks.config.ApplicationPropertiesConfig;
import mbooks.exceptions.ResourceNotFoundException;
import mbooks.model.Books;
import mbooks.model.Lending;
import mbooks.proxies.IMicroserviceUsersProxy;
import mbooks.repository.ILendingRepository;
import mbooks.service.IBooksService;
import mbooks.service.email.IEmailService;
import mbooks.technical.date.SimpleDate;
import mbooks.technical.email.EmailWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LendingServiceImpl implements ILendingService {

    @Autowired
    private ILendingRepository lendingRepository;

    @Autowired
    private IBooksService booksService;

    @Autowired
    private ApplicationPropertiesConfig appPropertiesConfig;

    @Autowired
    private SimpleDate simpleDate;

    @Autowired
    private IEmailService emailService;



    @Autowired
    private IMicroserviceUsersProxy usersProxy;

    public void renewal(Long id){
    Lending lending = this.find( id );

        if(lending.getRenewal() < appPropertiesConfig.getRenewalNumber() ){
            lending.setRenewal( lending.getRenewal() + 1);
            Calendar c = Calendar.getInstance();
            c.setTime( lending.getEndDate() );
            c.add(Calendar.DAY_OF_MONTH, appPropertiesConfig.getRenewalDay() );
            lending.setEndDate( c.getTime() );
            lendingRepository.save( lending );
        }
    }

    public Lending find(Long id){
        return lendingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prêt non trouvé avec l'id " + id ) );
    }

    public List<Lending> list(){
        return lendingRepository.findAll();
    }

    public List<Lending> list(String isbn){
        Books book = booksService.find( isbn );
        return  lendingRepository.findAllByBook( book );
    }

    public List<Lending> list(Long idUser){
        return lendingRepository.findAllByIdUser( idUser );
    }

    public Lending  save(Lending lending){ return lendingRepository.save( lending ); }

    public boolean delete(Long id){
        try {
            lendingRepository.deleteById( id );
            return true;
        }catch (DataIntegrityViolationException ee){
            return false;
        }
    }

    public void revival() {

            Date now = new Date();
            List<Lending> lendingList = lendingRepository.findAllByReturnDateIsNullAndAndEndDateBefore(now);

            ArrayList<EmailWrapper> emails = new ArrayList<>();

            if (lendingList.size() > 0)
                for (Lending l : lendingList) {
                    UsersBean usersBean = usersProxy.user(l.getIdUser());
                    emails.add(new EmailWrapper(usersBean.getEmail(), l.getBook().getTitle(), simpleDate.getDate(l.getEndDate())));
                }

            List<EmailWrapper> emailList = new ArrayList<>(emails);
            emailService.sendRevival(emailList);
    }
}
