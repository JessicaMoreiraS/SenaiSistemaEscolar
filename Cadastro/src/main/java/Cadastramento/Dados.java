package Cadastramento; /*Esta e uma classe estanciada*/

public class Dados {
	
	private String nome;
	private Integer matricula;
	private String cpf;
	private String curso;
	private String turma;
	private String endereco;
	private String telefone;
	private String email;
	private String senha;
	
	
	private String[][] notas = new String [26][60];
	
	private String[][] listaPorcentagemNotaTotal = new String [26][3];
	
	private int porcentagemNotaCC;
	private int porcentagemNotaCD;
	private int porcentagemNotaTotal;
	private String situacao;
	
	private String[][] presenca = new String[52][180];
	
	/*A situacao final dos alunos esta na ultima coluna de listaPorcentagemPresencaTotal*/
	private String[][] listaPorcentagemPresencaTotal = new String [26][4];
	
	
	public String getNotas(int x, int y) {
		return notas[x][y];
	}
	public void setNotas(int x, int y, String notas) {
		this.notas[x][y] = notas;
	}
	public String[][] getNotas() {
		return notas;
	}
	
	public String getListaPorcentagemNotaTotal(int x, int y) {
		return listaPorcentagemNotaTotal[x][y];
	}
	public String[][] getListaPorcentagemNotaTotal() {
		return listaPorcentagemNotaTotal;
	}
	public void setListaPorcentagemNotaTotal(int x, int y, String materiaOuNotaFinal) {
		this.listaPorcentagemNotaTotal[x][y] = materiaOuNotaFinal;
	}
	
	
	public String getListaPorcentagemPresencaTotal(int x, int y) {
		return listaPorcentagemPresencaTotal[x][y];
	}
	public String[][] getListaPorcentagemPresencaTotal() {
		return listaPorcentagemPresencaTotal;
	}
	public void setListaPorcentagemPresencaTotal(int x, int y, String presencaOuSituacao) {
		this.listaPorcentagemPresencaTotal[x][y] = presencaOuSituacao;
	}
	
	
	public int getPorcentagemNotaCC() {
		return porcentagemNotaCC;
	}
	public void setPorcentagemNotaCC(int porcentagemNotaCC) {
		this.porcentagemNotaCC = porcentagemNotaCC;
	}
	public int getPorcentagemNotaCD() {
		return porcentagemNotaCD;
	}
	public void setPorcentagemNotaCD(int porcentagemNotaCD) {
		this.porcentagemNotaCD = porcentagemNotaCD;
	}
	public int getPorcentagemNotaTotal() {
		return porcentagemNotaTotal;
	}
	public void setPorcentagemNotaTotal(int porcentagemNotaTotal) {
		this.porcentagemNotaTotal = porcentagemNotaTotal;
	}
	
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
	public String getPresenca(int x, int y) {
		return presenca[x][y];
	}
	public void setPresenca(int x, int y, String frequencia) {
		this.presenca[x][y] = frequencia;
	}
	public String[][] getPresenca() {
		return presenca;
	}
	
	
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
