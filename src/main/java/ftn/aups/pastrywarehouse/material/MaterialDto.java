package ftn.aups.pastrywarehouse.material;

import ftn.aups.pastrywarehouse.domain.MaterialType;
import ftn.aups.pastrywarehouse.supply.SupplyDto;
import lombok.Data;

@Data
public class MaterialDto {

  private Long id;

  private MaterialType materialType;

  private SupplyDto supplyDto;
}
