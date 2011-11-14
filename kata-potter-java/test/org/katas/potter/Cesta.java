package org.katas.potter;

import java.util.ArrayList;
import java.util.List;

public class Cesta {
	
	LibroFactory libroFactory;
	List<Libro> libros = new ArrayList<Libro>();

	public Cesta a–adir(int cantidad, int titulo) {
		List<Libro> libros = libroFactory.crearCestaLibro(cantidad, titulo);
		this.libros.addAll(libros);
		return this;
	}

	public Libro[] getLibros() {
		return this.libros.toArray(new Libro[0]);
	}

	public void setLibroFactory(LibroFactory libroFactory) {
		this.libroFactory = libroFactory;
	}

}
