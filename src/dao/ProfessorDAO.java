package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectDB.ConnectDB;
import model.Professor;

public class ProfessorDAO {

	/*
	 * CRUD C: CREATE R: READ U: UPDATE D: DELETE
	 */

	public void save(Professor professor) {
		String sql = "INSERT INTO professor(id_professor, nome_professor) VALUES(?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria conexão com o banco de dados
			conn = ConnectDB.criarConexao();

			// criamos uma PrepareStatement para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, professor.getIdProfessor());
			pstm.setString(2, professor.getNomeProfessor());
			// executa a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// fechar as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Método para listar os dados da tabela professor
	public List<Professor> getProfessor() {

		String sql = "SELECT * FROM professor ";

		List<Professor> professores = new ArrayList<Professor>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Classe que vai recuperar os dados do banco
		ResultSet rset = null;

		try {
			// cria conexão com o banco de dados
			conn = ConnectDB.criarConexao();

			// criamos uma PrepareStatement para executar a query
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Professor professor = new Professor();

				// recuperar o ID do professor
				professor.setIdProfessor(1);
				// recuperar o nome do professor
				professor.setNomeProfessor(rset.getString("nome_professor"));
				professores.add(professor);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					conn.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return professores;
	}

	// Método para alterar os dados de um professor
	public void alterarProfessor(Professor professor) throws ClassNotFoundException {

		// Cria a declaração SQL
		String sql = "UPDATE professor SET nome_professor = ? WHERE ID_professor = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectDB.criarConexao();

			// Prepara a declaração SQL
			pstm = conn.prepareStatement(sql);

			// Define os parâmetros
			pstm.setString(1, professor.getNomeProfessor());

			// Selecionar o ID que desejamos atualizar
			pstm.setInt(2, professor.getIdProfessor());

			// Executa a declaração SQL
			pstm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Método para deletar um professor
	public void deletarProfessor(int id) throws ClassNotFoundException {

		// Cria a query SQL
		String sql = "DELETE FROM professor WHERE ID_professor = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectDB.criarConexao();

			// Prepara a declaração SQL
			pstm = conn.prepareStatement(sql);

			// Define o parâmetro
			pstm.setInt(1, id);

			// Executa a declaração SQL
			pstm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
