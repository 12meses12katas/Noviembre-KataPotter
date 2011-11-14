package org.katas.potter;


public class CalculadoraPrecio {
	
	Grupo grupo = new Grupo();

	public double calcularPrecio(Cesta cesta) {
		grupo.agrupar(cesta.getLibros());
		double precio = grupo.calcularPrecio();
		return precio;
	}

}
