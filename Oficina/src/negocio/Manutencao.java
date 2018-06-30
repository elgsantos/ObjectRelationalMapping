package negocio;

import javax.persistence.*;

import negocio.Utiliza;
import negocio.Carro;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "manutencao")
@NamedQuery(name="Manutencao.findAll", query="SELECT c FROM Manutencao c")
public class Manutencao{

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "gen_manutencao", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "gen_manutencao", sequenceName = "seq_manutencao", schema = "oficina")
	public int id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_entrada")
	private Date dataEntrada;

	@Temporal(TemporalType.DATE)
	@Column(name="data_retirada")
	private Date dataRetirada;

	private float preco;

	@ManyToOne
	@JoinColumn(name="carro_id", referencedColumnName="id")
	private Carro carro;
	
	@OneToMany(mappedBy="manutencao", cascade = {CascadeType.PERSIST,CascadeType.REMOVE} , fetch=FetchType.EAGER)
	private List<Utiliza> listautiliza;

	public Manutencao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataEntrada() {
		return this.dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataRetirada() {
		return this.dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public float getPreco() {
		return this.preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public List<Utiliza> getListautiliza() {
		return listautiliza;
	}

	public void setListautiliza(List<Utiliza> listautiliza) {
		this.listautiliza = listautiliza;
	}
	
	public Utiliza addUtiliza(Utiliza utiliza) {
		getListautiliza().add(utiliza);
		utiliza.setManutencao(this);

		return utiliza;
	}

	public Utiliza removeUtiliza(Utiliza utiliza) {
		getListautiliza().remove(utiliza);
		utiliza.setManutencao(null);

		return utiliza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((carro == null) ? 0 : carro.hashCode());
		//result = prime * result + carro_id;
		result = prime * result + ((dataEntrada == null) ? 0 : dataEntrada.hashCode());
		result = prime * result + ((dataRetirada == null) ? 0 : dataRetirada.hashCode());
		result = prime * result + id;
		result = prime * result + Float.floatToIntBits(preco);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manutencao other = (Manutencao) obj;
		if (dataEntrada == null) {
			if (other.dataEntrada != null)
				return false;
		} else if (!dataEntrada.equals(other.dataEntrada))
			return false;
		if (dataRetirada == null) {
			if (other.dataRetirada != null)
				return false;
		} else if (!dataRetirada.equals(other.dataRetirada))
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Manutencao [id=" + id + ", preco="
				+ preco + ", carro=" + carro + "]";
	}

}