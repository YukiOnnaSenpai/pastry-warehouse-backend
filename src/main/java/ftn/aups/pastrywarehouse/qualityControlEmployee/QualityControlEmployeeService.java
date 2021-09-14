package ftn.aups.pastrywarehouse.qualityControlEmployee;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.aups.pastrywarehouse.CrudService;
import ftn.aups.pastrywarehouse.domain.QualityControlEmployee;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QualityControlEmployeeService implements CrudService<QualityControlEmployee> {

  private final QualityControlEmployeeRepository qualityControlEmployeeRepository;

  @Override
  public List<QualityControlEmployee> getAll() {
    return qualityControlEmployeeRepository.findAll();
  }

  @Override
  public QualityControlEmployee getOne(Long id) {
    return qualityControlEmployeeRepository.getOne(id);
  }

  @Override
  public QualityControlEmployee save(QualityControlEmployee qualityControlEmployee) {
    return qualityControlEmployeeRepository.save(qualityControlEmployee);
  }

  @Override
  public void delete(Long id) {
    qualityControlEmployeeRepository.deleteById(id);
  }
}
