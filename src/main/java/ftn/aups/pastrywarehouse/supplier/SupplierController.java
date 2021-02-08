package ftn.aups.pastrywarehouse.supplier;

import ftn.aups.pastrywarehouse.receiver.ReceiverDto;
import ftn.aups.pastrywarehouse.receiver.ReceiverMapper;
import ftn.aups.pastrywarehouse.receiver.ReceiverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;
    private final SupplierMapper supplierMapper;

    @GetMapping("api/supplier")
    public List<SupplierDto> getAll() {
        return supplierService.getAll().stream()
                .map(supplierMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("api/supplier")
    public ResponseEntity<ReceiverDto> insert(@RequestBody SupplierDto supplierDto) {
        supplierService.insert(supplierMapper.toEntity(supplierDto));
        return ResponseEntity.ok().build();
    }
}
