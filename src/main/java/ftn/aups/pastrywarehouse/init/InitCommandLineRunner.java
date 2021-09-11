package ftn.aups.pastrywarehouse.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.PostalAddress;
import ftn.aups.pastrywarehouse.domain.Supplier;
import ftn.aups.pastrywarehouse.supplier.SupplierRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitCommandLineRunner implements CommandLineRunner {

  private final SupplierRepository supplierRepository;

  @Override
  public void run(String... args) {

    Supplier supplier = new Supplier();
    supplier.setName("DHL");
    supplier.setEmail("dhl@mail.com");
    supplier.setPhoneNumber("09999999");

    PostalAddress postalAddress = new PostalAddress();
    postalAddress.setPostalCode("21000");
    postalAddress.setCity("Novi Sad");
    postalAddress.setStreetName("Zmaj Jovina");
    postalAddress.addSupplier(supplier);
    supplier.setPostalAddress(postalAddress);

    supplierRepository.save(supplier);
  }
}
