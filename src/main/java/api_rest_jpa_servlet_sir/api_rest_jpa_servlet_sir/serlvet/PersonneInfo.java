package api_rest_jpa_servlet_sir.api_rest_jpa_servlet_sir.serlvet;

import java.io.IOException;
import java.util.Date;
import java.io.PrintWriter;
import java.util.List;

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		/*manager*/
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("Abh_Col_SIR_TP_JPA_REST_SERVLET");
		EntityManager manager = factory.createEntityManager();
		List<Person> listPersonnes = manager.createQuery("SELECT a FROM Person a",Person.class).getResultList();
		/*affichage*/
		PrintWriter out = new PrintWriter(resp.getOutputStream());
		out.println("<html>");
		out.println("<style>table {border-collapse:collapse;} td{border:1px solid black; text-align:center;}</style>");
		out.println("Il y a " + listPersonnes.size() + " personnes dans la base.</br>");
		out.println("<table>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<td>Nom</td><td>Prenom</td><td>Sexe</td><td>Email</td><td>Date de Naissance</td><td>Login Facebook</td>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");			
		for(Person next : listPersonnes){
			out.println("<tr>");
			out.println("<td>"+ next.getNom() +"</td>");
			out.println("<td>"+ next.getPrenom() + "</td>");
			out.println("<td>"+ next.getSexe() + "</td>");
			out.println("<td>"+ next.getAdressmail() + "</td>");
			out.println("<td>"+ next.getDate_naissance() + "</td>");
			out.println("<td>"+ next.getLoginFB() + "</td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		out.println("</html>");
		out.close();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String nom = req.getParameter("name");
		String prenom = req.getParameter("firstname");
		@SuppressWarnings("deprecation")
		Date datenaissance =  new Date(req.getParameter("datenaissance"));
		String adresseemail = req.getParameter("email");
		String sexe = req.getParameter("sexe"); 
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
		//redirection vers la liste des personnes enregistr�es en base
		this.doGet(req,resp);
		
	//	super.doPost(req,resp);
	}
}
