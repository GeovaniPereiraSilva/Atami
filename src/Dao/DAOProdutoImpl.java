// Pacotes
package Dao;

// Importações
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConexaoBD.Conexao;
import Entidades.Produto;

public class DAOProdutoImpl implements ProdutoDAO {
	Connection con = null;

	public DAOProdutoImpl() {
		new Conexao();
		this.con = Conexao.getConnection();
	}

 // Método responsável por validar nome do produto.
	 
	public boolean isNomeProdutoValido(String nome, int id, int idcategoria) {
		boolean valido = false;

		String sql = "select codigo from treinamento.produtos where nome=? and codigo<>? and idcategoria=?";

		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);

			stmt.setString(1, nome);
			stmt.setInt(2, id);
			stmt.setInt(3, idcategoria);

			ResultSet rs = stmt.executeQuery();

			if (!rs.next()) {
				valido = true;
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return valido;
	}

	
// Método responsável por incluir produto no banco de dados.

	public void incluirProduto(String nome, int categoria, String descricao)
			throws SQLException {

		String sql = "insert into treinamento.produtos(idcategoria, nome, descricao) values(?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, categoria);
		stmt.setString(2, nome);
		stmt.setString(3, descricao);
		stmt.execute();
		stmt.close();
	}

	
// Método responsável por excluir produto no banco de dados.

	public void excluirProduto(int id) throws SQLException {

		PreparedStatement stmt = con
				.prepareStatement("delete from treinamento.produtos where codigo =?");
		stmt.setLong(1, id);
		stmt.execute();

		stmt.close();
	}


// Método responsável por alterar produto no banco de dados.

	public void alterarProduto(String nome, String descricao, int id)
			throws SQLException {
		try {
			String sql = "update treinamento.produtos set nome=?, descricao=? where codigo=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, descricao);
			stmt.setInt(3, id);
			stmt.execute();

			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

// Método responsável por retornar uma lista de treinamento.produtos
	
	public ArrayList<Produto> listarProdutos() throws SQLException {
		String sql = "select * from treinamento.produtos";

		PreparedStatement stmt = this.con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		ArrayList<Produto> lista = new ArrayList<Produto>();

		while (rs.next()) {
			Produto p = new Produto();
			p.setCodigo(rs.getInt("codigo"));
			p.setCategoria(rs.getInt("idcategoria"));
			p.setNome(rs.getString("nome"));
			p.setDescricao(rs.getString("descricao"));
			lista.add(p);
		}
		stmt.close();
		return lista;
	}

	public Produto buscarPorId(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Produto> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvar(Produto cliente) {
		// TODO Auto-generated method stub
		
	}

	public void excluir(Produto usuExcluir) {
		// TODO Auto-generated method stub
		
	}

}