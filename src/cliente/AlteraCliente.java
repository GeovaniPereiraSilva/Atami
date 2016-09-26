
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
public class AlteraCliente extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/*Definição de String : 
		 * Uma variavel de String se trata de qualquer texto que é inserido no campo que contém essa variavel  
		 */
		String codigo = request.getParameter("codigo"); //Declarada variável de nome codigo que é uma string e recebendo seus valores por parâmetro do jsp (tela)
		String categoria = request.getParameter("idCategoria");//Declarada variável categoria que é uma string e recebendo seus valores por parâmetro do jsp (tela)
		String nome = request.getParameter("nome");//Declarada variável nome que é uma string e recebendo seus valores por parâmetro do jsp (tela)
		String telefone = request.getParameter("telefone");//Declarada variável telefone que é uma string e recebendo seus valores por parâmetro do jsp (tela)

		// Método de Validação do campo nome para evitar duplicações de  registros
		
				ClienteDAO dao = new DAOClienteImpl();
				String erro = null;
				if (dao.isNomeClienteValido(nome, 0, Integer.parseInt(categoria))) {
					if (!nome.isEmpty()) {
						try {
							dao.alterarCliente(nome,telefone,Integer.parseInt(codigo));
						} catch (NumberFormatException e) {
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
		out.println("<title>Alterar Cliente</title>");
		out.println("</head>");
		out.println("<body>");
		// Caso não exista nem um cliente cadastrado incluir o nome do cliente juntamente com os outros dados
		// gravando no Banco de Dados e retornando a mensagem de Sucesso na tela.
		if (erro == null) {
			out.println("<h4>Alteração efetuada com sucesso</h4>");
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