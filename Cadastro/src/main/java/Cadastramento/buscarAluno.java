package Cadastramento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buscarAluno")
public class buscarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Buscando por aluno");
		String emailAluno = request.getParameter("emailAcessoAluno");
		String senhaAcessoAluno = request.getParameter("senhaAcessoAluno");
		Banco banco = new Banco();
		
		for(int x=0; x<banco.getDados().size(); x++) {
			if(banco.getDados().get(x).getEmail().equals(emailAluno) & banco.getDados().get(x).getSenha().equals(senhaAcessoAluno)) {
				System.out.println("Aluno encontrado");
				banco.setPosicaoNaListaA(x);
				request.getRequestDispatcher("homeAluno.html").forward(request, response);
				break;
			}
			if(x==banco.getDados().size()-1){
				System.out.println("Aluno nao encontrado no sistema, email ou senha invalidos");
				request.getRequestDispatcher("LoginAluno.html").forward(request, response);
				break;
			}
		}
		
	}

}
