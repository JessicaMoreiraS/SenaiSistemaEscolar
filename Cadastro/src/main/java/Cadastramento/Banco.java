package Cadastramento; /*Esta e uma classe estanciada*/

import java.util.ArrayList;
import java.util.List;

public class Banco {

	//Senha do gestor
	private String senhaGestor = "111";
	public String getSenhaGestor() {
		return senhaGestor;
	}
	public void setSenhaGestor(String senhaGestor) {
		this.senhaGestor = senhaGestor;
	}
	
	//Cadastramento de alunos
	private static List<Dados> listaA = new ArrayList<>();
	public void adicionarAlunos(Dados aluno) { /*Metodo para adicionar alunos no ArreyList*/
		Banco.listaA.add(aluno);
	}
	public List<Dados> getDados(){ /*Metodo para listar todo o conteudo da lista?*/
		return Banco.listaA;
	}
	
	
	//Cadastramento de professores
	private static List<DadosProf> listaP = new ArrayList<>();
	public void adicionarProfessor(DadosProf professor) { /*Metodo para adicionar alunos no ArreyList*/
		Banco.listaP.add(professor);
	}
	public List<DadosProf> getDadosProfessor(){ /*Metodo para listar todo o conteudo da listaProfessor?*/
		return Banco.listaP;
	}
	
	
	
	//Cadastramento de curso
	private static List<DadosCurso> listaC = new ArrayList<>();
	public void adicionarCurso(DadosCurso curso) {
		Banco.listaC.add(curso);
	}
	public List<DadosCurso> getListaC(){
		return Banco.listaC;
	}
	
	
	//Cadastramento de materia
	private static List<DadosMaterias> listaM = new ArrayList<>();
	public void adicionarMateria(DadosMaterias materia) {
		Banco.listaM.add(materia);
	}
	public List<DadosMaterias> getDadosMaterias(){
		return Banco.listaM;
	}
	
	//Aluno que esta acessando
	private static int posicaoNaListaA;
	public void setPosicaoNaListaA(int posicao) {
		posicaoNaListaA = posicao;
	}
	public int getPosicaoNaListaA() {
		return posicaoNaListaA;
	}
	
	
	//Professor que esta acessando
	private static int posicaoNaListaP;
	public void adicionarPosicaoNaListaP(int posicao){
		posicaoNaListaP = posicao;
	}
	public int getPosicionamentoProf() {
		return posicaoNaListaP;
	}
	//Statics da pagina de cadastrar nota
	private static int posicaoDaMateriaNaListaM;
	private static int nDeCCDaMateria;
	private static int nDeCDDaMateria;
	public void setPosicaoDaMateriaNaListaM(int posicao){
		posicaoDaMateriaNaListaM = posicao;
	}
	public int getPosicaoDaMateriaNaListaM(){
		return posicaoDaMateriaNaListaM;
	}
	public void setNDeCCDaMateria(int n){
		nDeCCDaMateria= n;
	}
	public int getNDeCCDaMateria(){
		return nDeCCDaMateria;
	}
	public void setNDeCDDaMateria(int n){
		nDeCDDaMateria= n;
	}
	public int getNDeCDDaMateria(){
		return nDeCDDaMateria;
	}
	
	
	//CC da nota //Trocar para variavel do aluno (Dados.java)
	/*private static List<String> listaCCNota = new ArrayList<>();
	public void adicionarCCNota(String cc) {
		Banco.listaCCNota.add(cc);
	}
	public List<String> getDadosCCNota(){
		return Banco.listaCCNota;
	}
	//CD da nota
	private static List<String> listaCDNota = new ArrayList<>();
	public void adicionarCDNota(String cd) {
		Banco.listaCDNota.add(cd);
	}
	public List<String> getDadosCDNota(){
		return Banco.listaCDNota;
	}*/
	
	//Cadastramento de notas dos alunos
	
}
