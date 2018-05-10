package negocio;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="carro")
public class Carro extends Veiculo{
	
	@Column
	private String combustivel;
	
	@Column
	private int km;
	
	@Column
	private String marca;
	
	@Column
	private String placa;
	
	@ManyToOne
	@JoinColumn(name="Modelo_id", referencedColumnName="id")
	private Modelo modelo;
	
	@ManyToOne
	@JoinColumn(name="Cliente_id", referencedColumnName="id")
	private Cliente cliente;

	private List<Manutencao> listaManutencao;

	public Carro() {
		super();//?
	}

	public String getCombustivel() {
		return this.combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public int getKm() {
		return this.km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Modelo getModelo() {
		return this.modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Manutencao> getListaManutencao() {
		return listaManutencao;
	}

	public void setListaManutencao(List<Manutencao> listaManutencao) {
		this.listaManutencao = listaManutencao;
	}



}