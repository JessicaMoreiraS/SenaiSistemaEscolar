package Cadastramento;/*Este e um Servlet*/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cadastrar")
public class cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastramento de aluno realizado");
		
		String nomeAluno = request.getParameter("nome");
		String matriculaAluno = request.getParameter("matricula");
		String cpfAluno = request.getParameter("cpf");
		String cursoAluno = request.getParameter("curso");
		String turmaAluno = request.getParameter("turma");
		String enderecoAluno = request.getParameter("endereco");
		String telefoneAluno = request.getParameter("telefone");
		String emailAluno = request.getParameter("email");
		String senhaAluno = request.getParameter("senha");
		
		Integer aMatricula = Integer.valueOf(matriculaAluno);
		
		
		Dados aluno = new Dados();
		aluno.setNome(nomeAluno);
		aluno.setMatricula(aMatricula);
		aluno.setCpf(cpfAluno);
		aluno.setCurso(cursoAluno);
		aluno.setTurma(turmaAluno);
		aluno.setEndereco(enderecoAluno);
		aluno.setTelefone(telefoneAluno);
		aluno.setEmail(emailAluno);
		aluno.setSenha(senhaAluno);
		
		Banco banco = new Banco();
		
		
		/*1-Procurar o curso em que o alno esta matriculado
		 * 2-Pegar as materias do curso 
		 * 3-Adicionar a materia na coluna 0 do array de notas*/
		for(int x =0; x<banco.getListaC().size(); x++) {
			if(banco.getListaC().get(x).getCurso().equals(cursoAluno)){
				for(int y=0; y<banco.getListaC().get(x).getListaM().size(); y++) {
					String materiaDoCursoDoAluno = banco.getListaC().get(x).getListaM().get(y).getMateria();
					for(int w=0; w<aluno.getNotas().length; w++) {
						if(w>0) {
							if(aluno.getNotas(w-1, 0).equals(materiaDoCursoDoAluno)) {
								break;
							}
						}
						if(aluno.getNotas(w, 0) == null) {
							aluno.setNotas(w, 0, materiaDoCursoDoAluno);
							System.out.println("Cadastrando a materia: " + materiaDoCursoDoAluno);
						}
						if(aluno.getListaPorcentagemNotaTotal(w, 0) == null) {
							aluno.setListaPorcentagemNotaTotal(w, 0, materiaDoCursoDoAluno);
						}
					}
				}
			}
		}
		System.out.println(aluno.getNotas(0, 0));
		System.out.println(aluno.getNotas(1, 0));
		banco.adicionarAlunos(aluno);
		
		PrintWriter coisa = response.getWriter();
		coisa.println("o aluno(a) "+ nomeAluno +" foi cadastrado(a) com sucesso");
		
		request.getRequestDispatcher("homeGestor.html").forward(request, response);
		}

}
