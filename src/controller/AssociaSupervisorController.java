package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LojaDao;
import dao.LojaProduto;
import dao.LojaSupervisor;
import dao.ProdutoDao;
import dao.SupervisorDao;
import negocio.Loja;

public class AssociaSupervisorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AssociaSupervisorController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("back".equals(request.getParameter("op"))) {
			response.sendRedirect("MenuController?tela=loja");
		}else {
			redirectPaginaDeAssociacao(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if ("associar".equals(request.getParameter("op"))) {
			
			LojaSupervisor lao = new LojaSupervisor();
			lao.salvar(Integer.parseInt(request.getParameter("idSupervisor")),Integer.parseInt(request.getParameter("idLoja")));
			
			response.sendRedirect("AssociaSupervisorController?idLoja=" +request.getParameter("idLoja"));			
		}
	}

	private void redirectPaginaDeAssociacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("listaAssociados",SupervisorDao.obterSupervisorAssociadosALoja(Integer.parseInt( request.getParameter("idLoja"))));
		request.setAttribute("lista", SupervisorDao.obterSupervisorNaoAssociadosALoja());
		Loja loja = LojaDao.buscarPorId(Integer.parseInt(request.getParameter("idLoja")));
		
		request.setAttribute("loja", loja);
		
		request.setAttribute("idLoja", request.getParameter("idLoja"));
		request.getRequestDispatcher("associaSupervisor.jsp").forward(request, response);
	}
}
