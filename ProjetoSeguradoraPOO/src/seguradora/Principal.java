package seguradora;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Principal extends Util {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		//Instancia a classe Seguradora que contem os metodos principais
		ControlaSeguradora controlaSeguradora = new ControlaSeguradora();
		//Inicia o programa
		while (true){
			//Chama o menu principal
			String opcao = controlaSeguradora.CallmenuPrincipal();
			//Executa os menus principais no sistema
			switch (opcao) {
			//Cadastrar Cliente
			case "1": {
				try {
					System.out.println("***Cadastro de Cliente***");
					controlaSeguradora.CadastraCliente();
				} catch (Exception e) {
					System.out.println("Erro ao Cadastrar Cliente: " + e.getMessage());
				}
				break;
			}
			//Cadastrar Contratos
			case "2": {
				try {
					System.out.println("***Cadastro de Contratos***");
					controlaSeguradora.CadastrarContrato();
				} catch (Exception e) {
					System.out.println("Erro ao Cadastrar Contratos: "+ e.getMessage());
				}
				break;
			}
			//Lista de clientes
			case "3": {
				try {
					System.out.println("***Lista de clientes***");
					controlaSeguradora.ListarClientes();
				} catch (Exception e) {
					System.out.println("Erro ao listar Clientes: "+ e.getMessage() );
				}
				break;
			}
			//Lista de Contratos
			case "4": {
				try {
					System.out.println("***Lista de Contratos***");
					controlaSeguradora.ListarContrato();
				} catch (Exception e) {
					System.out.println("Erro ao Listar Contratos: "+ e.getMessage());
				}
				break;
			}
			//Cadastro de Sinistro (data e percentual de perda)
			case "5": {
				try {
					System.out.println("***Cadastro de Sinistro***");
					controlaSeguradora.doCadastrarSinistro();
				} catch (Exception e) {
					System.out.println("Erro ao Cadastrar Sinistro: "+ e.getMessage());
				}
				break;
			}
			//Lista de Sinistro (agrupado por contrato)
			case "6": {
				try {
					System.out.println("***Lista de Sinistros***");
					controlaSeguradora.ListarSinistro();
				} catch (Exception e) {
					System.out.println("Erro ao Listar Sinistros: "+ e.getMessage());
				}
				break;
			}
			case "7": {
				try {
					System.out.println("***Consultar contratos com / sem Sinistros***");
					controlaSeguradora.ListarContratoSemSinistro();
				} catch (Exception e) {
					System.out.println("Erro ao Listar Sinistros: "+ e.getMessage());
				}
				break;
			}
			case "8": {
				System.out.println("Programa Encerrado");
				System.exit(0);
			}
			default:
				System.out.println("Opção inválida, tente novamente. ");
			}
			
			
			
			
		}
		
		
		
	}
	
}
