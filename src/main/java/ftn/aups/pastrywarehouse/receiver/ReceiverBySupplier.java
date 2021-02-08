package ftn.aups.pastrywarehouse.receiver;

import ftn.aups.pastrywarehouse.domain.Document;
import lombok.Data;

@Data
public class ReceiverBySupplier {

    private Document document;

    private String materialType;

    private int quantity;

    private String measurementUnit;

    private double pricePerUnit;

    private Long supplierId;
}
