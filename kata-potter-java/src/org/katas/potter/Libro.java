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
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Libro) {
			Libro libro = (Libro)obj;
			String titulo = libro.getTitulo();
			if (titulo != null)
				return titulo.equals(this.titulo);
			else
				return super.equals(obj);
		}
		return super.equals(obj);
	}

}
