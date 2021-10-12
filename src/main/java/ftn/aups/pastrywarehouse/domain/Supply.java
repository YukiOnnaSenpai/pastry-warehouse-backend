package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Supply {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate dateAdded;

    private LocalDate validFrom;

    private LocalDate validTo;

    private String name;

    private int stockQuantity;

    private MeasurementUnit measurementUnit;

	/*
	 * @OneToOne private Equipment equipment;
	 * 
	 * @OneToOne private Material material;
	 * 
	 * @OneToOne private PackagingSupply packagingSupply;
	 */

    @ManyToOne(fetch = FetchType.LAZY)
    private StorageUnit storageUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    private Receiver receiver;
}
