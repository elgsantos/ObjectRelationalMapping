package entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
@Table(name="dispositivo")
public class Dispositivo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "gen_dispositivo", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "gen_dispositivo", sequenceName = "seq_dispositivo", schema="aulajpa")
	private int id;
	@Column(name="descricao")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
   
}
