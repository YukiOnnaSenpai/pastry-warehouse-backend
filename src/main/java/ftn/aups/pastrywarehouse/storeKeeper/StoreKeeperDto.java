package ftn.aups.pastrywarehouse.storeKeeper;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StoreKeeperDto {

  private Long id;

  private String firstName;

  private String lastName;

  private String personalId;

  private String phoneNumber;

  private String bankAccountNumber;

  private String qualifications;

  private double salary;

  private String licenceNumber;

  private LocalDate licenceValidTo;
}
