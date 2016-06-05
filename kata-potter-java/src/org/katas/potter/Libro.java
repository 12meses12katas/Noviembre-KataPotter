package org.katas.potter;


public class Libro {

	private String titulo;
	public String getTitulo() {
		return titulo;
	}

	public double getPrecio() {
		return precio;
	}

	private double precio;

	public Libro(String titulo, double precio) {
		this.titulo = titulo;
		this.precio = precio;
	}

}
