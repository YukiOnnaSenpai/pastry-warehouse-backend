package ftn.aups.pastrywarehouse.qualityControlEmployee;

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

import ftn.aups.pastrywarehouse.domain.QualityControlEmployee;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class QualityControlEmployeeController {
  
  private final QualityControlEmployeeService qualityControlEmployeeService;
  private final QualityControlEmployeeMapper qualityControlEmployeeMapper;

  @GetMapping("api/qualityControlEmployee")
  public List<QualityControlEmployeeDto> getAll() {
    return qualityControlEmployeeService.getAll().stream()
        .map(qualityControlEmployeeMapper::toDto)
        .collect(Collectors.toList());
  }

  @PostMapping("api/qualityControlEmployee")
  public ResponseEntity<QualityControlEmployeeDto> insert(@RequestBody QualityControlEmployeeDto qualityControlEmployeeDto) {
    QualityControlEmployee save = qualityControlEmployeeService
        .save(qualityControlEmployeeMapper.toEntity(qualityControlEmployeeDto));
    return ResponseEntity.ok().body(qualityControlEmployeeMapper.toDto(save));
  }

  @PutMapping("api/qualityControlEmployee/{id}")
  public ResponseEntity<QualityControlEmployeeDto> update(@RequestBody QualityControlEmployeeDto qualityControlEmployeeDto, @PathVariable("id") Long id) {
    qualityControlEmployeeDto.setId(id);
    QualityControlEmployee save = qualityControlEmployeeService
        .save(qualityControlEmployeeMapper.toEntity(qualityControlEmployeeDto));
    return ResponseEntity.ok().body(qualityControlEmployeeMapper.toDto(save));
  }

  @DeleteMapping("api/qualityControlEmployee/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    qualityControlEmployeeService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
