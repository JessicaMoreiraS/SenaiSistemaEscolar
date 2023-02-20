<%@page import="javax.security.auth.message.MessagePolicy.TargetPolicy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Cadastramento.Banco"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/cadastro-de-notas.css" />
<title>Cadastre a presença dos alunos</title>
</head>
<body>
	<div id="escopo">
	<header>
		<h1>Cadastro de Frequência</h1>
	</header>
	<form action="/Cadastro/cadastrarPresencaDosAlunos" method="post">
		<label class="data">Data</label> <input class="input-data"type="text" name="data">
		<br> <br> <br>
		<table id="table-frequencia">
			<%
			//for que lista todos os alunos e coloca um input do lado de cada aluno para colocar P ou F
			String[] identificacaoInputs = { "a1", "a2", "a3", "a4,", "a5", "a6", "a7", "a8", "a9", "a10", "a11", "a12", "a13",
					"a14", "a15", "a16", "a17", "a18", "a19", "a20", "a21", "a22", "a23", "a24", "a25", "a26", "a27", "a28", "a29",
					"a30", "a31", "a32", "a33", "a34", "a35" };
			int nomeInput = 0;
			Banco banco = new Banco();
			for (int i = 0; i < banco.getDados().size(); i++) {
				if (banco.getDados().get(i).getCurso()
				.equals(banco.getDadosProfessor().get(banco.getPosicionamentoProf()).getCurso())) {
					out.print("<tr>");
					out.print("<td>");
					out.print(banco.getDados().get(i).getMatricula());
					out.print("</td>");
					out.print("<td>");
					out.print(banco.getDados().get(i).getNome());
					out.print("</td>");
			%>
			<td><input id="input-freq" type="text"
				name="<%out.print(identificacaoInputs[nomeInput]);%>" /></td>
			<%
			nomeInput++;
			out.print("</tr>");
			}
			}
			%>
		</table>
		<button id="btn-presenca" type="submit">Cadastrar</button>
	</form>
	</div>
	<footer id="rodape">
		<a href="homeProfessor.html" style="text-decoration: none;">
		<img class="home" src="img/home.png" alt="">
		</a>
	</footer>
</body>
</html>