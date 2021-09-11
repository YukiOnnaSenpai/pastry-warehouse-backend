package ftn.aups.pastrywarehouse.postalAddress;

import ftn.aups.pastrywarehouse.domain.PostalAddress;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class PostalAddressMapper implements Mapper<PostalAddressDto, PostalAddress> {

    @Override
    public PostalAddressDto toDto(PostalAddress postalAddress) {
        return PostalAddressDto.builder()
                .id(postalAddress.getId())
                .streetName(postalAddress.getStreetName())
                .postalCode(postalAddress.getPostalCode())
                .city(postalAddress.getCity())
                .build();
    }

    @Override
    public PostalAddress toEntity(PostalAddressDto postalAddressDto) {
        PostalAddress postalAddress = new PostalAddress();
        postalAddress.setStreetName(postalAddressDto.getStreetName());
        postalAddress.setPostalCode(postalAddressDto.getPostalCode());
        postalAddress.setCity(postalAddressDto.getCity());

        return postalAddress;
    }
}
