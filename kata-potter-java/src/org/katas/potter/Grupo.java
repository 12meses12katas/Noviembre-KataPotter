package org.katas.potter;

import java.util.HashSet;
import java.util.Set;

public class Grupo {
	
	Set<Libro> grupo = new HashSet<Libro>();
	Grupo otroGrupo;
	double[] descuentos = new double[] {0, 1, 0.95, 0.90, 0.80, 0.75}; 

	public void agrupar(Libro[] libros) {
		for (int i = 0; i < libros.length; i++) {
			agrupar(libros[i]);
		}
	}

	public void agrupar(Libro libro) {
		boolean libroYaExisteEnElGrupo = !grupo.add(libro);
		if (libroYaExisteEnElGrupo) {
			if (otroGrupo == null)
				otroGrupo = new Grupo();
			otroGrupo.agrupar(libro);
		}
	}

	public double calcularPrecio() {
		int cuantosLibrosHayEnElGrupo = grupo.size();
		double precio = 8 * cuantosLibrosHayEnElGrupo; 
		double descuento = descuentos[cuantosLibrosHayEnElGrupo];
		double precioOtroGrupo = otroGrupo != null ? otroGrupo.calcularPrecio() : 0;
		return precio * descuento + precioOtroGrupo;
	}

}
