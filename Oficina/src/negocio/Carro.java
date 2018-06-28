package negocio;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carro")
@NamedQuery(name="Carro.findAll", query="SELECT c FROM Carro c")
@PrimaryKeyJoinColumn(name="veiculo_id")
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
	@JoinColumn(name="modelo_id", referencedColumnName="id")
	private Modelo modelo;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id")
	private Cliente cliente;
	
	@OneToMany(mappedBy="carro", fetch=FetchType.EAGER, cascade = {CascadeType.REMOVE})
	private List<Manutencao> listaManutencao;

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

	public List<Manutencao> getListaManutencao() {
		return listaManutencao;
	}

	public void setListaManutencao(List<Manutencao> listaManutencao) {
		this.listaManutencao = listaManutencao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Carro [combustivel=" + combustivel + ", km=" + km + ", marca=" + marca + ", placa=" + placa
				+ ", modelo=" + modelo + ", listaManutencao=" + listaManutencao + "]";
	}
	
}