package model;

public class Professor {

	private int idProfessor;
	private String nomeProfessor;

	public Professor() {
		super();
	}

	public Professor(int idProfessor, String nomeProfessor) {
		super();
		this.idProfessor = idProfessor;
		this.nomeProfessor = nomeProfessor;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

}
