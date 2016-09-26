package Testes;

import ConexaoBD.Conexao;

public class TestConexao {

	public static void main(String[] args) {

		Conexao.getConnection();
		System.out.println("Conectado");
		
	}

}