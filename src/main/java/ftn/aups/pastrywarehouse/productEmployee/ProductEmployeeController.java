package ftn.aups.pastrywarehouse.productEmployee;

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

import ftn.aups.pastrywarehouse.domain.ProductEmployee;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductEmployeeController {
  
  private final ProductEmployeeService productEmployeeService;
  private final ProductEmployeeMapper productEmployeeMapper;

  @GetMapping("api/productEmployee")
  public List<ProductEmployeeDto> getAll() {
    return productEmployeeService.getAll().stream()
        .map(productEmployeeMapper::toDto)
        .collect(Collectors.toList());
  }

  @PostMapping("api/productEmployee")
  public ResponseEntity<ProductEmployeeDto> insert(@RequestBody ProductEmployeeDto productEmployeeDto) {
    ProductEmployee save = productEmployeeService.save(productEmployeeMapper.toEntity(productEmployeeDto));
    return ResponseEntity.ok().body(productEmployeeMapper.toDto(save));
  }

  @PutMapping("api/productEmployee/{id}")
  public ResponseEntity<ProductEmployeeDto> update(@RequestBody ProductEmployeeDto productEmployeeDto, @PathVariable("id") Long id) {
    productEmployeeDto.setId(id);
    ProductEmployee save = productEmployeeService.save(productEmployeeMapper.toEntity(productEmployeeDto));
    return ResponseEntity.ok().body(productEmployeeMapper.toDto(save));
  }

  @DeleteMapping("api/productEmployee/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    productEmployeeService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
