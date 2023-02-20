<%@page import="java.awt.image.BandCombineOp"%><!-- Não sei o que isso faz, apareceu sozinho -->
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%> <!-- Nao sei o que isso faz, copiei de Listagem.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Cadastramento.Banco"%>
<%@page import="Cadastramento.cadastrarMaterias"%>
<%@page import="Cadastramento.DadosMaterias"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/cadastro-de-notas.css">
<title>Cadastro de criterios</title>
</head>
<body>
	<header>
        <h1>Cadastrar Critérios da matéria</h1>
    </header>
    
    <main>
    	<div id="caixa-central-1">
            <div id="linha-verde"></div>
            <div id="conteudo-1">
                <h2>CADASTRE CURSOS E MATÉRIAS</h2>
            </div>
				<form action="/Cadastro/cadastrarCriteriosDaMateria" method="post">
					<div id="alinhar-2-3">
                		<div id="conteudo-2">
							<% 
							/*@SuppressWarnings("unchecked")*/
							/*List<DadosMaterias> lista = (List<DadosMaterias>) request.getAttribute("listaM"); Não sei o que é isso*/
							Banco bancoMateria = new Banco();
							DadosMaterias bancoCC = new DadosMaterias();
							String[] arreyNameImputCC = {"cc1", "cc2", "cc3", "cc4", "cc5", "cc6", "cc7", "cc8", "cc9", "cc10", "cc11", "cc12"};
							String[] arreyNameImputCD = {"cd1", "cd2", "cd3", "cd4", "cd5", "cd6", "cd7", "cd8", "cd9", "cd10", "cd11", "cd12"};
							
							
							for(int x = 0; x<bancoMateria.getDadosMaterias().get(bancoMateria.getDadosMaterias().size()-1).getNumeroCriteriosCriticos(); x++){
								%><label>Criterio Critico:</label>
								  <input class="inputs" type='text' name="<%out.print(arreyNameImputCC[x]);%>"/>
								<%	
							}%>
						</div>
                		<div id="conteudo-3">
							<%for(int x = 0; x<bancoMateria.getDadosMaterias().get(bancoMateria.getDadosMaterias().size()-1).getNumeroCriteriosDesejaveis(); x++){
								%><label>Criterio Desejavel:</label>
								  <input class="inputs" type='text' name="<%out.print(arreyNameImputCD[x]);%>"/>
								<%	
							}
							%>
							</div>
	            		</div>
					<button type="submit">Cadastrar Critérios</button>
				</form>
			</div>
		</main>
	<footer>
        <a href="homeGestor.html">
            <img class="retorno" src="img/back.png" alt="">
        </a>
    </footer>
</body>
</html>