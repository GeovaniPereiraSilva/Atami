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
public class AlterarProduto extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Declarando Variaveis
		String nome = request.getParameter("nome");
		String codigo = request.getParameter("codigo");
		String descricao = request.getParameter("descricao");
		String categoria = request.getParameter("idCategoria");

		ProdutoDAO dao = new DAOProdutoImpl();
		String erro = null;
		try {

			// Validar se o campo nome é empty
			if (dao.isNomeProdutoValido(nome, 0, Integer.parseInt(categoria))) {
				if (!nome.isEmpty()) {
					dao.alterarProduto(nome, descricao,
							Integer.parseInt(codigo));
				}
			} else {
				erro = "Nome do produto já cadastrado para a categoria selecionada";
			}

		} catch (SQLException e) {
			e.printStackTrace();
			erro = "Erro na operação alterar";
		}

		response.setContentType("text/html; charset=iso-8859-1;");
		PrintWriter out = response.getWriter();

		// Apresentando na tela em forma de HTML
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Alterar Produto</title>");
		out.println("</head>");
		out.println("<body>");
		if (erro == null) {
			out.println("<h4>Alteração Efetuada com Sucesso</h4>");
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
