package negocio;

import javax.persistence.*;
import java.util.List;
import negocio.Carro;

@Entity
public class Cliente{

	@Id
	@SequenceGenerator(name="CLIENTE_ID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CLIENTE_ID_GENERATOR")
	private int id;
	
	@Column
	private String endereco;
	
	@Column
	private String nome;
	
	@Column
	private String telefone;

	@OneToMany(mappedBy="cliente", cascade = CascadeType.PERSIST)
	private List<Carro> carros;

	public Cliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Carro> getCarros() {
		return this.carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

}