package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Cliente;

public interface DAOCliente {
	public boolean isNomeClienteValido(String nome, int id, int idtipo);
	public void excluirCliente(int id) throws SQLException;
	public ArrayList<Cliente> listarClientes() throws SQLException;
	public void alterarCliente(String nome, String telefone, int id) throws SQLException;
	public void incluirCliente(String nome, int categoria, String descricao) throws SQLException ;
}