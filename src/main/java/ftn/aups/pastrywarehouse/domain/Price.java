package ftn.aups.pastrywarehouse.domain;

import javax.persistence.Embeddable;
import java.util.Currency;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
@AllArgsConstructor
public class Price {

    private double amount;

    private Currency currency;
}
