package ftn.aups.pastrywarehouse.supply;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.aups.pastrywarehouse.CrudService;
import ftn.aups.pastrywarehouse.domain.Supply;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplyService implements CrudService<Supply> {

  private final SupplyRepository supplyRepository;

  @Override
  public List<Supply> getAll() {
    return supplyRepository.findAll();
  }

  @Override
  public Supply getOne(Long id) {
    return supplyRepository.getOne(id);
  }

  @Override
  public Supply save(Supply supply) {
    return supplyRepository.save(supply);
  }

  @Override
  public void delete(Long id) {
    supplyRepository.deleteById(id);
  }
}
