package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Aluno extends Persona {
	@Column(name = "estagiario")
	private Boolean estagiario;
	
	@Column(name = "mensalidade")
	private Double mensalidade;

	public Boolean getEstagiario() {
		return estagiario;
	}

	public void setEstagiario(Boolean estagiario) {
		this.estagiario = estagiario;
	}

	public Double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}
	
}

