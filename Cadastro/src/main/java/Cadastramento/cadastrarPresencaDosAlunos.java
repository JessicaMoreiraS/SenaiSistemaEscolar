package Cadastramento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cadastrarPresencaDosAlunos
 */
@WebServlet("/cadastrarPresencaDosAlunos")
public class cadastrarPresencaDosAlunos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		
		String data = request.getParameter("data");
		
		String a1 = request.getParameter("a1");
		String a2 = request.getParameter("a2");
		String a3 = request.getParameter("a3");
		String a4 = request.getParameter("a4");
		String a5 = request.getParameter("a5");
		String a6 = request.getParameter("a6");
		String a7 = request.getParameter("a7");
		String a8 = request.getParameter("a8");
		String a9 = request.getParameter("a9");
		String a10 = request.getParameter("a10");
		String a11 = request.getParameter("a11");
		String a12 = request.getParameter("a12");
		String a13 = request.getParameter("a13");
		String a14 = request.getParameter("a14");
		String a15 = request.getParameter("a15");
		String a16 = request.getParameter("a16");
		String a17 = request.getParameter("a17");
		String a18 = request.getParameter("a18");
		String a19 = request.getParameter("a19");
		String a20 = request.getParameter("a20");
		String a21 = request.getParameter("a21");
		String a22 = request.getParameter("a22");
		String a23 = request.getParameter("a23");
		String a24 = request.getParameter("a24");
		String a25 = request.getParameter("a25");
		String a26 = request.getParameter("a26");
		String a27 = request.getParameter("a27");
		String a28 = request.getParameter("a28");
		String a29 = request.getParameter("a29");
		String a30 = request.getParameter("a30");
		String a31 = request.getParameter("a31");
		String a32 = request.getParameter("a32");
		String a33 = request.getParameter("a33");
		String a34 = request.getParameter("a34");
		String a35 = request.getParameter("a35");
		
		System.out.println(a1);
		System.out.println(a2);
		
		String[] listaPresenca = {a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20,
									a21, a22, a23, a24, a25, a26, a27, a28, a29, a30, a31, a32, a33, a34, a35};
		int contadorListaPresenca= 0;
		int contadorAlunoPresente= 0;
		int totalAulasDadas =0;
		int parou=0;
		//1- Encontrar o aluno em Dados
		for(int i=0; i<banco.getDados().size(); i++){
			if(banco.getDados().get(i).getCurso().equals(banco.getDadosProfessor().get(banco.getPosicionamentoProf()).getCurso())){
				
				//2A- Verificar e/ou Cadastrar existencia a materia do professor na lista de presenca
				for(int x= 0; x<banco.getDados().get(i).getPresenca().length; x++) {
					/*System.out.println("entrou");*/
					if(banco.getDados().get(i).getPresenca(x,0) != null) {
						if(banco.getDados().get(i).getPresenca(x,0).equals(banco.getDadosProfessor().get(banco.getPosicionamentoProf()).getMateria())) {
						
							System.out.println("encontrou a materia");
							for(int y =1; y<banco.getDados().get(i).getPresenca().length; y++) {
								/*System.out.println("entrou 4");*/
								if(banco.getDados().get(i).getPresenca(x,y) == null) {/*TIREI O -1 DO Y*/
									/*System.out.println("entrou 5");*/
									banco.getDados().get(i).setPresenca(x,y, data);
									banco.getDados().get(i).setPresenca(x+1, y, listaPresenca[contadorListaPresenca]);
									contadorListaPresenca++;
									System.out.println("X vale: " + x);
									System.out.println("Y vale: " + y);
									System.out.println(banco.getDados().get(i).getPresenca(x,y));
									System.out.println(banco.getDados().get(i).getPresenca(x+1,y));
									
									/*if(listaPresenca[contadorListaPresenca].equals("P") || listaPresenca[contadorListaPresenca].equals("p")) {
										contadorAlunoPresente++;
									}
									if(banco.getDados().get(i).getPresenca(x+1,y).equals("p")||banco.getDados().get(i).getPresenca(x+1,y).equals("P")||banco.getDados().get(i).getPresenca(x+1,y).equals("f")||banco.getDados().get(i).getPresenca(x+1,y).equals("F")) {
										totalAulasDadas++;
									}*/
									
									break;
								}	
							}
							
							//FOR PARA VERIFICAR AULAS DADAS E PRESENCA
							for(int c=0; c<banco.getDados().get(i).getPresenca().length; c++) {
								if(banco.getDados().get(i).getPresenca(x+1,c) != null) {
									
									if(banco.getDados().get(i).getPresenca(x+1,c).equals("p")||banco.getDados().get(i).getPresenca(x,c).equals("P")) {
										contadorAlunoPresente++;
									}	
									if(banco.getDados().get(i).getPresenca(x+1,c).equals("p")||banco.getDados().get(i).getPresenca(x,c).equals("P") || banco.getDados().get(i).getPresenca(x+1,c).equals("f")||banco.getDados().get(i).getPresenca(x,c).equals("F")) {
										totalAulasDadas++;
									}	
								}
							}
							
							System.out.println("Presen�a: "+contadorAlunoPresente);
							System.out.println("Total de aulas: "+totalAulasDadas);
							
							System.out.println("entrou aqui tambem");
							parou=1;
							break;
						}
					}
					if(x==banco.getDados().get(i).getPresenca().length-2) {
						for(int y=0; y<banco.getDados().get(i).getPresenca().length; y++) {
							if(banco.getDados().get(i).getPresenca(y,0)==null) {
								System.out.println("finalmente cadastrando");
								banco.getDados().get(i).setPresenca(y,0, banco.getDadosProfessor().get(banco.getPosicionamentoProf()).getMateria());
								banco.getDados().get(i).setPresenca(y+1,0, banco.getDadosProfessor().get(banco.getPosicionamentoProf()).getMateria());
								x=-1;
								break;
							}
						}
					}
				}
				
				int porcentagemTotalPresenca = contadorAlunoPresente*100/totalAulasDadas;
				String numPorcentagemTotalPresenca = Integer.toString(porcentagemTotalPresenca);
				String situacao;
				if(porcentagemTotalPresenca >= 75) {
					situacao = "Aprovado";
				}else {
					situacao = "Reprovado";
				}
				
				
				System.out.println(situacao);
				System.out.println(numPorcentagemTotalPresenca);
				//cadastrar a materia e a porcentagem da presenca, e se esta aprovado ou reprovado
				for(int a=0; a<banco.getDados().get(i).getListaPorcentagemPresencaTotal().length; a++) {
					if(banco.getDados().get(i).getListaPorcentagemPresencaTotal(a,0) != null) {
						if(banco.getDados().get(i).getListaPorcentagemPresencaTotal(a,0).equals(banco.getDadosProfessor().get(banco.getPosicionamentoProf()).getMateria())) {
							banco.getDados().get(i).setListaPorcentagemPresencaTotal(a, 1, numPorcentagemTotalPresenca);
							banco.getDados().get(i).setListaPorcentagemPresencaTotal(a, 2, situacao);
							for(int b=0; b<banco.getDados().get(i).getListaPorcentagemNotaTotal().length; b++) {
								if(banco.getDados().get(i).getListaPorcentagemNotaTotal(b, 0) != null){
									if(banco.getDados().get(i).getListaPorcentagemNotaTotal(b, 0).equals(banco.getListaC().get(a).getListaM().get(b).getMateria())){
										if(banco.getDados().get(i).getListaPorcentagemNotaTotal(b, 1) !=null){
											
											//a coluna 3 contem a situacao final do aluno
											if(situacao.equals("Aprovado") & banco.getDados().get(i).getListaPorcentagemNotaTotal(b, 2).equals("Aprovado")) {
												banco.getDados().get(i).setListaPorcentagemPresencaTotal(a, 3, "Aprovado");
											}else {
												banco.getDados().get(i).setListaPorcentagemPresencaTotal(a, 3, "Reprovado");
											}
										}
									}
								}
							}
							break;
						}
					}
					if(a==banco.getDados().get(i).getListaPorcentagemPresencaTotal().length-1) {
						for(int b=0; b<banco.getDados().get(i).getListaPorcentagemPresencaTotal().length; b++) {
							if(banco.getDados().get(i).getListaPorcentagemPresencaTotal(b, 0) == null) {
								banco.getDados().get(i).setListaPorcentagemPresencaTotal(b, 0, banco.getDadosProfessor().get(banco.getPosicionamentoProf()).getMateria());
								a=-1;
								break;
							}
						}
					}
					
					
				}
			}
			System.out.println("ta zerando aqui 2");
			contadorAlunoPresente= 0;
			totalAulasDadas =0;
		}
		
		
		System.out.println("Presen�a: " + banco.getDados().get(0).getListaPorcentagemPresencaTotal(0, 1));
		System.out.println("Situa��o: " + banco.getDados().get(0).getListaPorcentagemPresencaTotal(0, 2));
//		System.out.println("Presen�a: " + banco.getDados().get(1).getListaPorcentagemPresencaTotal(0, 1));
//		System.out.println("Situa��o: " + banco.getDados().get(1).getListaPorcentagemPresencaTotal(0, 2));
		
		//System.out.println(banco.getDados().get(0).getPresenca(0,0));//Materia
//		System.out.println(banco.getDados().get(1).getPresenca(0,0));
		//System.out.println(banco.getDados().get(0).getPresenca(1,0));//Materia
//		System.out.println(banco.getDados().get(1).getPresenca(1,0));
		//System.out.println(banco.getDados().get(0).getPresenca(0,1));//Data
//		System.out.println(banco.getDados().get(1).getPresenca(0,1));
		//System.out.println(banco.getDados().get(0).getPresenca(1,1));//Presenca
//		System.out.println(banco.getDados().get(1).getPresenca(1,1));
		/*response.getWriter().append("Served at: ").append(request.getContextPath()); Não sei o que isso faz*/
		request.getRequestDispatcher("homeProfessor.html").forward(request, response);
	}

}
