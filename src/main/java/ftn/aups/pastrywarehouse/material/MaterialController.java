package ftn.aups.pastrywarehouse.material;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ftn.aups.pastrywarehouse.domain.Material;
import ftn.aups.pastrywarehouse.domain.Supply;
import ftn.aups.pastrywarehouse.supply.SupplyDto;
import ftn.aups.pastrywarehouse.supply.SupplyMapper;
import ftn.aups.pastrywarehouse.supply.SupplyService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MaterialController {
  
  private final MaterialService materialService;
  private final MaterialMapper materialMapper;
  private final SupplyService supplyService;
  private final SupplyMapper supplyMapper;

  @GetMapping("api/material")
  public List<MaterialDto> getAll() {
	  List<MaterialDto> materialDtos = materialService.getAll().stream()
		        .map(materialMapper::toDto)
		        .collect(Collectors.toList());
	  System.out.println(materialDtos.get(0).getSupply().getName());
    return materialDtos;
  }

  @PostMapping("api/material")
  public ResponseEntity<MaterialDto> insert(@RequestBody MaterialDto materialDto) {
	Supply savedSupply = supplyService.save(supplyMapper.toEntity(materialDto.getSupply()));
	SupplyDto savedSupplyDto = supplyMapper.toDto(savedSupply);
	materialDto.setSupply(savedSupplyDto);
    Material save = materialService.save(materialMapper.toEntity(materialDto));
    return ResponseEntity.ok().body(materialMapper.toDto(save));
  }

  @PutMapping("api/material/{id}") 
  public ResponseEntity<MaterialDto> update(@RequestBody MaterialDto materialDto, @PathVariable("id") Long id) {
    materialDto.setId(id);
    Supply supplySave = supplyService.save(supplyMapper.toEntity(materialDto.getSupply()));
    Material save = materialService.save(materialMapper.toEntity(materialDto));
    return ResponseEntity.ok().body(materialMapper.toDto(save));
  }

  @DeleteMapping("api/material/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    materialService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
