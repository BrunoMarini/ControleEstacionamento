package estacionamento;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Programa
{   
	private static Programa instance = null;
        private VeiculoEstacionado[] caminhonete  = new VeiculoEstacionado[20];
        private VeiculoEstacionado[] carros       = new VeiculoEstacionado[100];
        private VeiculoEstacionado[] motos        = new VeiculoEstacionado[20];
        
        public static Programa getInstance()
        {
            if(instance == null)
                instance = new Programa();
            return(instance);
        }
                
	public Programa()
        {            
            FrameEstacionamento telaEstacionamento = new FrameEstacionamento();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int height = screenSize.height;
            int width = screenSize.width;
            telaEstacionamento.setSize(width/2, height/2);
            telaEstacionamento.setVisible(true);
            telaEstacionamento.setLocationRelativeTo(null);
        }
}
