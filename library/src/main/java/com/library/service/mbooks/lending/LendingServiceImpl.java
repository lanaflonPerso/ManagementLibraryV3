package com.library.service.mbooks.lending;
import com.library.beans.mbooks.lending.LendingBean;
import com.library.beans.mbooks.lending.LendingCreateBean;
import com.library.config.ApplicationPropertiesConfig;
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
    private ApplicationPropertiesConfig appPropertiesConfig;

    public LendingBean find(Long id){
        return lendingProxy.find( id ) ;
    }

    public List<LendingBean> list(){
        return lendingProxy.list();
    }

    public List<LendingBean> list(String isbn){


        return  lendingProxy.list( isbn );
    }

    public List<LendingBean> list(Long idUser){
        return lendingProxy.list( idUser );
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

    public boolean isInProgress( Date endDate, Date returnDate){
        return isStartDateBeforeEndDate(  endDate, returnDate);
    }

    public boolean isOutOfTime( Date endDate, Date returnDate ){
        return isStartDateBeforeEndDate(  endDate, returnDate);
    }

    public boolean isReturn(Date returnDate){
        if ( returnDate == null)
            return false;

        return true;
    }

    private boolean isStartDateBeforeEndDate( Date endDate,Date returnDate){
        Date now = new Date();
        if( !this.isReturn( returnDate ) )
            return ( now.compareTo( endDate ) <= 0 );

        return false;
    }

    public boolean isRenewable(Long renewal){
        return (renewal < appPropertiesConfig.getRenewalNumber() );
    }

}
