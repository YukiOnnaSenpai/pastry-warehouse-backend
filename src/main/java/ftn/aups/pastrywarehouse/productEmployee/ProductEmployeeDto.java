package ftn.aups.pastrywarehouse.productEmployee;

import ftn.aups.pastrywarehouse.domain.ShiftType;
import lombok.Data;

@Data
public class ProductEmployeeDto {

  private Long id;

  private String firstName;

  private String lastName;

  private String personalId;

  private String phoneNumber;

  private String bankAccountNumber;

  private String qualifications;

  private double salary;

  private ShiftType shiftType;

  private int shiftDuration;

  private String workplace;
}
