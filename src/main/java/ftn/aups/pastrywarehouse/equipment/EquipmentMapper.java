package ftn.aups.pastrywarehouse.equipment;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.Equipment;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import ftn.aups.pastrywarehouse.supply.SupplyMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EquipmentMapper implements Mapper<EquipmentDto, Equipment> {

  private final SupplyMapper supplyMapper;
  @Override
  public EquipmentDto toDto(Equipment equipment) {
    EquipmentDto equipmentDto = new EquipmentDto();
    equipmentDto.setId(equipment.getId());
    equipmentDto.setSupply(supplyMapper.toDto(equipment.getSupply()));
    equipmentDto.setWarranty(equipment.getWarranty());
    equipmentDto.setMaintainedStatus(equipment.getMaintainedStatus());
    return equipmentDto;
  }

  @Override
  public Equipment toEntity(EquipmentDto equipmentDto) {
    Equipment equipment = new Equipment();
    equipment.setId(equipmentDto.getId());
    equipment.setMaintainedStatus(equipmentDto.getMaintainedStatus());
    equipment.setDateMaintained(LocalDate.now());
    equipment.setSupply(supplyMapper.toEntity(equipmentDto.getSupply()));
    equipment.setWarranty(equipmentDto.getWarranty());
    return equipment;
  }
}
