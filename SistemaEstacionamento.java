package estacionamento;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SistemaEstacionamento
{   
	private static SistemaEstacionamento instance = null;
    public ArrayList<VeiculoEstacionado> lista;
    
    BancoDados bancoDados = new BancoDados();
    BancoDados bancoSaida = new BancoDados();
    
	float horaCarro = 2;
    float horaMoto = 1;
    float horaCaminhonete = 3;
    
    float mensalistaCarro = 51;
    float mensalistaMoto = 50;
    float mensalistaCaminhonete = 52;
    
    float pernoiteCarro = 16;
    float pernoiteMoto = 15;
    float pernoiteCaminhonte = 17;
    
    private Date data = new Date();
    
    int tempoBonus = 0;
	
    public static SistemaEstacionamento getInstance()
    {
        if(instance == null)
            instance = new SistemaEstacionamento();
        return(instance);
    }    
    
    public void inicializar()
    {
    	bancoDados.openReadFile("banco.ser");
    	bancoSaida.openReadFile("dataSaida.ser");
    	
    	lista = bancoDados.readFile();
    	
    	bancoDados.closeFile();
    	
    	bancoDados.openWriteFile("banco.ser");
    	bancoSaida.openWriteFile("dataSaida.ser");
    	
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
    public void salvarLista()
    {
    	for(VeiculoEstacionado veiculoAtual : lista)
    	{
    		bancoDados.adicionarArquivo(veiculoAtual);
    	}
    	bancoDados.closeFile();
    	
    }
	
    public void saidaVeiculo(int vagaOcupada, Date dataSaida, float valor)
    {
    	bancoSaida.adicionarArquivo(new VeiculoSaida(dataSaida, valor));
    	
    	for(VeiculoEstacionado veiculoAutal : lista)
    	{
    		if (veiculoAutal.getVagaOcupada() == vagaOcupada)
    			lista.remove( lista.indexOf(veiculoAutal) );
    	}
    	
    }    
    
    public Date getDataEntrada(String placa)
    {
    	for(VeiculoEstacionado v : lista)
    	{
    		if (v.getPlaca().equals(placa))
    		{
    			return(v.getData());
    		}
    	}
    	return(null);
    }
    
    public Date converteMili(Date entrou, Date saiu)
    {
    	long x;
    	
    	x = saiu.getTime() - entrou.getTime();
    	
    	//int seg = (int) (x / 1000) % 60;
        //int min = (int) ((x / (1000 * 60)) % 60);
        //int hor = (int) ((x / (1000 * 60 * 60)) % 24);
        //int dia = (int) (x / (1000 * 60 * 60 * 24));
        
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTimeInMillis(x + 10800000);
    	    			
    	int ano = calendar.get(Calendar.YEAR) - 1970;
    	int mes = calendar.get(Calendar.MONTH);
    	int dia = calendar.get(Calendar.DAY_OF_MONTH);
    	int hora = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        int seg = calendar.get(Calendar.SECOND);
    	
        //System.out.println(dia+"/"+mes+"/"+ano+" "+hora+":"+min+":"+seg);
    	
    	return (new Date(ano, mes, dia, hora, min, seg));
    }
    
    public float calculaCusto(Date tempo, String pacote, String tipo)
    {
    	int ano, mes, dia, hora, min;
    	
    	ano = tempo.getYear();
    	mes = tempo.getMonth();
    	dia = tempo.getDay() - 1;
    	hora = tempo.getHours();
    	min = tempo.getMinutes();
    	
    	System.out.println(dia+"/"+mes+"/"+ano+"   "+hora+":"+min);
    	return ano;
//    	if(pacote.equals("Hora"))
//    	{
//    		//(tempo.getYear()
//    	}
    }
    
	//DE ACORDO COM O JEFF GEEETS
	
	public float getCustoHoraCarro(){
    	return horaCarro;
    }
    public float getCustoHoraMoto(){
    	return horaMoto;
    }
    public float getCustoHoraCaminhonete(){
    	return horaCaminhonete;
    }
    
    public float getCustoMensalistaCarro(){
    	return mensalistaCarro;
    }
    public float getCustoMensalistaMoto(){
    	return mensalistaMoto;
    }
    public float getCustoMensalistaCaminhonete(){
    	return mensalistaCaminhonete;
    }
    
    public float getCustoPernoiteCarro(){
    	return pernoiteCarro;
    }
    public float getCustoPernoiteMoto(){
    	return pernoiteMoto;
    }
    public float getCustoPernoiteCaminhonete(){
    	return pernoiteCaminhonte;
    }
    
    public int getNumeroVeiculos(){
        return (lista.size());
    }   
    
    public int getTempoBonus(){
    	return (tempoBonus);
    }
    //DE ACORDO COM O JEFF GEEETS
}