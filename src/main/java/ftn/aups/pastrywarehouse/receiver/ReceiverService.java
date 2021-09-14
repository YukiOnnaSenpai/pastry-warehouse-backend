package ftn.aups.pastrywarehouse.receiver;

import ftn.aups.pastrywarehouse.CrudService;
import ftn.aups.pastrywarehouse.domain.Receiver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceiverService implements CrudService<Receiver> {

    private final ReceiverRepository receiverRepository;

    @Override
    public List<Receiver> getAll() {
        return receiverRepository.findAll();
    }

    @Override
    public Receiver getOne(Long id) {
        return receiverRepository.getOne(id);
    }

    public List<Receiver> getBySupplier(Long supplierId) {
        return receiverRepository.findBySuppliersId(supplierId);
    }

    @Override
    public Receiver save(Receiver receiver) {
        return receiverRepository.save(receiver);
    }

    @Override
    public void delete(Long id) {
        receiverRepository.deleteById(id);
    }
}
