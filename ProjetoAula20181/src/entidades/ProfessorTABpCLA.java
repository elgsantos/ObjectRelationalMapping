package entidades;

import entidades.PersonaTABpCLA;
import javax.persistence.*;

@Entity
@Table(name="ProfessorTABpCLA")

public class ProfessorTABpCLA extends PersonaTABpCLA {

	@Column(name = "curso")
	private String curso;
	
	@Column(name = "salario")
	private Double salario;
	
	@Column(name = "lotacao")
	private String lotacao;

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getLotacao() {
		return lotacao;
	}

	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}
   
}
