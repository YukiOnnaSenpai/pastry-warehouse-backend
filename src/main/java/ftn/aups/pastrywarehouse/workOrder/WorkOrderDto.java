package ftn.aups.pastrywarehouse.workOrder;

import java.time.LocalDate;
import java.time.LocalDateTime;

import ftn.aups.pastrywarehouse.productEmployee.ProductEmployeeDto;
import lombok.Data;

@Data
public class WorkOrderDto {

  private Long id;

  private LocalDateTime dateCreated;

  private LocalDate validFrom;

  private LocalDate validTo;

  private double purchasePriceAmount;

  private double sellingPriceAmount;

  private String purchasePriceCurrency;

  private String sellingPriceCurrency;

  private String planningPeriod;

  private ProductEmployeeDto productEmployeeDto;
}
