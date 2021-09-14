package ftn.aups.pastrywarehouse.material;

import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.Material;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import ftn.aups.pastrywarehouse.supply.SupplyMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MaterialMapper implements Mapper<MaterialDto, Material> {

  private final SupplyMapper supplyMapper;

  @Override
  public MaterialDto toDto(Material material) {
    MaterialDto materialDto = new MaterialDto();
    materialDto.setMaterialType(material.getMaterialType());
    materialDto.setSupplyDto(supplyMapper.toDto(material.getSupply()));

    return materialDto;
  }

  @Override
  public Material toEntity(MaterialDto materialDto) {
    Material material = new Material();
    material.setId(materialDto.getId());
    material.setMaterialType(materialDto.getMaterialType());
    material.setSupply(supplyMapper.toEntity(materialDto.getSupplyDto()));

    return material;
  }
}
