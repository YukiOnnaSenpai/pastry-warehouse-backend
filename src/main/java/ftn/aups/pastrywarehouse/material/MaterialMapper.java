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
    supplyDto.setDateAdded(material.getSupply().getDateAdded());
    supplyDto.setValidFrom(material.getSupply().getValidFrom());
    supplyDto.setValidTo(material.getSupply().getValidTo());
    supplyDto.setStockQuantity(material.getSupply().getStockQuantity());
    
    materialDto.setSupply(supplyDto);
    
    return materialDto;
  }

  @Override
  public Material toEntity(MaterialDto materialDto) {
    Material material = new Material();
    material.setId(materialDto.getId());
    material.setMaterialType(materialDto.getMaterialType());
    
    Supply supply = new Supply();
    
    if(materialDto.getSupply() != null) {
	    supply.setId(materialDto.getSupply().getId());
	    supply.setName(materialDto.getSupply().getName());
	    supply.setMeasurementUnit(materialDto.getSupply().getMeasurementUnit());
	    supply.setStockQuantity(materialDto.getSupply().getStockQuantity());
	    supply.setValidFrom(materialDto.getSupply().getValidFrom());
	    supply.setValidTo(materialDto.getSupply().getValidTo());
	    material.setSupply(supply);
    }
    return material;
  }
}
