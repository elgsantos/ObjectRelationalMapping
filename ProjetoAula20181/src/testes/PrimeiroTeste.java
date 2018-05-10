package testes;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidades.Complemento;
import entidades.Endereco;
import entidades.Pessoa;
import util.JPAutil;
import util.TipoPessoa;

public class PrimeiroTeste {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {

		/* Inserindo uma nova entidade*/
		/*
		Pessoa p = new Pessoa();
		p.setNome("Eduardo");
		p.setSalario(2.223);
		
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		unGerenciadora.persist(p);
		
		tx.commit();
		JPAutil.close();
		*/
		/*entidade existente no contexto
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		Pessoa p = unGerenciadora.find(Pessoa.class, 1);
		
		System.out.println("ID: " +p.getId()+" / nome: "+p.getNome());
		
		unGerenciadora.close();
		JPAutil.close();
		*/
		/*Atualizando uma entidade*/
		/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		Pessoa p = unGerenciadora.find(Pessoa.class, 1);
		
		System.out.println("Dados Antigos:");
		System.out.println("ID: " +p.getId()+" / Nome: "+p.getNome()+" / Salário: "+p.getSalario());
		
		System.out.println("Alterando os dados");
		p.setNome("Eduardo Gomes");
		p.setSalario(2000.00);
		
		System.out.println("Dados Novos:");
		System.out.println("ID: " +p.getId()+" / Nome: "+p.getNome()+" / Salário: "+p.getSalario());
		
		
		tx.commit();
		unGerenciadora.close();
		JPAutil.close();
		*/
		
		/*Deletando uma entidade*/
		/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		Pessoa p = unGerenciadora.find(Pessoa.class, 1);//id
		
		System.out.println("Deletando:");
		System.out.println("ID: " +p.getId()+" / Nome: "+p.getNome()+" / Salário: "+p.getSalario());
		
		unGerenciadora.remove(p);
		
		tx.commit();
		unGerenciadora.close();
		JPAutil.close();
		*/
		
		/*Buscando lista de entidades*/
		/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		
		Query query = unGerenciadora.createQuery("from Pessoa p", Pessoa.class);
		
		List<Pessoa> listaPessoas = query.getResultList();
		
		for (Pessoa p : listaPessoas) {
			System.out.println("ID: " +p.getId()+" / Nome: "+p.getNome()+" / Salário: "+p.getSalario());
		}
		unGerenciadora.close();
		JPAutil.close();
		*/
		/*TESTANDO NIVEL DE CACHE PRIMARIO*/
		/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		
		Pessoa p1 = unGerenciadora.find(Pessoa.class, 1);
		System.out.println("ID: " +p1.getId()+" / nome: "+p1.getNome());
		
		Pessoa p2 = unGerenciadora.find(Pessoa.class, 1);
		System.out.println("ID: " +p2.getId()+" / nome: "+p2.getNome());
		
		System.out.println("É a mesma entidade? "+(p1==p2));
		
		unGerenciadora.close();
		JPAutil.close();*/
		
		/*TESTANDO NIVEL DE CACHE PRIMARIO com detached*/
		/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		
		Pessoa p1 = unGerenciadora.find(Pessoa.class, 1);
		System.out.println("ID: " +p1.getId()+" / nome: "+p1.getNome());
		
		System.out.println("Objeto está sendo gerenciado? "+unGerenciadora.contains(p1));
		
		unGerenciadora.detach(p1);
		
		System.out.println("E agora? Objeto está sendo gerenciado? "+unGerenciadora.contains(p1));
		Pessoa p2 = unGerenciadora.find(Pessoa.class, 1);
		System.out.println("ID: " +p2.getId()+" / nome: "+p2.getNome());
		
		System.out.println("É a mesma entidade? "+(p1==p2));
		
		unGerenciadora.close();
		JPAutil.close();
		*/
		/* Testando sincronização com o método flush*/
		/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		Pessoa p1 = unGerenciadora.find(Pessoa.class, 1);
		System.out.println("ID: " +p1.getId()+" / nome: "+p1.getNome());
		
		p1.setNome("Teste Flush");
		
		unGerenciadora.flush();
		
		System.out.println("NOVO VALOR- ID: " +p1.getId()+" / nome: "+p1.getNome());
		tx.commit();
		JPAutil.close();
		*/
		
		/* Testando sincronização com o método flush*/
		/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		Pessoa p1 = unGerenciadora.find(Pessoa.class, 1);
		System.out.println("ID: " +p1.getId()+" / nome: "+p1.getNome());
		
		p1.setNome("Teste Flush");
		
		unGerenciadora.flush();
		
