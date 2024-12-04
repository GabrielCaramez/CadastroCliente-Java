package br.com.cadastro;

import java.util.ArrayList;

public class ChecklistItem {
	private String descricao;
	private boolean concluido;
	private ArrayList <Veiculo> Veiculo = new ArrayList<>();
	private ArrayList <Cliente> Cliente = new ArrayList<>();
	
	public ChecklistItem(String descricao) {
		this.descricao = descricao;
		this.concluido = false;
	}
	
	public String getDescricao() { return descricao; }
	public void setDescricao(String descricao) { this.descricao = descricao; }
	
	public boolean isConcluido() { return concluido; }
	public void setConcluido(boolean concluido) { this.concluido = concluido;}
	
	public ArrayList<br.com.cadastro.Veiculo> getVeiculo() { return Veiculo; }
	public void setVeiculo(ArrayList<br.com.cadastro.Veiculo> Veiculo) { this.Veiculo = Veiculo; }
	
	public ArrayList<br.com.cadastro.Cliente> getCliente() { return Cliente; }
	public void setCliente(ArrayList<br.com.cadastro.Cliente> Cliente) { this.Cliente = Cliente; }

	@Override
	public String toString() {
		return "ChecklistItem[descricao=" + descricao + ",concluido=" + concluido + ", Veiculo" + Veiculo + ", Cliente" + Cliente + "]";
	}

}
