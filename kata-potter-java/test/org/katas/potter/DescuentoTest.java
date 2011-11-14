package org.katas.potter;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class DescuentoTest {
	

	static double delta = 0.01;
	private CalculadoraPrecio calc;
	private LibroFactory libroFactory;
	private Cesta cesta;
	
	@Before
	public void setUp() {
		calc = new CalculadoraPrecio();
		libroFactory = new LibroFactory();
		cesta = new Cesta();
		cesta.setLibroFactory(libroFactory);
	}
	
	@Test
	public void elPrimerLibroCuesta8Euros() {
		assertEquals(8, LibroFactory.l1.getPrecio(), delta);
	}
	
	
	@Test
	public void dosLibrosDistintosTienenUnDescuentoDel5PorCiento() {
		cesta.a–adir(1, 0).a–adir(1, 1);
		double precio = calc.calcularPrecio(cesta);
		assertEquals(2*8*0.95, precio, delta);
	}
	
	@Test
	public void dosLibrosIgualesNoTienenDescuento() {
		cesta.a–adir(1, 0).a–adir(1, 0);
		double precio = calc.calcularPrecio(cesta);
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
