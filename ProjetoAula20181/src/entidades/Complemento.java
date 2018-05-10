package entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Complemento {
	@Column(name="nome")
	String nome;
	
	@Column(name="descricao")
	String descricao;
	
	@Column(name="referencia")
	String referencia;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
}
