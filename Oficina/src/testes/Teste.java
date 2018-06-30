package testes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dao.CarroDAO;
import dao.ClienteDAO;
import dao.ManutencaoDAO;
import dao.ModeloDAO;
import negocio.Manutencao;
import negocio.Carro;
import negocio.Cliente;
import negocio.Manutencao;
import negocio.Modelo;
import util.JPAutil;

public class Teste {

	public static void main(String[] args) throws Exception {
		
		//--------------------Menu-----------------------
		Scanner inp = new Scanner(System.in);
	    int op;
	   
	    while (true) {
	        System.out.println(
	        		  "-------------------------------\n"
	                + "| Escolha sua op��o:          |\n"
	                + "| 1 Gerenciar Clientes        |\n"
	                + "| 2 Gerenciar Carros          |\n"
	                + "| 3 Gerenciar Manuten��es     |\n"
	                + "| Sair: qualquer outro n�mero |\n"
	                + "-------------------------------\n");

	        op = inp.nextInt();

	        switch (op) {
	        	case 1:
	        		menuCliente();
	        		
	        		break;
	        	case 2:
		        	menuCarro();
		        	
		        	break;
	        	case 3:
		        	menuManutencao();
		        	
		        	break;
			default:
				
	            return;
	        }
	    }
	    //---------------------FIM-MENU---------------		
	}
	public static void menuCliente() throws Exception {
		ClienteDAO clienteDAO = new ClienteDAO();
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		Scanner inp = new Scanner(System.in);
	    int op;
		while (true) {
	        System.out.println(
	        		  "---------------------------------------------"+"    ___\r\n"  
	    	        + "| Escolha sua op��o:                        |"+"   //_\\\\_\r\n"  
	                + "| 1 Incluir Clientes                        |"+" .\"\\\\    \".\r\n"  
	                + "| 2 Consultar Cliente                       |"+"/          \\\r\n"  
	                + "| 3 Atualizar Cliente                       |"+"|           \\_\r\n" 
	                + "| 4 Excluir Cliente                         |"+"|       ,--.-.)\r\n" 
	                + "| 5 Listar Clientes                         |"+" \\     /  o \\o\\\r\n"  
	                + "| Voltar para o menu: qualquer outro n�mero |"+" /\\/\\  \\    /_/\r\n"  
	                + "---------------------------------------------"+"  (_.   `--'__)\r\n" 
	                + "---------------------------------------------"+"   |     .-'  \\\r\n"  
	                + "---------------------------------------------"+"   |  .-'.     )\r\n" 
	                + "---------------------------------------------"+"   | (  _/--.-'\r\n"  
	                + "---------------------------------------------"+"   |  `.___.'\r\n" 
	                + "---------------------------------------------"+"         ("
	                );

	        op = inp.nextInt();
	        
	        switch (op) {
	        case 1:	
	    		Cliente cliente = new Cliente();
	    		
	    		cliente = clienteDAO.salvar(novoCliente());
	    		
	            break;
	        case 2:
	        	System.out.println("Insira o id:");
	    		
	    		Cliente cli = clienteDAO.consultarPorId(inp.nextInt());
	    		
	    		System.out.println(cli.toString());
	    		
	    		System.out.println(cli.getCarros().toString());
	            break;
	        case 3:
	        	System.out.println("Insira o id:");
	        	Cliente cliente1 = unGerenciadora.find(Cliente.class, inp.nextInt());

	        	  unGerenciadora.getTransaction().begin();
	        	  cliente1=updateCliente(cliente1);
	        	  System.out.println("Cliente Atualizado");
	        	  unGerenciadora.getTransaction().commit();
	        	break;
	        case 4:
	    		System.out.println("Insira o id:");
	    		int id=inp.nextInt();
	    		String ctz;
	    		do {
	    			System.out.println("Tem certeza que deseja excluir o Cliente de id="+id+"? (s ou n): ");
	    			ctz = inp.next();
	    		}while(!ctz.equals("s")&&!ctz.equals("n"));
	    		if(ctz.equals("s")) {
	    			clienteDAO.apagar(id);
	    		}else {
	    			System.out.println("Opera��o cancelada");
	    		}
	            break;
	        case 5:
	        	  TypedQuery<Cliente> query =
	        			  unGerenciadora.createNamedQuery("Cliente.findAll", Cliente.class);
	        	  List<Cliente> results = query.getResultList();
	        	  for (Cliente clienterRes : results) {
	        		  System.out.println(clienterRes.toString());
	        	  }
	        	break;
	        default:
	            return;

	        }
	    }
	}
	private static Cliente updateCliente(Cliente cliente) {
		Scanner inp = new Scanner(System.in);
		int op;
		while (true) {
	        System.out.println(
	                "Escolha o que vai alterar:\n"
	                + "1 Nome\n"
	                + "2 Endere�o \n"
	                + "3 Telefone \n"
	                + "Voltar: qualquer outro n�mero");

	        op = inp.nextInt();
	        
	        switch (op) {
	        case 1:
	        	System.out.println("Insira o novo nome:");
	        	cliente.setNome(inp.next());
	        	return cliente;
	        case 2:
	        	System.out.println("Insira o novo endere�o:");
	        	cliente.setEndereco(inp.next());
	        	return cliente;
	        case 3:
	        	System.out.println("Insira o novo telefone:");
	        	cliente.setTelefone(inp.next());
	        	return cliente;
	        default:
	        	return cliente;
	        }
	    }
		
	}
	public static void menuCarro() throws Exception {
		ClienteDAO clienteDAO = new ClienteDAO();
		ModeloDAO modeloDAO = new ModeloDAO();
		CarroDAO carroDAO = new CarroDAO();
		Scanner inp = new Scanner(System.in);
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		int op;
		while (true) {

	        System.out.println(
	        		  "---------------------------------------------\n"
	    	        + "| Escolha sua op��o:                        |\n" 
	                + "| 1 Incluir Carro                           |"+"    ____\r\n" 
	                + "| 2 Consultar Carro                         |"+" __/  |_\\_\r\n"
	                + "| 3 Atualizar Carro                         |"+"|  _     _``-.\r\n"
	                + "| 4 Excluir Carro                           |"+"\'-(_)---(_)--\'\n" 
	                + "| 5 Listar Carros                           |\n" 
	                + "| Voltar para o menu: qualquer outro n�mero |\n" 
	                + "---------------------------------------------\n"
	                );

	        op = inp.nextInt();
	        
	        switch (op) {
	        case 1:
	        	Carro c = new Carro();
	        	
	    		c = carroDAO.salvar(novoCarro());	    		
	            break;
	        case 2:
	        	System.out.println("Insira o id:");
	        	Carro car = carroDAO.consultarPorId(inp.nextInt());
	    		
	    		System.out.println(car.toString());
	    		
	    		System.out.println(car.getListaManutencao().toString());
	    		break;
	        case 3:
	        	System.out.println("Insira o id:");
	        	Carro carro1 = unGerenciadora.find(Carro.class, inp.nextInt());
	        	unGerenciadora.getTransaction().begin();
	        	carro1=updateCarro(carro1);
	        	System.out.println("Carro Atualizado");
	        	unGerenciadora.getTransaction().commit();
	        	break;
	        case 4:
	        	System.out.println("Insira o id:");
	        	int id=inp.nextInt();
	    		String ctz="n";
	    		do {
	    			System.out.println("Tem certeza que deseja excluir o Carro de id="+id+"? (s ou n): ");
	    			ctz = inp.next();
	    		}while(!ctz.equals("s")&&!ctz.equals("n"));
	    		if(ctz.equals("s")) {
	    			carroDAO.apagar(inp.nextInt());
	    		}else {
	    			System.out.println("Opera��o cancelada");
	    		}
	    		break;
	        case 5:
	        	  
	        	  TypedQuery<Carro> query =
	        			  unGerenciadora.createNamedQuery("Carro.findAll", Carro.class);
	        	  List<Carro> results = query.getResultList();
	        	  for (Carro carroRes : results) {
	        		  System.out.println(carroRes.toString());
	        	  }
	        	break;
	        default:
	            return;

	        }
	    }
	}
	public static void menuManutencao() throws Exception {
		ClienteDAO clienteDAO = new ClienteDAO();
		ModeloDAO modeloDAO = new ModeloDAO();
		ManutencaoDAO manutencaoDAO = new ManutencaoDAO();
		CarroDAO carroDAO = new CarroDAO();
		Scanner inp = new Scanner(System.in);
		EntityManager unGerenciadora = JPAutil.getEntityManager();
		int op;
		while (true) {

	        System.out.println(
	        		  "---------------------------------------------\n"
	    	        + "| Escolha sua op��o:                        |\n" 
	                + "| 1 Incluir Manuten��o                      |\n"
	                + "| 2 Consultar Manuten��o                    |\n"
	                + "| 3 Atualizar Manuten��o                    |\n"
	                + "| 4 Excluir Manuten��o                      |\n"
	                + "| 5 Listar Manuten��o                       |\n" 
	                + "| Voltar para o menu: qualquer outro n�mero |\n" 
	                + "---------------------------------------------\n"
	                );

	        op = inp.nextInt();
	        
	        switch (op) {
	        case 1:
	        	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	        	Manutencao m = new Manutencao();
	        	System.out.println("Digite a data de entrada: ");
	        	Date data = formato.parse(inp.next());
	    		m.setDataEntrada(data);
	    		System.out.println("Digite a data de sa�da: ");
	    		data = formato.parse(inp.next());
	    		m.setDataRetirada(data);
	    		System.out.println("Insira o id do carro (0 para novo):");
	    		int num = inp.nextInt(); 
 	    		if(num!=0) {
	    			m.setCarro(carroDAO.consultarPorId(num));
	    		}else {
	    			m.setCarro(novoCarro());
	    			carroDAO.salvar(m.getCarro());
	    		}
	    		
	    		System.out.println("Insira o pre�o:");
	    		m.setPreco(inp.nextFloat());
	    		
				m = manutencaoDAO.salvar(m);	    		
	            break;
	        case 2:
	        	System.out.println("Insira o id:");
	    		Manutencao man = manutencaoDAO.consultarPorId(inp.nextInt());
	    		
	    		System.out.println(man.toString());

	    		break;
	        case 3:
	        	System.out.println("Insira o id:");
	        	Manutencao man1 = unGerenciadora.find(Manutencao.class, inp.nextInt());
	        	unGerenciadora.getTransaction().begin();

	        	System.out.println("Manuten��o Atualizada");
	        	unGerenciadora.getTransaction().commit();
	        	break;
	        case 4:
	        	System.out.println("Insira o id:");
	        	int id=inp.nextInt();
	    		String ctz="n";
	    		do {
	    			System.out.println("Tem certeza que deseja excluir a Manuten��o de id="+id+"? (s ou n): ");
	    			ctz = inp.next();
	    		}while(!ctz.equals("s")&&!ctz.equals("n"));
	    		if(ctz.equals("s")) {
	    			manutencaoDAO.apagar(inp.nextInt());
	    		}else {
	    			System.out.println("Opera��o cancelada");
	    		}
	    		break;
	        case 5:
	        	  TypedQuery<Manutencao> query =
	        			  unGerenciadora.createNamedQuery("Manutencao.findAll", Manutencao.class);
	        	  List<Manutencao> results = query.getResultList();
	        	  for (Manutencao manRes : results) {
	        		  System.out.println(manRes.toString());
	        	  }
	        	break;
	        default:
	            return;

	        }
	    }
	}
	private static Carro updateCarro(Carro carro) {
		Scanner inp = new Scanner(System.in);		
	    System.out.println("Insira o novo KM (somente numeros):");
	    carro.setKm(inp.nextInt());
	    return carro;
		
	}
	public static Cliente novoCliente() {
		Scanner inp = new Scanner(System.in);
		Cliente cliente = new Cliente();
    	System.out.println("Insira o nome:");
		cliente.setNome(inp.next());
		System.out.println("Insira o Telefone:");
		cliente.setTelefone(inp.next());
		System.out.println("Insira o Endereco:");
		cliente.setEndereco(inp.next());
		System.out.println("Insira o CPF:");
		cliente.setCpf(inp.next());
		return cliente;
	}
    public static Modelo novoModelo() {
		Scanner inp = new Scanner(System.in);
    	Modelo m = new Modelo();
    	System.out.println("\nNovo Modelo\nInsira o ano:");
		m.setAno(inp.nextInt());
		System.out.println("Insira o numero de passageiros:");
		m.setNumpassageiro(inp.nextInt());
		System.out.println("Insira o nome do modelo:");
		m.setNome(inp.next());
		return m;
    	
    }
    public static Carro novoCarro() throws Exception {
    	Scanner inp = new Scanner(System.in);
    	Modelo m = new Modelo();
    	ModeloDAO modeloDAO = new ModeloDAO();
    	ClienteDAO clienteDAO = new ClienteDAO();
    	Carro c = new Carro();
    	System.out.println("Digite o tipo do carro");
		c.setTipo(inp.next());
		System.out.println("Digite o tipo de combust�vel");
		c.setCombustivel(inp.next());
		System.out.println("Digite o km percorrido do carro");
		c.setKm(inp.nextInt());
		System.out.println("Digite a marca do carro");
		c.setMarca(inp.next());
		System.out.println("Insira o id do modelo (0 para novo):");
		int num = inp.nextInt(); 
 		if(num!=0) {
			c.setModelo(modeloDAO.consultarPorId(num));
		}else {
			c.setModelo(novoModelo());
			modeloDAO.salvar(c.getModelo());
		}
		
		System.out.println("Insira o id do cliente:");
		Cliente cli=clienteDAO.consultarPorId(inp.nextInt());
		c.setCliente(cli);
		System.out.println("Digite a placa do carro");
		c.setPlaca(inp.next());
		List<Carro> carros = new ArrayList<Carro>();
		carros.add(c);
		m.setCarros(carros);
		cli.setCarros(carros);
		return c;
		
    }

}
