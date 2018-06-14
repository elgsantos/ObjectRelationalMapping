package negocio;

import javax.persistence.*;

@Entity
@Table(name = "veiculo")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Veiculo {

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "gen_veiculo", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "gen_veiculo", sequenceName = "seq_veiculo", schema = "oficina")
	public int id;

	@Column(name="tipo")
	public String tipo;
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}