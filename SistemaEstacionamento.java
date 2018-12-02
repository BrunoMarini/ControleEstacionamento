package estacionamento;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.time.*;
import java.time.temporal.ChronoUnit;


public class SistemaEstacionamento
{   
	private static SistemaEstacionamento instance = null;
    public ArrayList<VeiculoEstacionado> listaDados;
    public ArrayList<VeiculoSaida> listaSaida;
    
    BancoDados bancoDados = new BancoDados();
    BancoDados bancoSaida = new BancoDados();
    BancoDados bancoConfig = new BancoDados();
    
    FrameEstacionamento telaEstacionamento;
    
	float horaCarro = 2;
    float horaMoto = 1;
    float horaCaminhonete = 3;
    
    float mensalistaCarro = 51;
    float mensalistaMoto = 50;
    float mensalistaCaminhonete = 52;
    
    float pernoiteCarro = 16;
    float pernoiteMoto = 15;
    float pernoiteCaminhonete = 17;
    
    int tempoBonus = 0;
    boolean validaTempoBonus = false;
	
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
    	bancoConfig.openReadFile("configuracoes.ser");
    	
    	listaDados = bancoDados.readFile();    	
    	listaSaida = bancoSaida.readFileDatasSaida();
    	
		Configuracoes config = bancoConfig.readFileConfiguracoes();
		
		if(bancoConfig.existiaArquivo() && config != null)
		{
			horaCarro = config.getHoraCarro();
		    horaMoto = config.getHoraMoto();
		    horaCaminhonete = config.getHoraCaminhonete();
		    
		    mensalistaCarro = config.getMensalistaCarro();
		    mensalistaMoto = config.getMensalistaMoto();
		    mensalistaCaminhonete = config.getMensalistaCaminhonete();
		    
		    pernoiteCarro = config.getPernoiteCarro();
		    pernoiteMoto = config.getPernoiteMoto();
		    pernoiteCaminhonete = config.getPernoiteCaminhonete();
		    
		    tempoBonus = config.getTempoBonus();
		    validaTempoBonus = config.isValida();
			
			bancoDados.closeFile();
			bancoSaida.closeFile();
			bancoConfig.closeFile();
		
		}
			
		bancoConfig.openWriteFile("configuracoes.ser");
		bancoDados.openWriteFile("banco.ser");
		bancoSaida.openWriteFile("dataSaida.ser");
	
        instanciaTelaEstacionamento();
         
    }
    
    public void instanciaTelaEstacionamento()
    {
    	telaEstacionamento = new FrameEstacionamento();
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

    public int entradaVeiculo(String placa, String modelo, String tipo, String pacote, LocalDateTime d)
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
    	
        VeiculoEstacionado veiculo = new VeiculoEstacionado(placa, modelo, pacote, tipo, vagaOcupada, d);
        listaDados.add(veiculo);  
        
        // MOVER PARA ONDE FECHA O PROGRAMA
        //BancoDados bancoDados = setBanco();
        //bancoDados.openWriteFile();
        //bancoDados.adicionarArquivo(veiculo);
        //bancoDados.closeFile();
        // FIM DO MOVER
        
        telaEstacionamento.dispose();
        instanciaTelaEstacionamento();
        
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
        pernoiteCaminhonete = pcam;
        
       if(valida == 1)
       {
    	   tempoBonus = tempo;
    	   validaTempoBonus = true;
       }
       else
       {
    	   validaTempoBonus = false;
       }
    }

