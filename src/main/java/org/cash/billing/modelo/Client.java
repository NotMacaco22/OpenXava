package org.cash.billing.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
public class Client {

	@Id
	@Column(length=5)
	int number;
	
	@Column(length=50)
	String name;

	// entidad embebida
	// los campos de esta entidad embebida se van a almacenar
	// dentro de la misma tabla de la entidad contenedora, en
	// lugar de crear una tabla separada.
	@Embedded @NoFrame
	Address address;
}
