package Cadastramento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class atualizarDadosAlunos
 */
@WebServlet("/atualizarDadosAlunos")
public class atualizarDadosAlunos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Atualizar Dados");
		Banco banco = new Banco();
		String matriculaDoAluno = request.getParameter("matriculaAlunoAtualizacao");
		int aMatriculaDoAluno = Integer.valueOf(matriculaDoAluno);
		
		String emailAlunoAtualizacao = request.getParameter("emailAlunoAtualizacao");
		String telefoneAlunoAtualizacao = request.getParameter("telefoneAlunoAtualizacao");
		String enderecoAlunoAtualizacao = request.getParameter("enderecoAlunoAtualizacao");
		String cursoAlunoAtualizacao = request.getParameter("cursoAlunoAtualizacao");
		String turmaAlunoAtualizacao = request.getParameter("turmaAlunoAtualizacao");
		
		//For para encontrar o aluno
		for(int x=0; x<banco.getDados().size(); x++) {
			if(banco.getDados().get(x).getMatricula() == aMatriculaDoAluno) {
				
				//Ifs para atualizar os dados do aluno
				System.out.println("Atualizacao dos dados do(a) aluno(a): "+ banco.getDados().get(x).getNome());
				if(emailAlunoAtualizacao != null & !emailAlunoAtualizacao.equals("")) {
					banco.getDados().get(x).setEmail(emailAlunoAtualizacao);
				}
				if(telefoneAlunoAtualizacao != null & !telefoneAlunoAtualizacao.equals("")) {
					System.out.println("tel 1:"+ banco.getDados().get(x).getTelefone());
					banco.getDados().get(x).setTelefone(telefoneAlunoAtualizacao);
					System.out.println("tel 2:"+ banco.getDados().get(x).getTelefone());
				}
				if(enderecoAlunoAtualizacao != null & !enderecoAlunoAtualizacao.equals("")) {
					banco.getDados().get(x).setEndereco(enderecoAlunoAtualizacao);
				}
				if(cursoAlunoAtualizacao != null & !cursoAlunoAtualizacao.equals("")) {
					banco.getDados().get(x).setCurso(cursoAlunoAtualizacao);
				}
				if(turmaAlunoAtualizacao != null & !turmaAlunoAtualizacao.equals("")) {
					banco.getDados().get(x).setTurma(turmaAlunoAtualizacao);
				}
				request.getRequestDispatcher("homeGestor.html").forward(request, response);
				break;
			}
		}
		
	}

}
