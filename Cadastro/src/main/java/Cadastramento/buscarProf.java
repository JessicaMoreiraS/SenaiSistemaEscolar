package Cadastramento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buscarProf")
public class buscarProf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Buscando por professor");
		String emailProfessor = request.getParameter("emailAcessoProf");
		String senhaAcessoProf = request.getParameter("senhaAcessoProf");
		Banco banco = new Banco();
		System.out.println(banco.getDadosProfessor().get(0).getNome());
		
		int acessoErrado=0;
		
		
		
		for(int x = 0; x< banco.getDadosProfessor().size(); x++) {
			if(banco.getDadosProfessor().get(x).getEmail().equals(emailProfessor) & banco.getDadosProfessor().get(x).getSenha().equals(senhaAcessoProf)) {/*se der errado olha aqui nessa linha*/
				banco.getDadosProfessor().get(x).getNome();
				banco.adicionarPosicaoNaListaP(x);
				System.out.print("Professor encontrado no sistema");
				break;
			}else {
				System.out.println("Professor nao encontrado no sistema, email ou senha invalidos");
				if(x==banco.getDadosProfessor().size()-1) {
					acessoErrado=1;
					request.getRequestDispatcher("LoginProfessor.html").forward(request, response);
				}
			}
		}/**/
		
		
		
		for(int x = 0; x< banco.getDadosMaterias().size(); x++) {
			if(acessoErrado==1) {
				break;
			}
			if(banco.getDadosMaterias().get(x).getMateria().equals(banco.getDadosProfessor().get(banco.getPosicionamentoProf()).getMateria())) {
				banco.setPosicaoDaMateriaNaListaM(x);
				System.out.println(x);
				System.out.println("Materia Encontrada");
				request.getRequestDispatcher("homeProfessor.html").forward(request, response);
			}else {
				System.out.println("Materia nao encontrada");
			}
		}
		

	}

}
