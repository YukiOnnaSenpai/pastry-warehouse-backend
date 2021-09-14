package ftn.aups.pastrywarehouse.supply;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.aups.pastrywarehouse.domain.Supply;

public interface SupplyRepository extends JpaRepository<Supply, Long> {
}
