package travel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.jsf.FacesContextUtils;

import travel.business.facades.UserFacade;
import travel.commons.context.SpringContext;
import travel.data.entities.jpa.Quarter;
import travel.test.Test2;
/**
 * Servlet implementation class for Servlet: Test
 *
 */
 public class Test extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	 	@PersistenceContext
	    public EntityManager em;
	 	final Logger log=LoggerFactory.getLogger(Test.class);
	 	
	 	
   static final long serialVersionUID = 1L;
	public Test() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter out = response.getWriter();
		 // SpringContext.setServletContext(getServletContext());
		  Test2 test2=(Test2) SpringContext.getCtx().getBean("Test2");
		  Test2 test=new Test2();
		  test.metoda();
		  
		  
		  /*
		  Test2 test3=new Test2();
		  test3.metoda();
		  
		  test2.metoda();
		  */
		  
		  UserFacade userFacade=(UserFacade) SpringContext.getCtx().getBean("userFacade");
		  boolean wynik=userFacade.authenticate("Rafal", "Costam");
		  System.out.println(wynik);
		  List<Quarter> kwatery=userFacade.getKwatery();
		  out.close();

	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	public EntityManager getEm() {
		return em;
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}
 	    
}