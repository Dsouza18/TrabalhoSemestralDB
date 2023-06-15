package model;

public class Turno {

	private int idTurno;
	private String nomeTurno;

	public Turno() {
		super();
	}

	public Turno(int idTurno, String nomeTurno) {
		super();
		this.idTurno = idTurno;
		this.nomeTurno = nomeTurno;
	}

	public int getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(int idTurno) {
		this.idTurno = idTurno;
	}

	public String getNomeTurno() {
		return nomeTurno;
	}

	public void setNomeTurno(String nomeTurno) {
		this.nomeTurno = nomeTurno;
	}

}
