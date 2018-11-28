package estacionamento;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;
import java.util.ArrayList;

public class SistemaEstacionamento extends BaseDeDados
{   
    BaseDeDados base = new BaseDeDados();
    private static SistemaEstacionamento instance = null;
    public ArrayList<VeiculoEstacionado> lista = new ArrayList<VeiculoEstacionado>();
    
    float horaCarro = 2;
    float horaMoto = 2;
    float horaCaminhonete = 2;
    
    float mensalistaCarro = 50;
    float mensalistaMoto = 50;
    float mensalistaCaminhonete = 50;
    
    float pernoiteCarro = 15;
    float pernoiteMoto = 15;
    float pernoiteCaminhonte = 15;
    
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
        
        //base.openFile();
    }

    public void EntradaVeiculo(String placa, String modelo, String tipo, String pacote, Date d)
    {
        VeiculoEstacionado veiculo = new VeiculoEstacionado(placa, modelo, pacote, 1, d);
        lista.add(veiculo);
    }
    
    public void Configuracoes(float hcar, float hm, float hcam, float mcar, float mm, float mcam, float pcar, float pm, float pcam)
    {
    	horaCarro = hcar;
        horaMoto = hm;
        horaCaminhonete = hcam;
        
        mensalistaCarro = mcar;
        mensalistaMoto = mm;
        mensalistaCaminhonete = mcam;
        
        pernoiteCarro = pcar;
        pernoiteMoto = pm;
        pernoiteCaminhonte = pcam;
    }
    
    public float getHoraCarro(){
    	return horaCarro;
    }
    public float getHoraMoto(){
    	return horaCarro;
    }
    public float getHoraCaminhonete(){
    	return horaCarro;
    }
    
    public float getMensalistaCarro(){
    	return mensalistaCarro;
    }
    public float getMensalistaMoto(){
    	return mensalistaCarro;
    }
    public float getMensalistaCaminhonete(){
    	return mensalistaCarro;
    }
    
    public float getPernoiteCarro(){
    	return pernoiteCarro;
    }
    public float getPernoiteMoto(){
    	return pernoiteMoto;
    }
    public float getPernoiteCaminhonete(){
    	return pernoiteCaminhonte;
    }
    
    public int getNumeroCarros(){
        return (lista.size());
    }    
}