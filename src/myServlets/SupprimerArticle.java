package myServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myBusinessLayer.Article;
import myBusinessLayer.Client;
import myBusinessLayer.Panier;
import myDAOs.ArticleDAO;

/**
 * Servlet implementation class SupprimerArticle
 */
@WebServlet("/SupprimerArticle")
public class SupprimerArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession();
		int articleaSupprimer=Integer.valueOf(request.getParameter("articleasupp"));
		int quantite=Integer.valueOf(request.getParameter("quantite"));
		Client utilisateur=(Client)session.getAttribute("utilisateur");
		ArticleDAO articleDao=new ArticleDAO();
		Article article=articleDao.find(articleaSupprimer);
		Panier panier=new Panier(article,quantite);
		utilisateur.SupprimerDuPanier(panier);
		session.setAttribute("utilisateur", utilisateur);
		
		RequestDispatcher view=request.getRequestDispatcher("/restreint/voirPanier.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
