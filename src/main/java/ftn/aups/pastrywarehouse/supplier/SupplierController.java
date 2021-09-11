package ftn.aups.pastrywarehouse.supplier;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ftn.aups.pastrywarehouse.receiver.ReceiverDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SupplierController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierController.class);

    private final SupplierService supplierService;
    private final SupplierMapper supplierMapper;

    @GetMapping("api/supplier")
    public List<SupplierDto> getAll() {
        LOGGER.info("Fetching all suppliers!");
        return supplierService.getAll().stream()
                .map(supplierMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping(value = "api/supplier", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SupplierDto> insert(@RequestBody SupplierDto supplierDto) {
        LOGGER.info("Adding a new supplier! {}", supplierDto);
        supplierService.insert(supplierMapper.toEntity(supplierDto));
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "api/supplier/{id}")
    public ResponseEntity<SupplierDto> getOne(@PathVariable("id") Long id) {
        SupplierDto supplierDto = supplierMapper.toDto(supplierService.getOne(id));
        return ResponseEntity.ok(supplierDto);
    }
}
