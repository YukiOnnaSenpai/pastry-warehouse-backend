package ftn.aups.pastrywarehouse.storageUnit;

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

import ftn.aups.pastrywarehouse.domain.StorageUnit;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StorageUnitController {
  
  private final StorageUnitService storageUnitService;
  private final StorageUnitMapper storageUnitMapper;

  @GetMapping("api/storageUnit")
  public List<StorageUnitDto> getAll() {
    return storageUnitService.getAll().stream()
        .map(storageUnitMapper::toDto)
        .collect(Collectors.toList());
  }

  @PostMapping("api/storageUnit")
  public ResponseEntity<StorageUnitDto> insert(@RequestBody StorageUnitDto storageUnitDto) {
    StorageUnit save = storageUnitService.save(storageUnitMapper.toEntity(storageUnitDto));
    return ResponseEntity.ok().body(storageUnitMapper.toDto(save));
  }

  @PutMapping("api/storageUnit/{id}")
  public ResponseEntity<StorageUnitDto> update(@RequestBody StorageUnitDto storageUnitDto, @PathVariable("id") Long id) {
    storageUnitDto.setId(id);
    StorageUnit save = storageUnitService.save(storageUnitMapper.toEntity(storageUnitDto));
    return ResponseEntity.ok().body(storageUnitMapper.toDto(save));
  }

  @DeleteMapping("api/storageUnit/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    storageUnitService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
