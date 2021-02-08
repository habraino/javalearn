import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Main {
	private static final String ADCLIENTE = "AC";
	private static final String CREDCLIENTE = "CC";
	private static final String CRILEILAO = "CL";
	private static final String ADARTIGO = "AA";
	private static final String ABLEILAO = "AL";
	private static final String TERMILEILAO = "TL";
	private static final String FALICITACAO = "FL";
	private static final String INFLEILAO = "IL";
	private static final String LISTCLIENTE = "LC";
	private static final String SAIR = "S";

	private static Cliente cliente;
	private static Leilao leilao;
	private static List<Cliente> clientes;
	private static List<Leilao> leilaos;
	private static List<Leilao> artigos;

	// método para verificar se o usuário já existe
	private static boolean verificaNome(List<String> nomes, String nome) {
		for (String n : nomes) {
			if (n.contains(nome)) {
				return  true;
			} 
		}
		return false;
	}

	// método para procurar cliente
	private static Cliente procuraCliente(String nome, List<Cliente> clientes) {
		for (Cliente cliente : clientes)  {
			if (cliente.getNome().toString().equalsIgnoreCase(nome)) {
				return cliente;
			} 
		}
		return null;
	}

	private static void CredCliente(String nome, double valor, List<Cliente> clientes) {
		Cliente cliente = procuraCliente(nome, clientes);
		if (cliente != null) { 
			cliente.addSaldo(valor);
		} 
	}

	// método para mostrar menu de opções
	public static void menu() {
		System.out.println("*************************************************");
		System.out.println(ADCLIENTE + " - Para Adicionar Cliente");
		System.out.println(CREDCLIENTE + " - Para ver credito do cliente");
		System.out.println(CRILEILAO + " - Para Criar Leilão");
		System.out.println(ADARTIGO + "  - Para Adicionar Artigo");
		System.out.println(ABLEILAO + "  - Para Abrir Leilão");
		System.out.println(TERMILEILAO +" - Para Terminar Leilão");
		System.out.println(FALICITACAO +" - Para Fazer Licitação");
		System.out.println(INFLEILAO + " - Para ver Informação do Leilão");
		System.out.println(LISTCLIENTE +" - Para Listar Clientes");
		System.out.println(SAIR + " - Para Sair");
		System.out.println("*************************************************");
	}

	// método para listar todos os clientes
	private static void listarClientes(List<Cliente> list) {
        System.out.println("***********************");
        for(Cliente c : list){
            System.out.println("**********************");
            System.out.printf("Nome: %s\nSaldo: %.2f\n", c.getNome(), c.getSaldo());
            System.out.println("***********************");
        }
	}
	
	// método para ver informação de leilão
	public static void infoLeilao(List<Leilao> list) {
		System.out.println("***********************");
        for(Leilao l : list){
            System.out.println("**********************");
            System.out.printf("Nome: %s\nEstado: %s\n", l.getNomeLeilao(), l.getEstadoLeilao());
            System.out.println("***********************");
        }
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		clientes = new ArrayList<>();
		artigos = new ArrayList<>();

		// cria um nova lista para armazenar nomes dos clientes
		List<String> nomes = new ArrayList<>();

		// cria uma lista de nomes de leilao
		List<String> nomesleilao = new ArrayList<>();

		boolean sair = true; // controle principal da execução do programa

		// enquanto for verdadeiro
		while (sair) {
			menu(); // chama método menu
	
			System.out.print("Insira o comando: ");
			String user = scan.next();

			boolean s = true;

			if (user.toUpperCase().equalsIgnoreCase(ADCLIENTE)) {
				while (s) {
					cliente = new Cliente(); // cria nova instância do Cliente
	
					System.out.println("****************************************");
					System.out.println("\t\tADCIONAR CLIENTE");
					System.out.println("****************************************");
					
					String nome = null;
					double saldo = 0.0;
	
					// FAZ VERIFICAÇÃO DOS NOMES REPETIDOS
					if (nomes.size() == 0){ // caso não exista nenhum nome
						System.out.println(nomes.size());
						System.out.print("Informe seu nome: ");
						nome = scan.next().toUpperCase();
						// adiciona o nome do cliente no vector
						nomes.add(nome);
					} else { // caso já exista algum nome
						System.out.print("Informe seu nome: ");
						nome = scan.next().toUpperCase();
	
						while (true){
							if (verificaNome(nomes, nome)){
								System.out.println("[-] \033[1;31mO cliente informado já existe!!\033[m");
								System.out.print("Favor informe outro nome: ");
								nome = scan.next().toUpperCase();
							} else {
								break;
							}
						}
						nomes.add(nome);
					}
	
					System.out.print("Informe seu saldo: ");
					saldo = scan.nextDouble();
	
					// valida cadastro do novo cliente
					if (cliente.AdCliente(nome, saldo)) {
						System.out.println("****************************************");
						System.out.println("[+] \033[1;32mCliente adicionado com sucesso!\033[m");
						clientes.add(cliente); // adiciona novo cliente
					} else {
						System.out.println("[-] \033[1;31mErro ao adicionar Cliente!\033[m");
					}
					System.out.print("Desejas continuar? [s/n]: ");
					String op = scan.next().toLowerCase();

					if (op.equalsIgnoreCase("n")) {
						s = false;
					}
				}
				
			} else if (user.toUpperCase().equalsIgnoreCase(SAIR)) {
				sair = false;
				break;
			} else if (user.toUpperCase().equalsIgnoreCase(LISTCLIENTE)) {
				listarClientes(clientes);
			} else if (user.toUpperCase().equalsIgnoreCase(CREDCLIENTE)) {
				String n = null;
				double v = 0.0;

				System.out.print("Informe o nome do cliente: ");
				n = scan.next();

				if (procuraCliente(n, clientes) != null) {
					System.out.println("*************************************************");
					System.out.println("[+]\033[1;32mOk!\033[m");
					System.out.println("*************************************************");
					System.out.print("Informe o credito do cliente: ");
					v = scan.nextDouble();

					CredCliente(n, v, clientes);
				} else {
					System.out.println("*************************************************");
					System.out.println("[+]\033[1;31mCustomer NomeDoCliente not registered\033[m");
					System.out.println("*************************************************");
				}

			} else if (user.toUpperCase().equalsIgnoreCase(TERMILEILAO)) {
				sair = false;
				break;
			} else if (user.toUpperCase().equalsIgnoreCase(CRILEILAO)) {
				leilaos = new ArrayList<>();
				if (nomesleilao.size() == 0){
					System.out.print("Qual o nome da leilão? ");
					String nomeLeilao = scan.next().toUpperCase();
					nomesleilao.add(nomeLeilao);
					System.out.println("*************************************************");
					System.out.println("[+]\033[1;32mOk!\033[m");
					System.out.println("*************************************************");
				} else {
					System.out.print("Qual o nome da leilão? ");
					String nomeLeilao = scan.next().toUpperCase();

					if (verificaNome(nomesleilao, nomeLeilao) == false) {
						nomesleilao.add(nomeLeilao);
						System.out.println("*************************************************");
						System.out.println("[+]\033[1;32mOk!\033[m");
						System.out.println("*************************************************");
					} else {
						System.out.println("*************************************************");
						System.out.println("[+]\033[1;31mLeilão"+ nomeLeilao +" já existe!!\033[m");
						System.out.println("*************************************************");
					}
					if (leilao.criarLeilao(nomeLeilao)) {
						leilaos.add(leilao);
					}
				} 
			} else if (user.toUpperCase().equalsIgnoreCase(ADARTIGO)) {
				while (s) {
					leilao = new Leilao();

					String nLeilao = null;
					String nArtigo = null;
					String nVendedor = null;
					double pArtigo = 0.0;

					System.out.println("****************************************");
					System.out.println("\tADCIONAR NOVO ARTIGO");
					System.out.println("****************************************");
					
					System.out.print("Informe o nome da leilão: ");
					nLeilao = scan.next().toUpperCase();

					if (verificaNome(nomesleilao, nLeilao)) {
						System.out.print("Informe o nome do artigo: ");
						nArtigo = scan.next();
						System.out.print("Informe o nome do vendedor: ");
						nVendedor = scan.next();
						System.out.print("Informe o preço do artigo: ");
						pArtigo = scan.nextDouble();
						
						if (leilao.AdArtigo(nLeilao, nArtigo, nVendedor, pArtigo)) {
							artigos.add(leilao);
							System.out.println("*************************************************");
							System.out.println("[+]\033[1;32mOk!\033[m");
							System.out.println("*************************************************");
						}
						System.out.print("Desejas continuar? [s/n]: ");
						String op = scan.next().toLowerCase();
	
						if (op.equalsIgnoreCase("n")) {
							s = false;
						}
					} else {
						break;
					}
				}
			} else if (user.toUpperCase().equalsIgnoreCase(ABLEILAO)) {
				System.out.print("Informe o nome do leilão: ");
				String nLeilao = scan.next().toUpperCase();
 
				if (verificaNome(nomesleilao, nLeilao)) {
					System.out.println("*************************************************");
					System.out.println("[+]\033[1;32mOk!\033[m");
					System.out.println("*************************************************");
				} else {
					System.out.println("*************************************************");
					System.out.println("[+]\033[1;31mLeilão "+ nLeilao +" não pode ser aberto!!\033[m");
					System.out.println("*************************************************");
				}
			} else if (user.toUpperCase().equalsIgnoreCase(INFLEILAO)) {
				infoLeilao(leilaos);
			}
		}
		
		scan.close();
	}
}
