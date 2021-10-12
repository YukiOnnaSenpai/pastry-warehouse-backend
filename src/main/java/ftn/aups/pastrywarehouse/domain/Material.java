package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Material {

    @Id
    @GeneratedValue
    private Long id;

    private MaterialType materialType;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Supply supply;
}