//	public void LocalDateTimeDiff (LocalDateTime entrada, LocalDateTime saida)
//	{
//        LocalDateTime fromTemp = LocalDateTime.from(entrada);
//        long years = fromTemp.until(saida, ChronoUnit.YEARS);
//        fromTemp = fromTemp.plusYears(years);
//
//        long months = fromTemp.until(saida, ChronoUnit.MONTHS);
//        fromTemp = fromTemp.plusMonths(months);
//
//        long days = fromTemp.until(saida, ChronoUnit.DAYS);
//        fromTemp = fromTemp.plusDays(days);
//
//        long hours = fromTemp.until(saida, ChronoUnit.HOURS);
//        fromTemp = fromTemp.plusHours(hours);
//
//        long minutes = fromTemp.until(saida, ChronoUnit.MINUTES);
//        fromTemp = fromTemp.plusMinutes(minutes);
//
//        System.out.println("From = " + entrada);
//        System.out.println("To   = " + saida);
//        System.out.printf("The difference is %s years, %s months, %s days, " +
//                        "%s hours, %s minutes, %s seconds, %s millis",
//                years, months, days, hours, minutes);
//}
	
    public boolean isOcupado(int vagaTeste)
    {
    	
    	for(VeiculoEstacionado veiculoAtual : listaDados)
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
    	for(VeiculoEstacionado veiculoAtual : listaDados)
    	{
    		bancoDados.adicionarArquivo(veiculoAtual);
    	}
    	for(VeiculoSaida v : listaSaida)
    	{
    		bancoSaida.adicionarArquivo(v);
    	}
    	
    	Configuracoes config = new Configuracoes(horaCarro, horaMoto, horaCaminhonete, mensalistaCarro, mensalistaMoto, mensalistaCaminhonete, 
    																pernoiteCarro, pernoiteMoto, pernoiteCaminhonete, tempoBonus, validaTempoBonus);
    		
    	bancoConfig.adicionarArquivo(config);
    	
    	bancoConfig.closeFile();
    	bancoDados.closeFile();
    	bancoSaida.closeFile();
    	
    }
	
    public void saidaVeiculo(int vagaOcupada, LocalDateTime dataSaida, float valor) throws VeiculoNaoEncontradoException
    {
    	int aux;
    	boolean encontrou = false;
  
    	listaSaida.add(new VeiculoSaida(dataSaida, valor));
    	
    	for(VeiculoEstacionado veiculoAtual : listaDados)
    	{
    		if (veiculoAtual.getVagaOcupada() == vagaOcupada)
    		{
    			aux = listaDados.indexOf(veiculoAtual);
    			listaDados.remove(aux);
    			encontrou = true;
    			break;
    		}
    	}	
    	
    	if(!encontrou)
    		throw new VeiculoNaoEncontradoException();
    	
    	telaEstacionamento.dispose();
    	instanciaTelaEstacionamento();
    }    
    
    public LocalDateTime getDataEntrada(String placa)
    {
    	for(VeiculoEstacionado v : listaDados)
    	{
    		if (v.getPlaca().equals(placa))
    		{
    			return(v.getData());
    		}
    	}
    	return(null);
    }
    
