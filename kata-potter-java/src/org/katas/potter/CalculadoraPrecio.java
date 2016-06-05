package org.katas.potter;


public class CalculadoraPrecio {
	

	public double calcularPrecio(Libro[] libros) {
		Grupo grupo = new Grupo();
		grupo.agrupar(libros);
		double precio = grupo.calcularPrecio();
		grupo.balancear();
		double precioBalanceado = grupo.calcularPrecio();
		if (precioBalanceado < precio)
			precio = precioBalanceado;
		return precio;
	}

}
