package ftn.aups.pastrywarehouse.receiver;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ftn.aups.pastrywarehouse.domain.MaterialType;
import ftn.aups.pastrywarehouse.domain.MeasurementUnit;
import ftn.aups.pastrywarehouse.domain.Receiver;
import ftn.aups.pastrywarehouse.domain.Supplier;
import ftn.aups.pastrywarehouse.mapper.Mapper;
import ftn.aups.pastrywarehouse.supplier.SupplierService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReceiverMapper implements Mapper<ReceiverDto, Receiver> {

    private final SupplierService supplierService;

    @Override
    public ReceiverDto toDto(Receiver receiver) {
        return ReceiverDto.builder()
                .document(receiver.getDocument())
                .materialType(receiver.getMaterialType().name())
                .measurementUnit(receiver.getMeasurementUnit().name())
                .quantity(receiver.getQuantity())
                .pricePerUnit(receiver.getPricePerUnit())
                .supplierIds(receiver.getSuppliers().stream().map(Supplier::getId).collect(Collectors.toList()))
                .build();
    }

    @Override
    public Receiver toEntity(ReceiverDto receiverDto) {
        Receiver receiver = new Receiver();
        receiver.setDocument(receiverDto.getDocument());
        receiver.setMaterialType(MaterialType.valueOf(receiverDto.getMaterialType()));
        receiver.setMeasurementUnit(MeasurementUnit.valueOf(receiverDto.getMeasurementUnit()));
        receiver.setQuantity(receiverDto.getQuantity());
        receiver.setPricePerUnit(receiverDto.getPricePerUnit());

        Set<Supplier> suppliers = supplierService.getByIds(receiverDto.getSupplierIds());

        suppliers.forEach(receiver::addSupplier);

        return receiver;
    }
}
