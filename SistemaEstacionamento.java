package estacionamento;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

public class SistemaEstacionamento
{   
	private static SistemaEstacionamento instance = null;
    public ArrayList<VeiculoEstacionado> lista = new ArrayList<VeiculoEstacionado>();
    
    private SistemaEstacionamento()
    {            
        
    }
    
    public static SistemaEstacionamento getInstance()
    {
        if(instance == null)
            instance = new SistemaEstacionamento();
        return(instance);
    }

    public BancoDados setBanco()
    {
    	BancoDados bancoDados = new BancoDados();
    	return bancoDados;
    }
    
    
    public void inicializar()
    {
    	BancoDados bancoDados = setBanco();	
    	bancoDados.openReadFile();
    	bancoDados.readFile();
    	bancoDados.closeFile();
    	
    	
        FrameEstacionamento telaEstacionamento = new FrameEstacionamento();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        telaEstacionamento.setSize(width/2, height/2);
        telaEstacionamento.setVisible(true);
        telaEstacionamento.setLocationRelativeTo(null);
        
        
    }

    public int EntradaVeiculo(String placa, String modelo, String tipo, String pacote, int entrada)
    {
    	int contCarro = 0, contMoto = 0, contCaminhonete = 0, vagaOcupada = -1;
    	String tipoAtual;
    	
        // ACHAR VAGA DISPONIVEL PARA O TIPO DE VEICULO
    	for(VeiculoEstacionado veiculoAtual : lista)
    	{
    		tipoAtual = veiculoAtual.getModelo();
    		
    		if(tipoAtual.equals("Carro"))
    		{
    			contCarro++;
    		}
    		
    		else if(tipoAtual.equals("Moto"))
    		{
    			contMoto++;
    		}
    		
    		else if(tipoAtual.equals("Caminhonete"))
    		{
    			contCaminhonete++;
    		}
    		
    	}
    	
    	if (tipo.equals("Carro") && contCarro < 160)
    	{
    		vagaOcupada = 40 + contCarro;
    	}
    	else if(tipo.equals("Moto") && contCarro < 20)
		{
    		vagaOcupada = contMoto;
		}
		
		else if(tipo.equals("Caminhonete") && contCarro < 20)
		{
			vagaOcupada = 20 + contCaminhonete;
		}
		else
		{
			return -1;
		}
    	 
        VeiculoEstacionado veiculo = new VeiculoEstacionado(placa, modelo, pacote, vagaOcupada, entrada);
        lista.add(veiculo);  
        
        BancoDados bancoDados = setBanco();
        bancoDados.openWriteFile();
        bancoDados.adicionarArquivo(veiculo);
        bancoDados.closeFile();
        
        return vagaOcupada;
        
    }

    public boolean isOcupado(int vagaTeste)
    {
    	
    	for(VeiculoEstacionado veiculoAtual : lista)
    	{
    		if(vagaTeste == veiculoAtual.getVagaOcupada())
    		{
    			return (true);
    		}
    		
    	}
    	
    	return false;
    }
    
    public int getNumeroCarros(){
        return (lista.size());
    }
    
    
}
