package testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dao.CarroDAO;
import dao.ClienteDAO;
import dao.ModeloDAO;
import negocio.Carro;
import negocio.Cliente;
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
	                + "| Escolha sua opção:          |\n"
	                + "| 1 Gerenciar Clientes        |\n"
	                + "| 2 Gerenciar Carros          |\n"
	                + "| 3 Gerenciar Manutenções     |\n"
	                + "| Sair: qualquer outro número |\n"
	                + "-------------------------------\n");

	        op = inp.nextInt();

	        switch (op) {
	        	case 1:
	        		menuCliente();
	        		
	        		break;
	        	case 2:
		        	menuCarro();
		        	
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
	    	        + "| Escolha sua opção:                        |"+"   //_\\\\_\r\n"  
	                + "| 1 Incluir Clientes                        |"+" .\"\\\\    \".\r\n"  
	                + "| 2 Consultar Cliente                       |"+"/          \\\r\n"  
	                + "| 3 Atualizar Cliente                       |"+"|           \\_\r\n" 
	                + "| 4 Excluir Cliente                         |"+"|       ,--.-.)\r\n" 
	                + "| 5 Listar Clientes                         |"+" \\     /  o \\o\\\r\n"  
	                + "| Voltar para o menu: qualquer outro número |"+" /\\/\\  \\    /_/\r\n"  
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
	    			System.out.println("Operação cancelada");
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
	                + "2 Endereço \n"
	                + "3 Telefone \n"
	                + "Voltar: qualquer outro número");

	        op = inp.nextInt();
	        
	        switch (op) {
	        case 1:
	        	System.out.println("Insira o novo nome:");
	        	cliente.setNome(inp.next());
	        	return cliente;
	        case 2:
	        	System.out.println("Insira o novo endereço:");
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
	    	        + "| Escolha sua opção:                        |\n" 
	                + "| 1 Incluir Carro                           |"+"    ____\r\n" 
	                + "| 2 Consultar Carro                         |"+" __/  |_\\_\r\n"
	                + "| 3 Atualizar Carro                         |"+"|  _     _``-.\r\n"
	                + "| 4 Excluir Carro                           |"+"\'-(_)---(_)--\'\n" 
	                + "| 5 Listar Carros                           |\n" 
	                + "| Voltar para o menu: qualquer outro número |\n" 
	                + "---------------------------------------------\n"
	                );

	        op = inp.nextInt();
	        
	        switch (op) {
	        case 1:
	        	Modelo m = new Modelo();
	        	Carro c = new Carro();
	        	System.out.println("Digite o tipo do carro");
	    		c.setTipo(inp.next());
	    		System.out.println("Digite o tipo de combustível");
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
	    		c = carroDAO.salvar(c);	    		
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
	    			System.out.println("Operação cancelada");
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

}
