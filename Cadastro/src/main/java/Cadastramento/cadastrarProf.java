package Cadastramento;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastrarProf")
public class cadastrarProf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastramento de professor realizado");
		
		String nomeProfessor = request.getParameter("nomeProfessor");
		String cpfProfessor = request.getParameter("cpfProfessor");
		String cursoProfessor = request.getParameter("curso");
		String materiaProfessor = request.getParameter("materia");
		String enderecoProfessor = request.getParameter("enderecoProfessor");
		String telefoneProfessor = request.getParameter("telefoneProfessor");
		String emailProfessor = request.getParameter("emailProfessor");
		String senhaProfessor = request.getParameter("senhaProfessor");
		
		DadosProf professor = new DadosProf();
		professor.setNome(nomeProfessor);
		professor.setCpf(cpfProfessor);
		professor.setCurso(cursoProfessor);
		professor.setMateria(materiaProfessor);
		professor.setEndereco(enderecoProfessor);
		professor.setTelefone(telefoneProfessor);
		professor.setEmail(emailProfessor);
		professor.setSenha(senhaProfessor);
		
		Banco bancoProf = new Banco();
		bancoProf.adicionarProfessor(professor);
		
		PrintWriter coisa = response.getWriter();
		coisa.println("o aluno(a) "+ nomeProfessor +" foi cadastrado(a) com sucesso");
		
		
		request.getRequestDispatcher("homeGestor.html").forward(request, response);
	}

}
