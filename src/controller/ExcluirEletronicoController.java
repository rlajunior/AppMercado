package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EletronicoDao;
import dao.PadariaDao;
import dao.ProdutoDao;

public class ExcluirEletronicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ExcluirEletronicoController() {
        super();
      
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		EletronicoDao eao = new EletronicoDao();
//		eao.remove(Integer.parseInt(request.getParameter("id")));
//		ProdutoDao pao = new ProdutoDao();
		response.sendRedirect("MenuController?tela=eletronico");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
