
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="Cadastramento.Dados" %>
<%@page import="Cadastramento.listarAlunos"%>
<%@page import="Cadastramento.Banco"%>
<%@page import="Cadastramento.cadastrar"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/styleNotas.css" rel="stylesheet">
	<title>Avaliações Somativas</title>
</head>
<body>
<% Banco banco = new Banco(); %>
	<main>
	<br>
		<table>
			<thead>
	            <tr>
	                <th colspan="11" scope="col">Citérios Avaliativos</th>
	            </tr>
	        </thead>
			<tr>
				<th>
					<td colspan="2" align="center" scope="col">Curso: <%out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getCurso()); %></td>
					<td align="center" scope="col">Turma: <%out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getTurma()); %></td>
					<td colspan="2" align="center" scope="col">Aluno: <%out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getNome()); %></td>
				</th>
			</tr>
			
			<tr>
				<td align="center" scope="col">Materia</td>
				<td align="center" scope="col">Críticos</td>
				<td align="center" scope="col">Atende</td>
				<td align="center" scope="col">Desejaveis</td>
				<td align="center" scope="col">Atende</td>
			</tr>
			
			<%
			int quantidadeDeCriteriosDoCurso;
			int teste=0;
			boolean entrouAqui=false;
			//Encontrar o curso
			for(int a=0; a<banco.getListaC().size(); a++){
				if(banco.getListaC().get(a).getCurso().equals(banco.getDados().get(banco.getPosicaoNaListaA()).getCurso())){
					//Encontrar as materias
					for(int b=0; b<banco.getListaC().get(a).getListaM().size(); b++){
						String materia = banco.getListaC().get(a).getListaM().get(b).getMateria();
						
						if(banco.getListaC().get(a).getListaM().get(b).getListaCC().size() > banco.getListaC().get(a).getListaM().get(b).getListaCD().size()){
							quantidadeDeCriteriosDoCurso = banco.getListaC().get(a).getListaM().get(b).getListaCC().size();
							System.out.println(quantidadeDeCriteriosDoCurso );
						}else{
							quantidadeDeCriteriosDoCurso = banco.getListaC().get(a).getListaM().get(b).getListaCD().size();
							System.out.println(quantidadeDeCriteriosDoCurso );
						}
						
						if(banco.getListaC().get(a).getListaM().get(b).getCurso().equals(banco.getDados().get(banco.getPosicaoNaListaA()).getCurso())){
						//Encontrar os criterios de cada materia
						
						for(int c=0; c<banco.getDados().get(banco.getPosicaoNaListaA()).getNotas().length; c++){
							if(teste == 1){
							c=c+1;}
							if(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c,0)!=null){
							if(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c,0).equals(materia)){
							//Encontrar Notas dos alunos
							for(int d=0; d<quantidadeDeCriteriosDoCurso; d++){
								if(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c,d+1) != null){
									System.out.println("c: "+ c);
									out.print("<tr>");
									out.print("<td scope='col' align='center'>");
									out.print(materia);
									out.print("</td>");
									out.print("<td>");
									out.print(banco.getListaC().get(a).getListaM().get(b).getListaCC().get(d));
									out.print("</td>");
									out.print("<td>");
									out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c,d+1));
									out.print("</td>");
								}
								if(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c,d+1) == null & banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c,d+12) != null){
									out.print("<tr>");
									out.print("<td scope='col' align='center'>");
									out.print(materia);
									out.print("</td>");
									out.print("<td>");
									out.print("</td>");
									out.print("<td>");
									out.print("</td>");
								}
								if(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c,d+12) != null){
									out.print("<td>");
									out.print(banco.getListaC().get(a).getListaM().get(b).getListaCD().get(d));
									out.print("</td>");
									out.print("<td>");
									out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c,d+12));
									out.print("</td>");
									out.print("</tr>");
								}
								if(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c,d+1) != null & banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c,d+12) == null){
									out.print("</td>");
									out.print("<td>");
									out.print("</td>");
									out.print("<td>");
									out.print("</tr>");
									teste=1;
								}
								
								if(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c,d+1) == null & banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c,d+12) == null){
									//se não tiver sido impresso os criterios
									if(d==0){
										for(int e=0; e<quantidadeDeCriteriosDoCurso; e++){
											out.print("<tr>");
											out.print("<td  scope='col' align='center'>");
											out.print(materia);
											out.print("</td>");
											out.print("<td>");
											if(e <banco.getListaC().get(a).getListaM().get(b).getListaCC().size()){
												out.print(banco.getListaC().get(a).getListaM().get(b).getListaCC().get(e));
											}
											out.print("</td>");
											out.print("<td>");
											out.print("</td>");
											out.print("<td>");
											if(e <banco.getListaC().get(a).getListaM().get(b).getListaCD().size()){
												out.print(banco.getListaC().get(a).getListaM().get(b).getListaCD().get(e));
											}
											out.print("</td>");
											out.print("<td>");
											out.print("</td>");
											out.print("<tr>");
											entrouAqui=true;
										}
									}
									teste=1;
									break;
								}
							}
							//encontrar materia para pegar a nota total
							boolean entrou= false;
							for(int x=0; x<banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemNotaTotal().length ;x++){
								//Exibir nota total da materia e a situacao
								if(banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemNotaTotal(x, 0) != null){
									if(banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemNotaTotal(x, 0).equals(materia)){
										out.print("<tr>");
										out.print("<td colspan='3'  scope='col' align='center'>");
										if(banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemNotaTotal(x, 1) == null){
											out.print("Nota: não atribuido");
											out.print("</td>");
											out.print("<td colspan='3' scope='col' align='center'>");
											out.print("Situação: não atribuida");
										}else{
											out.print("Nota: " + banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemNotaTotal(x, 1));
											out.print("</td>");
											out.print("<td colspan='3' scope='col' align='center'>");
											out.print("Situação: "+ banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemNotaTotal(x, 2));
										}
										out.print("</td>");
										out.print("</tr>");
										entrou = true;
										break;
									}
								}
							}
							if(entrou == true){
								break;
							}
							}
							}
						}
						}
						
					}
					break;
				}
			}
			
			/*
			if(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c, d) == null){
									System.out.println("é nulo, parou");
								}else{
									out.print("<tr>");
									out.print("<td>");
									out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(b, 0));
									out.print("</td>");
									out.print("<td>");
									out.print(banco.getListaC().get(b).getListaM().get(b).getListaCC().get(d));
									System.out.println("d: "+d);
									out.print("</td>");
									out.print("<td>");
									out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c, d+1));
									out.print("</td>");
								}
								
								quantidadeDeMateriasDoCurso = banco.getListaC().get(a).getListaM().get(b).getListaCD().size();
								/*if(banco.getListaC().get(a).getListaM().get(b).getListaCD().get(d) == null){
									System.out.print("é nulo outra vez, parou");
									break;
								}*/
								/*if(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c, d+12) == null & banco.getListaC().get(a).getListaM().get(b).getListaCD().get(d) == null){
									out.print("<td>");
									out.print("");
									out.print("</td>");
									out.print("<td>");
									out.print("não avaliado");
									out.print("</td>");
									out.print("</tr>");
									e=1;
									System.out.println("é nulo também, parou");
								}else{
									if(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c, d+12) !=null){
									out.print("<td>");
									out.print(banco.getListaC().get(b).getListaM().get(b).getListaCD().get(d));
									out.print("</td>");
									out.print("<td>");
									out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c, d+12));
									out.print("</td>");
									out.print("</tr>");
									}*/
			
			
			
			
			/*for(int c=0; c<banco.getDados().get(banco.getPosicaoNaListaA()).getNotas().length; c=c+2){*/
				/* for(int d=0; d<banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getListaCC().size(); d++){
					if(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c, d+1) != null){
						out.print("<tr>");
						out.print("<td>");
						out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c, 0));
						out.print("</td>");
						out.print("<td>");
						out.print(banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getListaCC().get(d));
						out.print("</td>");
						out.print("<td>");
						out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c, d+1));
						out.print("</td>");
					}
					
					if(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c, d+12) != null){*/
						/*out.print("<td>");
						out.print(banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getListaCC().get(d));
						out.print("</td>");
						out.print("<td>");
						out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getNotas(c, d+1));
						out.print("</td>");
						out.print("</tr>");
					}
				}
			}*/
			%>
			
		</table>
	</main>
</body>
</html>