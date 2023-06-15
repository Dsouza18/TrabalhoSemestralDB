package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectDB.ConnectDB;
import model.Curso;

public class CursoDAO {

	/*
	 * CRUD C: CREATE R: READ U: UPDATE D: DELETE
	 */

	public void save(Curso curso) {
		String sql = "INSERT INTO curso(id_curso, nome_curso, descricao_curso) VALUES(?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria conexão com o banco de dados
			conn = ConnectDB.criarConexao();

			// criamos uma PrepareStatement para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, curso.getIdCurso());
			pstm.setString(2, curso.getNomeCurso());
			pstm.setString(3, curso.getDescricaoCurso());

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

	// Método para listar os dados da tabela cursos
	public List<Curso> getCurso() {

		String sql = "SELECT * FROM curso ";

		List<Curso> cursos = new ArrayList<Curso>();

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
				Curso curso = new Curso();
				// recuperar o ID do curso
				curso.setIdCurso(1);
				// recuperar o nome do curso
				curso.setNomeCurso(rset.getString("nome_curso"));
				// recuperar a descricao do curso
				curso.setDescricaoCurso(rset.getString("descricao_curso"));

				// adiciona a lista de cursos
				cursos.add(curso);
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
		return cursos;
	}

	// Método para alterar os dados de um curso
	public void alterarCurso(Curso curso) throws ClassNotFoundException {

		// Cria a declaração SQL
		String sql = "UPDATE curso SET nome_curso = ?, descricao_curso = ? WHERE ID_curso = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectDB.criarConexao();

			// Prepara a declaração SQL
			pstm = conn.prepareStatement(sql);

			// Define os parâmetros
			pstm.setString(1, curso.getNomeCurso());
			pstm.setString(2, curso.getDescricaoCurso());

			// Selecionar o ID que desejamos atualizar
			pstm.setInt(3, curso.getIdCurso());

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

	// Método para deletar um curso
	public void deletarCurso(int id) throws ClassNotFoundException {

		// Cria a query SQL
		String sql = "DELETE FROM curso WHERE ID_curso = ?";

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
