package ftn.aups.pastrywarehouse.workOrder;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.aups.pastrywarehouse.domain.WorkOrder;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
}
