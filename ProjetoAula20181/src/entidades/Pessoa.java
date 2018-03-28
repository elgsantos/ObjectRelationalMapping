package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

//@Entity(name = "Pessoa")
@Entity
public class Pessoa {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "gen_pessoa", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "gen_pessoa", sequenceName = "seq_pessoa", schema="aulajpa")
	private int id;
	
	@Column(name = "nome", length=250, nullable = false)
	private String nome;
	
	@Column(name = "salario", precision=2, nullable = false)
	private Double salario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
