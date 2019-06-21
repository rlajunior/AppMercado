package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EletronicoDao;
import dao.LojaDao;
import dao.LojaProduto;
import dao.ProdutoDao;
import negocio.Loja;

public class AssociaProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AssociaProdutoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("back".equals(request.getParameter("op"))) {
			response.sendRedirect("MenuController?tela=loja");
		} else {
			redirectPaginaDeAssociacao(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ("associar".equals(request.getParameter("op"))) {

			LojaProduto lao = new LojaProduto();
			lao.salvar(Integer.parseInt(request.getParameter("idProduto")),
					Integer.parseInt(request.getParameter("idLoja")));

			response.sendRedirect("AssociaProdutoController?idLoja=" + request.getParameter("idLoja"));

		}
		
		if ("desassociar".equals(request.getParameter("op"))) {

			LojaProduto lao = new LojaProduto();
			lao.remove(Integer.parseInt(request.getParameter("idProduto")),
					Integer.parseInt(request.getParameter("idLoja")));

			response.sendRedirect("AssociaProdutoController?idLoja=" + request.getParameter("idLoja"));

		}
	}

	private void redirectPaginaDeAssociacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listaAssociados",
				ProdutoDao.obterProdutosAssociadosALoja(Integer.parseInt(request.getParameter("idLoja"))));

		request.setAttribute("lista",
				ProdutoDao.obterProdutosNaoAssociadosALoja(Integer.parseInt(request.getParameter("idLoja"))));

		Loja loja = LojaDao.buscarPorId(Integer.parseInt(request.getParameter("idLoja")));

		request.setAttribute("loja", loja);

		request.setAttribute("idLoja", request.getParameter("idLoja"));
		request.getRequestDispatcher("associaLoja.jsp").forward(request, response);
	}
}
