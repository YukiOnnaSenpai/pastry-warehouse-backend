package ftn.aups.pastrywarehouse.material;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.aups.pastrywarehouse.CrudService;
import ftn.aups.pastrywarehouse.domain.Material;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaterialService implements CrudService<Material> {

  private final MaterialRepository materialRepository;

  @Override
  public List<Material> getAll() {
	  List<Material> materials = materialRepository.findAll();
	  System.out.println(materials.get(0).getSupply().getName());
    return materials;
  }

  @Override
  public Material getOne(Long id) {
    return materialRepository.getOne(id);
  }

  @Override
  public Material save(Material material) {
    return materialRepository.save(material);
  }

  @Override
  public void delete(Long id) {
    materialRepository.deleteById(id);
  }
}
