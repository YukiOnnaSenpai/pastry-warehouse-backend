package ftn.aups.pastrywarehouse.qualityControlEmployee;

import lombok.Data;

@Data
public class QualityControlEmployeeDto {

  private Long id;

  private String firstName;

  private String lastName;

  private String personalId;

  private String phoneNumber;

  private String bankAccountNumber;

  private String qualifications;

  private double salary;

  private String status;

}
