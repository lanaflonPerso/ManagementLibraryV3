package com.library.service.mbooks.lending;
import com.library.beans.mbooks.lending.LendingBean;
import com.library.beans.mbooks.lending.LendingCreateBean;
import com.library.config.ApplicationPropertiesConfig;
import com.library.exception.ResourceNotFoundException;
import com.library.proxies.IBooksPropertiesProxy;
import com.library.proxies.ILendingProxy;
import com.library.technical.date.SimpleDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LendingServiceImpl implements ILendingService {


    @Autowired
    private ILendingProxy lendingProxy;

    @Autowired
    private SimpleDate simpleDate;


    @Autowired
    private IBooksPropertiesProxy booksPropertiesProxy;

    public void renewal(Long id){

        lendingProxy.renewal( id );
    }

    public LendingBean find(Long id){
            try {
                return lendingProxy.find( id ) ;
            }catch (ResourceNotFoundException e){
                return null;
            }
    }

    public List<LendingBean> list(){
        try {
            return lendingProxy.list();
        }catch (ResourceNotFoundException e){
            return null;
        }

    }

    public List<LendingBean> list(String isbn){
        try {
            return  lendingProxy.list( isbn );
        }catch (ResourceNotFoundException e){
            return null;
        }


    }

    public List<LendingBean> list(Long idUser){
        try {
            return lendingProxy.list( idUser );
        }catch (ResourceNotFoundException e){
            return null;
        }

    }

    public LendingBean save(LendingCreateBean lending){
        return lendingProxy.save( lending );
    }

    public LendingBean save(LendingBean lending){
        return lendingProxy.update( lending );
    }

    public boolean delete(Long id){
        return lendingProxy.delete( id );
    }

    public String getDate(Date date){ return simpleDate.getDate( date );   }

    public boolean isInProgress( LendingBean lending){
        return isStartDateBeforeEndDate(  lending);
    }

    public boolean isOutOfTime( LendingBean lending ){
        return !isStartDateBeforeEndDate(  lending);
    }

    public boolean isReturn(LendingBean lending){
        if ( lending.getReturnDate() == null)
            return false;

        return true;
    }

    private boolean isStartDateBeforeEndDate( LendingBean lending){
        Date now = new Date();
        if( !this.isReturn( lending ) )
            return ( now.compareTo( lending.getEndDate() ) <= 0 );

        return false;
    }

    public boolean isRenewable(Integer renewal){
        return (renewal < booksPropertiesProxy.renewalNumber() );
    }

}
