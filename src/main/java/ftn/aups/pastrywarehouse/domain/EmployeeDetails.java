package ftn.aups.pastrywarehouse.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class EmployeeDetails {

    private String firstName;

    private String lastName;

    private String personalId;

    private String phoneNumber;

    private String bankAccountNumber;

    private String qualifications;

    private double salary;
}
