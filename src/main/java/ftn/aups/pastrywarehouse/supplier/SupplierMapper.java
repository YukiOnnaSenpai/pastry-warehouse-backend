package ftn.aups.pastrywarehouse.supplier;

import ftn.aups.pastrywarehouse.domain.PostalAddress;
import ftn.aups.pastrywarehouse.domain.Supplier;
import ftn.aups.pastrywarehouse.postalAddress.PostalAddressMapper;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplierMapper implements Mapper<SupplierDto, Supplier> {

    private final PostalAddressMapper postalAddressMapper;

    @Override
    public SupplierDto toDto(Supplier supplier) {
        return SupplierDto.builder()
                .id(supplier.getId())
                .email(supplier.getEmail())
                .name(supplier.getName())
                .phoneNumber(supplier.getPhoneNumber())
                .postalAddress(postalAddressMapper.toDto(supplier.getPostalAddress()))
                .build();
    }

    @Override
    public Supplier toEntity(SupplierDto supplierDto) {
        Supplier supplier = new Supplier();
        supplier.setEmail(supplierDto.getEmail());
        supplier.setName(supplierDto.getName());
        supplier.setPhoneNumber(supplierDto.getPhoneNumber());
        PostalAddress postalAddress = postalAddressMapper.toEntity(supplierDto.getPostalAddress());
        postalAddress.addSupplier(supplier);
        return supplier;
    }
}
