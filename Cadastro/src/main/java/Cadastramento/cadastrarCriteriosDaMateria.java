package Cadastramento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastrarCriteriosDaMateria")
public class cadastrarCriteriosDaMateria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		
		String cC1 = request.getParameter("cc1");
		String cC2 = request.getParameter("cc2");
		String cC3 = request.getParameter("cc3");
		String cC4 = request.getParameter("cc4");
		String cC5 = request.getParameter("cc5");
		String cC6 = request.getParameter("cc6");
		String cC7 = request.getParameter("cc7");
		String cC8 = request.getParameter("cc8");
		String cC9 = request.getParameter("cc9");
		String cC10 = request.getParameter("cc10");
		String cC11 = request.getParameter("cc11");
		String cC12 = request.getParameter("cc12");
		
		String cD1 = request.getParameter("cd1");
		String cD2 = request.getParameter("cd2");
		String cD3 = request.getParameter("cd3");
		String cD4 = request.getParameter("cd4");
		String cD5 = request.getParameter("cd5");
		String cD6 = request.getParameter("cd6");
		String cD7 = request.getParameter("cd7");
		String cD8 = request.getParameter("cd8");
		String cD9 = request.getParameter("cd9");
		String cD10 = request.getParameter("cd10");
		String cD11 = request.getParameter("cd11");
		String cD12 = request.getParameter("cd12");
		
		String [] cCS = {cC1, cC2, cC3, cC4, cC5, cC6, cC7, cC8, cC9, cC10, cC11, cC12};
		String [] cDS = {cD1, cD2, cD3, cD4, cD5, cD6, cD7, cD8, cD9, cD10, cD11, cD12};
		
		//NM = Nova Materia
		
		for(int x = 0; x<12; x++) {
			if(cCS[x] != null) {
				banco.getDadosMaterias().get(banco.getDadosMaterias().size()-1).setListaCC(cCS[x]);
			}
		}
		for(int x = 0; x<12; x++) {
			if(cDS[x] != null) {
				banco.getDadosMaterias().get(banco.getDadosMaterias().size()-1).setListaCD(cDS[x]);
			}
		}
		System.out.println("Cadastramento realizado");
		System.out.print(banco.getDadosMaterias().get(banco.getDadosMaterias().size()-1).getListaCC());
		/*System.out.print(banco.getDadosMaterias().get(banco.getDadosMaterias().size()-1).getListaCD());*/
		
		request.getRequestDispatcher("homeGestor.html").forward(request, response);
	}

}
