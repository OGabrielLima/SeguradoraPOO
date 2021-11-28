package seguradora;

import java.io.Serializable;

public class Contratos implements Serializable{
	
	private Cliente cliente;
	private String endereco;
	private float valorImovel;
	private String zona;
	private String tipo;
	private int numFuncionarios;
	private int numVisitasDiarias;
	private float valorContrato;
	//Se comércio / Industria / Agropercuária
	private String ramoAtividade;
		
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public float getValorImovel() {
		return valorImovel;
	}
	public void setValorImovel(float valorImovel) {
		this.valorImovel = valorImovel;
	}
	public float getValorContrato() {
		return valorContrato;
	}
	public void setValorContrato(float valorContrato) {
		this.valorContrato = valorContrato;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getNumFuncionarios() {
		return numFuncionarios;
	}
	public void setNumFuncionarios(int numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}
	public int getNumVisitasDiarias() {
		return numVisitasDiarias;
	}
	public void setNumVisitasDiarias(int numVisitasDiarias) {
		this.numVisitasDiarias = numVisitasDiarias;
	}
	public String getRamoAtividade() {
		return ramoAtividade;
	}
	public void setRamoAtividade(String ramoAtividade) {
		ramoAtividade = ramoAtividade;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Cliente: \n");
		sb.append(cliente);
		sb.append("\n Endereco: ");
		sb.append(endereco);
		sb.append("\n Valor do Imovel: ");
		sb.append(valorImovel);
		sb.append("\n Valor do contrato: ");
		sb.append(valorContrato);
		sb.append("\n Zona: ");
		sb.append(zona);
		sb.append("\n Tipo: ");
		sb.append(tipo);
		sb.append("\n Número de Funcionarios: ");
		sb.append(numFuncionarios);
		sb.append("\n Numero de Visitas Diarias: ");
		sb.append(numVisitasDiarias);
		sb.append("\n Ramo de Atividade: ");
		sb.append(ramoAtividade);
		sb.append("\n");
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
}
