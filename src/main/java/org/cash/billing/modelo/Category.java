package org.cash.billing.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Category {

	// Computadoras 550e8400-e29b-41d4-a716-446655440000
	// LIbros 550e8400-e29b-41d4-a716-askdghaskdaslkdhasd

	@Id	@Hidden
	@GeneratedValue(generator="system-uuid") @GenericGenerator(name="system-uuid", strategy="uuid")
	@Column(length=32)
	String oid;
	
	@Column(length=50)
	String description;
}
