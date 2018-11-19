package estacionamento;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Programa
{   
	private static Programa instance = null;
        private VeiculoEstacionado[] estacionados = new VeiculoEstacionado[200];
        
        int removeu = 0;
        int count = 0;
        
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
        
        public void EntradaVeiculo(String placa, String modelo, String tipo, String pacote)
        {
            int i;
            
            if(removeu == 0)
            {
                estacionados[count] = new VeiculoEstacionado(placa, modelo, pacote);                
            }
            else
            {
                for(i = 0; i < count; i++)
                {
                    if(!estacionados[i].getOcupado())
                    {
                        estacionados[count] = new VeiculoEstacionado(placa, modelo, pacote);
                    }
                }
            }
        }
        
        
}
