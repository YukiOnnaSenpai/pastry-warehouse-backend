package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ProductEmployee {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private EmployeeDetails employeeDetails;

    private ShiftType shiftType;

    private int shiftDuration;

    private String workplace;

    @OneToMany(
            mappedBy = "productEmployee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<WorkOrder> workOrders;

    public void addWorkOrder(WorkOrder workOrder) {
        workOrders.add(workOrder);
        workOrder.setProductEmployee(this);
    }

    public void removeWorkOrder(WorkOrder workOrder) {
        workOrders.remove(workOrder);
        workOrder.setProductEmployee(null);
    }
}
