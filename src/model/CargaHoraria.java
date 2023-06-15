package model;

public class CargaHoraria {

	private int idCargaHoraria;
	private int horas;

	public CargaHoraria() {
		super();
	}

	public CargaHoraria(int idCargaHoraria, int horas) {
		super();
		this.idCargaHoraria = idCargaHoraria;
		this.horas = horas;
	}

	public int getIdCargaHoraria() {
		return idCargaHoraria;
	}

	public void setIdCargaHoraria(int idCargaHoraria) {
		this.idCargaHoraria = idCargaHoraria;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

}
