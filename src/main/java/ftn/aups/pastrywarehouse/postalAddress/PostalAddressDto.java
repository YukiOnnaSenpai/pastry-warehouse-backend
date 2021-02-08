package ftn.aups.pastrywarehouse.postalAddress;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostalAddressDto {

    private Long id;

    private String streetName;

    private String postalCode;

    private String city;
}
