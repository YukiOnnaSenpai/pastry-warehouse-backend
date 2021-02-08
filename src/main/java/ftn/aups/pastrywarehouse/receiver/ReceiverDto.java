package ftn.aups.pastrywarehouse.receiver;

import ftn.aups.pastrywarehouse.domain.Document;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ReceiverDto {

    private Document document;

    private String materialType;

    private int quantity;

    private String measurementUnit;

    private double pricePerUnit;

    private List<Long> supplierIds;

}
