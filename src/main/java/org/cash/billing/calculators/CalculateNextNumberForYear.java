package org.cash.billing.calculators;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import lombok.*;

public class CalculateNextNumberForYear implements ICalculator{
		
	@Getter @Setter
	int year;

	@Override
	public Object calculate() throws Exception {

		/*
		* Consulta la base de datos buscando el número más alto de las facturas (Bill) emitidas en un año específico (b.number), filtrando por el campo de año (b.year = :year).

		  Si existen facturas en ese año, obtiene el número de factura más alto y le suma 1, devolviendo el siguiente número en la secuencia.

		  Si no existen facturas para ese año, entonces devuelve el número 1, ya que sería la primera factura emitida para ese año.
		* */






		Query query = XPersistence.getManager()
				.createQuery("select max(b.number) from Bill b where b.year = :year");

		// 2024
		// 2025
		// 2010


		query.setParameter("year", year);
		Integer lastNumber = (Integer) query.getSingleResult();
		// Ejecuta la consulta y obtiene el resultado, que será el número máximo de facturas del año especificado.
		// Si no hay facturas, devuelve null.

		return lastNumber == null ? 1 : lastNumber + 1;
		// Si no se encontraron facturas (lastNumber == null), devuelve 1 como primer número de factura.
		// Si se encontró un número de factura, devuelve ese número + 1 para el siguiente número de factura.
	}
	}

