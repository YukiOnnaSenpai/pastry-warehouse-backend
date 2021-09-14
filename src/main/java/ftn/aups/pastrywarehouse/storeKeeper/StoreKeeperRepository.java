package ftn.aups.pastrywarehouse.storeKeeper;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.aups.pastrywarehouse.domain.StoreKeeper;

public interface StoreKeeperRepository extends JpaRepository<StoreKeeper, Long> {
}
