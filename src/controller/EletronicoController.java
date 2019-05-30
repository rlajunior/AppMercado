package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EletronicoDao;
import dao.ProdutoDao;
import negocio.Eletronico;

public class EletronicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EletronicoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if("back".equals(request.getParameter("op"))) {
			request.getRequestDispatcher("main.jsp").forward(request, response);		
		} else {
			request.getRequestDispatcher("eletronicoDetalhe.jsp").forward(request, response);		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Eletronico e = new Eletronico(
				 null, 
				 request.getParameter("nome"), 
				 Float.valueOf(request.getParameter("peso")), 
						 Double.valueOf(request.getParameter("valor")), 
						 request.getParameter("local"), 
						 request.getParameter("locaRetirada"), 
						 Integer.valueOf(request.getParameter("anoGarantia")), 
						 Boolean.valueOf(request.getParameter("possuiGarantia")));
		 EletronicoDao edao = new EletronicoDao();
		 edao.salvar(e);
	}

}
