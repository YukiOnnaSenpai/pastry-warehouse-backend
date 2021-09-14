package ftn.aups.pastrywarehouse.material;

import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.Material;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MaterialMapper implements Mapper<MaterialDto, Material> {

  @Override
  public MaterialDto toDto(Material material) {
    MaterialDto materialDto = new MaterialDto();
    materialDto.setMaterialType(material.getMaterialType());

    return materialDto;
  }

  @Override
  public Material toEntity(MaterialDto materialDto) {
    Material material = new Material();
    material.setId(materialDto.getId());
    material.setMaterialType(materialDto.getMaterialType());

    return material;
  }
}
