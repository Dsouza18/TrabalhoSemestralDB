package model;

public class Modalidade {
	
	private int idModalidade;
	private String nomeModalidade;
	
	public Modalidade() {
		super();
	}

	public Modalidade(int idModalidade, String nomeModalidade) {
		super();
		this.idModalidade = idModalidade;
		this.nomeModalidade = nomeModalidade;
	}

	public int getIdModalidade() {
		return idModalidade;
	}

	public void setIdModalidade(int idModalidade) {
		this.idModalidade = idModalidade;
	}

	public String getNomeModalidade() {
		return nomeModalidade;
	}

	public void setNomeModalidade(String nomeModalidade) {
		this.nomeModalidade = nomeModalidade;
	}


}
