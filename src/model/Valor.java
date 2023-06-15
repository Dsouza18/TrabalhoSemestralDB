package model;

public class Valor {
	
	private int idValor;
	private int preco;
	
	public Valor() {
		super();
	}

	public Valor(int idValor, int preco) {
		super();
		this.idValor = idValor;
		this.preco = preco;
	}

	public int getIdValor() {
		return idValor;
	}

	public void setIdValor(int idValor) {
		this.idValor = idValor;
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	

}
