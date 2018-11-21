import javax.swing.JFrame;

public class Estacionamento extends JFrame{
	
	int vagas[] = new int[200];
	
	public void zeraVagas()
	{
		for(int i = 0; i < 200; i++)
		{
			vagas[i] = 0;
		}
	}
	
	public int disponibilidade (String tipo)
	{
		int i = 0, fim = 0;
		
		// SETA INICIO E FIM DO LOOP
		if(tipo.equals("carro")) 
		{
			i = 0;
			fim = 160;
		}
		else if (tipo.equals("caminhotene"))
		{
			i = 160;
			fim = 180;
		}
		else if (tipo.equals("moto"))
		{
			i = 180;
			fim = 200;
		}
		
		// LOOP PROCURA DISPONIVEL
		while(vagas[i] == 1 && (i < fim))
		{
			i++;
		}
		
		if(i == fim) return -1;
		return i;
	
	}
	
	public int ocuparVagaCarro(int posi)
	{
		vagas[posi] = 1;
		
		return 1;
	}
	
}
