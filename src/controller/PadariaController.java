package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EletronicoDao;
import dao.PadariaDao;
import negocio.Eletronico;
import negocio.Padaria;
import dao.ProdutoDao;

public class PadariaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public PadariaController() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("back".equals(request.getParameter("op"))) {
			request.getRequestDispatcher("main.jsp").forward(request, response);		
		} else {
			request.getRequestDispatcher("padariaDetalhe.jsp").forward(request, response);		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			Padaria p = new Padaria(
					 null, 
					 request.getParameter("nome"), 
					 Float.valueOf(request.getParameter("peso")), 
					 Double.valueOf(request.getParameter("valor")), 
					 request.getParameter("localDepartamento"), 
					 request.getParameter("locaRetirada"), 
					 request.getParameter("nomeAtendente"));
			
			PadariaDao pao = new PadariaDao();
			pao.salvar(p);
			
			response.sendRedirect("MenuController?tela=padaria");
		 
	}


	}

