 package estacionamento;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BancoDados
{
	SistemaEstacionamento estacionamento = SistemaEstacionamento.getInstance();
    private ObjectOutputStream output;
    private ObjectInputStream input;
    
    public void openWriteFile()
    {
        try
        {          
            output = new ObjectOutputStream(new FileOutputStream("banco.ser"));
        }
        catch(IOException ioException)
        {
             System.out.println("Erro ao tentar abrir o arquivo");
        }
    }
    
    public void openReadFile()
    {
    	try
        {          
            input = new ObjectInputStream(new FileInputStream("banco.ser"));
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
    
    public void readFile()
    {
    	VeiculoEstacionado veiculoReg;
    	
    	try
        {
            while(true)
            {
            	veiculoReg = (VeiculoEstacionado)input.readObject();
            	estacionamento.lista.add(veiculoReg);
            }
        
        }
    	catch(EOFException exception)
        {
            return;
        }
    	
		catch(ClassNotFoundException exception)
		{
		    System.err.println("Erro");
		}
    	
        catch(IOException exception)
        {
            System.err.println("Erro");
        }
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
