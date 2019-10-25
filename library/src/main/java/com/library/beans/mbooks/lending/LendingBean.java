package com.library.beans.mbooks.lending;

import com.library.beans.mbooks.book.BookBean;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

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

    @NotNull(message = "Le choix du livre est obligatoire")
    private BookBean book;
}
