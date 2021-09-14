package ftn.aups.pastrywarehouse.storageUnit;

import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.StorageUnit;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StorageUnitMapper implements Mapper<StorageUnitDto, StorageUnit> {

  @Override
  public StorageUnitDto toDto(StorageUnit storageUnit) {
    StorageUnitDto storageUnitDto = new StorageUnitDto();
    storageUnitDto.setCapacity(storageUnit.getCapacity());

    return storageUnitDto;
  }

  @Override
  public StorageUnit toEntity(StorageUnitDto storageUnitDto) {
    StorageUnit storageUnit = new StorageUnit();
    storageUnit.setId(storageUnitDto.getId());
    storageUnit.setCapacity(storageUnitDto.getCapacity());

    return storageUnit;
  }
}
