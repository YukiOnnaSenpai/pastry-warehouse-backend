package ftn.aups.pastrywarehouse.supplier;

import ftn.aups.pastrywarehouse.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Set<Supplier> findByIdIn(List<Long> ids);
}
