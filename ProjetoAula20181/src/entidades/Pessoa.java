package entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import util.TipoPessoa;

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

	@Column(name = "tipo_pessoa")
	@Enumerated(EnumType.ORDINAL)
	private TipoPessoa tipoPessoa;
	
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Transient
	private String desc;
	
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

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getDescricao() {
		String desc = this.id + this.nome;
		return desc;
	}

	public void setDescricao() {
		String desc = this.id + this.nome;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", salario=" + salario + ", tipoPessoa=" + tipoPessoa
				+ ", dataNascimento=" + dataNascimento + "]";
	}
	
}
