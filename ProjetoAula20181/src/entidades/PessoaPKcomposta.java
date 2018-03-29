package entidades;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_composta")
public class PessoaPKcomposta {
	
	@EmbeddedId
	private PessoaPK pk;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "salario", nullable = false)
	private Double salario;
	
	public PessoaPK getPk() {
		return pk;
	}

	public void setPk(PessoaPK pk) {
		this.pk = pk;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
}
