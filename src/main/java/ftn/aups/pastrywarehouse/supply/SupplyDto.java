package ftn.aups.pastrywarehouse.supply;

import java.time.LocalDate;

import ftn.aups.pastrywarehouse.domain.MeasurementUnit;
import ftn.aups.pastrywarehouse.equipment.EquipmentDto;
import ftn.aups.pastrywarehouse.material.MaterialDto;
import ftn.aups.pastrywarehouse.packagingSupply.PackagingSupplyDto;
import lombok.Data;

@Data
public class SupplyDto {

  private Long id;

  private LocalDate validFrom;

  private LocalDate validTo;

  private String name;

  private int stockQuantity;

  private MeasurementUnit measurementUnit;

  private EquipmentDto equipment;

  private MaterialDto material;

  private PackagingSupplyDto packagingSupply;
}
