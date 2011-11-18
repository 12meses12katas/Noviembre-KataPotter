package org.katas.potter;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Grupo {

	Set<Libro> grupo = new HashSet<Libro>();
	Grupo otroGrupo;
	double[] descuentos = new double[] { 0, 1, 0.95, 0.90, 0.80, 0.75 };

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
		double precioOtroGrupo = otroGrupo != null ? otroGrupo.calcularPrecio()
				: 0;
		return precio * descuento + precioOtroGrupo;
	}

	public int contarGrupos() {
		int cantidadDeGrupos = 0;
		if (this.grupo != null && this.grupo.size() > 0)
			cantidadDeGrupos++;
		if (this.otroGrupo != null)
			cantidadDeGrupos += otroGrupo.contarGrupos();
		return cantidadDeGrupos;
	}

	public void balancear() {
		if (this.otroGrupo != null) {
			if (this.grupo.size() - this.otroGrupo.grupo.size() > 1) {
				Iterator<Libro> it = this.grupo.iterator();
				while (it.hasNext()) {
					Libro libro = (Libro) it.next();
					if (this.otroGrupo.push(libro)) {
						it.remove();
						break;
					}
				}
			}
			this.otroGrupo.balancear();
		}
	}

	public boolean push(Libro libro) {
		boolean libroYaExisteEnElGrupo = !grupo.add(libro);
		if (libroYaExisteEnElGrupo) {
			if (otroGrupo != null)
				libroYaExisteEnElGrupo = otroGrupo.push(libro);
		}
		return !libroYaExisteEnElGrupo;
	}

	public int[] tallasGrupos() {
		int[] tallas = new int[this.contarGrupos()];
		Grupo g = this;
		for (int i=0; i<tallas.length; i++) {
			tallas[i] = g.grupo.size();
			g = g.otroGrupo;
		}
		return tallas;
	}
}
