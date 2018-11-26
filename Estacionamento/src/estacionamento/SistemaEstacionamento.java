package estacionamento;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

public class SistemaEstacionamento extends BaseDeDados
{   
    BaseDeDados base = new BaseDeDados();
    private static SistemaEstacionamento instance = null;
    ArrayList<VeiculoEstacionado> lista = new ArrayList();
    
    public static SistemaEstacionamento getInstance()
    {
        if(instance == null)
            instance = new SistemaEstacionamento();
        return(instance);
    }

    public SistemaEstacionamento()
    {            
        
    }

    public void inicializar()
    {
        FrameEstacionamento telaEstacionamento = new FrameEstacionamento();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        telaEstacionamento.setSize(width/2, height/2);
        telaEstacionamento.setVisible(true);
        telaEstacionamento.setLocationRelativeTo(null);
        
        base.openFile();
    }

    public void EntradaVeiculo(String placa, String modelo, String tipo, String pacote)
    {
        VeiculoEstacionado veiculo = new VeiculoEstacionado(placa, modelo, pacote, 1);
        lista.add(veiculo);
        base.adicionarArquivo(placa, modelo, pacote, 1);
    }

        
}
