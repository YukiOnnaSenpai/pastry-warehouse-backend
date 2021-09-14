package ftn.aups.pastrywarehouse.storageUnit;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.aups.pastrywarehouse.CrudService;
import ftn.aups.pastrywarehouse.domain.StorageUnit;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StorageUnitService implements CrudService<StorageUnit> {

  private final StorageUnitRepository storageUnitRepository;

  @Override
  public List<StorageUnit> getAll() {
    return storageUnitRepository.findAll();
  }

  @Override
  public StorageUnit getOne(Long id) {
    return storageUnitRepository.getOne(id);
  }

  @Override
  public StorageUnit save(StorageUnit storageUnit) {
    return storageUnitRepository.save(storageUnit);
  }

  @Override
  public void delete(Long id) {
    storageUnitRepository.deleteById(id);
  }
}
