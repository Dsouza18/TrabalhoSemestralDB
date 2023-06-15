package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectDB.ConnectDB;
import model.CargaHoraria;

public class CargaHorariaDAO {

	/*
	 * CRUD C: CREATE R: READ U: UPDATE D: DELETE
	 */

	public void save(CargaHoraria cargaHoraria) {
		String sql = "INSERT INTO carga_horaria(id_carga_horaria, horas)VALUES(?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria conexão com o banco de dados
			conn = ConnectDB.criarConexao();

			// criamos uma PrepareStatement para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cargaHoraria.getIdCargaHoraria());
			pstm.setInt(2, cargaHoraria.getHoras());
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

	// Método para listar os dados da tabela carga horaria
	public List<CargaHoraria> getCargaHoraria() {

		String sql = "SELECT * FROM carga_horaria ";

		List<CargaHoraria> cargasHorarias = new ArrayList<CargaHoraria>();

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
				CargaHoraria cargaHoraria = new CargaHoraria();

				// recuperar o ID da carga horaria
				cargaHoraria.setIdCargaHoraria(0);
				// recuperar a quantidade de horas
				cargaHoraria.setHoras(0);

				cargasHorarias.add(cargaHoraria);
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
		return cargasHorarias;
	}

	// Método para alterar os dados de uma carga horaria
	public void alterarCargaHoraria(CargaHoraria cargaHoraria) throws ClassNotFoundException {

		// Cria a declaração SQL
		String sql = "UPDATE carga_horaria SET horas = ? WHERE ID_carga_horaria = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectDB.criarConexao();

			// Prepara a declaração SQL
			pstm = conn.prepareStatement(sql);

			// Define os parâmetros
			pstm.setInt(1, cargaHoraria.getHoras());

			// Selecionar o ID que desejamos atualizar
			pstm.setInt(2, cargaHoraria.getIdCargaHoraria());

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

	// Método para deletar uma carga horaria
	public void deletarCargaHoraria(int id) throws ClassNotFoundException {

		// Cria a query SQL
		String sql = "DELETE FROM carga_horaria WHERE ID_carga_horaria = ?";

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
