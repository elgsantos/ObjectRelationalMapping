package negocio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
public class Peca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PECA_ID_GENERATOR", sequenceName="SEQ")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="PECA_ID_GENERATOR")
	private int id;

	private String categoria;

	private String duracao;

	private String nome;

	private float preco;

	private List<Modelo> modelos;

	@OneToMany(mappedBy="peca")
	private List<Utiliza> listaUtiliza;

	public Peca() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDuracao() {
		return this.duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return this.preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public List<Modelo> getModelos() {
		return this.modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public List<Utiliza> getListaUtiliza() {
		return listaUtiliza;
	}

	public void setListaUtiliza(List<Utiliza> listaUtiliza) {
		this.listaUtiliza = listaUtiliza;
	}

}