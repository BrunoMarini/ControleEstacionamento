import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class FrameTelaCarregamento extends JFrame{
	private JPanel panelPrincipal;
	private ImageIcon imageInicio;
	private JLabel labelInicio;
	private JProgressBar barraProgesso;
	
	
	public FrameTelaCarregamento() 
	{
		panelPrincipal = new JPanel();
		
		setTitle("Controle de Estacionamento");
		
		imageInicio = new ImageIcon(getClass().getResource("ImgCarregamento.png"));
		labelInicio = new JLabel(imageInicio);
		panelPrincipal.add(labelInicio);
		//panelPrincipal.add(barraProgesso);
		add(panelPrincipal);
	}
	
}
