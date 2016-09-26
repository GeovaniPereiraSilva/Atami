// Pacotes
package cliente;

// Importações
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClienteDAO;
import Dao.DAOClienteImpl;

@SuppressWarnings("serial")
public class IncluirCliente extends HttpServlet {

	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		//Declarando Variaveis e recebendo seus valores por parâmetro do jsp que serão exibidos na tela.
		
/*Definição de String : 
* Uma variavel de String se trata de qualquer texto que é inserido no campo que contém essa variavel  
*/
		String nome = request.getParameter("nome");//Declarada variável nome que é uma string e recebendo seus valores por parâmetro do jsp (tela)
		String categoria = request.getParameter("categoria");//Declarada variável categoria que é uma string e recebendo seus valores por parâmetro do jsp (tela)
		String telefone = request.getParameter("telefone");//Declarada variável telefone que é uma string e recebendo seus valores por parâmetro do jsp (tela)

		ClienteDAO dao = new DAOClienteImpl();
		String erro = null;
		if (dao.isNomeClienteValido(nome, 0, Integer.parseInt(categoria))) {
			if (!nome.isEmpty()) {
			
				try {// código que inclui comandos/invocações de métodos, que podem gerar uma situação de exceção.
					dao.incluirCliente(nome, Integer.parseInt(categoria), telefone);
				} catch (NumberFormatException e) {// tratamento para a situação de exceção.
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			erro = "Nome do cliente já cadastrado para o tipo selecionado";
		}
	
		response.setContentType("text/html; charset=iso-8859-1;");
		PrintWriter out = response.getWriter();

		
		// Apresentando na tela com código HTML.
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Cadastro Cliente</title>");
		out.println("</head>");
		out.println("<body>");
		// Caso não exista nem um cliente cadastrado incluir o nome do cliente juntamente com os outros dados
		// gravando no Banco de Dados e retornando a mensagem de Sucesso na tela.la.
		
		if (erro == null) {
			out.println("<h4>Operação efetuada com sucesso</h4>");
			out.println("<a href='listar_cliente.jsp'><input type='button' value='Listar'></a>");
		
			// Se houver o nome de cliente já cadastrado no BD, depois de fazer a consulta procurando e constatando,
			// retornar mensagem de que o usuário já está cadastrado e voltar a pagina de alteração.
		
			} else {
			out.println("<h4>" + erro + "</h4>");
			out.println("<a href='javascript:window.history.go(-1)'><input type='button' value='Voltar'></a>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}