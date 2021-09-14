package ftn.aups.pastrywarehouse.qualityControlEmployee;

import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.EmployeeDetails;
import ftn.aups.pastrywarehouse.domain.QualityControlEmployee;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class QualityControlEmployeeMapper implements Mapper<QualityControlEmployeeDto, QualityControlEmployee> {

  @Override
  public QualityControlEmployeeDto toDto(QualityControlEmployee qualityControlEmployee) {
    QualityControlEmployeeDto qualityControlEmployeeDto = new QualityControlEmployeeDto();
    qualityControlEmployeeDto.setFirstName(qualityControlEmployee.getEmployeeDetails().getFirstName());
    qualityControlEmployeeDto.setLastName(qualityControlEmployee.getEmployeeDetails().getLastName());
    qualityControlEmployeeDto.setPersonalId(qualityControlEmployee.getEmployeeDetails().getPersonalId());
    qualityControlEmployeeDto.setQualifications(qualityControlEmployee.getEmployeeDetails().getQualifications());
    qualityControlEmployeeDto.setSalary(qualityControlEmployee.getEmployeeDetails().getSalary());
    qualityControlEmployeeDto.setPhoneNumber(qualityControlEmployee.getEmployeeDetails().getPhoneNumber());
    qualityControlEmployeeDto.setBankAccountNumber(qualityControlEmployee.getEmployeeDetails().getBankAccountNumber());

    qualityControlEmployeeDto.setStatus(qualityControlEmployee.getStatus());

    return qualityControlEmployeeDto;
  }

  @Override
  public QualityControlEmployee toEntity(QualityControlEmployeeDto qualityControlEmployeeDto) {

    EmployeeDetails employeeDetails = new EmployeeDetails();
    employeeDetails.setQualifications(qualityControlEmployeeDto.getQualifications());
    employeeDetails.setFirstName(qualityControlEmployeeDto.getFirstName());
    employeeDetails.setLastName(qualityControlEmployeeDto.getLastName());
    employeeDetails.setPersonalId(qualityControlEmployeeDto.getPersonalId());
    employeeDetails.setSalary(qualityControlEmployeeDto.getSalary());
    employeeDetails.setPhoneNumber(qualityControlEmployeeDto.getPhoneNumber());
    employeeDetails.setBankAccountNumber(qualityControlEmployeeDto.getBankAccountNumber());

    QualityControlEmployee qualityControlEmployee = new QualityControlEmployee();
    qualityControlEmployee.setId(qualityControlEmployeeDto.getId());
    qualityControlEmployee.setStatus(qualityControlEmployeeDto.getStatus());
    qualityControlEmployee.setEmployeeDetails(employeeDetails);

    return qualityControlEmployee;
  }
}
