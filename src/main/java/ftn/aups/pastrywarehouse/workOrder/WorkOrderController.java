package ftn.aups.pastrywarehouse.workOrder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ftn.aups.pastrywarehouse.domain.WorkOrder;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class WorkOrderController {

	private final WorkOrderService workOrderService;
	private final WorkOrderMapper workOrderMapper;

	@PostMapping("api/workOrder")
	public ResponseEntity<WorkOrderDto> insert(@RequestBody WorkOrderDto workOrder) {
		System.out.println("DATUM  >>>>>>>>>>>> " + workOrder.getValidFrom());
		WorkOrder save = workOrderService.save(workOrderMapper.toEntity(workOrder));
		return ResponseEntity.ok().body(workOrderMapper.toDto(save));
	}

	@PutMapping("api/workOrder/{id}")
	public ResponseEntity<WorkOrderDto> update(@RequestBody WorkOrderDto workOrder, @PathVariable("id") Long id) {
		workOrder.setId(id);
		WorkOrder save = workOrderService.save(workOrderMapper.toEntity(workOrder));
		return ResponseEntity.ok().body(workOrderMapper.toDto(save));
	}

	@DeleteMapping("api/workOrder/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		workOrderService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
