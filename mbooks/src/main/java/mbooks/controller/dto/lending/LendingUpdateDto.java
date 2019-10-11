package mbooks.controller.dto.lending;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class LendingUpdateDto {

    @Id
    private Long id;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date returnDate;

    private Long renewal;
}
