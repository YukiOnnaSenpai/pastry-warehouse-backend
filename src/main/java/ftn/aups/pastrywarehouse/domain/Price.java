package ftn.aups.pastrywarehouse.domain;

import javax.persistence.Embeddable;
import java.util.Currency;

@Embeddable
public class Price {

    private double amount;

    private Currency currency;
}
