package seguradora;

import java.io.Serializable;

public class Sinistro implements Serializable{
	private String data;
	private float Percentual;
	private Cliente cliente;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public float getPercentual() {
		return Percentual;
	}
	public void setPercentual(float percentual) {
		Percentual = percentual;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Sinistro \n Data: ");
		sb.append(data);
		sb.append("\n Percentual: ");
		sb.append(Percentual);
		sb.append("\n Cliente: ");
		sb.append(cliente);
		sb.append("\n");
		return sb.toString();
	}
	
	
	
}
