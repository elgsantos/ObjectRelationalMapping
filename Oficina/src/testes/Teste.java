package testes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import negocio.Carro;
import negocio.Cliente;
import negocio.Modelo;
import util.JPAutil;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		cliente.setNome("Eduardo");
		cliente.setTelefone("11111111");
		cliente.setEndereco("Rua 1");
		
		Modelo m = new Modelo();
		m.setAno(2018);
		m.setNumpassageiro(4);
		m.setNome("Uno");
		
		Carro c = new Carro();
		c.setTipo("Carro esportivo");
		c.setCombustivel("gas");
		c.setKm(0);
		c.setMarca("Fiat");
		c.setModelo(m);
		c.setCliente(cliente);
		c.setPlaca("123ABCS");
		List<Carro> carros = new ArrayList<Carro>();
		carros.add(c);
		
		m.setCarros(carros);
		cliente.setCarros(carros);
		
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		unGerenciadora.persist(cliente);
		unGerenciadora.persist(m);

		
		tx.commit();
		JPAutil.close();
		
	}

}
