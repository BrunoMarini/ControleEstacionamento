package estacionamento;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

public class SistemaEstacionamento extends BancoDados
{   
	private static SistemaEstacionamento instance = null;
	private BancoDados bancoDados = new BancoDados();
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

    public void inicializar()
    {
    	
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

    public void EntradaVeiculo(String placa, String modelo, String tipo, String pacote, int entrada)
    {
        VeiculoEstacionado veiculo = new VeiculoEstacionado(placa, modelo, pacote, 1, entrada);
        lista.add(veiculo);
        
        bancoDados.openWriteFile();
        bancoDados.adicionarArquivo(veiculo);
        bancoDados.closeFile();
    }
    
    public int getNumeroCarros(){
        return (lista.size());
    }
    
    
}
