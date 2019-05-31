package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SupervisorDao;
import negocio.Supervisor;




public class SupervisorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SupervisorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("back".equals(request.getParameter("op"))) {
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}	else {
			request.getRequestDispatcher("supervisorDetalhe.jsp").forward(request, response);
	
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Supervisor s = new Supervisor(
				null, 
				request.getParameter("nome"), 
				request.getParameter("email"), 
				Integer.valueOf(request.getParameter("anoEntrada")), 
				true );
		
		SupervisorDao sao = new SupervisorDao();
		sao.salvar(s);
				
		response.sendRedirect("MenuController?tela=supervisor");
	
	}
	
}
