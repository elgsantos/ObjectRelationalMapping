package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="persona_id")
public class AlunoJOINED extends PersonaJOINED {
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
