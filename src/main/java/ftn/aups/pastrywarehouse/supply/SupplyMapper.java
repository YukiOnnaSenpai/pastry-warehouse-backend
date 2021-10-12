package ftn.aups.pastrywarehouse.supply;

import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.Supply;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import ftn.aups.pastrywarehouse.material.MaterialMapper;
import ftn.aups.pastrywarehouse.packagingSupply.PackagingSupplyMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SupplyMapper implements Mapper<SupplyDto, Supply> {

  private final MaterialMapper materialMapper;
  private final PackagingSupplyMapper packagingSupplyMapper;

  @Override
  public SupplyDto toDto(Supply supply) {
    SupplyDto supplyDto = new SupplyDto();
    supplyDto.setId(supply.getId());
    supplyDto.setDateAdded(supply.getDateAdded());
    supplyDto.setMeasurementUnit(supply.getMeasurementUnit());
    supplyDto.setName(supply.getName());
    supplyDto.setValidFrom(supply.getValidFrom());
    supplyDto.setValidTo(supply.getValidTo());
    supplyDto.setStockQuantity(supply.getStockQuantity());
    supplyDto.setMaterial(materialMapper.toDto(supply.getMaterial()));
    supplyDto.setPackagingSupply(packagingSupplyMapper.toDto(supply.getPackagingSupply()));

    return supplyDto;
  }

  @Override
  public Supply toEntity(SupplyDto supplyDto) {
    Supply supply = new Supply();
    supply.setId(supplyDto.getId());
    supply.setName(supplyDto.getName());
    supply.setMeasurementUnit(supplyDto.getMeasurementUnit());
    supply.setStockQuantity(supplyDto.getStockQuantity());
    supply.setDateAdded(supplyDto.getDateAdded());
    supply.setValidFrom(supplyDto.getValidFrom());
    supply.setValidTo(supplyDto.getValidTo());
    supply.setMaterial(materialMapper.toEntity(supplyDto.getMaterial()));
    supply.setPackagingSupply(packagingSupplyMapper.toEntity(supplyDto.getPackagingSupply()));

    return supply;
  }
}
