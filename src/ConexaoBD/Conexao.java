package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;

// Publicando a Classe
public class Conexao {
	private static Connection con = null;

	// Conectando com o Banco de Dados
	public static Connection getConnection() {

		if (con == null) {
			try {
				Class.forName("org.postgresql.Driver").newInstance(); // Inserindo o Driver para fazer a conexão com o Banco de dados escolhido
				//con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres?user=postgres&password=geovani123"); // Inserindo o Banco de Dados, local onde ele está (IP), o Banco de Dados, usuário e a senha cadastrados.
				con = DriverManager.getConnection("jdbc:postgresql://192.168.0.3/treinamento?user=cresol&password=%%cresol"); // Inserindo o Banco de Dados, local onde ele está (IP), o Banco de Dados, usuário e a senha cadastrados.				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return con;
	}
}