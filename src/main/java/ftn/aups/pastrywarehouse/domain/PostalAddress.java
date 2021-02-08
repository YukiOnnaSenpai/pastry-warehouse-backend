package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class PostalAddress {

    @Id
    @GeneratedValue
    private Long id;

    private String streetName;

    private String postalCode;

    private String city;

    @OneToMany(mappedBy = "postalAddress", fetch = FetchType.LAZY)
    private List<Supplier> suppliers;

    public void addSupplier(Supplier supplier) {
        if (suppliers == null) {
            suppliers = new ArrayList<>();
        }
        suppliers.add(supplier);
        supplier.setPostalAddress(this);
    }

    public void removeSupplier(Supplier supplier) {
        suppliers.remove(supplier);
        supplier.setPostalAddress(null);
    }
}
