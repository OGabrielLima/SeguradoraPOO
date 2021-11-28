package seguradora;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.DefaultRowSorter;

public class ControlaSeguradora extends Util {
	Scanner leitor = new Scanner(System.in);
	Util util = new Util();
	@SuppressWarnings("finally")
	public String CallmenuPrincipal() {
		String option = "";
		//Menu Principal
		System.out.println("--------------------------------------------------------");
		System.out.println("1 - Cadastro de Clientes.");
		System.out.println("2 - Cadastro de Contratos.");
		System.out.println("3 - Lista de clientes.");
		System.out.println("4 - Lista de Contratos");
		System.out.println("5 - Cadastrar Sinistro.");
		System.out.println("6 - Lista Sinistro.");
		System.out.println("7 - Lista de Contratos sem sinistro.");
		System.out.println("8 - Encerrar Programa.");
		System.out.print("Insira a Op��o desejada: ");
		try {
			option = leitor.nextLine();
		} catch (Exception e) {
			System.out.println("Entrada Inv�lida");
		} finally {
			System.out.println("--------------------------------------------------------");
			return option;
		}
		
	}
	
	//Cadastra o Cliente
	public void CadastraCliente() throws MensagemErroSeguradoraExeption {
		Cliente novoCliente = new Cliente();
		System.out.print("Insira o nome do cliente: ");
		String nome = leitor.nextLine();
		if(nome != null && nome != "") {
			novoCliente.setNome(nome);
		} else {
			throw new MensagemErroSeguradoraExeption("Nome Inv�lido.");
		}
		System.out.println("***Tipo do cliente***");
		System.out.println("1 - Pessoa F�sica");
		System.out.println("2 - pessoa Juridica");
		System.out.print("Digite a Op��o: ");
		String tipoPessoa = leitor.nextLine();
		if(tipoPessoa.equals("1")) {
			novoCliente.setTipoCliente("PF");
		} else if (tipoPessoa.equals("2")) {
			novoCliente.setTipoCliente("PJ");
		} else {
			throw new MensagemErroSeguradoraExeption("Tipo do Cliente Inv�lido.");
		}
		if(novoCliente.getTipoCliente().equals("PF")) {
			System.out.print("Infome seu CPF (apenas n�meros): ");
			String cpf = leitor.nextLine();
			novoCliente.setCpf(cpf);
		} else if (novoCliente.getTipoCliente().equals("PJ")) {
			System.out.print("Informe seu CNPJ (apenas n�meros): ");
			String cnpj = leitor.nextLine();
			novoCliente.setCpf(cnpj);
		} else {
			throw new MensagemErroSeguradoraExeption("CPF/CNPJ Inv�lido.");
		}
		util.gravarCliente(novoCliente);
		System.out.println("*CLIENTE CADASTRADO COM SUCESSO*");
	}
	
	
	public void CadastrarContrato() {
		Scanner scan = new Scanner(System.in);
		//Obtendo o cliente do contrato 
		System.out.println("Infome seu CPF/CNPJ (apenas n�meros): ");
		String numCpfCnpj = scan.nextLine();
		Cliente cliente = util.obterCliente(numCpfCnpj);
		Contratos contrato = new Contratos();
		if(cliente != null) {
			System.out.println("--Cliente--");
			System.out.println(cliente);
			contrato.setCliente(cliente);		
			if(cliente.getTipoCliente().equals("PF")) {
				System.out.print("Insira o endere�o do im�vel: ");
				String ender = scan.nextLine();
				if(ender != null && ender != "") {
					contrato.setEndereco(ender);
				} else {
					throw new MensagemErroSeguradoraExeption("Endere�o digitado Inv�lido.");
				}
				
				System.out.println("Escolha qual a zona do Im�vel: ");
					System.out.println("1 - Zona Urbana.");	
					System.out.println("2 - Zona Suburbana.");
					System.out.println("3 - Zona Rural.");
					System.out.print("Opcao: ");
					String zona = scan.nextLine();
					if(zona.equals("1")) {
						contrato.setZona("URBANA");
					} else if (zona.equals("2")){
						contrato.setZona("SUBURBANA");
					} else if (zona.equals("3")) {
						contrato.setZona("RURAL");
					} else {
						throw new MensagemErroSeguradoraExeption("Zona Inv�lido, tente novamente com uma entrada n�merica de 1 at� 3.");
					}
				System.out.println("Escolha qual o tipo da resid�ncia: ");
					System.out.println("1 - Apartamento");
					System.out.println("2 - Casa");
					String tipo = scan.nextLine();
					if(tipo.equals("1")) {
						contrato.setTipo("APARTAMENTO");
					} else if (tipo.equals("2")) {
						contrato.setTipo("CASA");
					} else {
						throw new MensagemErroSeguradoraExeption("Tipo do im�vel Inv�lido, tente novamente com uma entrada n�merica de 1 at� 2.");
					}
				
				try {
					System.out.print("Insira o valor do im�vel: ");
					float valor = scan.nextFloat();
					contrato.setValorImovel(valor);
					calculaValorContratoPF(contrato);
					System.out.println("Valor Contrato: "+contrato.getValorContrato());
				}catch (Exception e) {
					throw new MensagemErroSeguradoraExeption("Valor do �m�vel digitado Inv�lido.");
				}
				
			} else {
				System.out.print("Insira o valor do im�vel: ");
				String valor = scan.nextLine();
				System.out.println("Escolha qual ramo da empresa: ");
				System.out.println("1 - Com�rcio.");	
				System.out.println("2 - Ind�stria.");
				System.out.println("3 - Agropecu�ria.");
				String ramo = leitor.nextLine();
				if(ramo.equals("1")) {
					contrato.setRamoAtividade("COM�RCIO");
				} else if (ramo.equals("2")){
					contrato.setRamoAtividade("IND�STRIA");
				} else if (ramo.equals("3")) {
					contrato.setRamoAtividade("AGROPECU�RIA");
				} else {
					throw new MensagemErroSeguradoraExeption("Ramo Inv�lido, tente novamente com uma entrada n�merica de 1 at� 3.");
				}
				System.out.println("\nInsira o n�mero de funcion�rios: ");
				try {
					int func = leitor.nextInt();	
					contrato.setNumFuncionarios(func);
				} catch (Exception e) {
					throw new MensagemErroSeguradoraExeption("Entrada inv�lida no campo: n�mero de funcion�rios");
				}
				System.out.println("Insira o numero de vis�tas di�rias");
				try {
					int vis = leitor.nextInt();	
					contrato.setNumVisitasDiarias(vis);
				} catch (Exception e) {
					throw new MensagemErroSeguradoraExeption("Entrada inv�lida no campo: N�mero de visitas.");
				}
				try {
					System.out.print("Insira o valor do im�vel: ");
					float value = scan.nextFloat();
					contrato.setValorImovel(value);
					calculaValorContratoPJ(contrato);
					System.out.println("Valor Contrato: "+contrato.getValorContrato());
				} catch (Exception e) {
					throw new MensagemErroSeguradoraExeption("Valor do �m�vel digitado Inv�lido.");
				}
			}
			util.gravarContrato(contrato);
			System.out.println("*CADASTRADO COM SUCESSO*");
		} else {
			throw new MensagemErroSeguradoraExeption("Verifique se o CPF digitado � v�lido.");
		}		
	}
	
	
	public void ListarClientes() throws IOException {
		System.out.println("Infome o CPF/CNPJ do cliente que deseja consultar (apenas n�meros): ");
		String num = leitor.nextLine();
		if(num != null && num != "") {
			Cliente cliente = util.obterCliente(num);
			if(cliente != null) {
				System.out.print(cliente);
			} else {
				throw new MensagemErroSeguradoraExeption("Verifique se o CPF digitado � v�lido.");
			} 
		} 
	}
	
