package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Produto;


public interface DAOProduto {
	public boolean isNomeProdutoValido(String nome, int id, int idcategoria);
	public void incluirProduto(String nome, int categoria, String descricao) throws SQLException;
	public void excluirProduto(int id) throws SQLException;
	public void alterarProduto(String nome, String descricao, int id) throws SQLException;
	public ArrayList<Produto> listarProdutos() throws SQLException;

}