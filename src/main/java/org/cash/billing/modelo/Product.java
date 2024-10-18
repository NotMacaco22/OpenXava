package org.cash.billing.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Product {

	@Id @Column(length=9)
	int number;
	
	@Column(length=50) @Required
	String description;

	// No se cargará inmediatamente cuando se obtenga un objeto Product, solo se cargará cuando sea necesaria
	// Cuando se acceda directamente a la propiedad category en el objeto Product

	@ManyToOne
	(fetch=FetchType.LAZY,
	optional=true)
	@DescriptionsList
	Category category;

	// $ 300
	@Money
	BigDecimal precio;
	
	@Files
	@Column(length=32)
	String photos;
	
	@TextArea
	String observations;
}