	public void ListarContrato() throws IOException {
		System.out.println("Infome o CPF/CNPJ do cliente que deseja consultar (apenas n�meros): ");
		String num = leitor.nextLine();
		if(num != null && num != "") {
			Contratos contrato = util.obterContrato(num);
			if(contrato != null) {
				//System.out.print(contrato);
				if(contrato.getCliente().getTipoCliente().equals("PF")) {
					System.out.println(contrato.getCliente());
					System.out.println("Endere�o: "+ contrato.getEndereco());
					System.out.println("Valor do Im�vel: "+ contrato.getValorImovel());
					System.out.println("Valor do Contrato: "+ contrato.getValorContrato());
					System.out.println("Zona: "+ contrato.getZona());
					System.out.println("Tipo: "+ contrato.getTipo());
					
				} else {
					System.out.println(contrato.getCliente());
					System.out.println("Valor do Im�vel: "+ contrato.getValorImovel());
					System.out.println("Num Funcin�rios: "+ contrato.getNumFuncionarios());
					System.out.println("Num Visitas: "+ contrato.getNumVisitasDiarias());
					System.out.println("Ramo: "+ contrato.getRamoAtividade());
				}
			} else {
				throw new MensagemErroSeguradoraExeption("Verifique se o CPF digitado � v�lido.");
			} 
		} 
	}
	
