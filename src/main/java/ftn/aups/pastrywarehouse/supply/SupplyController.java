package ftn.aups.pastrywarehouse.supply;

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

import ftn.aups.pastrywarehouse.domain.Supply;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SupplyController {
  
  private final SupplyService supplyService;
  private final SupplyMapper supplyMapper;

  @GetMapping("api/supply")
  public List<SupplyDto> getAll() {
    return supplyService.getAll().stream()
        .map(supplyMapper::toDto)
        .collect(Collectors.toList());
  }

  @PostMapping("api/supply")
  public ResponseEntity<SupplyDto> insert(@RequestBody SupplyDto supply) {
    Supply save = supplyService.save(supplyMapper.toEntity(supply));
    return ResponseEntity.ok().body(supplyMapper.toDto(save));
  }

  @PutMapping("api/supply/{id}")
  public ResponseEntity<SupplyDto> update(@RequestBody SupplyDto supply, @PathVariable("id") Long id) {
    supply.setId(id);
    Supply save = supplyService.save(supplyMapper.toEntity(supply));
    return ResponseEntity.ok().body(supplyMapper.toDto(save));
  }

  @DeleteMapping("api/supply/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    supplyService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
