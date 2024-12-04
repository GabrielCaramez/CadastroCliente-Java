package br.com.cadastro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 8) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Remover Cliente");
            System.out.println("4. Adicionar veículo a cliente");
            System.out.println("5. Agendar Vistoria");
            System.out.println("6. Listar Agendamentos de Cliente");
            System.out.println("7. Adicionar Item ao Checklist de Vistoria");
            System.out.print("8. Sair ");
            
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
                	adicionarItemChecklist(scanner);
                	break;
                case 8:
                	System.out.println("Saindo...");
                	break;
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
            if (cliente.getVeiculos().isEmpty()) {
                System.out.println("O cliente não possui veículos cadastrados. Cadastre um veículo antes de agendar a vistoria.");
                return;
            }

            System.out.println("Veículos do cliente:");
            for (Veiculo veiculo : cliente.getVeiculos()) {
                System.out.println(veiculo.getPlaca() + " - " + veiculo.getModelo());
            }

            System.out.print("Digite a placa do veículo para a vistoria: ");
            String placaVeiculo = scanner.nextLine();
            Veiculo veiculoEscolhido = null;

            for (Veiculo veiculo : cliente.getVeiculos()) {
                if (veiculo.getPlaca().equalsIgnoreCase(placaVeiculo)) {
                    veiculoEscolhido = veiculo;
                    break;
                }
            }

            if (veiculoEscolhido == null) {
                System.out.println("Veículo não encontrado para o cliente.");
                return;
            }

            System.out.print("Data da vistoria (YYYY-MM-DD): ");
            String data = scanner.nextLine();
            System.out.print("Hora da vistoria (HH:MM): ");
            String hora = scanner.nextLine();
            System.out.print("Status da vistoria: ");
            String status = scanner.nextLine();

            Agendamento agendamento = new Agendamento(nomeCliente, data, hora, status, placaVeiculo);
            cliente.adicionarAgendamento(agendamento);
            System.out.println("Vistoria agendada com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
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
    
    private static void adicionarItemChecklist(Scanner scanner) {
    	System.out.print("Digite o nome do cliente: ");
    	String nomeCliente = scanner.nextLine();
    	Cliente cliente = null;
    	for(Cliente c : clientes) {
    		if (c.getNome().equalsIgnoreCase(nomeCliente)) {
    			cliente = c;
    			break;
    		}
    	}
    	if (cliente != null) {
    		System.out.print("Digite a data da vistoria (YYYY-MM-DD): ");
    		String dataVistoria = scanner.nextLine();
    		System.out.print("Digite a hora da vistoria (HH:MM): ");
    		String horaVistoria = scanner.nextLine();
    		System.out.print("Digite a placa do veículo: ");
    		String placaVeiculo = scanner.nextLine();
    		
    	Agendamento agendamento = null;
    	for (Agendamento a : cliente.getAgendamentos()) {
    		if(a.getDataVistoria().equals(dataVistoria) && a.getHoraVistoria().equals(horaVistoria) && a.getPlacaVeiculo().equals(placaVeiculo)) {
    			agendamento = a;
    			break;
    		}
    	}
    	if (agendamento != null) {
    		System.out.print("Digite a descrição do item do checklist: ");
    		String descricao = scanner.nextLine();
    		ChecklistItem item = new ChecklistItem(descricao);
    		agendamento.adicionarChecklistItem(item);
    		System.out.println("Item adicionado ao checklist com sucesso!");
    	}else {
    		System.out.println("Agendamento não encontrado. ");
    	}
    	}else {
    		System.out.println("Cliente não encontrado.");
    	}
    }
}
