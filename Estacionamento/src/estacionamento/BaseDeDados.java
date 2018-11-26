package estacionamento;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BaseDeDados
{
    private ObjectOutputStream output;
    
    public void openFile()
    {
        try
        {
            FileOutputStream arquivoGrav = new FileOutputStream("base.dat");
            output = new ObjectOutputStream(arquivoGrav);
        }
        catch(IOException ioException)
        {
             System.out.println("Ola Amigos");
        }
    }
    
    public void adicionarArquivo(VeiculoEstacionado armazenar)
    {
        try
        {
            output.writeObject(armazenar);
            
        }catch(IOException ioException)
        {
            System.err.println("Erro");
        }
    }
    
    public void fecharArquivo()
    {
        try
        {
            if(output != null)
                output.close();
        }
        catch(IOException ioException)
        {
            System.err.println("Erro");
        }
    }
}
