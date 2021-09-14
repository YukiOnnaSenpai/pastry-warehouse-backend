package ftn.aups.pastrywarehouse.equipment;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.aups.pastrywarehouse.domain.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
