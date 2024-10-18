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
		* Consulta la base de datos buscando el n�mero m�s alto de las facturas (Bill) emitidas en un a�o espec�fico (b.number), filtrando por el campo de a�o (b.year = :year).

		  Si existen facturas en ese a�o, obtiene el n�mero de factura m�s alto y le suma 1, devolviendo el siguiente n�mero en la secuencia.

		  Si no existen facturas para ese a�o, entonces devuelve el n�mero 1, ya que ser�a la primera factura emitida para ese a�o.
		* */






		Query query = XPersistence.getManager()
				.createQuery("select max(b.number) from Bill b where b.year = :year");

		// 2024
		// 2025
		// 2010


		query.setParameter("year", year);
		Integer lastNumber = (Integer) query.getSingleResult();
		// Ejecuta la consulta y obtiene el resultado, que ser� el n�mero m�ximo de facturas del a�o especificado.
		// Si no hay facturas, devuelve null.

		return lastNumber == null ? 1 : lastNumber + 1;
		// Si no se encontraron facturas (lastNumber == null), devuelve 1 como primer n�mero de factura.
		// Si se encontr� un n�mero de factura, devuelve ese n�mero + 1 para el siguiente n�mero de factura.
	}
	}

