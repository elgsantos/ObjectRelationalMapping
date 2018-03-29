package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Entity
@IdClass(value = PessoaPK.class)
public class PessoaPKcomposta2 {
	
	@Id
	@Column(name = "cpf")
	private String cpf;
	@Id
	@Column(name = "rg")
	private String rg;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "salario", nullable = false)
	private Double salario;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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
