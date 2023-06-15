package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectDB.ConnectDB;
import model.Turno;

public class TurnoDAO {

	// Método para inserir um turno
	public void save(Turno turno) {
		String sql = "INSERT INTO turno (id_turno, nome_turno) VALUES(?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria conexão com o banco de dados
			conn = ConnectDB.criarConexao();

			// criamos uma PrepareStatement para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, turno.getIdTurno());
			pstm.setString(2, turno.getNomeTurno());
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

	// Método para listar os dados da tabela turno
	public List<Turno> getTurno() {

		String sql = "SELECT * FROM turno ";

		List<Turno> turnos = new ArrayList<Turno>();

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
				Turno turno = new Turno();
				// recuperar o ID do turno
				turno.setIdTurno(rset.getInt("id_turno"));
				// recuperar o nome do turno
				turno.setNomeTurno(rset.getString("nome_turno"));
				turnos.add(turno);
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
		return turnos;
	}

	// Método para alterar os dados de um turno
	public void alterarTurno(Turno turno) throws ClassNotFoundException {

		// Cria a declaração SQL
		String sql = "UPDATE turno SET nome_turno = ? WHERE ID_turno = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectDB.criarConexao();

			// Prepara a declaração SQL
			pstm = conn.prepareStatement(sql);

			// Define os parâmetros
			pstm.setString(1, turno.getNomeTurno());

			// Selecionar o ID que desejamos atualizar
			pstm.setInt(2, turno.getIdTurno());

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

	// Método para deletar um turno
	public void deletarTurno(int id) throws ClassNotFoundException {

		// Cria a query SQL
		String sql = "DELETE FROM Turno WHERE ID_turno = ?";

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
