package entidades;

import entidades.PersonaTABpCLA;
import javax.persistence.*;

@Entity
@Table(name="AlunoTABpCLA")
public class AlunoTABpCLA extends PersonaTABpCLA {

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
