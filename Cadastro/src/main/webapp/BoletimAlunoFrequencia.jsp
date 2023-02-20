<%/*<   @ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"*/%>
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
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/styleNotas.css" rel="stylesheet">
	<title>Acompanhamento de Frequecia</title>
</head>
<body>
	<table>
		<tr>
			<th colspan="6" scope="col">Frequência</th>
		</tr>
	
		<tr>
			<th colspan="2" align="center" scope="col">Materia</th>
			<th align="center" scope="col">Frequencia</th>
			<th align="center" scope="col">Nota</th>
			<th colspan="2" align="center" scope="col">Situação<th>
		</tr>
		
		<%
		Banco banco = new Banco();
		
		//Procurar curso do aluno
		for(int a=0; a<banco.getListaC().size(); a++){
			if(banco.getListaC().get(a).getCurso().equals(banco.getDados().get(banco.getPosicaoNaListaA()).getCurso())){
				//Pecorrer materias do curso
				for(int b=0; b<banco.getListaC().get(a).getListaM().size(); b++){
					//percorrer a frequencia do aluno
					for(int c=0; c<banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemPresencaTotal().length; c++){
						if(banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemPresencaTotal(c,0)!=null){
							if(banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemPresencaTotal(c,0).equals(banco.getListaC().get(a).getListaM().get(b).getMateria())){
								out.print("<tr>");
								out.print("<td colspan='2' >");
								out.print(banco.getListaC().get(a).getListaM().get(b).getMateria());
								out.print("</td>");
								out.print("<td>");
								out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemPresencaTotal(c,1));
								out.print("</td>");
								out.print("<td>");
								//procurar materia para por a nota total
								for(int d=0; d<banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemNotaTotal().length; d++){
									if(banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemNotaTotal(d, 0) != null){
										if(banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemNotaTotal(d, 0).equals(banco.getListaC().get(a).getListaM().get(b).getMateria())){
											if(banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemNotaTotal(d, 1) !=null){
												out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemNotaTotal(d, 1));
												out.print("</td>");
												out.print("<td colspan='2' >");
												
												out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemPresencaTotal(c,3));
												
												out.print("</td>");
												out.print("</tr>");
											}else{
												out.print("Não atribuido");
												out.print("</td>");
												out.print("<td colspan='2' >");
												out.print(banco.getDados().get(banco.getPosicaoNaListaA()).getListaPorcentagemPresencaTotal(c,2));
												out.print("</td>");
												out.print("</tr>");
											}
										}
									}
								}
								
							}
						}
					}
				}
			}
		}
		%>
	</table>
</body>
</html>