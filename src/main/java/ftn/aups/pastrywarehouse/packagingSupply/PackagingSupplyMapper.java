package ftn.aups.pastrywarehouse.packagingSupply;

import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.PackagingSupply;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PackagingSupplyMapper implements Mapper<PackagingSupplyDto, PackagingSupply> {

  @Override
  public PackagingSupplyDto toDto(PackagingSupply packagingSupply) {
    PackagingSupplyDto packagingSupplyDto = new PackagingSupplyDto();
    packagingSupplyDto.setMaterial(packagingSupply.getMaterial());

    return packagingSupplyDto;
  }

  @Override
  public PackagingSupply toEntity(PackagingSupplyDto packagingSupplyDto) {
    PackagingSupply packagingSupply = new PackagingSupply();
    packagingSupply.setMaterial(packagingSupplyDto.getMaterial());
    packagingSupply.setId(packagingSupplyDto.getId());

    return packagingSupply;
  }
}
