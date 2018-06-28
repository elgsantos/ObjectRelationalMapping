package negocio;

import javax.persistence.*;
import java.util.List;
import negocio.Carro;

@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente{

	@Id
	@SequenceGenerator(name="CLIENTE_ID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CLIENTE_ID_GENERATOR")
	private int id;
	
	@Column(unique=true)
	private String cpf;
	
	@Column
	private String endereco;
	
	@Column
	private String nome;
	
	@Column
	private String telefone;

	@OneToMany(mappedBy="cliente", cascade = {CascadeType.PERSIST,CascadeType.REMOVE} , fetch=FetchType.EAGER)
	private List<Carro> carros;

	public Cliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cpf=" + cpf + ", endereco=" + endereco + ", nome=" + nome + ", telefone="
				+ telefone + "]";
	}	
	

}