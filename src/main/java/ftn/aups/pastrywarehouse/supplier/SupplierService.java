package ftn.aups.pastrywarehouse.supplier;

import ftn.aups.pastrywarehouse.CrudService;
import ftn.aups.pastrywarehouse.domain.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SupplierService implements CrudService<Supplier> {

    private final SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public Set<Supplier> getByIds(List<Long> ids) {
        return supplierRepository.findByIdIn(ids);
    }

    @Override
    public Supplier getOne(Long id) {
        return supplierRepository.findById(id).orElseThrow();
    }

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }
}
