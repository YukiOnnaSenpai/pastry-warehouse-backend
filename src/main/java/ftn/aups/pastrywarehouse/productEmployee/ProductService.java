package ftn.aups.pastrywarehouse.productEmployee;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.aups.pastrywarehouse.CrudService;
import ftn.aups.pastrywarehouse.domain.ProductEmployee;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements CrudService<ProductEmployee> {

  private final ProductEmployeeRepository productEmployeeRepository;

  @Override
  public List<ProductEmployee> getAll() {
    return productEmployeeRepository.findAll();
  }

  @Override
  public ProductEmployee getOne(Long id) {
    return productEmployeeRepository.getOne(id);
  }

  @Override
  public ProductEmployee save(ProductEmployee productEmployee) {
    return productEmployeeRepository.save(productEmployee);
  }

  @Override
  public void delete(Long id) {
    productEmployeeRepository.deleteById(id);
  }
}
