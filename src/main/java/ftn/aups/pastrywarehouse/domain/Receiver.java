package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Receiver {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private Document document;

    private MaterialType materialType;

    private int quantity;

    private MeasurementUnit measurementUnit;

    private double pricePerUnit;

    @OneToMany(
            mappedBy = "receiver",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Supply> supplies;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "store_keeper_receiver",
            joinColumns = @JoinColumn(name = "receiver_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<StoreKeeper> storeKeepers;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "quality_control_employee_receiver",
            joinColumns = @JoinColumn(name = "receiver_id"),
            inverseJoinColumns = @JoinColumn(name = "quality_control_employee_id")
    )
    private Set<QualityControlEmployee> qualityControlEmployees;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "supplier_receiver",
            joinColumns = @JoinColumn(name = "receiver_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private Set<Supplier> suppliers;

    public void addSupply(Supply supply) {
        supplies.add(supply);
        supply.setReceiver(this);
    }

    public void removeSupply(Supply supply) {
        supplies.remove(supply);
        supply.setReceiver(null);
    }

    public void addStoreKeeper(StoreKeeper storeKeeper) {
        storeKeepers.add(storeKeeper);
        storeKeeper.getReceivers().add(this);
    }

    public void removeStoreKeeper(StoreKeeper storeKeeper) {
        storeKeepers.remove(storeKeeper);
        storeKeeper.getReceivers().remove(this);
    }

    public void addQualityControlEmployee(QualityControlEmployee qualityControlEmployee) {
        qualityControlEmployees.add(qualityControlEmployee);
        qualityControlEmployee.getReceivers().add(this);
    }

    public void removeQualityControlEmployee(QualityControlEmployee qualityControlEmployee) {
        qualityControlEmployees.remove(qualityControlEmployee);
        qualityControlEmployee.getReceivers().remove(this);
    }

    public void addSupplier(Supplier supplier) {
        if (suppliers == null) {
            suppliers = new HashSet<>();
        }
        suppliers.add(supplier);
        supplier.getReceivers().add(this);
    }

    public void removeSupplier(Supplier supplier) {
        suppliers.remove(supplier);
        supplier.getReceivers().remove(this);
    }
}
