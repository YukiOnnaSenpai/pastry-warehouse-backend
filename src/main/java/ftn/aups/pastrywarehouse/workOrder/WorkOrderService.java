package ftn.aups.pastrywarehouse.workOrder;

import java.util.List;

import org.springframework.stereotype.Service;

import ftn.aups.pastrywarehouse.CrudService;
import ftn.aups.pastrywarehouse.domain.WorkOrder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkOrderService implements CrudService<WorkOrder> {

  private final WorkOrderRepository workOrderRepository;

  @Override
  public List<WorkOrder> getAll() {
    return workOrderRepository.findAll();
  }

  @Override
  public WorkOrder getOne(Long id) {
    return workOrderRepository.getOne(id);
  }

  @Override
  public WorkOrder save(WorkOrder workOrder) {
    return workOrderRepository.save(workOrder);
  }

  @Override
  public void delete(Long id) {
    workOrderRepository.deleteById(id);
  }
}
