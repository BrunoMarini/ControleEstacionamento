
package estacionamento;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class ControleEstacionamento {
    
    private static ControleEstacionamento instance = null;
    
    public static ControleEstacionamento getInstance()
    {
        if(instance == null)
            instance = new ControleEstacionamento();
        return(instance);
    }
    
    public void inicializar()
    {
        TelaEstacionamento telaEstacionamento = new TelaEstacionamento();
        telaEstacionamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        
        telaEstacionamento.setExtendedState(telaEstacionamento.MAXIMIZED_BOTH);
        telaEstacionamento.setSize(width/2, height/2);
        telaEstacionamento.setLocationRelativeTo(null);
        
        telaEstacionamento.setVisible(true); 
    }
    
    
}
