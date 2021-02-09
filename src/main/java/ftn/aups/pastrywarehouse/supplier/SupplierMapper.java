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
    SupplierDto supplierDto = new SupplierDto();

    supplierDto.setId(supplier.getId());
    supplierDto.setEmail(supplier.getEmail());
    supplierDto.setName(supplier.getName());
    supplierDto.setPhoneNumber(supplier.getPhoneNumber());
    supplierDto.setPostalAddress(postalAddressMapper.toDto(supplier.getPostalAddress()));
    return supplierDto;
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
