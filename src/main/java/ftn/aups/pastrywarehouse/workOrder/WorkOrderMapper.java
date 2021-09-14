package ftn.aups.pastrywarehouse.workOrder;

import java.util.Currency;

import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.Document;
import ftn.aups.pastrywarehouse.domain.Price;
import ftn.aups.pastrywarehouse.domain.WorkOrder;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import ftn.aups.pastrywarehouse.productEmployee.ProductEmployeeMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WorkOrderMapper implements Mapper<WorkOrderDto, WorkOrder> {

  private final ProductEmployeeMapper productEmployeeMapper;

  @Override
  public WorkOrderDto toDto(WorkOrder workOrder) {
    WorkOrderDto workOrderDto = new WorkOrderDto();
    workOrderDto.setDateCreated(workOrder.getDocument().getDateCreated());
    workOrderDto.setPurchasePriceAmount(workOrder.getPurchasePrice().getAmount());
    workOrderDto.setSellingPriceAmount(workOrder.getSellingPrice().getAmount());
    workOrderDto.setValidFrom(workOrder.getDocument().getValidFrom());
    workOrderDto.setValidTo(workOrder.getDocument().getValidTo());
    workOrderDto.setPurchasePriceCurrency(workOrder.getPurchasePrice().getCurrency().getCurrencyCode());
    workOrderDto.setSellingPriceCurrency(workOrder.getSellingPrice().getCurrency().getCurrencyCode());
    workOrderDto.setProductEmployeeDto(productEmployeeMapper.toDto(workOrder.getProductEmployee()));
    return workOrderDto;
  }

  @Override
  public WorkOrder toEntity(WorkOrderDto workOrderDto) {
    WorkOrder workOrder = new WorkOrder();
    workOrder.setId(workOrderDto.getId());
    workOrder.setPlanningPeriod(workOrderDto.getPlanningPeriod());
    workOrder.setPurchasePrice(new Price(workOrderDto.getPurchasePriceAmount(), Currency.getInstance(workOrderDto.getPurchasePriceCurrency())));
    workOrder.setSellingPrice(new Price(workOrderDto.getSellingPriceAmount(), Currency.getInstance(workOrderDto.getSellingPriceCurrency())));
    workOrder.setProductEmployee(productEmployeeMapper.toEntity(workOrderDto.getProductEmployeeDto()));

    Document document = new Document();
    document.setDateCreated(workOrderDto.getDateCreated());
    document.setValidFrom(workOrderDto.getValidFrom());
    document.setValidTo(workOrderDto.getValidTo());

    workOrder.setDocument(document);

    return workOrder;
  }
}
