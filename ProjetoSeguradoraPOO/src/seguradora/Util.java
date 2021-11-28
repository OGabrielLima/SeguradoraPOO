package seguradora;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class Util {	
	
    public void gravarCliente(Cliente cliente){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream outputStream = null;
        try{
        	fileOutputStream = new FileOutputStream(cliente.getCpf()+".txt");
        	outputStream =  new ObjectOutputStream(fileOutputStream);
        	outputStream.writeObject(cliente);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(outputStream !=null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public Cliente obterCliente(String cpf) {
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        Cliente cliente = null;
        try{
            fis = new FileInputStream(cpf+".txt");
            ois = new ObjectInputStream(fis);
            cliente = (Cliente) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("O sistema não pode encontrar o arquivo especificado.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    	return cliente;
    }
	
    public void gravarContrato(Contratos contrato){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream outputStream = null;
        try{
        	fileOutputStream = new FileOutputStream(contrato.getCliente().getCpf()+"contrato.txt");
        	outputStream =  new ObjectOutputStream(fileOutputStream);
        	outputStream.writeObject(contrato);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(outputStream !=null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public Contratos obterContrato(String cpf) {
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        Contratos contrato = null;
        try{
            fis = new FileInputStream(cpf+"contrato.txt");
            ois = new ObjectInputStream(fis);
            contrato = (Contratos) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("O sistema não pode encontrar o arquivo especificado.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    	return contrato;
    }
    
    public void gravarSinistro(Sinistro sinistro){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream outputStream = null;
        try{
        	fileOutputStream = new FileOutputStream(sinistro.getCliente().getCpf()+"sinistro.txt");
        	outputStream =  new ObjectOutputStream(fileOutputStream);
        	outputStream.writeObject(sinistro);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(outputStream !=null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public Sinistro obterSinistro(String cpf) {
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        Sinistro sinistro = null;
        try{
            fis = new FileInputStream(cpf+"sinistro.txt");
            ois = new ObjectInputStream(fis);
            sinistro = (Sinistro) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("O sistema não pode encontrar o arquivo especificado.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    	return sinistro;
    }

	
}
