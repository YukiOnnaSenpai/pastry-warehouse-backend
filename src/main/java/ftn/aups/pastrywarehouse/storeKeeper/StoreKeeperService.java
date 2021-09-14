package ftn.aups.pastrywarehouse.storeKeeper;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.aups.pastrywarehouse.CrudService;
import ftn.aups.pastrywarehouse.domain.StoreKeeper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreKeeperService implements CrudService<StoreKeeper> {

  private final StoreKeeperRepository storeKeeperRepository;

  @Override
  public List<StoreKeeper> getAll() {
    return storeKeeperRepository.findAll();
  }

  @Override
  public StoreKeeper getOne(Long id) {
    return storeKeeperRepository.getOne(id);
  }

  @Override
  public StoreKeeper save(StoreKeeper storeKeeper) {
    return storeKeeperRepository.save(storeKeeper);
  }

  @Override
  public void delete(Long id) {
    storeKeeperRepository.deleteById(id);
  }
}
