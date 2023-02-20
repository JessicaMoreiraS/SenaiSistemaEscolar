package Cadastramento;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cadastrarNotas
 */
@WebServlet("/cadastrarNotas")
public class cadastrarNotas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco banco = new Banco();
		String matriculaAlunoNota = request.getParameter("matriculaAlunoNota");
		int aMatriculaAlunoNota = Integer.parseInt(matriculaAlunoNota);
		String materiaDaNota = banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getMateria();
		
		
		
		String notaAlunoCc1 = request.getParameter("notaCc1");
		String notaAlunoCc2 = request.getParameter("notaCc2");
		String notaAlunoCc3 = request.getParameter("notaCc3");
		String notaAlunoCc4 = request.getParameter("notaCc4");
		String notaAlunoCc5 = request.getParameter("notaCc5");
		String notaAlunoCc6 = request.getParameter("notaCc6");
		String notaAlunoCc7 = request.getParameter("notaCc7");
		String notaAlunoCc8 = request.getParameter("notaCc8");
		String notaAlunoCc9 = request.getParameter("notaCc9");
		String notaAlunoCc10 = request.getParameter("notaCc10");
		String notaAlunoCc11 = request.getParameter("notaCc11");
		String notaAlunoCc12 = request.getParameter("notaCc12");
		
		String notaAlunoCd1 = request.getParameter("notaCd1");
		String notaAlunoCd2 = request.getParameter("notaCd2");
		String notaAlunoCd3 = request.getParameter("notaCd3");
		String notaAlunoCd4 = request.getParameter("notaCd4");
		String notaAlunoCd5 = request.getParameter("notaCd5");
		String notaAlunoCd6 = request.getParameter("notaCd6");
		String notaAlunoCd7 = request.getParameter("notaCd7");
		String notaAlunoCd8 = request.getParameter("notaCd8");
		String notaAlunoCd9 = request.getParameter("notaCd9");
		String notaAlunoCd10 = request.getParameter("notaCd10");
		String notaAlunoCd11 = request.getParameter("notaCd11");
		String notaAlunoCd12 = request.getParameter("notaCd12");
		
		String[] notasAlunoCC = {notaAlunoCc1, notaAlunoCc2, notaAlunoCc3, notaAlunoCc4, notaAlunoCc5, notaAlunoCc6, notaAlunoCc7, notaAlunoCc8, notaAlunoCc9, notaAlunoCc10, notaAlunoCc11, notaAlunoCc12};
		String[] notasAlunoCD = {notaAlunoCd1, notaAlunoCd2, notaAlunoCd3, notaAlunoCd4, notaAlunoCd5, notaAlunoCd6, notaAlunoCd7, notaAlunoCd8, notaAlunoCd9, notaAlunoCd10, notaAlunoCd11, notaAlunoCd12};
		
		//codigo desnecessario, apenas conferrindo o array
		for(int x=0; x<notasAlunoCC.length; x++) {
			System.out.println(notasAlunoCC[x]);
		}
		
		String[] criteriosDasNotasCC = new String[12];
		String[] criteriosDasNotasCD = new String[12];
		
		//Encontrar e repassar para um array mais facil os criteriosC referentes as notas
		for(int x = 0; x<banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getListaCC().size(); x++) {
			criteriosDasNotasCC[x] = banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getListaCC().get(x);
			System.out.println("criterios criticos encontrados e repassados");
		}
		//Encontrar os criteriosD referentes as notas
		for(int x = 0; x<banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getListaCD().size(); x++) {
			criteriosDasNotasCD[x] = banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getListaCD().get(x);
			System.out.println("criterios desejaveis encontrados e repassados ");
		}
		
		int totalNotasCC=0;
		int contadorCC=0;
		int totalNotasCD=0;
		int contadorCD=0;
		int w=0;
		int z=12;
		int parada = 0;
		
		//Encontrar o aluno
		Dados AlunoDaNota = new Dados();
		for(int x=0; x<banco.getDados().size(); x++) {
			if(banco.getDados().get(x).getMatricula() == aMatriculaAlunoNota) {
				AlunoDaNota = banco.getDados().get(x);	
				System.out.println("O aluno é: " + AlunoDaNota.getNome());
				//BUG RESOLVIDO (NAO SEI COMO)
				//encontarar a materia
				for(int y=0; y<banco.getDados().get(x).getNotas().length; y++) {
					System.out.println("entrou 1");
					if(banco.getDados().get(x).getNotas(y,0) != null) {
						if(banco.getDados().get(x).getNotas(y, 0).equals(materiaDaNota)) {
							System.out.println("entrou 2");
							
							for(int a = 0; a<notasAlunoCC.length; a++) {
								System.out.println("entrou 3");
								if(banco.getDados().get(x).getNotas(y,0) != null) {
									System.out.println("entrou 4");
									
									if(banco.getDados().get(x).getNotas(y, 0).equals(materiaDaNota)) {
										System.out.println("Materia da vez: "+ banco.getDados().get(x).getNotas(y,0));
										
										for(int b = 0; b<notasAlunoCC.length; b++) {
											if(b<12) {
												if(notasAlunoCC[b] != null) {
													totalNotasCC++;
													banco.getDados().get(x).setNotas(y,b+1, notasAlunoCC[b]);
													System.out.println("etapa cadastrando criterio critico");
													System.out.println(banco.getDados().get(x).getNotas(y, b+1));
													
													if(banco.getDados().get(x).getNotas(y, b+1).equals("a")||banco.getDados().get(x).getNotas(y, b+1).equals("r")) {
														contadorCC++;
														System.out.println("Chegou até aqui 1");
													}
													System.out.println("Chegou até aqui 2");
												}
											}
											
											if(b<12) {
												if(notasAlunoCD[b] != null) {
													totalNotasCD++;
													banco.getDados().get(x).setNotas(y,b+12, notasAlunoCD[b]);
													System.out.println("etapa cadastrando criterio critico");
													System.out.println(banco.getDados().get(x).getNotas(y, b+1));
													
													if(banco.getDados().get(x).getNotas(y, b+12).equals("a")||banco.getDados().get(x).getNotas(y, b+12).equals("r")) {
														contadorCD++;
														System.out.println("Chegou até aqui 1");
													}
													System.out.println("Chegou até aqui 2");
												}
											}
										}
									}
								}
								if(notasAlunoCD[a] == null & notasAlunoCC[a] == null) {
									parada=1;
									System.out.println("parou aqui 1");
									break;
								}
							}
							if(parada==1) {
								System.out.println("agora paraaaaaaaaaaaaaaaaaaa");
								break;
							}
						}
					}
				}parada =0;
			}
		}
		
		/*1- encontrar o aluno que deve receber a nota atravez da matricula
		  2- encontrar a linha da coluna 0 em que esta a materia da nota
		  3- abastecer a linha com as notas (espaços de 1 até 12 com CC e de 13 até 24 com CD enquanto soma o total de criterios e o total de acertos */
		
		/*BUG: A PARTIR DO SEGUNDO ALUNO CADASTRADO O SISTEMA SIMPLESMENTE NAO ENTRA NO PROXIMO IF OU NO FOR GetNota.length*/
		
		System.out.println(banco.getDados().size());
		
		/*for(int x = 0; x< banco.getDados().size(); x++) {
			if( banco.getDados().get(x).getMatricula() == aMatriculaAlunoNota) {
				System.out.println("Aluno encontrado: " + banco.getDados().get(x).getNome());
				
				for(int y=0; y<banco.getDados().get(x).getNotas().length; y++) {
					System.out.println("entrou no for");
					
					if(banco.getDados().get(x).getNotas(y,0) != null) {
						if(banco.getDados().get(x).getNotas(y, 0).equals(materiaDaNota)) {
							System.out.println("Materia da vez: "+ banco.getDados().get(x).getNotas(y,0));
							
							for(int a = 0; a<notasAlunoCC.length; a++) {
								
								if(notasAlunoCC[a] != null) {
									totalNotasCC++;
									banco.getDados().get(x).setNotas(y,a+1, notasAlunoCC[a]);
									System.out.println("etapa cadastrando criterio critico");
									System.out.println(banco.getDados().get(x).getNotas(y, a+1));
									
									if(banco.getDados().get(x).getNotas(y, a+1).equals("a")||banco.getDados().get(x).getNotas(y, a+1).equals("r")) {
										contadorCC++;
										System.out.println("Chegou até aqui 1");
									}
									System.out.println("Chegou até aqui 2");
								}
								System.out.println("Chegou até aqui 3");
								
								if(notasAlunoCD[a] != null) {
									System.out.println("Chegou até aqui 4");
									totalNotasCD++;
									if(a+12<banco.getDados().get(x).getNotas().length) {
										System.out.println("Chegou até aqui 5");
										banco.getDados().get(x).setNotas(y,a+12, notasAlunoCD[a]);/*o problema ta aqui*/
										/*System.out.println("etapa cadastrando criterio desejavel");
										System.out.println(banco.getDados().get(x).getNotas(y, a+12));
										
										if(banco.getDados().get(x).getNotas(y, a+12).equals("a")||banco.getDados().get(x).getNotas(y, a+12).equals("r")) {
											contadorCD++;
										}
									}	
								}
								
								if(notasAlunoCD[a] == null & notasAlunoCC[a] == null) {
									parada=1;
									System.out.println("parou aqui 1");
									break;
								}
							}
							if(parada==1) {
								System.out.println("agora paraaaaaaaaaaaaaaaaaaa");
								break;
							}
						}else {
							System.out.println("Não é a materia");
						}
					}
				}
				/*if(parada==1) {
					System.out.println("ja deu por hoje");
					break;
				}*/	
			/*}*/
		parada=0;
		/*Calcular porcentagem da nota*/
		System.out.println(contadorCC);
		System.out.println(contadorCD);
			
		//TESTANDO BUG
		if(totalNotasCC==0) {
			totalNotasCC=1;
		}
		if(totalNotasCD ==0) {
			totalNotasCD =1;
		}
		//APOS O TESTE RETIRE OS 2 IF DE CIMA
			
			
		for(int x=0; x<banco.getDados().size(); x++) {
			if(banco.getDados().get(x).getMatricula() == aMatriculaAlunoNota) {
				banco.getDados().get(x).setPorcentagemNotaCC(contadorCC*100/totalNotasCC);
					
				banco.getDados().get(x).setPorcentagemNotaCD(contadorCD*100/totalNotasCD);
					
				if(banco.getDados().get(x).getPorcentagemNotaCC() == 100) {
					banco.getDados().get(x).setPorcentagemNotaTotal((banco.getDados().get(x).getPorcentagemNotaCC()+banco.getDados().get(x).getPorcentagemNotaCD())/2);
				}else {
					banco.getDados().get(x).setPorcentagemNotaTotal(banco.getDados().get(x).getPorcentagemNotaCC()/2);
				}
				System.out.println(banco.getDados().get(x).getPorcentagemNotaTotal());
				
					if(banco.getDados().get(x).getPorcentagemNotaTotal()>= 50) {
						banco.getDados().get(x).setSituacao("Aprovado");
					}
				if(banco.getDados().get(x).getPorcentagemNotaTotal()< 50) {
					banco.getDados().get(x).setSituacao("Reprovado");
				}
					
				String mediaFinal = Integer.toString(banco.getDados().get(x).getPorcentagemNotaTotal());
					
				for(int b=0; b<banco.getDados().get(x).getListaPorcentagemNotaTotal().length; b++) {
					if(banco.getDados().get(x).getListaPorcentagemNotaTotal(b,0) != null) {
						if(banco.getDados().get(x).getListaPorcentagemNotaTotal(b,0).equals(materiaDaNota)) {
							
							//adiciona media final em porcentagem e se essa media o deixa aprovado ou reprovado
							banco.getDados().get(x).setListaPorcentagemNotaTotal(b, 1, mediaFinal);
							System.out.println(banco.getDados().get(x).getListaPorcentagemNotaTotal(b,1));
							banco.getDados().get(x).setListaPorcentagemNotaTotal(b, 2, banco.getDados().get(x).getSituacao());
							System.out.println(banco.getDados().get(x).getListaPorcentagemNotaTotal(b,2));
							
							//adiciona a situacao final levando em conta a presenca e a nota
							//procurar a materia no array de presenca (ontem tambem deve estar a situacao final na coluna 3)
							for(int c=0; c<banco.getDados().get(x).getListaPorcentagemPresencaTotal().length; c++) {
								if(banco.getDados().get(x).getListaPorcentagemPresencaTotal(c,0) != null) {
									if(banco.getDados().get(x).getListaPorcentagemPresencaTotal(c,0).equals(materiaDaNota)) {
										if(banco.getDados().get(x).getListaPorcentagemPresencaTotal(c,2).equals("Aprovado") & banco.getDados().get(x).getListaPorcentagemNotaTotal(b,2).equals("Aprovado")) {
											banco.getDados().get(x).setListaPorcentagemPresencaTotal(c, 3, "Aprovado");
										}else {
											banco.getDados().get(x).setListaPorcentagemPresencaTotal(c, 3, "Reprovado");
										}
									}
								}
							}
							break;
						}
					}
				}		
			}
		}
		request.getRequestDispatcher("homeProfessor.html").forward(request, response);
	}
}
