package ftn.aups.pastrywarehouse.storeKeeper;

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

import ftn.aups.pastrywarehouse.domain.StoreKeeper;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StoreKeeperController {
  
  private final StoreKeeperService storeKeeperService;
  private final StoreKeeperMapper storeKeeperMapper;

  @GetMapping("api/storeKeeper")
  public List<StoreKeeperDto> getAll() {
    return storeKeeperService.getAll().stream()
        .map(storeKeeperMapper::toDto)
        .collect(Collectors.toList());
  }

  @PostMapping("api/storeKeeper")
  public ResponseEntity<StoreKeeperDto> insert(@RequestBody StoreKeeperDto storeKeeper) {
    StoreKeeper save = storeKeeperService.save(storeKeeperMapper.toEntity(storeKeeper));
    return ResponseEntity.ok().body(storeKeeperMapper.toDto(save));
  }

  @PutMapping("api/storeKeeper/{id}")
  public ResponseEntity<StoreKeeperDto> update(@RequestBody StoreKeeperDto storeKeeper, @PathVariable("id") Long id) {
    storeKeeper.setId(id);
    StoreKeeper save = storeKeeperService.save(storeKeeperMapper.toEntity(storeKeeper));
    return ResponseEntity.ok().body(storeKeeperMapper.toDto(save));
  }

  @DeleteMapping("api/storeKeeper/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    storeKeeperService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
