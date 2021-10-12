package ftn.aups.pastrywarehouse.domain;

import java.time.LocalDate;

import javax.persistence.Embeddable;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Embeddable
@Data
public class Document {

	@CreatedDate
	private LocalDate dateCreated;

	private LocalDate validFrom;

	private LocalDate validTo;
}
