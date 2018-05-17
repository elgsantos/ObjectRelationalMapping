package negocio;

import javax.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {

	@Id
	@SequenceGenerator(name="VEICULO_ID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="VEICULO_ID_GENERATOR")
	public int id;

	public String tipo;
	
	private Cliente cliente;

	public Veiculo() {
	}

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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}