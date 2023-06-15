package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectDB.ConnectDB;
import model.Valor;

public class ValorDAO {

	/*
	 * CRUD C: CREATE R: READ U: UPDATE D: DELETE
	 */

	public void save(Valor valor) {
		String sql = "INSERT INTO valor(id_valor, preco)VALUES(?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria conexão com o banco de dados
			conn = ConnectDB.criarConexao();

			// criamos uma PrepareStatement para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, valor.getIdValor());
			pstm.setInt(2, valor.getPreco());
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

	// Método para listar os dados da tabela valor
	public List<Valor> getValor() {

		String sql = "SELECT * FROM valor ";

		List<Valor> valores = new ArrayList<Valor>();

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
				Valor valor = new Valor();
				// recuperar o ID do valor
				valor.setIdValor(0);
				// recuperar o preco
				valor.setPreco(rset.getInt("preco"));
				valores.add(valor);
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
		return valores;
	}

	// Método para alterar os dados de um valor
	public void alterarValor(Valor valor) throws ClassNotFoundException {

		// Cria a declaração SQL
		String sql = "UPDATE valor SET preco = ? WHERE ID_valor = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectDB.criarConexao();

			// Prepara a declaração SQL
			pstm = conn.prepareStatement(sql);

			// Define os parâmetros
			pstm.setInt(1, valor.getPreco());

			// Selecionar o ID que desejamos atualizar
			pstm.setInt(2, valor.getIdValor());

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

	// Método para deletar um valor
	public void deletarValor(int id) throws ClassNotFoundException {

		// Cria a query SQL
		String sql = "DELETE FROM valor WHERE ID_valor = ?";

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
