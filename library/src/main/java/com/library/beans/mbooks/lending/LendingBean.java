package com.library.beans.mbooks.lending;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
public  @Data class LendingBean {
    private Long id;

    private Long idUser;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startDate;


    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;


    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date returnDate;

    private Long renewal;
}
