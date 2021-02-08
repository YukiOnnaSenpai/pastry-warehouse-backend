package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Equipment {

    @Id
    @GeneratedValue
    private Long id;

    private String warranty;

    private LocalDate dateMaintained;

    private MaintainedStatus maintainedStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Supply supply;
}
