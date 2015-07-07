package model;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addNumber
 */
@WebServlet("/addNumber")
public class addNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String number = request.getParameter("score");
		
		int counter = 1;
		
		HttpSession session = request.getSession();
		EntityManager em = mytools.DBUtil.getEmFactory().createEntityManager();
		model.Scorecalculator calculate= em.find(model.Scorecalculator.class, number);
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		
		try
		{
			
			em.persist(calculate);
		}
		catch(Exception e)
		{
			System.out.println(e);
			trans.rollback();
		}
		finally
		{
			em.close();
		}
		
		
		session.setAttribute("counterValue", counter);
		request.setAttribute("testScore", calculate);
		
		getServletContext()
		.getRequestDispatcher("/displayResult.jsp")
		.forward(request, response);

		
	}

}
