package com.library.service.mbooks.lending;

import com.library.beans.mbooks.lending.LendingBean;
import com.library.beans.mbooks.lending.LendingCreateBean;

import java.util.Date;
import java.util.List;

public interface ILendingService {

    void renewal(Long id);

    LendingBean find(Long id);

    List<LendingBean> list();
    List<LendingBean> list(String isbn);
    List<LendingBean> list(Long idUser);

    LendingBean save(LendingCreateBean lending);
    LendingBean save(LendingBean lending);

    boolean delete(Long id);

    String getDate(Date date);

    boolean isInProgress( LendingBean lending );
    boolean isOutOfTime(  LendingBean lending );
    boolean isReturn( LendingBean lending );

    boolean isRenewable(LendingBean lending );
    String renewalDate(Date date);
    String getEndDate(Date date);


}
