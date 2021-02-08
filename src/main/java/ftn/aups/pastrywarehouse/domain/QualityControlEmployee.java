package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class QualityControlEmployee {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private EmployeeDetails employeeDetails;

    private String status;

    @ManyToMany(mappedBy = "qualityControlEmployees")
    private Set<Receiver> receivers;
}
