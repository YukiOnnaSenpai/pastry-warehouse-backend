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
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MaterialController {
  
  private final MaterialService materialService;
  private final MaterialMapper materialMapper;

  @GetMapping("api/material")
  public List<MaterialDto> getAll() {
    return materialService.getAll().stream()
        .map(materialMapper::toDto)
        .collect(Collectors.toList());
  }

  @PostMapping("api/material")
  public ResponseEntity<MaterialDto> insert(@RequestBody MaterialDto materialDto) {
	  System.out.println("ID SPLAJA U MATERIJALU>>>>>>>>>>" + materialDto.getSupplyDto().getId());
    Material save = materialService.save(materialMapper.toEntity(materialDto));
    return ResponseEntity.ok().body(materialMapper.toDto(save));
  }

  @PutMapping("api/material/{id}")
  public ResponseEntity<MaterialDto> update(@RequestBody MaterialDto materialDto, @PathVariable("id") Long id) {
    materialDto.setId(id);
    Material save = materialService.save(materialMapper.toEntity(materialDto));
    return ResponseEntity.ok().body(materialMapper.toDto(save));
  }

  @DeleteMapping("api/material/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    materialService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
