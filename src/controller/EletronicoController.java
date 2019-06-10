package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;

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
	
		
		Boolean garantia =	null;
	
		if (request.getParameter("anoGarantia") !=null)  {
			garantia = true;
		}  else {
			garantia = false;
		}
		
			Eletronico e = new Eletronico(
				 null, 
				 request.getParameter("nome"), 
				 Float.valueOf(request.getParameter("peso")), 
				 Double.valueOf(request.getParameter("valor")), 
				 request.getParameter("local"), 
				 request.getParameter("localRetirada"), 
				 Integer.valueOf(request.getParameter("anoGarantia")), 
				 Boolean.valueOf(garantia));
	
		 EletronicoDao edao = new EletronicoDao();
		 edao.salvar(e);
		 
		 	request.setAttribute("titulo", "Eletronico");
			request.setAttribute("mensagem", e.toString());
			request.setAttribute("controller", "EletronicoController");
			request.getRequestDispatcher("finaliza.jsp").forward(request, response);
	}
}