	public void calculaValorContratoPF(Contratos contrato){
		try {
			float valorSeguro = (float) (contrato.getValorImovel()*0.02);
			if(contrato.getZona().equals("URBANA")) {
				float valorContrato = (float) (valorSeguro + (valorSeguro*0.01));
				contrato.setValorContrato(valorContrato);
			} else if (contrato.getZona().equals("SUBURBANA")) {
				float valorContrato = (float) (valorSeguro + (valorSeguro*0.005));
				contrato.setValorContrato(valorContrato);
			} else if (contrato.getZona().equals("RURAL")) {
				float valorContrato = (float) (valorSeguro + (valorSeguro*0.005));
				contrato.setValorContrato(valorContrato);
			}
		} catch (Exception e) {
			throw new MensagemErroSeguradoraExeption("Valor do im�vel inv�lido.");
		}
		
	}
	
	public void calculaValorContratoPJ(Contratos contrato){
		try {
			float valorSeguro = (float) (contrato.getValorImovel()*0.04);
			int valorFuncionarios = contrato.getNumFuncionarios();
			int i = 10;
			while(i <= valorFuncionarios) {
				i = i + 10;
				valorSeguro = (float) (valorSeguro + (valorSeguro*0.02));
			}
			int v = 200;
			while(v <= valorFuncionarios) {
				v = v + 200;
				valorSeguro = (float) (valorSeguro + (valorSeguro*0.03));
			}
			if(contrato.getRamoAtividade().equals("COM�RCIO")) {
				float valorContrato = (float) (valorSeguro + (valorSeguro*0.005));
				contrato.setValorContrato(valorContrato);
			} else if (contrato.getRamoAtividade().equals("IND�STRIA")) {
				float valorContrato = (float) (valorSeguro + (valorSeguro*0.001));
				contrato.setValorContrato(valorContrato);
			} 
		} catch (Exception e) {
			throw new MensagemErroSeguradoraExeption("Valor do im�vel inv�lido.");
		}
	}
	
	public void doCadastrarSinistro() {
		System.out.println("Infome o CPF/CNPJ do cliente que deseja cadastrar o Sinistro (apenas n�meros): ");
		String num = leitor.nextLine();
		if(num != null && num != "") {
			Cliente cliente = util.obterCliente(num);
			if(cliente != null) {
				Sinistro sin = new Sinistro();
				sin.setCliente(cliente);
				
				System.out.println("Infome a data do Sinistro: ");
				String data = leitor.nextLine();
				if(data != null && data != "" && data.contains("/") && data.length() == 10) {
					sin.setData(data);
				} else {
					throw new MensagemErroSeguradoraExeption("Data inv�lida.");	
				}
				try {
					System.out.println("Infome o percentual de perda: ");
					float per = leitor.nextFloat();
					sin.setPercentual(per);
				}catch (Exception e) {
					throw new MensagemErroSeguradoraExeption("Entrada do percentual inv�lida.");	
				}
				util.gravarSinistro(sin);
				System.out.println("*CADASTRADO COM SUCESSO*");
			} else {
				throw new MensagemErroSeguradoraExeption("Verifique se o CPF digitado � v�lido.");
			} 
		} 
	}
	
	public void ListarSinistro() throws IOException {
		System.out.println("Infome o CPF/CNPJ do cliente que deseja consultar (apenas n�meros): ");
		String num = leitor.nextLine();
		if(num != null && num != "") {
			Sinistro sinistro = util.obterSinistro(num);
			if(sinistro != null) {
				System.out.print(sinistro);
			} else {
				throw new MensagemErroSeguradoraExeption("Verifique se o CPF digitado � v�lido.");
			} 
		} 
	}
	
	public void ListarContratoSemSinistro() throws IOException {
		System.out.println("Infome o CPF/CNPJ do cliente que deseja consultar (apenas n�meros): ");
		String num = leitor.nextLine();
		if(num != null && num != "") {
			Sinistro sinistro = util.obterSinistro(num);
			if(sinistro != null) {
				System.out.println("H� um sinistro para este contrato");
				System.out.print(sinistro);
			} else {
				System.out.println("N�o h� um sinistro para este CPF");
			} 
		} 
	}
	
	
}
