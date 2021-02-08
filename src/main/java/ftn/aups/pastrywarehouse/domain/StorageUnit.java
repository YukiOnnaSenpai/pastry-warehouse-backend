package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class StorageUnit {

    @Id
    @GeneratedValue
    private Long id;

    private String capacity;

    @OneToMany(
            mappedBy = "storageUnit",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Supply> supplies;

    public void addSupply(Supply supply) {
        supplies.add(supply);
        supply.setStorageUnit(this);
    }

    public void removeSupply(Supply supply) {
        supplies.remove(supply);
        supply.setStorageUnit(null);
    }
}
