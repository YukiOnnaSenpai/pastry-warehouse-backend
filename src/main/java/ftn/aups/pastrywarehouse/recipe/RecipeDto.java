package ftn.aups.pastrywarehouse.recipe;

import ftn.aups.pastrywarehouse.workOrder.WorkOrderDto;
import lombok.Data;

@Data
public class RecipeDto {

  private Long id;

  private String name;

  private WorkOrderDto workOrderDto;
}
