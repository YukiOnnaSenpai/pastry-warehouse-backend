package ftn.aups.pastrywarehouse.packagingSupply;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.aups.pastrywarehouse.CrudService;
import ftn.aups.pastrywarehouse.domain.PackagingSupply;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PackagingSupplyService implements CrudService<PackagingSupply> {

  private final PackagingSupplyRepository packagingSupplyRepository;

  @Override
  public List<PackagingSupply> getAll() {
    return packagingSupplyRepository.findAll();
  }

  @Override
  public PackagingSupply getOne(Long id) {
    return packagingSupplyRepository.getOne(id);
  }

  @Override
  public PackagingSupply save(PackagingSupply packagingSupply) {
    return packagingSupplyRepository.save(packagingSupply);
  }

  @Override
  public void delete(Long id) {
    packagingSupplyRepository.deleteById(id);
  }
}
