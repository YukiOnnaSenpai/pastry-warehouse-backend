package ftn.aups.pastrywarehouse.productEmployee;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.aups.pastrywarehouse.domain.ProductEmployee;

public interface ProductEmployeeRepository extends JpaRepository<ProductEmployee, Long> {
}
