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
public class ExcluirProduto extends HttpServlet {

// ???
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String codigo = request.getParameter("codigo");
		ProdutoDAO dao = new DAOProdutoImpl();
		String erro = null;
		try {
			dao.excluirProduto(Integer.parseInt(codigo));
		} catch (SQLException e) {
			e.printStackTrace();
			erro = "Erro na operação excluir";
		}
		
		response.setContentType("text/html; charset=iso-8859-1;");
		PrintWriter out = response.getWriter();

// Apresentando em forma de HTML na tela
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Excluir Produto</title>");
		out.println("</head>");
		out.println("<body>");
		if (erro == null) {
			out.println("<h4>Exclusão efetuada com sucesso</h4>");
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