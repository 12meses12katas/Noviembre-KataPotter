package org.katas.potter;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class DescuentoTest {

	static double delta = 0.01;
	private CalculadoraPrecio calc;
	private LibroFactory libroFactory;
	private Libro[] libros;

	@Before
	public void setUp() {
		calc = new CalculadoraPrecio();
		libroFactory = new LibroFactory();
	}

	@Test
	public void elPrimerLibroCuesta8Euros() {
		assertEquals(8, LibroFactory.l1.getPrecio(), delta);
	}

	@Test
	public void dosLibrosDistintosTienenUnDescuentoDel5PorCiento() {
		libros = libroFactory.crearCestaLibro(new int[] {0,1});
		double precio = calc.calcularPrecio(libros);
		assertEquals(2 * 8 * 0.95, precio, delta);
	}

	@Test
	public void dosLibrosIgualesNoTienenDescuento() {
		libros = libroFactory.crearCestaLibro(new int[] {0,0});
		double precio = calc.calcularPrecio(libros);
		assertEquals(2 * 8, precio, delta);
	}

	@Test(expected = AssertionError.class)
	public void compareTwoBigDecimals() throws Exception {
		BigDecimal a = new BigDecimal(8).add(new BigDecimal(8)).multiply(
				new BigDecimal(0.95));
		BigDecimal b = new BigDecimal(2 * 8 * 0.95);
		assertEquals(b, a);
	}

	@Test
	public void compareTwoNativeDecimals() throws Exception {
		double a = (8 + 8) * 0.95;
		double b = 2 * 8 * 0.95;
		double delta = 0.1;
		for (int i = 1; i < 10; i++) {
			assertEquals(b, a, delta);
			delta = delta / 10;
		}
	}

	@Test
	public void descuentosSimplesSinLibrosRepetidos() {
		double precio = 0;

		libros = libroFactory.crearCestaLibro(new int[] {0,1});
		precio = calc.calcularPrecio(libros);
		assertEquals(2 * 8 * 0.95, precio, delta);

		libros = libroFactory.crearCestaLibro(new int[] {0,1,2});
		precio = calc.calcularPrecio(libros);
		assertEquals(3 * 8 * 0.90, precio, delta);

		libros = libroFactory.crearCestaLibro(new int[] {0,1,2,3});
		precio = calc.calcularPrecio(libros);
		assertEquals(4 * 8 * 0.80, precio, delta);

		libros = libroFactory.crearCestaLibro(new int[] {0,1,2,3,4});
		precio = calc.calcularPrecio(libros);
		assertEquals(5 * 8 * 0.75, precio, delta);
	}

	@Test
	public void descuentosEnVariosGrupos() {
		double precio = 0;

		libros = libroFactory.crearCestaLibro(new int[] {0,0,1});
		precio = calc.calcularPrecio(libros);
		assertEquals(8 + 2 * 8 * 0.95, precio, delta);

		libros = libroFactory.crearCestaLibro(new int[] {0,0,1,1});
		precio = calc.calcularPrecio(libros);
		assertEquals(2 * 2 * 8 * 0.95, precio, delta);

		libros = libroFactory.crearCestaLibro(new int[] {
				0,0,
				1,1,
				2,3
				});
		precio = calc.calcularPrecio(libros);
		assertEquals((8 * 4 * 0.8) + (8 * 2 * 0.95), precio, delta);
		
	}

	@Test
	public void descuentosComplejos() {
		double precio = 0;

		libros = libroFactory.crearCestaLibro(new int[] {0,0,0,0,0,1,1,1,1,1,2,2,2,2,3,3,3,3,3,4,4,4,4});
		precio = calc.calcularPrecio(libros);
		assertEquals(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8), precio, delta);
	}
}
