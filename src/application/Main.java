package application;

import dao.CargaHorariaDAO;
import dao.CursoDAO;
import dao.ModalidadeDAO;
import dao.ProfessorDAO;
import dao.TurnoDAO;
import dao.ValorDAO;
import model.CargaHoraria;
import model.Curso;
import model.Modalidade;
import model.Professor;
import model.Turno;
import model.Valor;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {

		CargaHorariaDAO CargaHorariaDAO = new CargaHorariaDAO();

		CargaHoraria cargaHoraria = new CargaHoraria();
		cargaHoraria.setIdCargaHoraria(1);
		cargaHoraria.setHoras(30);

		CargaHorariaDAO.save(cargaHoraria);
		
		// Aqui temos um laço de repetição para listar os dados do Banco
		for (CargaHoraria ch : CargaHorariaDAO.getCargaHoraria()) {
			System.out.println("Carga Horaria: " + ch.getIdCargaHoraria());
		}

		// Aqui temos os métodos de atualização dos dados no DB
		CargaHoraria cargaHoraria1 = new CargaHoraria();
		cargaHoraria1.setIdCargaHoraria(1);
		cargaHoraria1.setHoras(40);

		CargaHorariaDAO.alterarCargaHoraria(cargaHoraria1);

		// Aqui temos a chamada do métodos para deletar os dados no DB
			CargaHorariaDAO.deletarCargaHoraria(1);


		CursoDAO cursoDAO = new CursoDAO();

		Curso curso = new Curso();
		curso.setIdCurso(1);
		curso.setNomeCurso("Analise e desenvolvimento de sistemas");
		curso.setDescricaoCurso("Curso de tecnologia");

		cursoDAO.save(curso);
		
		for (Curso cs : cursoDAO.getCurso()) {
			System.out.println("Curso: " + cs.getNomeCurso());
		}

		// Aqui temos os métodos de atualização dos dados no DB
		
		Curso curso1 = new Curso();
		curso1.setIdCurso(1);;
		curso1.setNomeCurso("Direito");
		curso1.setDescricaoCurso("Curso voltado para a area juridica");

		cursoDAO.alterarCurso(curso1);

		// Aqui temos a chamada do métodos para deletar os dados no DB
		cursoDAO.deletarCurso(1);

		ModalidadeDAO modalidadeDAO = new ModalidadeDAO();

		Modalidade modalidade = new Modalidade();
		modalidade.setIdModalidade(2);
		modalidade.setNomeModalidade("Hibrido");

		modalidadeDAO.save(modalidade);
		
		// Aqui temos um laço de repetição para listar os dados do Banco
		for (Modalidade m : modalidadeDAO.getModalidade()) {
			System.out.println("modalidade: " + m.getNomeModalidade());
		}

		// Aqui temos os métodos de atualização dos dados no DB
		Modalidade modalidade1 = new Modalidade();
		modalidade1.setIdModalidade(1);
		modalidade1.setNomeModalidade("presencial");

		modalidadeDAO.alterarModalidade(modalidade1);

		// Aqui temos a chamada do métodos para deletar os dados no DB
		modalidadeDAO.deletarModalidade(1);
		

		// Aqui temos os métodos de inserção de dados no DB
		ProfessorDAO professorDAO = new ProfessorDAO();

		Professor professor = new Professor();
		professor.setIdProfessor(1);
		professor.setNomeProfessor("Angela Peixoto");

		professorDAO.save(professor);

		// Aqui temos um laço de repetição para listar os dados do Banco
		for (Professor p : professorDAO.getProfessor()) {
			System.out.println("professores: " + p.getNomeProfessor());
		}

		// Aqui temos os métodos de atualização dos dados no DB
		Professor professor1 = new Professor();
		professor1.setIdProfessor(1);
		professor1.setNomeProfessor("Rosangela");

		professorDAO.alterarProfessor(professor1);

		// Aqui temos a chamada do métodos para deletar os dados no DB
		professorDAO.deletarProfessor(1);

		// Aqui temos os métodos de inserção de dados no DB
		TurnoDAO turnoDAO = new TurnoDAO();

		Turno turno = new Turno();
		turno.setIdTurno(3);
		turno.setNomeTurno("Matutino");

		turnoDAO.save(turno);

		// Aqui temos um laço de repetição para listar os dados do Banco
		for (Turno t : turnoDAO.getTurno()) {
			System.out.println("turno: " + t.getNomeTurno());
		}

		// Aqui temos os métodos de atualização dos dados no DB
		Turno turno1 = new Turno();
		turno.setIdTurno(3);
		turno.setNomeTurno("Noturno");

		turnoDAO.alterarTurno(turno1);

		// Aqui temos a chamada do métodos para deletar os dados no DB
		turnoDAO.deletarTurno(3);

		
		
		ValorDAO valorDAO = new ValorDAO();

		Valor valor = new Valor();
		valor.setIdValor(1);
		valor.setPreco(800);

		valorDAO.save(valor);
		
		// Aqui temos um laço de repetição para listar os dados do Banco
		for (Valor v : valorDAO.getValor()) {
			System.out.println("valor: " + v.getPreco());
		}

		// Aqui temos os métodos de atualização dos dados no DB
		Valor valor1 = new Valor();
		valor1.setIdValor(1);
		valor1.setPreco(1500);

		valorDAO.alterarValor(valor1);
		// Aqui temos a chamada do métodos para deletar os dados no DB
		valorDAO.deletarValor(1);

	}
}
