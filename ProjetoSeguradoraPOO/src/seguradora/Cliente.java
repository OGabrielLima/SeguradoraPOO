package seguradora;

import java.io.Serializable;

public class Cliente implements Serializable{

	private String nome;
	private String tipoCliente;
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" Nome: ");
		sb.append(nome);
		sb.append("\n Tipo do Cliente: ");
		sb.append(tipoCliente);
		sb.append("\n CPF/CNPJ:");
		sb.append(cpf);
		sb.append("\n");
		return sb.toString();
	}
	
	
	
	
	
	
	
	
}
