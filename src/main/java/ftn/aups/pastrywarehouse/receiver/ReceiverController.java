package ftn.aups.pastrywarehouse.receiver;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ReceiverController {

    private final ReceiverService receiverService;
    private final ReceiverMapper receiverMapper;

    @GetMapping("api/receiver")
    public List<ReceiverDto> getAll() {
        return receiverService.getAll().stream()
                .map(receiverMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("api/receiver")
    public ResponseEntity<ReceiverDto> insert(@RequestBody ReceiverDto receiverDto) {
         receiverService.save(receiverMapper.toEntity(receiverDto));
         return ResponseEntity.ok().build();
    }

    @GetMapping("api/receiver/supplier/{id}")
    public List<ReceiverDto> getReceiversBySupplier(@PathVariable("id") Long supplierId) {
        return receiverService.getBySupplier(supplierId).stream()
                .map(receiverMapper::toDto)
                .collect(Collectors.toList());
    }
}
