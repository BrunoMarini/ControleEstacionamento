 package estacionamento;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BancoDados
{
	//SistemaEstacionamento estacionamento = SistemaEstacionamento.getInstance();
    private ObjectOutputStream output;
    private ObjectInputStream input;
    
    public void openWriteFile(String nomeArquivo)
    {
        try
        {          
            output = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
        }
        catch(IOException ioException)
        {
             System.out.println("Erro ao tentar abrir o arquivo");
        }
    }
    
    public void openReadFile(String nomeArquivo)
    {
    	try
        {          
            input = new ObjectInputStream(new FileInputStream(nomeArquivo));
        }
        catch(IOException ioException)
        {
             System.out.println("Erro ao tentar abrir o arquivo");
        }
    }
    
    public void adicionarArquivo(VeiculoEstacionado veiculoReg)
    {
        try
        {
            output.writeObject(veiculoReg);
            
        }catch(IOException ioException)
        {
            System.err.println("Erro ao escrever no arquivo");
        }
    }
    
    public void adicionarArquivo(VeiculoSaida veiculoReg) // CONTROLA ARQUIVO DE SAIDA DE VEICULOS
    {
        try
        {
            output.writeObject(veiculoReg);
            
        }catch(IOException ioException)
        {
            System.err.println("Erro ao escrever no arquivo");
        }
    }
    
    public ArrayList readFile()
    {
    	VeiculoEstacionado veiculoReg;
    	ArrayList<VeiculoEstacionado> lista = new ArrayList<VeiculoEstacionado>();
    	
    	try
        {
            while(true)
            {
            	veiculoReg = (VeiculoEstacionado)input.readObject();
            	lista.add(veiculoReg);
            }
        
        }
    	catch(EOFException exception)
        {
            return lista;
        }
    	
		catch(ClassNotFoundException exception)
		{
		    System.err.println("Erro");
		}
    	
        catch(IOException exception)
        {
            System.err.println("Erro");
        }
		return lista;
    }
    
    public ArrayList readFileDatasSaida()
    {
    	 ArrayList<VeiculoSaida> lista = new ArrayList<VeiculoSaida>();
    	 VeiculoSaida veiculoAtual;
    	 
    	 try
    	 {
    		 while(true)
    		 {
    			 veiculoAtual = (VeiculoSaida)input.readObject();
    			 lista.add(veiculoAtual);
    		 }	 
    	 }
    	 catch(EOFException exception)
         {
             return lista;
         }
     	
 		catch(ClassNotFoundException exception)
 		{
 		    System.err.println("Erro");
 		}
     	
         catch(IOException exception)
         {
             System.err.println("Erro");
         }    	 
    	 
    	 return lista;
    }
    
    public void closeFile()
    {
        try
        {
            if(output != null)
            {
            	output.close();
            }
            else if(input != null)
            {
            	input.close();
            }   
        }
        catch(IOException ioException)
        {
            System.err.println("Erro ao tentar fechar o arquivo");
        }
    }
}
