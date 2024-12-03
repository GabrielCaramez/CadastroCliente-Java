package br.com.cadastro;

public class Agendamento {
	private String clienteNome;
	private String dataVistoria;
	private String horaVistoria;
	private String status;
	
	public Agendamento(String clienteNome, String dataVistoria, String horaVistoria, String status) {
		this.clienteNome = clienteNome;
		this.dataVistoria = dataVistoria;
		this.horaVistoria = horaVistoria;
		this.status = status;
	}
	
	public String getClienteNome() { return clienteNome; }
	public void setClienteNome(String clienteNome) {this.clienteNome = clienteNome;}
	
	public String getDataVistoria() { return dataVistoria; }
	public void setDataVistoria(String dataVistoria) { this.dataVistoria = dataVistoria; }
	
	public String getHoraVistoria() { return horaVistoria; }
	public void setHoraVistoria(String horaVistoria) {this.horaVistoria = horaVistoria;}
	
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	
	@Override
	public String toString() {
		return "Agendamento[clienteNome=" + clienteNome + ",dataVistoria="+ dataVistoria + ",horaVistoria=" + horaVistoria + ",Status" + status +"]";}

}
