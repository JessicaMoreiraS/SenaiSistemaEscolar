package Cadastramento;

import java.util.ArrayList;
import java.util.List;

public class DadosMaterias {
	private String materia;
	private String curso;
	private Integer numeroCriteriosCriticos;
	private Integer numeroCriteriosDesejaveis;
	private List<String> listaCC = new ArrayList<>();
	private List<String> listaCD = new ArrayList<>();
	
	public List<String> getListaCC() {
		return listaCC;
	}
	/*public String getListaNomeCC(int x) {
		String criterio = getListaCC(x);
		return criterio;
	}*/
	public void setListaCC(String cc) {
		listaCC.add(cc);
	}
	
	public List<String> getListaCD(){
		return listaCD;
	}
	public void setListaCD(String cd) {
		listaCD.add(cd);
	}
	
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Integer getNumeroCriteriosCriticos() {
		return numeroCriteriosCriticos;
	}
	public void setNumeroCriteriosCriticos(Integer numeroCriteriosCriticos) {
		this.numeroCriteriosCriticos = numeroCriteriosCriticos;
	}
	public Integer getNumeroCriteriosDesejaveis() {
		return numeroCriteriosDesejaveis;
	}
	public void setNumeroCriteriosDesejaveis(Integer numeroCriteriosDesejaveis) {
		this.numeroCriteriosDesejaveis = numeroCriteriosDesejaveis;
	}
}
