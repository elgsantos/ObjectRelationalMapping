package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "personaJOINED")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class PersonaJOINED {
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "gen_personaJ", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "gen_personaJ", sequenceName = "seq_personaJ", schema = "aulajpa")
	private int id;
	
	@Column(name="nome")
	private String nome;

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
}
