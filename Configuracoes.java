package estacionamento;

import java.io.Serializable;

public class Configuracoes implements Serializable
{
	private float horaCarro;
	private float horaMoto;
	private float horaCaminhonete;
    
	private float mensalistaCarro;
	private float mensalistaMoto;
	private float mensalistaCaminhonete;
    
	private float pernoiteCarro;
	private float pernoiteMoto;
	private float pernoiteCaminhonete;
    
    private int tempoBonus;
    private boolean valida;
	
	public Configuracoes(float horaCarro, float horaMoto, float horaCaminhonete, float mensalistaCarro, float mensalistaMoto, float mensalistaCaminhonete, float pernoiteCarro, float pernoiteMoto, float pernoiteCaminhonete, int tempoBonus, boolean valida)
	{
		this.horaCarro = horaCarro;
		this.horaMoto = horaMoto;
		this.horaCaminhonete = horaCaminhonete;
	    
		this.mensalistaCarro = mensalistaCarro;
		this.mensalistaMoto = mensalistaMoto;
		this.mensalistaCaminhonete = mensalistaCaminhonete;
	    
		this.pernoiteCarro = pernoiteCarro;
		this.pernoiteMoto = pernoiteMoto;
		this.pernoiteCaminhonete = pernoiteCaminhonete;
	    
	    this.tempoBonus = tempoBonus;
	    this.valida = valida;
	}

	public float getHoraCarro() {
		return horaCarro;
	}

	public float getHoraMoto() {
		return horaMoto;
	}

	public float getHoraCaminhonete() {
		return horaCaminhonete;
	}

	public float getMensalistaCarro() {
		return mensalistaCarro;
	}

	public float getMensalistaMoto() {
		return mensalistaMoto;
	}

	public float getMensalistaCaminhonete() {
		return mensalistaCaminhonete;
	}

	public float getPernoiteCarro() {
		return pernoiteCarro;
	}

	public float getPernoiteMoto() {
		return pernoiteMoto;
	}

	public float getPernoiteCaminhonete() {
		return pernoiteCaminhonete;
	}

	public int getTempoBonus() {
		return tempoBonus;
	}

	public boolean isValida() {
		return valida;
	}
	
}
