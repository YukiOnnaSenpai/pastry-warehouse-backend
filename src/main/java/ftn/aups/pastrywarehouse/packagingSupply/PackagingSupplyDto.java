package ftn.aups.pastrywarehouse.packagingSupply;

import ftn.aups.pastrywarehouse.supply.SupplyDto;
import lombok.Data;

@Data
public class PackagingSupplyDto {

  private Long id;

  private String material;

  private SupplyDto supplyDto;
}
