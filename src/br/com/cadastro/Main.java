    package br.com.cadastro;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.util.ArrayList;

    public class Main {
        private static ArrayList<Cliente> clientes = new ArrayList<>();

        public static void main(String[] args) {
            SwingUtilities.invokeLater(Main::createAndShowGUI);
        }

        private static void createAndShowGUI() {
            JFrame frame = new JFrame("Sistema de Cadastro");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(9, 1));

            JButton btnAdicionarCliente = new JButton("Adicionar Cliente");
            JButton btnListarClientes = new JButton("Listar Clientes");
            JButton btnRemoverCliente = new JButton("Remover Cliente");
            JButton btnAdicionarVeiculo = new JButton("Adicionar Veículo a Cliente");
            JButton btnAgendarVistoria = new JButton("Agendar Vistoria");
            JButton btnListarAgendamentos = new JButton("Listar Agendamentos de Cliente");
            JButton btnAdicionarItemChecklist = new JButton("Adicionar Item ao Checklist");
            JButton btnMostrarChecklist = new JButton("Mostrar Checklist");
            JButton btnSair = new JButton("Sair");

            panel.add(btnAdicionarCliente);
            panel.add(btnListarClientes);
            panel.add(btnRemoverCliente);
            panel.add(btnAdicionarVeiculo);
            panel.add(btnAgendarVistoria);
            panel.add(btnListarAgendamentos);
            panel.add(btnAdicionarItemChecklist);
            panel.add(btnMostrarChecklist);
            panel.add(btnSair);

            frame.add(panel);

            // Actions
            btnAdicionarCliente.addActionListener(e -> adicionarCliente());
            btnListarClientes.addActionListener(e -> listarClientes());
            btnRemoverCliente.addActionListener(e -> removerCliente());
            btnAdicionarVeiculo.addActionListener(e -> adicionarVeiculo());
            btnAgendarVistoria.addActionListener(e -> agendarVistoria());
            btnListarAgendamentos.addActionListener(e -> listarAgendamentos());
            btnAdicionarItemChecklist.addActionListener(e -> adicionarItemChecklist());
            btnMostrarChecklist.addActionListener(e -> mostrarChecklist());
            btnSair.addActionListener(e -> System.exit(0));

            frame.setVisible(true);
        }

        private static void adicionarCliente() {
            JTextField nomeField = new JTextField();
            JTextField emailField = new JTextField();
            JTextField telefoneField = new JTextField();

            Object[] message = {
                "Nome:", nomeField,
                "Email:", emailField,
                "Telefone:", telefoneField
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Adicionar Cliente", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String nome = nomeField.getText();
                String email = emailField.getText();
                String telefone = telefoneField.getText();

                Cliente cliente = new Cliente(nome, email, telefone);
                clientes.add(cliente);

                JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
            }
        }

        private static void listarClientes() {
            if (clientes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado.");
                return;
            }

            StringBuilder sb = new StringBuilder("=== Lista de Clientes ===\n");
            for (Cliente cliente : clientes) {
                sb.append(cliente).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }

        private static void removerCliente() {
            String nome = JOptionPane.showInputDialog("Digite o nome do cliente a ser removido:");

            if (nome == null || nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome não pode ser vazio.");
                return;
            }

            Cliente clienteARemover = null;
            for (Cliente cliente : clientes) {
                if (cliente.getNome().equalsIgnoreCase(nome)) {
                    clienteARemover = cliente;
                    break;
                }
            }

            if (clienteARemover != null) {
                clientes.remove(clienteARemover);
                JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            }
        }

        private static void adicionarVeiculo() {
            String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");

            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getNome().equalsIgnoreCase(nomeCliente)) {
                    cliente = c;
                    break;
                }
            }

            if (cliente != null) {
                JTextField marcaField = new JTextField();
                JTextField modeloField = new JTextField();
                JTextField placaField = new JTextField();

                Object[] message = {
                    "Marca do veículo:", marcaField,
                    "Modelo do veículo:", modeloField,
                    "Placa do veículo:", placaField
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Adicionar Veículo", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String marca = marcaField.getText();
                    String modelo = modeloField.getText();
                    String placa = placaField.getText();

                    Veiculo veiculo = new Veiculo(marca, modelo, placa);
                    cliente.adicionarVeiculo(veiculo);

                    JOptionPane.showMessageDialog(null, "Veículo adicionado com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            }
        }

        private static void agendarVistoria() {
            String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");

            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getNome().equalsIgnoreCase(nomeCliente)) {
                    cliente = c;
                    break;
                }
            }

            if (cliente != null) {
                JTextField dataField = new JTextField();
                JTextField horaField = new JTextField();
                JTextField statusField = new JTextField();
                JTextField placaField = new JTextField();
                JTextField marcaField = new JTextField();
                JTextField modeloField = new JTextField();
                JTextField anoField = new JTextField();
                JTextField chassiField = new JTextField();
                JTextField kmField = new JTextField();

                Object[] message = {
                    "Data (YYYY-MM-DD):", dataField,
                    "Hora (HH:MM):", horaField,
                    "Status:", statusField,
                    "Placa do veículo:", placaField,
                    "Marca do veículo:", marcaField,
                    "Modelo do veículo:", modeloField,
                    "Ano do veículo:", anoField,
                    "Chassi do veículo:", chassiField,
                    "KM do veículo:", kmField
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Agendar Vistoria", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String data = dataField.getText();
                    String hora = horaField.getText();
                    String status = statusField.getText();
                    String placa = placaField.getText();
                    String marca = marcaField.getText();
                    String modelo = modeloField.getText();
                    int ano = Integer.parseInt(anoField.getText());
                    String chassi = chassiField.getText();
                    int km = Integer.parseInt(kmField.getText());

                    Agendamento agendamento = new Agendamento(nomeCliente, data, hora, status, placa, marca, modelo, ano, chassi, km);
                    cliente.adicionarAgendamento(agendamento);

                    JOptionPane.showMessageDialog(null, "Vistoria agendada com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            }
        }

        private static void listarAgendamentos() {
            String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");

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
                    JOptionPane.showMessageDialog(null, "Nenhum agendamento encontrado para este cliente.");
                } else {
                    StringBuilder sb = new StringBuilder("=== Agendamentos ===\n");
                    for (Agendamento agendamento : agendamentos) {
                        sb.append(agendamento).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            }
        }

        private static void adicionarItemChecklist() {
            String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");

            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getNome().equalsIgnoreCase(nomeCliente)) {
                    cliente = c;
                    break;
                }
            }

            if (cliente != null) {
                String dataVistoria = JOptionPane.showInputDialog("Digite a data da vistoria (YYYY-MM-DD):");
                String horaVistoria = JOptionPane.showInputDialog("Digite a hora da vistoria (HH:MM):");
                String placaVeiculo = JOptionPane.showInputDialog("Digite a placa do veículo:");

                Agendamento agendamento = null;
                for (Agendamento a : cliente.getAgendamentos()) {
                    if (a.getDataVistoria().equals(dataVistoria) &&
                        a.getHoraVistoria().equals(horaVistoria) &&
                        a.getPlacaVeiculo().equals(placaVeiculo)) {
                        agendamento = a;
                        break;
                    }
                }

                if (agendamento != null) {
                    String descricao = JOptionPane.showInputDialog("Digite a descrição do item do checklist:");
                    ChecklistItem item = new ChecklistItem(descricao);
                    agendamento.adicionarChecklistItem(item);
                    JOptionPane.showMessageDialog(null, "Item adicionado ao checklist com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Agendamento não encontrado.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            }
        }

        private static void mostrarChecklist() {
            String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");

            Cliente cliente = null;
            for (Cliente c : clientes) {
                if (c.getNome().equalsIgnoreCase(nomeCliente)) {
                    cliente = c;
                    break;
                }
            }

            if (cliente != null) {
                String dataVistoria = JOptionPane.showInputDialog("Digite a data da vistoria (YYYY-MM-DD):");
                String horaVistoria = JOptionPane.showInputDialog("Digite a hora da vistoria (HH:MM):");
                String placaVeiculo = JOptionPane.showInputDialog("Digite a placa do veículo:");

                Agendamento agendamento = null;
                for (Agendamento a : cliente.getAgendamentos()) {
                    if (a.getDataVistoria().equals(dataVistoria) &&
                        a.getHoraVistoria().equals(horaVistoria) &&
                        a.getPlacaVeiculo().equals(placaVeiculo)) {
                        agendamento = a;
                        break;
                    }
                }

                if (agendamento != null) {
                    ArrayList<ChecklistItem> checklist = agendamento.getChecklist();
                    if (checklist.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum item no checklist para este agendamento.");
                    } else {
                        StringBuilder sb = new StringBuilder("=== Checklist ===\n");
                        for (ChecklistItem item : checklist) {
                            sb.append("- ").append(item.getDescricao()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Agendamento não encontrado.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            }
        }
    }

