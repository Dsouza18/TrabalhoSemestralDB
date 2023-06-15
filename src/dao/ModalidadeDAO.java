package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectDB.ConnectDB;
import model.Modalidade;

public class ModalidadeDAO {

	/*
	 * CRUD C: CREATE R: READ U: UPDATE D: DELETE
	 */

	public void save(Modalidade modalidade) {
		String sql = "INSERT INTO modalidade(id_modalidade, nome_modalidade) VALUES(?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria conexão com o banco de dados
			conn = ConnectDB.criarConexao();

			// criamos uma PrepareStatement para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, modalidade.getIdModalidade());
			pstm.setString(2, modalidade.getNomeModalidade());
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
	
	// Método para listar os dados da tabela modalidade
		public List<Modalidade> getModalidade() {

			String sql = "SELECT * FROM modalidade ";

			List<Modalidade> modalidades = new ArrayList<Modalidade>();

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
					Modalidade modalidade = new Modalidade();

					// recuperar o ID da modalidade
					modalidade.setIdModalidade(1);;
					// recuperar o nome da modalidade
					modalidade.setNomeModalidade(rset.getString("nome_modalidade"));
					modalidades.add(modalidade);
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
			return modalidades;
		}

		// Método para alterar os dados de uma modalidade
		public void alterarModalidade(Modalidade modalidade) throws ClassNotFoundException {

			// Cria a declaração SQL
			String sql = "UPDATE modalidade SET nome_modalidade = ? WHERE ID_modalidade = ?";

			Connection conn = null;
			PreparedStatement pstm = null;
			try {
				conn = ConnectDB.criarConexao();

				// Prepara a declaração SQL
				pstm = conn.prepareStatement(sql);

				// Define os parâmetros
				pstm.setString(1, modalidade.getNomeModalidade());

				// Selecionar o ID que desejamos atualizar
				pstm.setInt(2, modalidade.getIdModalidade());

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

		// Método para deletar uma modalidade
		public void deletarModalidade(int id) throws ClassNotFoundException {

			// Cria a query SQL
			String sql = "DELETE FROM modalidade WHERE ID_modalidade = ?";

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
