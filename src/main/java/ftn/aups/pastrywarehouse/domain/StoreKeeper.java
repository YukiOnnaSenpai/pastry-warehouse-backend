package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class StoreKeeper {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private EmployeeDetails employeeDetails;

    private String licenceNumber;

    private LocalDate licenceValidTo;

    @ManyToMany(mappedBy = "storeKeepers")
    private Set<Receiver> receivers;

}
