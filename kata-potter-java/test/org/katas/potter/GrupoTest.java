package org.katas.potter;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrupoTest {
	
	LibroFactory factory = new LibroFactory();
	
	@Test
	public void unSoloGrupoDeLibros() {
		Grupo grupo = new Grupo();
		Libro[] libros = factory.crearCestaLibro(new int[] {0,1,2,3,4});
		grupo.agrupar(libros);
		int grupos = grupo.contarGrupos();
		assertEquals(1, grupos);
	}
	
	@Test
	public void distribucionDeLibrosOrdenadosDeMenorAMayor() {
		Grupo grupo = new Grupo();
		Libro[] libros = factory.crearCestaLibro(new int[] {1,1,2,2,3,3,4,4});
		grupo.agrupar(libros);
		int grupos = grupo.contarGrupos();
		assertEquals(2, grupos);
	}
	
	@Test
	public void distribucionDeLibrosAgrupados() {
		Grupo grupo = new Grupo();
		Libro[] libros = factory.crearCestaLibro(new int[] {1,2,3,4,1,2,3,4});
		grupo.agrupar(libros);
		int grupos = grupo.contarGrupos();
		assertEquals(2, grupos);
		
	}

	@Test
	public void distribucionDeLibrosEnGruposBalanceados() {
		Grupo grupo = new Grupo();
		Libro[] libros = factory.crearCestaLibro(new int[] {
				0,0,0,0,0,
				1,1,1,1,1,
				2,2,2,2,
				3,3,3,3,3,
				4,4,4,4
				});
		
		grupo.agrupar(libros);

		int grupos = grupo.contarGrupos();
		int[] tallas = grupo.tallasGrupos();
		assertEquals(5, grupos);
		assertArrayEquals(new int[] {5,5,5,5,3}, tallas);

		grupo.balancear();
		
		grupos = grupo.contarGrupos();
		tallas = grupo.tallasGrupos();
		assertEquals(5, grupos);
		assertArrayEquals(new int[] {5,5,5,4,4}, tallas);
	}

}
