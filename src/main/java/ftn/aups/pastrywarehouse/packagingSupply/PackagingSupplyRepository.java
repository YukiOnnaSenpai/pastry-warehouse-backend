package ftn.aups.pastrywarehouse.packagingSupply;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.aups.pastrywarehouse.domain.PackagingSupply;

public interface PackagingSupplyRepository extends JpaRepository<PackagingSupply, Long> {
}
