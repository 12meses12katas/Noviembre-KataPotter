package org.katas.potter;


public class CalculadoraPrecio {
	
	Grupo grupo = new Grupo();

	public double calcularPrecio(Libro[] libros) {
		grupo.agrupar(libros);
		double precio = grupo.calcularPrecio();
		return precio;
	}

}
