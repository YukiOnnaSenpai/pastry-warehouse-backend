package ftn.aups.pastrywarehouse.supplier;

import ftn.aups.pastrywarehouse.domain.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public Set<Supplier> getByIds(List<Long> ids) {
        return supplierRepository.findByIdIn(ids);
    }

    public Supplier getOne(Long id) {
        return supplierRepository.findById(id).orElseThrow();
    }

    public void insert(Supplier supplier) {
        supplierRepository.save(supplier);
    }
}
