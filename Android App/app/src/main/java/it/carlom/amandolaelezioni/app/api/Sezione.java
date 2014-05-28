package it.carlom.amandolaelezioni.app.api;

public class Sezione {

	private int number;

	private int lista1;
	private int lista2;
	private int lista3;

	public Sezione(){
		
	}
	
	public Sezione(int number) {
		this.number = number;
		lista1 = 0;
		lista2 = 0;
		lista3 = 0;
	}

	public int getNumber() {
		return number;
	}

	public int getLista1() {
		return lista1;
	}

	public void setLista1(int lista1) {
		this.lista1 = lista1;
	}

	public int getLista2() {
		return lista2;
	}

	public void setLista2(int lista2) {
		this.lista2 = lista2;
	}

	public int getLista3() {
		return lista3;
	}

	public void setLista3(int lista3) {
		this.lista3 = lista3;
	}

}
