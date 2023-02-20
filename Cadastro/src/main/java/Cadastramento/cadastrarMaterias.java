package Cadastramento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastrarMaterias")
public class cadastrarMaterias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aMateria = request.getParameter("materia");
		String oCurso = request.getParameter("curso");
		String nCritCrit = request.getParameter("nCriteriosCriticos");
		String nCritDesej = request.getParameter("nCriteriosDesejaveis");
		
		Integer numCritCrit = Integer.valueOf(nCritCrit);
		Integer numCritDesej = Integer.valueOf(nCritDesej); 
		
		DadosMaterias materia = new DadosMaterias();
		materia.setMateria(aMateria);
		materia.setCurso(oCurso);
		materia.setNumeroCriteriosCriticos(numCritCrit);
		materia.setNumeroCriteriosDesejaveis(numCritDesej);
		
		Banco banco = new Banco();
		banco.adicionarMateria(materia);
		System.out.println("Materia adicionada na listaM");
		
		/*Adicionar cursos ainda não adicionados a lista de Cursos*/
		if(banco.getListaC().size()>0) {
			for(int x=0; x<banco.getListaC().size(); x++){
				System.out.println("Fase1");
				if(!banco.getListaC().get(x).getCurso().equals(oCurso)) {
					System.out.println("Faze 2");
					if(x == banco.getListaC().size()-1) {
						System.out.println("Faze 3");
						DadosCurso curso = new DadosCurso();
						curso.setCurso(oCurso);
						banco.adicionarCurso(curso);
						System.out.println("Curso adicionado a lista");
					}
				}/**/
			}
		}else {
			DadosCurso curso = new DadosCurso();
			curso.setCurso(oCurso);
			banco.adicionarCurso(curso);
			System.out.println("Curso adicionado a lista");
		}
		
		
		/*Adicionar materias do curso (cada curso é um objeto com arrey de materias)*/
		for(int y=0; y<banco.getListaC().size(); y++) {
			if(banco.getListaC().get(y).getCurso().equals(oCurso)) {
				banco.getListaC().get(y).setListaM(materia);
				System.out.println("materia adicionada:" + banco.getListaC().get(y).getListaM().get(0).getMateria());
				for(int a=0; a<banco.getListaC().get(y).getListaM().size(); a++) {
					System.out.println(banco.getListaC().get(y).getListaM().get(a).getMateria());
				}
			}
		}
			
		System.out.println("Cadastramento de materia realizado");
		
		request.getRequestDispatcher("CadastrarCriterios.jsp").forward(request, response);
	}

}
