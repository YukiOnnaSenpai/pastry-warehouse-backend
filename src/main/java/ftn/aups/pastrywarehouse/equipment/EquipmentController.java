package ftn.aups.pastrywarehouse.equipment;

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

import ftn.aups.pastrywarehouse.domain.Equipment;
import ftn.aups.pastrywarehouse.receiver.ReceiverDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EquipmentController {

  private final EquipmentService equipmentService;
  private final EquipmentMapper equipmentMapper;


  @GetMapping("api/equipment")
  public List<EquipmentDto> getAll() {
    return equipmentService.getAll().stream()
        .map(equipmentMapper::toDto)
        .collect(Collectors.toList());
  }

  @PostMapping("api/equipment")
  public ResponseEntity<EquipmentDto> insert(@RequestBody EquipmentDto equipmentDto) {
    Equipment save = equipmentService.save(equipmentMapper.toEntity(equipmentDto));
    return ResponseEntity.ok().body(equipmentMapper.toDto(save));
  }

  @PutMapping("api/equipment/{id}")
  public ResponseEntity<EquipmentDto> update(@RequestBody EquipmentDto equipmentDto, @PathVariable("id") Long id) {
    equipmentDto.setId(id);
    Equipment save = equipmentService.save(equipmentMapper.toEntity(equipmentDto));
    return ResponseEntity.ok().body(equipmentMapper.toDto(save));
  }

  @DeleteMapping("api/equipment/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    equipmentService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
