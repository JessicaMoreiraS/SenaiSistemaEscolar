package Cadastramento;

import java.util.ArrayList;
import java.util.List;

public class DadosCurso {
	private String curso;
	private static List<DadosMaterias> listaMateriasDoCurso = new ArrayList<>();
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public static List<DadosMaterias> getListaM() {
		return listaMateriasDoCurso;
	}
	
	public static void setListaM(DadosMaterias materia) {
		DadosCurso.listaMateriasDoCurso.add(materia);
	}
}
