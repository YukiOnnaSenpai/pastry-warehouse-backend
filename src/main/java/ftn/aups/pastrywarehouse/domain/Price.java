package ftn.aups.pastrywarehouse.domain;

import java.util.Currency;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Embeddable
@Getter
@AllArgsConstructor
public class Price {

	private double amount;

	private Currency currency;

	public Price() {

	}
}
