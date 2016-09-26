package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConexaoBD.Conexao;
import Entidades.Cliente;

public class DAOClienteImpl implements ClienteDAO {
	Connection con = null;

	public DAOClienteImpl() {
		new Conexao();
		this.con = Conexao.getConnection();
	}

	// Método responsável por validar nome do cliente.
	
	public boolean isNomeClienteValido(String nome, int id, int idCategoria) {
		boolean valido = false;

		String sql = "select codigo from treinamento.clientes where nome=? and codigo<>? and idtipo=?";

		try {
			PreparedStatement stmt = this.con.prepareStatement(sql);

			stmt.setString(1, nome);
			stmt.setInt(2, id);
			stmt.setInt(3, idCategoria);

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

	// Método responsável por incluir cliente no banco de dados.

	public void incluirCliente(String nome, int categoria, String descricao)
			throws SQLException {

		String sql = "insert into treinamento.clientes(idtipo, nome, telefone) values(?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, categoria);
		stmt.setString(2, nome);
		stmt.setString(3, descricao);
		stmt.execute();
		stmt.close();
	}

	// Método responsável por excluir cliente no banco de dados.

	public void excluirCliente(int id) throws SQLException {

		PreparedStatement stmt = con
				.prepareStatement("delete from treinamento.clientes where codigo =?");
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
	}

	// Método responsável por alterar cliente no banco de dados.

	public void alterarCliente(String nome, String telefone, int id)
			throws SQLException {
		try {
			String sql = "update treinamento.clientes set nome=?, telefone=? where codigo=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, telefone);
			stmt.setInt(3, id);
			stmt.execute();

			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	// Método responsável por retornar uma lista de treinamento.clientes

	public ArrayList<Cliente> listarClientes() throws SQLException {
		String sql = "select * from treinamento.clientes";

		PreparedStatement stmt = this.con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		while (rs.next()) {
			Cliente c = new Cliente();
			c.setCodigo(rs.getInt("codigo"));
			c.setCategoria(rs.getInt("idtipo"));
			c.setNome(rs.getString("nome"));
			c.setTelefone(rs.getString("telefone"));
			lista.add(c);
		}
		stmt.close();
		return lista;
	}

	public void excluir(Cliente usuExcluir) {
		// TODO Auto-generated method stub
		
	}

	public Cliente buscarPorId(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void salvar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}
}
