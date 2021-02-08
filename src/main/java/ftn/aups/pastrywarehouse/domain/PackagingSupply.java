package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PackagingSupply {

    @Id
    @GeneratedValue
    private Long id;

    private String material;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Supply supply;
}
