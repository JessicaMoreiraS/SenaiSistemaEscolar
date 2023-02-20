<!--<%/* @ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"*/%>-->
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
	<title>Lista de alunos cadastrados na instituição</title>
</head>
<body>
	<header>
        <h1>Lista de todos os alunos cadastrados</h1>
    </header>
    <main>
		<table>
			<tr>
				<th>Matrícula</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Curso</th>
				<th>Turma</th>
				<th>E-mail</th>
				<th>Telefone</th>
				<th>Endereço</th>
			</tr>
			
			<%
			Banco banco = new Banco();
			for(int i=0; i<banco.getDados().size(); i++){
				out.print("<tr>");
				out.print("<td>");
				out.print(banco.getDados().get(i).getMatricula());
				out.print("</td>");
				out.print("<td>");
				out.print(banco.getDados().get(i).getNome());
				out.print("</td>");
				out.print("<td>");
				out.print(banco.getDados().get(i).getCpf());
				out.print("</td>");
				out.print("<td>");
				out.print(banco.getDados().get(i).getCurso());
				out.print("</td>");
				out.print("<td>");
				out.print(banco.getDados().get(i).getTurma());
				out.print("</td>");
				out.print("<td>");
				out.print(banco.getDados().get(i).getEmail());
				out.print("</td>");
				out.print("<td>");
				out.print(banco.getDados().get(i).getTelefone());
				out.print("</td>");
				out.print("<td>");
				out.print(banco.getDados().get(i).getEndereco());
				out.print("</td>");
				out.print("</tr>");
			}
			%>
		</table>
	</main>
	<footer>
        <a href="homeGestor.html"><img class="retorno2" src="img/back.png" alt=""></a>
    </footer>
</body>
</html>