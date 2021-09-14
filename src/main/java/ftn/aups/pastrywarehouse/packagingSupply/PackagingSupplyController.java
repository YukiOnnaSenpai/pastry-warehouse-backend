package ftn.aups.pastrywarehouse.packagingSupply;

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

import ftn.aups.pastrywarehouse.domain.PackagingSupply;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PackagingSupplyController {
  
  private final PackagingSupplyService packagingSupplyService;
  private final PackagingSupplyMapper packagingSupplyMapper;

  @GetMapping("api/packagingSupply")
  public List<PackagingSupplyDto> getAll() {
    return packagingSupplyService.getAll().stream()
        .map(packagingSupplyMapper::toDto)
        .collect(Collectors.toList());
  }

  @PostMapping("api/packagingSupply")
  public ResponseEntity<PackagingSupplyDto> insert(@RequestBody PackagingSupplyDto packagingSupplyDto) {
    PackagingSupply save = packagingSupplyService.save(packagingSupplyMapper.toEntity(packagingSupplyDto));
    return ResponseEntity.ok().body(packagingSupplyMapper.toDto(save));
  }

  @PutMapping("api/packagingSupply/{id}")
  public ResponseEntity<PackagingSupplyDto> update(@RequestBody PackagingSupplyDto packagingSupplyDto, @PathVariable("id") Long id) {
    packagingSupplyDto.setId(id);
    PackagingSupply save = packagingSupplyService.save(packagingSupplyMapper.toEntity(packagingSupplyDto));
    return ResponseEntity.ok().body(packagingSupplyMapper.toDto(save));
  }

  @DeleteMapping("api/packagingSupply/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    packagingSupplyService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
