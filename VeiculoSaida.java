package estacionamento;

import java.io.Serializable;
import java.util.Date;

public class VeiculoSaida implements Serializable{
	private Date dataSaida;
	private float valor;
	
	public VeiculoSaida(Date dataSaida, float valor)
	{
		this.dataSaida = dataSaida;
		this.valor = valor;
	}
}
