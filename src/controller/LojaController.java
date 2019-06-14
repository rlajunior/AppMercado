package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LojaDao;
import negocio.Loja;

public class LojaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LojaController() {
        super();
       
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("back".equals(request.getParameter("op"))) {
			request.getRequestDispatcher("main.jsp").forward(request, response);		
		} else {
			request.getRequestDispatcher("lojaDetalhe.jsp").forward(request, response);		
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Loja l = new Loja(
				null, 
				request.getParameter("nome"), 
				request.getParameter("endereco"), 
				request.getParameter("bairro"));
		
		LojaDao lao = new LojaDao();
		lao.salvar(l);
				
		request.setAttribute("titulo", "Loja");
		request.setAttribute("mensagem", l.toString());
		request.setAttribute("controller", "LojaController");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	 
		}		
	}
		


