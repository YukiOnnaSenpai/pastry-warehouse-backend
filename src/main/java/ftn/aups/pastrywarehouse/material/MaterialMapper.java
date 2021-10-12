package ftn.aups.pastrywarehouse.material;

import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.Material;
import ftn.aups.pastrywarehouse.domain.Supply;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import ftn.aups.pastrywarehouse.supply.SupplyDto;
import ftn.aups.pastrywarehouse.supply.SupplyMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MaterialMapper implements Mapper<MaterialDto, Material> {

	
  @Override
  public MaterialDto toDto(Material material) {
    MaterialDto materialDto = new MaterialDto();
    materialDto.setMaterialType(material.getMaterialType());

    SupplyDto supplyDto = new SupplyDto();
    supplyDto.setId(material.getSupply().getId());
    supplyDto.setMeasurementUnit(material.getSupply().getMeasurementUnit());
    supplyDto.setName(material.getSupply().getName());
    supplyDto.setValidFrom(material.getSupply().getValidFrom());
    supplyDto.setValidTo(material.getSupply().getValidTo());
    supplyDto.setStockQuantity(material.getSupply().getStockQuantity());
    
    return materialDto;
  }

  @Override
  public Material toEntity(MaterialDto materialDto) {
    Material material = new Material();
    material.setId(materialDto.getId());
    material.setMaterialType(materialDto.getMaterialType());
    
    Supply supply = new Supply();
    
    if(materialDto.getSupplyDto() != null) {
	    supply.setId(materialDto.getSupplyDto().getId());
	    
	    supply.setName(materialDto.getSupplyDto().getName());
	    supply.setMeasurementUnit(materialDto.getSupplyDto().getMeasurementUnit());
	    supply.setStockQuantity(materialDto.getSupplyDto().getStockQuantity());
	    supply.setValidFrom(materialDto.getSupplyDto().getValidFrom());
	    supply.setValidTo(materialDto.getSupplyDto().getValidTo());
	    material.setSupply(supply);
    }
    return material;
  }
}
