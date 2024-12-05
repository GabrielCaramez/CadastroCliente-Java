package br.com.cadastro;

import java.util.ArrayList;

public class Agendamento {
    private String clienteNome;
    private String dataVistoria;
    private String horaVistoria;
    private String status;
    private String placaVeiculo;
    private String marcaVeiculo;
    private String modeloVeiculo;
    private int anoVeiculo;
    private String chassiVeiculo;
    private int kmVeiculo;
    private ArrayList<ChecklistItem> checklist;

    // Construtor
    public Agendamento(String clienteNome, String dataVistoria, String horaVistoria, String status, String placaVeiculo, 
                       String marcaVeiculo, String modeloVeiculo, int anoVeiculo, String chassiVeiculo, int kmVeiculo) {
        this.clienteNome = clienteNome;
        this.dataVistoria = dataVistoria;
        this.horaVistoria = horaVistoria;
        this.status = status;
        this.placaVeiculo = placaVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.chassiVeiculo = chassiVeiculo;
        this.kmVeiculo = kmVeiculo;
        this.checklist = new ArrayList<>();
    }

    // Getters e Setters
    public String getClienteNome() { return clienteNome; }
    public void setClienteNome(String clienteNome) { this.clienteNome = clienteNome; }

    public String getDataVistoria() { return dataVistoria; }
    public void setDataVistoria(String dataVistoria) { this.dataVistoria = dataVistoria; }

    public String getHoraVistoria() { return horaVistoria; }
    public void setHoraVistoria(String horaVistoria) { this.horaVistoria = horaVistoria; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPlacaVeiculo() { return placaVeiculo; }
    public void setPlacaVeiculo(String placaVeiculo) { this.placaVeiculo = placaVeiculo; }

    public String getMarcaVeiculo() { return marcaVeiculo; }
    public void setMarcaVeiculo(String marcaVeiculo) { this.marcaVeiculo = marcaVeiculo; }

    public String getModeloVeiculo() { return modeloVeiculo; }
    public void setModeloVeiculo(String modeloVeiculo) { this.modeloVeiculo = modeloVeiculo; }

    public int getAnoVeiculo() { return anoVeiculo; }
    public void setAnoVeiculo(int anoVeiculo) { this.anoVeiculo = anoVeiculo; }

    public String getChassiVeiculo() { return chassiVeiculo; }
    public void setChassiVeiculo(String chassiVeiculo) { this.chassiVeiculo = chassiVeiculo; }

    public int getKmVeiculo() { return kmVeiculo; }
    public void setKmVeiculo(int kmVeiculo) { this.kmVeiculo = kmVeiculo; }

    public ArrayList<ChecklistItem> getChecklist() { return checklist; }
    public void adicionarChecklistItem(ChecklistItem item) { this.checklist.add(item); }

    // toString
    @Override
    public String toString() {
        return "Agendamento{" +
                "clienteNome='" + clienteNome + '\'' +
                ", dataVistoria='" + dataVistoria + '\'' +
                ", horaVistoria='" + horaVistoria + '\'' +
                ", status='" + status + '\'' +
                ", placaVeiculo='" + placaVeiculo + '\'' +
                ", marcaVeiculo='" + marcaVeiculo + '\'' +
                ", modeloVeiculo='" + modeloVeiculo + '\'' +
                ", anoVeiculo=" + anoVeiculo +
                ", chassiVeiculo='" + chassiVeiculo + '\'' +
                ", kmVeiculo=" + kmVeiculo +
                ", checklist=" + checklist +
                '}';
    }
}

