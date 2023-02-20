<%@page import="javax.security.auth.message.MessagePolicy.TargetPolicy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="Cadastramento.Banco"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/cadastro-de-notas.css"/>
<title>Cadastrar Notas</title>
</head>
<body>
	<div id="escopo">
		<header>
			<h1>Cadastrar notas dos alunos</h1>
		</header>

		<%
		Banco banco = new Banco();
		String nomeProfessor = banco.getDadosProfessor().get(banco.getPosicionamentoProf()).getNome();
		String materiaDoProfessor = banco.getDadosProfessor().get(banco.getPosicionamentoProf()).getMateria();

		//Esse for para linkar a materia do professor com a materia na Lita materia 
		for (int x = 0; x < banco.getDadosMaterias().size(); x++) {
			if (banco.getDadosMaterias().get(x).getMateria().equals(materiaDoProfessor)) {
				/*banco.setPosicaoDaMateriaNaListaM(banco.getDadosMaterias().indexOf(banco.getDadosMaterias().get(x)));*/
				banco.setNDeCCDaMateria(
				banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getNumeroCriteriosCriticos());
				banco.setNDeCDDaMateria(
				banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getNumeroCriteriosDesejaveis());
			}
		}
		%>
		<h2 class="titulos">
			Professor:
			<%
		out.print(nomeProfessor);
		%>
		</h2>
		<h3>
			Materia:
			<%
		out.print(materiaDoProfessor);
		%>
		</h3 class="titulos">
		<form action="/Cadastro/cadastrarNotas" method="post">
		
		<br><br><br>

			<label>Número da matricula do aluno</label> 
			<br>
			<input id="input-matriculaA" type="number" name="matriculaAlunoNota"><br>

			<%
			String[] arrayNotasCCAluno = { "notaCc1", "notaCc2", "notaCc3", "notaCc4", "notaCc5", "notaCc6", "notaCc7", "notaCc8",
					"notaCc9", "notaCc10", "notaCc11", "notaCc12", };
			/*for(int y = 0; y<banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM().get; y++){
				
			}*/
			for (int x = 0; x < banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM())
					.getNumeroCriteriosCriticos(); x++) {
			%>
			<label>
				<%
				out.print(banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getListaCC().get(x));
				%>
			</label> <input class="input-notas" type="text" name="<%out.print(arrayNotasCCAluno[x]);%>"><br>
			<%
			}
			String[] arrayNotasCDAluno = { "notaCd1", "notaCd2", "notaCd3", "notaCd4", "notaCd5", "notaCd6", "notaCd7", "notaCd8",
					"notaCd9", "notaCd10", "notaCd11", "notaCd12", };
			for (int x = 0; x < banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM())
					.getNumeroCriteriosDesejaveis(); x++) {
			%>
			<label>
				<%
				out.print(banco.getDadosMaterias().get(banco.getPosicaoDaMateriaNaListaM()).getListaCD().get(x));
				%>
			</label> <input class="input-notas"  type="text" name="<%out.print(arrayNotasCDAluno[x]);%>"><br>
			<%
			}
			%>
			<button id="btn-notas" type="submit">Cadastrar Notas</button>
		</form>
	</div>
	<footer id="rodape">
		<a href="homeProfessor.html" style="text-decoration: none;">
		<img class="home" src="img/home.png" alt="">
		</a>
	</footer>
</body>
</html>
