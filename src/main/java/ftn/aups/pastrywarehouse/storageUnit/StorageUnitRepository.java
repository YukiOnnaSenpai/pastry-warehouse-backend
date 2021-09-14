package ftn.aups.pastrywarehouse.storageUnit;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.aups.pastrywarehouse.domain.StorageUnit;

public interface StorageUnitRepository extends JpaRepository<StorageUnit, Long> {
}
