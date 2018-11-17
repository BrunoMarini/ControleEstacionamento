package estacionamento;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Programa
{
	
	public Programa()
        {
                FrameEstacionamento telaEstacionamento = new FrameEstacionamento();
		// BRUNO
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int height = screenSize.height;
                int width = screenSize.width;
                telaEstacionamento.setSize(width/2, height/2);
                    //FIM BRUNO
                telaEstacionamento.setVisible(true);
                    //telaEstacionamento.setSize(685,410);
                telaEstacionamento.setLocationRelativeTo(null);
        }		
}
