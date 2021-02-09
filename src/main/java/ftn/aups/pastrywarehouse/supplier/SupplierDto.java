package ftn.aups.pastrywarehouse.supplier;

import ftn.aups.pastrywarehouse.postalAddress.PostalAddressDto;
import lombok.Data;

@Data
public class SupplierDto {

    private Long id;

    private String name;

    private PostalAddressDto postalAddress;

    private String phoneNumber;

    private String email;
}
