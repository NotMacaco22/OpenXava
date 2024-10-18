package org.cash.billing.modelo;

import javax.persistence.*;

import lombok.*;

@Embeddable @Getter @Setter
public class Detail {
	
	int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	Product product;

}
