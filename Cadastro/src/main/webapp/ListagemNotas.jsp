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
    <link rel="stylesheet" href="css/cadastro-de-notas.css">
<title>Tabela de notas</title>
</head>
<body>
	<%Banco banco = new Banco(); %>
	<header>
        <h1>Notas dos alunos</h1>
    </header>
    <main>
		<table>
			<tr>
				<th>Matrícula</th>
				<th>Nome</th>
				<%
				for (int x=0; x<banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getNumeroCriteriosCriticos(); x++){
					out.print("<th>");
					out.print(banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getListaCC().get(x));
					out.print("</th>");
				}
				for (int y=0; y<banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getNumeroCriteriosDesejaveis(); y++){
					out.print("<th>");
					out.print(banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getListaCD().get(y));
					out.print("</th>");
				}
				%>
				<th>Nota</th>
				<th>Situação</th>
			</tr>
			<%
			for(int i=0; i<banco.getDados().size(); i++){
				if(banco.getDados().get(i).getCurso().equals(banco.getDadosProfessor().get(banco.getPosicionamentoProf()).getCurso())){
					
					out.print("<tr>");
					out.print("<td>");
					out.print(banco.getDados().get(i).getMatricula());
					out.print("</td>");
					out.print("<td>");
					out.print(banco.getDados().get(i).getNome());
					out.print("</td>");
					
					for(int a=0; a<banco.getDados().get(i).getNotas().length; a++){
						if(banco.getDados().get(i).getNotas(a, 0) != null){
							if(banco.getDados().get(i).getNotas(a, 0).equals(banco.getDadosProfessor().get(banco.getPosicionamentoProf()).getMateria())){
								for(int b=1; b-1<banco.getDados().get(i).getNotas().length; b++){
									
									if(banco.getDados().get(i).getNotas(a, b) != null){
										out.print("<td>");
										out.print(banco.getDados().get(i).getNotas(a, b));
										out.print("</td>");
									}
									
								}
							}
						}
					}
					for(int b=0; b<banco.getDados().get(i).getListaPorcentagemNotaTotal().length; b++) {
						if(banco.getDados().get(i).getListaPorcentagemNotaTotal(b,0) != null) {
							if(banco.getDados().get(i).getListaPorcentagemNotaTotal(b,0).equals(banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getMateria())) {
								out.print("<td>");
								//porcentagem nota
								if(banco.getDados().get(i).getListaPorcentagemNotaTotal(b,1) != null){
									out.print(banco.getDados().get(i).getListaPorcentagemNotaTotal(b,1));
								}
								out.print("</td>");
								out.print("<td>");
								//situacao
								if(banco.getDados().get(i).getListaPorcentagemNotaTotal(b,2) != null){
								out.print(banco.getDados().get(i).getListaPorcentagemNotaTotal(b,2));
								}
								out.print("</td>");
							}
						}
					}
					out.print("</tr>");
				}
			}
			%>
		</table>
	</main>
	<footer>
        <a href="homeProfessor.html"><img class="retorno2" src="img/back.png" alt=""></a>
    </footer>
</body>
</html>