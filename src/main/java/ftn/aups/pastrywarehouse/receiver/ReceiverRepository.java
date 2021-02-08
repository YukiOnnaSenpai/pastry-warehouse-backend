package ftn.aups.pastrywarehouse.receiver;

import ftn.aups.pastrywarehouse.domain.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceiverRepository extends JpaRepository<Receiver, Long> {

    List<Receiver> findBySuppliersId(Long id);
}
