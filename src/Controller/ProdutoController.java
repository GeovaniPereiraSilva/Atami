package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DAOProdutoImpl;
import Entidades.Produto;

@WebServlet({ "/prodcontroller.do", "/produtocontroller", "/prodcontroller" })
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ProdutoController() {
    	
    	System.out.println("instanciando ProdutoController...");
       
    }

	public void init(ServletConfig config) throws ServletException {

			System.out.println("Chamando init...");
	}
	
	public void destroy() {
		System.out.println("Chamou destroy...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao =  request.getParameter("acao");
		
		//instancia do DAO
		DAOProdutoImpl produtoDAO =  new DAOProdutoImpl();
		
		if(acao!=null && acao.equals("exc")){
			
			String id = request.getParameter("id");
			
			if(id!=null){
			
				Produto usuExcluir =  new Produto();
				usuExcluir.setId(Integer.parseInt(id));
				produtoDAO.excluir(usuExcluir);
				//Pede para o navegador fazer a seguinte requisicao para 
				//causar o redirecionamento
				response.sendRedirect("usucontroller.do?acao=lis");
				
			}
			
		}else if(acao!=null && acao.equals("alt")){
			
			String id = request.getParameter("id");
			
			if(id!=null){
				
				//buscar por id				
				Produto ususalvar = produtoDAO.buscarPorId(Integer.parseInt(id));
				//criando atributo no request para enviar para o jsp 
				request.setAttribute("ususalvar", ususalvar);
				
				//encaminhar para o frmcadcliente
				request.getRequestDispatcher("frmcadcliente.jsp").forward(request, response);
				
			}
			
		}else if(acao!=null && acao.equals("lis")){
		
			//BUscando a lista do banco
			List<Produto> lista = produtoDAO.buscarTodos();
			
			//Colocando a lista como atributo para o jsp acesssa como parametro
			request.setAttribute("lista", lista);
			
			//Encaminhando para o jsp
			request.getRequestDispatcher("listaclientes.jsp").forward(request, response);
		} else if(acao!=null && acao.equals("cad")){
			Produto ususalvar = new Produto();
			ususalvar.setId(0);
			ususalvar.setNome("");
			ususalvar.setSenha("");
			ususalvar.setProduto("");
			
			//criando atributo no request para enviar para o jsp 
			request.setAttribute("ususalvar", ususalvar);
			
			//encaminhar para o frmcadcliente
			request.getRequestDispatcher("frmcadcliente.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamou por post");
		
		//Capturando dados da tela
		String txtid =  request.getParameter("txtid"); 
		String txtnome =  request.getParameter("txtnome"); 
		String txtcliente = request.getParameter("txtcliente");
		String txtsenha =  request.getParameter("txtsenha");
		
		//Intancia de cliente
		Produto cliente =  new Produto();
		
		if(txtid!=null){
			cliente.setId(Integer.parseInt(txtid));
		}
		
		cliente.setNome(txtnome);
		cliente.setProduto(txtcliente);
		cliente.setSenha(txtsenha);
		
		DAOProdutoImpl produtoDAO=  new DAOProdutoImpl();		
		produtoDAO.salvar(cliente);
		
		//Atribuicao de atributos ao request
		request.setAttribute("usu", cliente);
				
		
		//encaminha o fluxo para o JSP de saida
		request.getRequestDispatcher("saidacadcliente.jsp").forward(request, response);

	}

}