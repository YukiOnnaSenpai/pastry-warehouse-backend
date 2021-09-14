package ftn.aups.pastrywarehouse.qualityControlEmployee;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.aups.pastrywarehouse.domain.QualityControlEmployee;

public interface QualityControlEmployeeRepository extends JpaRepository<QualityControlEmployee, Long> {
}
