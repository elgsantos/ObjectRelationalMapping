package negocio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Embeddable
public class Manutencao implements Serializable {

	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name="MANUTENCAO_ID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="MANUTENCAO_ID_GENERATOR")
	private int id;

	//private int carro_id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_entrada")
	private Date dataEntrada;

	@Temporal(TemporalType.DATE)
	@Column(name="data_retirada")
	private Date dataRetirada;

	private float preco;

	//private Carro carro;

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

}