package br.com.cadastro;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String email;
	private String telefone;
	private ArrayList<Veiculo> veiculos;
	
	public Cliente(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.veiculos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public ArrayList<Veiculo> getVeiculos(){
		return veiculos;
	}
	public void adicionarVeiculo(Veiculo veiculo) {
		this.veiculos.add(veiculo);
	}
	
	@Override
	public String toString() {
	    return "Cliente[nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", veiculos=" + veiculos +"]";
	}


}
