package org.katas.potter;

import java.util.ArrayList;
import java.util.List;

public class LibroFactory {
	
	static Libro l1 = new Libro("Harry Potter y la piedra filosofal", 8);
	static Libro l2 = new Libro("Harry Potter y la c‡mara secreta", 8);
	static Libro l3 = new Libro("Harry Potter y el prisionero de Azkab‡n", 8);
	static Libro l4 = new Libro("Harry Potter y el c‡liz de fuego", 8);
	static Libro l5 = new Libro("Harry Potter y la Orden del FŽlix", 8);
	static Libro l6 = new Libro("Harry Potter y el misterio del pr’ncipe", 8);
	static Libro l7 = new Libro("Harry Potter y las reliquias de la muerte", 8);
	static Libro[] listaLibros = new Libro[] {l1, l2, l3, l4, l5, l6, l7};

	public List<Libro> crearCestaLibro(int cantidad, int titulo) {
		List<Libro> libros = new ArrayList<Libro>();
		for (int i=0; i<cantidad; i++) {
			libros.add(listaLibros[titulo]);
		}
		return libros;
	}

}
