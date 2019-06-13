package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PadariaDao;
import dao.ProdutoDao;
import dao.SupervisorDao;

public class ExcluirPadariaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExcluirPadariaController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PadariaDao pao = new PadariaDao();
		pao.remove(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("mensagem","Produto Excluído com sucesso");	
		request.setAttribute("titulo", "Padaria");
		request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
