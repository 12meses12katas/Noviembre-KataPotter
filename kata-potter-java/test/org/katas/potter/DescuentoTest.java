package org.katas.potter;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import junit.framework.AssertionFailedError;

import org.junit.Test;

public class DescuentoTest {
	
	Libro l1 = new Libro("Harry Potter y la piedra filosofal", 8);
	Libro l2 = new Libro("Harry Potter y la c‡mara secreta", 8);

	static double delta = 0.01;
	
	@Test
	public void elPrimerLibroCuesta8Euros() {
		assertEquals(8, l1.getPrecio(), delta);
	}
	
	@Test
	public void dosLibrosDistintosTienenUnDescuentoDel5PorCiento() {
		CalculadoraPrecio calc = new CalculadoraPrecio();
		Libro[] libros = new Libro[] {l1, l2}; 
		double precio = calc.calcularPrecio(libros);
		assertEquals(2*8*0.95, precio, delta);
	}
	
	@Test
	public void dosLibrosIgualesNoTienenDescuento() {
		CalculadoraPrecio calc = new CalculadoraPrecio();
		Libro[] libros = new Libro[] {l1, l1}; 
		double precio = calc.calcularPrecio(libros);
		assertEquals(2*8, precio, delta);
	}
	
	@Test(expected=AssertionError.class)
	public void compareTwoBigDecimals() throws Exception {
		BigDecimal a = new BigDecimal(8).add(new BigDecimal(8)).multiply(new BigDecimal(0.95));
		BigDecimal b = new BigDecimal(2*8*0.95);
		assertEquals(b, a);
	}

	@Test
	public void compareTwoNativeDecimals() throws Exception {
		double a = (8+8)*0.95;
		double b = 2*8*0.95;
		double delta = 0.1;
		for (int i=1; i<10; i++) {
			assertEquals(b, a, delta);
			delta = delta / 10;
		}
	}
}
