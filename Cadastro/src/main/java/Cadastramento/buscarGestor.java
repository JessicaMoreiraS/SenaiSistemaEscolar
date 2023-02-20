package Cadastramento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buscarGestor")
public class buscarGestor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String senhaAcessoGestor = request.getParameter("senhaAcessoGestor");
		Banco banco = new Banco();
		
		if(senhaAcessoGestor.equals(banco.getSenhaGestor())) {
			request.getRequestDispatcher("homeGestor.html").forward(request, response);
		}else {
			System.out.println("senha incorreta");
			request.getRequestDispatcher("LoginGestor.html").forward(request, response);
		}
	}
	/**/

}
