package negocio;

import javax.persistence.*;
import java.util.List;

@Entity
public class Modelo {

	@Id
	@SequenceGenerator(name="MODELO_ID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="MODELO_ID_GENERATOR")
	private int id;

	@Column
	private int ano;
	
	@Column
	private String nome;
	
	@Column
	private int numpassageiro;
	
	@OneToMany(mappedBy="modelo", cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Modelo_id")
	private List<Carro> carros;

	private List<Peca> pecas;

	public Modelo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAno() {
		return this.ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumpassageiro() {
		return this.numpassageiro;
	}

	public void setNumpassageiro(int numpassageiro) {
		this.numpassageiro = numpassageiro;
	}

	public List<Carro> getCarros() {
		return this.carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public List<Peca> getPecas() {
		return this.pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

}