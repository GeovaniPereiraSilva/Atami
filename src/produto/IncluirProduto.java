// Pacotes

package produto;

// Importações
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProdutoDAO;
import Dao.DAOProdutoImpl;

@SuppressWarnings("serial")
public class IncluirProduto extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

// Declarando Variaveis		
		String nome = request.getParameter("nome");
		String categoria = request.getParameter("categoria");
		String descricao = request.getParameter("descricao");

		ProdutoDAO dao = new DAOProdutoImpl();
		String erro = null;
		try {
			
// Validar se o campo nome é empty
			
			if (dao.isNomeProdutoValido(nome, 0,Integer.parseInt(categoria))) {
				if (!nome.isEmpty()) {
					dao.incluirProduto(nome, Integer.parseInt(categoria),descricao);
				} else {
					erro = "Nome do produto obrigatório!";
				}
			} else {
				erro = "Nome do produto já cadastrado para a categoria selecionada";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			erro = "Erro na operação incluir";
		}

		response.setContentType("text/html; charset=iso-8859-1;");
		PrintWriter out = response.getWriter();
		
// Apresentando na tela em forma de HTML
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Novo Produto</title>");
		out.println("</head>");
		out.println("<body>");
		if (erro == null) {
			out.println("<h4>Inclusão efetuada com sucesso</h4>");
			out.println("<a href='listar_produto.jsp'><input type='button' value='Listar'></a>");
		} else {
			out.println("<h4>" + erro + "</h4>");
			out.println("<a href='javascript:window.history.go(-1)'><input type='button' value='Voltar'></a>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}