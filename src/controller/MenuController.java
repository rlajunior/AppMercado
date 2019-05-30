package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EletronicoDao;
import dao.PadariaDao;
import dao.SupervisorDao;

public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MenuController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tela = request.getParameter("tela").toLowerCase();
		
		if (tela.equals("eletronico")) {
			request.setAttribute("lista", EletronicoDao.obterlista());
			request.getRequestDispatcher(tela+"Lista.jsp").forward(request, response);

		} else  if (tela.equals("padaria")) {
			request.setAttribute("lista", PadariaDao.obterlista());
			request.getRequestDispatcher(tela+"Lista.jsp").forward(request, response);

		} else if (tela.equals("supervisor")) {
			request.setAttribute("lista", SupervisorDao.obterlista());
			request.getRequestDispatcher(tela+"Lista.jsp").forward(request, response);

		
		}
	}

}
