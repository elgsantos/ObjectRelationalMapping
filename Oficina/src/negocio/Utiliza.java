package negocio;

import javax.persistence.*;

@Entity
public class Utiliza{
	
	@Id
	
	
	@ManyToOne
	@JoinColumn(name="manutencao_id", referencedColumnName="id")
	private Manutencao manutencao;
	
	private Peca peca;
	
	private int qtd;	

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