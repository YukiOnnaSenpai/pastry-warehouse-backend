package ftn.aups.pastrywarehouse.material;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.aups.pastrywarehouse.domain.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
