package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Supplier {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private PostalAddress postalAddress;

    private String phoneNumber;

    private String email;

    @ManyToMany(mappedBy = "suppliers")
    private List<Receiver> receivers;
}
