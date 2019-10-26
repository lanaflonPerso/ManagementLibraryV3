package com.library.controller.mbooks;

import com.library.beans.mbooks.book.author.AuthorBean;
import com.library.beans.mbooks.lending.LendingBean;

import java.util.Date;

public interface ILendingController {

    String getDate(Date date);

    boolean isInProgress(LendingBean lending);
    boolean isOutOfTime(LendingBean lending);
    boolean isReturn(LendingBean lending);
    boolean isRenewable(Long renewal);

    String getFullAuthorName(AuthorBean author);

}
