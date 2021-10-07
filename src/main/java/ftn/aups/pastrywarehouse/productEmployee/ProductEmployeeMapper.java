package ftn.aups.pastrywarehouse.productEmployee;

import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.EmployeeDetails;
import ftn.aups.pastrywarehouse.domain.ProductEmployee;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductEmployeeMapper implements Mapper<ProductEmployeeDto, ProductEmployee> {

  @Override
  public ProductEmployeeDto toDto(ProductEmployee productEmployee) {
    ProductEmployeeDto productEmployeeDto = new ProductEmployeeDto();
    productEmployeeDto.setId(productEmployee.getId());
    productEmployeeDto.setFirstName(productEmployee.getEmployeeDetails().getFirstName());
    productEmployeeDto.setLastName(productEmployee.getEmployeeDetails().getLastName());
    productEmployeeDto.setPersonalId(productEmployee.getEmployeeDetails().getPersonalId());
    productEmployeeDto.setQualifications(productEmployee.getEmployeeDetails().getQualifications());
    productEmployeeDto.setSalary(productEmployee.getEmployeeDetails().getSalary());
    productEmployeeDto.setPhoneNumber(productEmployee.getEmployeeDetails().getPhoneNumber());
    productEmployeeDto.setBankAccountNumber(productEmployee.getEmployeeDetails().getBankAccountNumber());
    productEmployeeDto.setShiftDuration(productEmployee.getShiftDuration());
    productEmployeeDto.setWorkplace(productEmployee.getWorkplace());
    productEmployeeDto.setShiftType(productEmployee.getShiftType());

    return productEmployeeDto;
  }

  @Override
  public ProductEmployee toEntity(ProductEmployeeDto productEmployeeDto) {
    ProductEmployee productEmployee = new ProductEmployee();
    productEmployee.setShiftDuration(productEmployeeDto.getShiftDuration());
    productEmployee.setId(productEmployeeDto.getId());
    productEmployee.setWorkplace(productEmployeeDto.getWorkplace());
    productEmployee.setShiftType(productEmployeeDto.getShiftType());

    EmployeeDetails employeeDetails = new EmployeeDetails();
    employeeDetails.setQualifications(productEmployeeDto.getQualifications());
    employeeDetails.setFirstName(productEmployeeDto.getFirstName());
    employeeDetails.setLastName(productEmployeeDto.getLastName());
    employeeDetails.setPersonalId(productEmployeeDto.getPersonalId());
    employeeDetails.setSalary(productEmployeeDto.getSalary());
    employeeDetails.setPhoneNumber(productEmployeeDto.getPhoneNumber());
    employeeDetails.setBankAccountNumber(productEmployeeDto.getBankAccountNumber());

    productEmployee.setEmployeeDetails(employeeDetails);
    return productEmployee;
  }
}
