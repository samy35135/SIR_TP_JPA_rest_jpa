package api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.serlvet;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.metier.Person;

@WebServlet(name="personneinfo",urlPatterns={"/personneinfo"})
public class PersonneInfo extends HttpServlet {
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		/*PrintWriter out = resp.getWriter();
		out.println("<HTMl>");
		out.println("Voici les donnees que vous avez saisies");
		out.print n("Name : " + req.getParameter("name"));
		out.println("Firstname :  " + req.getParameter("firstname"));
		out.println("age : " + req.getParameter("age"));
		out.println("</HTMl>");
		out.close();*/
		
		String nom = req.getParameter("name");
		String prenom = req.getParameter("firstname");
		@SuppressWarnings("deprecation")
		Date datenaissance =  new Date(req.getParameter("datenaissance"));
		String adresseemail = req.getParameter("email");
		char sexe = req.getParameter("sexe").charAt(0); 
		String loginFb = req.getParameter("loginFb");
		
		
		Person user = new Person(nom, prenom , adresseemail, sexe,  datenaissance, loginFb);
		
		
		
		// Enregistrement de l'user en base
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("Abh_Col_SIR_TP_JPA_REST_SERVLET");
		EntityManager manager = factory.createEntityManager();
		
		
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(user);
		tx.commit();
		
		
		
	//	super.doPost(req,resp);
	}
}