		System.out.println("NOVO VALOR- ID: " +p1.getId()+" / nome: "+p1.getNome());
		tx.commit();
		JPAutil.close();
		*/
		/* Testando sincronização com o método merge*/
/*
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		Pessoa p1 = unGerenciadora.find(Pessoa.class, 1);
		System.out.println("ID: " +p1.getId()+" / nome: "+p1.getNome());
		
		tx.commit();
		unGerenciadora.close();
		
		p1.setNome("Teste Merge");
		
		unGerenciadora = JPAutil.getEntityManager();
		tx = unGerenciadora.getTransaction();
		
		tx.begin();
		p1=unGerenciadora.merge(p1);
		tx.commit();
		unGerenciadora.close();
		
		System.out.println("NOVO VALOR- ID: " +p1.getId()+" / nome: "+p1.getNome());
		
		JPAutil.close();
*/
		/*Testando mapeamento pk composta - classe embutida*/
		/*
		PessoaPKcomposta ppk = new PessoaPKcomposta();
		
		ppk.setPk(new PessoaPK("1","1"));
		ppk.setNome("Thiago");
		ppk.setSalario(200.0);
		
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		unGerenciadora.persist(ppk);
		
		tx.commit();
		JPAutil.close();
		*/
		/*Testando mapeamento pk composta - classe embutida estrategia 2 */
		/*
		PessoaPKcomposta2 ppk2 = new PessoaPKcomposta2();
		
		ppk2.setCpf("1");
		ppk2.setRg("1");
		ppk2.setNome("Thiago");
		ppk2.setSalario(200.0);
		
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		unGerenciadora.persist(ppk2);
		
		tx.commit();
		JPAutil.close();
		*/
		/*TESTANDO MAPEAMENTO ENUM*/
		/*
		Pessoa p = new Pessoa();
		
		p.setNome("Eduardo");
		p.setSalario(2.20);
		p.setTipoPessoa(TipoPessoa.ESTUDANTE);
		p.setDataNascimento(new Date("1983/07/02"));
		
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		unGerenciadora.persist(p);
		
		System.out.println(p.getDescricao());
		
		tx.commit();
		JPAutil.close();
		*/
		/*TESTANDO MAPEAMENTO CLOB E BLOB*/
		/*
		Pessoa p = new Pessoa();
		
		p.setNome("Eduardo");
		p.setSalario(2.20);
		p.setTipoPessoa(TipoPessoa.ESTUDANTE);
		p.setDataNascimento(new Date("1983/07/02"));
		
		StringBuilder historico = new StringBuilder();
		
		historico.append("\nPersona fulano de tal, adicionou um item");
		historico.append("\nPersona fulano de tal, removeu um item");
		historico.append("\nO personagem evoluiu para o level 3.");
		
		p.setHistorico(historico.toString().toCharArray());
		
		Path path = FileSystems.getDefault().getPath("C:\\Users\\Public\\Pictures\\Sample Pictures\\Desert.jpg");
		byte[] foto = Files.readAllBytes(path);
		p.setFoto(foto);
		
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		unGerenciadora.persist(p);
		
		System.out.println(p.getDescricao());
		
		tx.commit();
		JPAutil.close();
		*/
		/* Recuperar arquivo do banco
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		Pessoa p = unGerenciadora.find(Pessoa.class, 1);
		
		if(p.getFoto()!=null) {
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(p.getFoto()));
			JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
		}
		
		unGerenciadora.close();
		*/
		/* heranca embbeded
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		Complemento c = new Complemento();
		c.setNome("Loja 1");
		c.setDescricao("Loja 1 que fica no segundo andar");
		c.setReferencia("Em frente ao mestre do suco");
		
		Endereco endereco = new Endereco();
		endereco.setId(1);
		endereco.setRua("Rua 1");
		endereco.setNumero(1);
		endereco.setBairro("Fonseca");
		endereco.setCep("123456");
		endereco.setCidade("niteroi");
		endereco.setEstado("RJ");
		endereco.setComplemento(c);
		
		unGerenciadora.persist(endereco);
		
		tx.commit();
		JPAutil.close();
		*/
		//Testando one to one
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		EntityTransaction tx = unGerenciadora.getTransaction();
		
		tx.begin();
		
		Complemento c = new Complemento();
		c.setNome("Loja 1");
		c.setDescricao("Loja 1 que fica no segundo andar");
		c.setReferencia("Em frente ao mestre do suco");
		
		Endereco endereco = new Endereco();
		endereco.setId(1);
		endereco.setRua("Rua 1");
		endereco.setNumero(1);
		endereco.setBairro("Fonseca");
		endereco.setCep("123456");
		endereco.setCidade("niteroi");
		endereco.setEstado("RJ");
		endereco.setComplemento(c);
		
		Pessoa p = new Pessoa();
		p.setId(1);
		p.setNome("Eduardo");
		p.setSalario(2.00);
		p.setTipoPessoa(TipoPessoa.ESTUDANTE);
		p.setDataNascimento(new Date(1990/01/01));
		p.setEndereco(endereco);
		
		unGerenciadora.persist(endereco);
		unGerenciadora.persist(p);
		
		tx.commit();
		JPAutil.close();
	}

}
