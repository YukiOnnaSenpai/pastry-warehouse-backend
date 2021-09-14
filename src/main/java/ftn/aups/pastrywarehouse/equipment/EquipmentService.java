package ftn.aups.pastrywarehouse.equipment;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.aups.pastrywarehouse.CrudService;
import ftn.aups.pastrywarehouse.domain.Equipment;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipmentService implements CrudService<Equipment> {

  private final EquipmentRepository equipmentRepository;

  @Override
  public List<Equipment> getAll() {
    return equipmentRepository.findAll();
  }

  @Override
  public Equipment getOne(Long id) {
    return equipmentRepository.getOne(id);
  }

  @Override
  public Equipment save(Equipment equipment) {
    return equipmentRepository.save(equipment);
  }

  @Override
  public void delete(Long id) {
    equipmentRepository.deleteById(id);
  }
}
