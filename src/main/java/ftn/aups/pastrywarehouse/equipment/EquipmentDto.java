package ftn.aups.pastrywarehouse.equipment;

import ftn.aups.pastrywarehouse.domain.MaintainedStatus;
import ftn.aups.pastrywarehouse.supply.SupplyDto;
import lombok.Data;

@Data
public class EquipmentDto {

  private Long id;

  private String warranty;

  private MaintainedStatus maintainedStatus;

  private SupplyDto supplyDto;
}
