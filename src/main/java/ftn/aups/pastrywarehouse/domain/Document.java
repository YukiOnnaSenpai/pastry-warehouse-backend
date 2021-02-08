package ftn.aups.pastrywarehouse.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@Data
public class Document {

    @CreatedDate
    private LocalDateTime dateCreated;

    private LocalDate validFrom;

    private LocalDate validTo;
}
