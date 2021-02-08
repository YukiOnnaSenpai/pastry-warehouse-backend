package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Material {

    @Id
    private Long id;

    private MaterialType materialType;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Supply supply;
}
