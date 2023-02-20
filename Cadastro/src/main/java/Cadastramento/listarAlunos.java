package Cadastramento;/*ESte e um servlet*/

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;/*Import do RequestDispatcher*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listarAlunos")
public class listarAlunos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {/**/
		Banco banco = new Banco();
		List<Dados> lista = banco.getDados(); /*getDados e um metodo da classe Banco*/
		/*PrintWriter out = response.getWriter();*/
		lista = banco.getDados();
		
		/*out.println("<html><body>");*/
		/*out.print("<table>");
		for(Dados Dados : lista) {
			out.print("<tr>");
			out.print("<td>"+ Dados.getNome() +"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.println("</body></html>");*/
		
		
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*///acho que nao precisa disso
		 /*request.setAttribute("styles", Listagem);*/
	        
	    request.getRequestDispatcher("Listagem.jsp").forward(request, response); /*Envia para a pagina jsp*/
	}

}
