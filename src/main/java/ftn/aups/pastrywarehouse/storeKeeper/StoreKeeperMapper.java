package ftn.aups.pastrywarehouse.storeKeeper;

import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.EmployeeDetails;
import ftn.aups.pastrywarehouse.domain.StoreKeeper;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StoreKeeperMapper implements Mapper<StoreKeeperDto, StoreKeeper> {

  @Override
  public StoreKeeperDto toDto(StoreKeeper storeKeeper) {
    StoreKeeperDto storeKeeperDto = new StoreKeeperDto();

    storeKeeperDto.setFirstName(storeKeeper.getEmployeeDetails().getFirstName());
    storeKeeperDto.setLastName(storeKeeper.getEmployeeDetails().getLastName());
    storeKeeperDto.setPersonalId(storeKeeper.getEmployeeDetails().getPersonalId());
    storeKeeperDto.setQualifications(storeKeeper.getEmployeeDetails().getQualifications());
    storeKeeperDto.setSalary(storeKeeper.getEmployeeDetails().getSalary());
    storeKeeperDto.setPhoneNumber(storeKeeper.getEmployeeDetails().getPhoneNumber());
    storeKeeperDto.setBankAccountNumber(storeKeeper.getEmployeeDetails().getBankAccountNumber());

    storeKeeperDto.setLicenceNumber(storeKeeper.getLicenceNumber());
    storeKeeperDto.setLicenceValidTo(storeKeeper.getLicenceValidTo());

    return storeKeeperDto;

  }

  @Override
  public StoreKeeper toEntity(StoreKeeperDto storeKeeperDto) {

    EmployeeDetails employeeDetails = new EmployeeDetails();
    employeeDetails.setQualifications(storeKeeperDto.getQualifications());
    employeeDetails.setFirstName(storeKeeperDto.getFirstName());
    employeeDetails.setLastName(storeKeeperDto.getLastName());
    employeeDetails.setPersonalId(storeKeeperDto.getPersonalId());
    employeeDetails.setSalary(storeKeeperDto.getSalary());
    employeeDetails.setPhoneNumber(storeKeeperDto.getPhoneNumber());
    employeeDetails.setBankAccountNumber(storeKeeperDto.getBankAccountNumber());

    StoreKeeper storeKeeper = new StoreKeeper();
    storeKeeper.setId(storeKeeperDto.getId());
    storeKeeper.setLicenceNumber(storeKeeperDto.getLicenceNumber());
    storeKeeper.setLicenceValidTo(storeKeeperDto.getLicenceValidTo());
    storeKeeper.setEmployeeDetails(employeeDetails);

    return storeKeeper;
  }
}
