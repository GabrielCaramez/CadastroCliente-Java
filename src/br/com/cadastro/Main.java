package br.com.cadastro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Remover Cliente");
            System.out.println("4. Adicionar veículo a cliente");
            System.out.println("5. Agendar Vistoria");
            System.out.println("6. Listar Agendamentos de Cliente");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o "enter" após o nextInt

            switch (opcao) {
                case 1:
                    adicionarCliente(scanner);
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    removerCliente(scanner);
                    break;
                case 4:
                    adicionarVeiculoACliente(scanner);
                    break;
                case 5:
                	agendarVistoria(scanner);
                	break;
                case 6:
                	listarAgendamentosDeCLiente(scanner);
                	break;
                case 7:
                	System.out.println("Saindo...");
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("\n=== Lista de Clientes ===");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    private static void adicionarCliente(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email, telefone);
        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void removerCliente(Scanner scanner) {
        System.out.print("Digite o nome do cliente a ser removido: ");
        String nome = scanner.nextLine();

        Cliente clienteARemover = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                clienteARemover = cliente;
                break;
            }
        }
        if (clienteARemover != null) {
            clientes.remove(clienteARemover);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
    
    private static void adicionarVeiculoACliente(Scanner scanner) {
    	System.out.print("Digite o nome do cliente: ");
    	String nomeCliente = scanner.nextLine();
    	
    	Cliente cliente = null;
    	for (Cliente c : clientes) {
    		if(c.getNome().equalsIgnoreCase(nomeCliente)) {
    			cliente = c;
    			break;
    		}
    	}
    	
    	if (cliente != null) {
    		System.out.print("Marca do veículo: ");
    		String marca = scanner.nextLine();
    		System.out.print("Modelo do veículo: ");
    		String modelo = scanner.nextLine();
    		System.out.print("Placa do veículo: ");
    		String placa = scanner.nextLine();
    		
    		Veiculo veiculo = new Veiculo(marca, modelo, placa);
    		cliente.adicionarVeiculo(veiculo);
    		System.out.println("Veículo adicionado com sucesso!");
    		
    	}else {
    		System.out.println("Cliente não encontrado. ");
    	}
    }
    
    private static void agendarVistoria(Scanner scanner) {
    	System.out.print("Digite o nome do cliente: ");
    	String nomeCliente = scanner.nextLine();
    	
    	Cliente cliente = null;
    	for (Cliente c : clientes) {
    		if (c.getNome().equalsIgnoreCase(nomeCliente)) {
    			cliente = c;
    			break;
    		}
    	}
    	
    	if (cliente != null) {
    		System.out.print("Data da vistoria(YYYY-MM-DD: ");
    		String data = scanner.nextLine();
    		System.out.print("Hora da vistoria (HH:MM): ");
    		String hora = scanner.nextLine();
    		System.out.print("Status da vistoria: ");
    		String status = scanner.nextLine();
    		
    		Agendamento agendamento = new Agendamento(nomeCliente, data, hora, status);
    		cliente.adicionarAgendamento(agendamento);
    		System.out.println("Vistoria agendada com sucesso!");
    	}else {
    		System.out.println("Cliente não encontrado. ");
    	}
    }
    
    private static void listarAgendamentosDeCLiente(Scanner scanner) {
    	System.out.print("Digite o nome do cliente: ");
    	String nomeCliente = scanner.nextLine();
    	
    	Cliente cliente = null;
    	for (Cliente c : clientes) {
    		if (c.getNome().equalsIgnoreCase(nomeCliente)) {
    			cliente = c;
    			break;
    		}
    	}
    	
    	if (cliente != null) {
    		ArrayList<Agendamento> agendamentos = cliente.getAgendamentos();
    		if (agendamentos.isEmpty()) {
    			System.out.println("Nenhum agendamento encontrado para este cliente. ");
    		}else {
    			for(Agendamento agendamento : agendamentos) {
    				System.out.println(agendamento);
    			}
    		}
    	}else {
    		System.out.println("Cliente não encontrado.");
    	}
    }
}
