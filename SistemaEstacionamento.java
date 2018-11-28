package estacionamento;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Date;

public class SistemaEstacionamento
{   
	private static SistemaEstacionamento instance = null;
    public ArrayList<VeiculoEstacionado> lista;
    
    BancoDados bancoDados = new BancoDados();
    
	float horaCarro = 2;
    float horaMoto = 1;
    float horaCaminhonete = 3;
    
    float mensalistaCarro = 51;
    float mensalistaMoto = 50;
    float mensalistaCaminhonete = 52;
    
    float pernoiteCarro = 16;
    float pernoiteMoto = 15;
    float pernoiteCaminhonte = 17;
    
    int tempoBonus = 0;
	
    private SistemaEstacionamento()
    {            
        
    }
    
    public static SistemaEstacionamento getInstance()
    {
        if(instance == null)
            instance = new SistemaEstacionamento();
        return(instance);
    }
    
    /*public BancoDados setBanco()
    {
    	BancoDados bancoDados = new BancoDados();
    	return bancoDados;
    }*/
    
    
    public void inicializar()
    {
    	//BancoDados bancoDados = setBanco();	
    	bancoDados.openReadFile();
    	lista = bancoDados.readFile();
    	bancoDados.closeFile();
    	
    	bancoDados.openWriteFile();
    	
        FrameEstacionamento telaEstacionamento = new FrameEstacionamento();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        telaEstacionamento.setSize(width/2, height/2);
        telaEstacionamento.setVisible(true);
        telaEstacionamento.setLocationRelativeTo(null);
       
        telaEstacionamento.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				salvarLista();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
    }

    public int entradaVeiculo(String placa, String modelo, String tipo, String pacote, Date d)
    {
    	int contCarro = 0, contMoto = 0, contCaminhonete = 0, vagaOcupada = -1, inicio = 0;
    	int fim = 0, i;
    	String tipoAtual;
    	
        // ACHAR VAGA DISPONIVEL PARA O TIPO DE VEICULO
    	
    	if (tipo.equals("Carro"))
    	{
    		inicio = 40;
    		fim = 200;
    	}
    	else if(tipo.equals("Moto"))
		{
    		inicio = 0;
    		fim = 20;
		}
		
		else if(tipo.equals("Caminhonete"))
		{
			inicio = 20;
			fim = 40;
		}
    	
    	
    	for(i = inicio; i < fim; i++)
    	{	
    		if(isOcupado(i) == false)
    			break;
    	}
    	
    	if(i < fim)
    	{
        	vagaOcupada = i;
    	}
		else
		{
			return -1;
		}
    	 
        VeiculoEstacionado veiculo = new VeiculoEstacionado(placa, modelo, pacote, vagaOcupada, d);
        lista.add(veiculo);  
        
        // MOVER PARA ONDE FECHA O PROGRAMA
        //BancoDados bancoDados = setBanco();
        //bancoDados.openWriteFile();
        //bancoDados.adicionarArquivo(veiculo);
        //bancoDados.closeFile();
        // FIM DO MOVER
        
        return vagaOcupada;
        
    }
	
	public void Configuracoes(float hcar, float hm, float hcam, float mcar, float mm, float mcam, 
							  float pcar, float pm, float pcam, int valida, int tempo)
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
        
       if(valida == 1)
    	   tempoBonus = tempo;
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
    
    public void salvarLista()
    {
    	for(VeiculoEstacionado veiculoAtual : lista)
    	{
    		bancoDados.adicionarArquivo(veiculoAtual);
    	}
    	bancoDados.closeFile();
    	
    }
	
	//DE ACORDO COM O JEFF GEEETS
	
	public float getHoraCarro(){
    	return horaCarro;
    }
    public float getHoraMoto(){
    	return horaMoto;
    }
    public float getHoraCaminhonete(){
    	return horaCaminhonete;
    }
    
    public float getMensalistaCarro(){
    	return mensalistaCarro;
    }
    public float getMensalistaMoto(){
    	return mensalistaMoto;
    }
    public float getMensalistaCaminhonete(){
    	return mensalistaCaminhonete;
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
    
    public int getTempoBonus(){
    	return (tempoBonus);
    }
    //DE ACORDO COM O JEFF GEEETS
}