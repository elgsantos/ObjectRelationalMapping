package entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "acessorio")
public class Acessorio {

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "gen_acessorio", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "gen_acessorio", sequenceName = "seq_acessorio", schema = "aulajpa")
	private int id;
	
	@Column(name = "descricao")
	private String descricao;

	@ManyToMany(mappedBy = "acessorios")
	private Set<Dispositivo> dispositivos;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(Set<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}
}
