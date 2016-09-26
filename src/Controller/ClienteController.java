package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DAOClienteImpl;
import Entidades.Cliente;

@WebServlet({ "/cliecontroller.do", "/clientecontroller", "/cliecontroller" })
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ClienteController() {
    	
    	System.out.println("instanciando ClienteController...");
       
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
		DAOClienteImpl clienteDAO =  new DAOClienteImpl();
		
		if(acao!=null && acao.equals("exc")){
			
			String id = request.getParameter("id");
			
			if(id!=null){
			
				Cliente usuExcluir =  new Cliente();
				usuExcluir.setId(Integer.parseInt(id));
				clienteDAO.excluir(usuExcluir);
				//Pede para o navegador fazer a seguinte requisicao para 
				//causar o redirecionamento
				response.sendRedirect("usucontroller.do?acao=lis");
				
			}
			
		}else if(acao!=null && acao.equals("alt")){
			
			String id = request.getParameter("id");
			
			if(id!=null){
				
				//buscar por id				
				Cliente ususalvar = clienteDAO.buscarPorId(Integer.parseInt(id));
				//criando atributo no request para enviar para o jsp 
				request.setAttribute("ususalvar", ususalvar);
				
				//encaminhar para o frmcadcliente
				request.getRequestDispatcher("frmcadcliente.jsp").forward(request, response);
				
			}
			
		}else if(acao!=null && acao.equals("lis")){
		
			//BUscando a lista do banco
			List<Cliente> lista = clienteDAO.buscarTodos();
			
			//Colocando a lista como atributo para o jsp acesssa como parametro
			request.setAttribute("lista", lista);
			
			//Encaminhando para o jsp
			request.getRequestDispatcher("listaclientes.jsp").forward(request, response);
		} else if(acao!=null && acao.equals("cad")){
			Cliente ususalvar = new Cliente();
			ususalvar.setId(0);
			ususalvar.setNome("");
			ususalvar.setSenha("");
			ususalvar.setCliente("");
			
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
		Cliente cliente =  new Cliente();
		
		if(txtid!=null){
			cliente.setId(Integer.parseInt(txtid));
		}
		
		cliente.setNome(txtnome);
		cliente.setCliente(txtcliente);
		cliente.setSenha(txtsenha);
		
		DAOClienteImpl clienteDAO=  new DAOClienteImpl();		
		clienteDAO.salvar(cliente);
		
		//Atribuicao de atributos ao request
		request.setAttribute("usu", cliente);
				
		
		//encaminha o fluxo para o JSP de saida
		request.getRequestDispatcher("saidacadcliente.jsp").forward(request, response);

	}

}