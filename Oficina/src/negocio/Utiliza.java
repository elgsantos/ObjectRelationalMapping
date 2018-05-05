package negocio;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Utiliza implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Manutencao manutencao;
	private Peca peca;
	
	private int qtd;	

	public Utiliza() {
	}

	public int getQtd() {
		return this.qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Manutencao getManutencao() {
		return this.manutencao;
	}

	public void setManutencao(Manutencao manutencao) {
		this.manutencao = manutencao;
	}

	public Peca getPeca() {
		return this.peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

}