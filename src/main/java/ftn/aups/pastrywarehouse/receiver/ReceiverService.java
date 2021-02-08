package ftn.aups.pastrywarehouse.receiver;

import ftn.aups.pastrywarehouse.domain.Receiver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceiverService {

    private final ReceiverRepository receiverRepository;

    public List<Receiver> getAll() {
        return receiverRepository.findAll();
    }

    public List<Receiver> getBySupplier(Long supplierId) {
        return receiverRepository.findBySuppliersId(supplierId);
    }

    public Receiver insert(Receiver receiver) {
        return receiverRepository.save(receiver);
    }
}
