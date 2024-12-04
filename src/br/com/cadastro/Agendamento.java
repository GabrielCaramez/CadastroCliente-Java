package br.com.cadastro;

import java.util.ArrayList;

public class Agendamento {
	private String clienteNome;
	private String dataVistoria;
	private String horaVistoria;
	private String status;
	private String placaVeiculo;
	private ArrayList<ChecklistItem> checklist = new ArrayList<>();
	
	public Agendamento(String clienteNome, String dataVistoria, String horaVistoria, String status, String placaVeiculo) {
		this.clienteNome = clienteNome;
		this.dataVistoria = dataVistoria;
		this.horaVistoria = horaVistoria;
		this.status = status;
		this.placaVeiculo = placaVeiculo;
		this.checklist =  new ArrayList<>();
	}
	
	public String getClienteNome() { return clienteNome; }
	public void setClienteNome(String clienteNome) {this.clienteNome = clienteNome;}
	
	public String getDataVistoria() { return dataVistoria; }
	public void setDataVistoria(String dataVistoria) { this.dataVistoria = dataVistoria; }
	
	public String getHoraVistoria() { return horaVistoria; }
	public void setHoraVistoria(String horaVistoria) {this.horaVistoria = horaVistoria;}
	
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	
	public String getPlacaVeiculo() { return placaVeiculo; }
	public void setPlacaVeiculo(String placaVeiculo) { this.placaVeiculo = placaVeiculo;}
	
	public ArrayList<ChecklistItem> getChecklist() { return checklist; }
	public void adicionarChecklistItem(ChecklistItem item) { this.checklist.add(item); }
	
	@Override
	public String toString() {
		return "Agendamento[clienteNome=" + clienteNome + ",dataVistoria="+ dataVistoria + ",horaVistoria=" + horaVistoria + ",Status" + status + ",placaVeiculo=" + placaVeiculo + "checklist" + checklist +"]";}

}