//    public Date converteMili(Date entrou, Date saiu)
//    {
//    	long x;
//    	
//    	x = saiu.getTime() - entrou.getTime();
//    	
//    	//int seg = (int) (x / 1000) % 60;
//        //int min = (int) ((x / (1000 * 60)) % 60);
//        //int hor = (int) ((x / (1000 * 60 * 60)) % 24);
//        //int dia = (int) (x / (1000 * 60 * 60 * 24));
//        
//    	Calendar calendar = Calendar.getInstance();
//    	calendar.setTimeInMillis(x + 10800000);
//    	    			
//    	int ano = calendar.get(Calendar.YEAR) - 1970;
//    	int mes = calendar.get(Calendar.MONTH);
//    	//int dia = calendar.get(Calendar.DAY_OF_MONTH);
//    	int hora = calendar.get(Calendar.HOUR);
//        int min = calendar.get(Calendar.MINUTE);
//        int seg = calendar.get(Calendar.SECOND);
//    	
//        //System.out.println(dia+"/"+mes+"/"+ano+" "+hora+":"+min+":"+seg);
//    	
//    	int dia;
//    	dia = (int)x / 86400000;
//    	
//    	System.out.println(dia);
//    	
//    	return (new Date(ano, mes, dia, hora, min, seg));
//    }
    
    //HORA
    public int getAnoEstacionado(LocalDateTime entrada, LocalDateTime saida){
    	LocalDateTime fromTemp = LocalDateTime.from(entrada);
        long ano = fromTemp.until(saida, ChronoUnit.YEARS);
        fromTemp = fromTemp.plusYears(ano);
        
        return((int)ano);
    }
    
    public int getMesEstacionado(LocalDateTime entrada, LocalDateTime saida){
    	LocalDateTime fromTemp = LocalDateTime.from(entrada);
        long ano = fromTemp.until(saida, ChronoUnit.YEARS);
        fromTemp = fromTemp.plusYears(ano);

        long mes = fromTemp.until(saida, ChronoUnit.MONTHS);
        fromTemp = fromTemp.plusMonths(mes);
        
        return((int)mes);
    }
    
    public int getDiasEstacionado(LocalDateTime entrada, LocalDateTime saida){
    	LocalDateTime fromTemp = LocalDateTime.from(entrada);
        long ano = fromTemp.until(saida, ChronoUnit.YEARS);
        fromTemp = fromTemp.plusYears(ano);

        long mes = fromTemp.until(saida, ChronoUnit.MONTHS);
        fromTemp = fromTemp.plusMonths(mes);

        long dia = fromTemp.until(saida, ChronoUnit.DAYS);
        fromTemp = fromTemp.plusDays(dia);
        
        return((int)dia);
    }
    
    public int getHorasEstacionado(LocalDateTime entrada, LocalDateTime saida){
    	LocalDateTime fromTemp = LocalDateTime.from(entrada);
        long ano = fromTemp.until(saida, ChronoUnit.YEARS);
        fromTemp = fromTemp.plusYears(ano);

        long mes = fromTemp.until(saida, ChronoUnit.MONTHS);
        fromTemp = fromTemp.plusMonths(mes);

        long dia = fromTemp.until(saida, ChronoUnit.DAYS);
        fromTemp = fromTemp.plusDays(dia);

        long hora = fromTemp.until(saida, ChronoUnit.HOURS);
        fromTemp = fromTemp.plusHours(hora);
        
        return((int)hora);
    }
    
    public int getMinEstacionado(LocalDateTime entrada, LocalDateTime saida){
    	LocalDateTime fromTemp = LocalDateTime.from(entrada);
        long ano = fromTemp.until(saida, ChronoUnit.YEARS);
        fromTemp = fromTemp.plusYears(ano);

        long mes = fromTemp.until(saida, ChronoUnit.MONTHS);
        fromTemp = fromTemp.plusMonths(mes);

        long dia = fromTemp.until(saida, ChronoUnit.DAYS);
        fromTemp = fromTemp.plusDays(dia);

        long hora = fromTemp.until(saida, ChronoUnit.HOURS);
        fromTemp = fromTemp.plusHours(hora);

        long min = fromTemp.until(saida, ChronoUnit.MINUTES);
        fromTemp = fromTemp.plusMinutes(min);
        
        return((int)min);
    }
    
    public float calculaCusto(LocalDateTime entrada, LocalDateTime saida, String tipo, String pacote)
    {
    	LocalDateTime fromTemp = LocalDateTime.from(entrada);
        long ano = fromTemp.until(saida, ChronoUnit.YEARS);
        fromTemp = fromTemp.plusYears(ano);

        long mes = fromTemp.until(saida, ChronoUnit.MONTHS);
        fromTemp = fromTemp.plusMonths(mes);

        long dia = fromTemp.until(saida, ChronoUnit.DAYS);
        fromTemp = fromTemp.plusDays(dia);

        long hora = fromTemp.until(saida, ChronoUnit.HOURS);
        fromTemp = fromTemp.plusHours(hora);

        long min = fromTemp.until(saida, ChronoUnit.MINUTES);
        fromTemp = fromTemp.plusMinutes(min);
    	
    	if(pacote.equals("Hora")) //Se pacote hora
    	{
    		if(hora == 0) //Se ficou < 1 hora
    		{	
    			if(validaTempoBonus && min <= tempoBonus) //Se tem tempo bonus e se ficou < tempo bonus
    				return(0);
    			else
    			{
    				return(getCusto(tipo, pacote) * 1);
    			}
    		}
    		else
    		{
    			return(getCusto(tipo, pacote) * ((12 * 31 * 24 * ano) + (31 * 24 * mes) + (24 * dia) + hora));
    		}
    	}
    	else if(pacote.equals("Mensalista"))
    	{
    		if(dia <= 31)
    		{
    			return(getCusto(tipo, pacote) * 1);
    		}
    		else
    		{
    			int aux = (int)dia % 31;
    			if(aux != 0)
    				return(getCusto(tipo, pacote) * ((dia / 31) + 1));
    			else 
    				return(getCusto(tipo, pacote) * (dia / 31));
    				
    		}
    	}
    	else if(pacote.equals("Pernoite"))
    	{
			if(saida.getHour() < 7)
			{
				return(getCusto(tipo, pacote) * 1);
			}
			else
			{
				if(dia == 0)
				{
					return(getCusto(tipo, pacote) + (getCusto(tipo, "Hora") * ((saida.getHour() - 7) + (24 * dia) + (31 * 24 * mes) + (12 * 31 * 24 * ano))));
				}
				else
				{
					return(getCusto(tipo, "Hora") * hora);
				}
			}
    	}
    	return(-1);
    }
    
	//DE ACORDO COM O JEFF GEEETS
	
    public boolean getValidaTempoBonus(){
    	return(validaTempoBonus);
    }
    
    public int getVeiculosPeriodo(LocalDateTime entrada, LocalDateTime saida){
    	
    	int count = 0;
    	
    	for(VeiculoSaida s : listaSaida)
    	{
    		if(s != null)
    			if(s.getData().isAfter(entrada) && s.getData().isBefore(saida))
    				count++;
    	}
    	
    	return (count);
    }
    
    public float getValorPeriodo(LocalDateTime entrada, LocalDateTime saida){
    	float count = 0;
    	
    	for(VeiculoSaida s : listaSaida)
    	{
    		if(s.getData().isAfter(entrada) && s.getData().isBefore(saida))
    			count += s.getValor();
    	}
    	
    	return (count);
    }
    
    public int getCarrosEstacionados(){
    	int cont = 0;
    	for(VeiculoEstacionado v : listaDados)
    		if(v.getTipo().equals("Carro"))
    			cont++;
    	return cont;
    }
    
    public int getMotosEstacionados(){
    	int cont = 0;
    	for(VeiculoEstacionado v : listaDados)
    		if(v.getTipo().equals("Moto"))
    			cont++;
    	return cont;
    }
    
    public int getCaminhonetesEstacionados(){
    	int cont = 0;
    	for(VeiculoEstacionado v : listaDados)
    		if(v.getTipo().equals("Caminhonete"))
    			cont++;
    	return cont;
    }
    
    public int getQtdPacoteHora(){
    	int cont = 0;
    	for(VeiculoEstacionado v : listaDados)
    		if(v.getPacote().equals("Hora"))
    			cont++;
    	return cont;
    }
    
    public int getQtdPacoteMensalista(){
    	int cont = 0;
    	for(VeiculoEstacionado v : listaDados)
    		if(v.getPacote().equals("Mensalista"))
    			cont++;
    	return cont;
    }
    
    public int getQtdPacotePernoite(){
    	int cont = 0;
    	for(VeiculoEstacionado v : listaDados)
    		if(v.getPacote().equals("Pernoite"))
    			cont++;
    	return cont;
    }
    
    public int getTempoBonus(){
    	return(tempoBonus);
    }
    
    public int getNumeroVeiculos(){
    	return(listaDados.size());
    }
    
    public float getCusto(String tipo, String pacote)
    {   
    	if(tipo.equals("Carro"))
    	{
    		if(pacote.equals("Hora"))
    		{
    			return(horaCarro);
    		}
			else if(pacote.equals("Mensalista"))
			{
				return(mensalistaCarro);
			}
    		else if(pacote.equals("Pernoite"))
			{
    			return(pernoiteCarro);
			}
    	}
    	else if(tipo.equals("Moto"))
    	{
    		if(pacote.equals("Hora"))
    		{
    			return(horaMoto);
    		}
			else if(pacote.equals("Mensalista"))
			{
				return(mensalistaMoto);
			}
    		else if(pacote.equals("Pernoite"))
			{
    			return(pernoiteMoto);
			}
    	}
    	else if(tipo.equals("Caminhonete"))
    	{
    		if(pacote.equals("Hora"))
    			return(horaCaminhonete);
    		else if(pacote.equals("Mensalista"))
    			return(mensalistaCaminhonete);
    		else if(pacote.equals("Pernoite"))
    			return(pernoiteCaminhonete);
    	}
    	
    	return(-1);
    }
	
    //DE ACORDO COM O JEFF GEEETS
}