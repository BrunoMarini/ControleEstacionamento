package estacionamento;

import java.io.Serializable;
import java.time.*;

public class VeiculoSaida implements Serializable{
	
	private LocalDateTime dataSaida;
	private float valor;
	
	public VeiculoSaida(LocalDateTime dataSaida, float valor)
	{
		this.dataSaida = dataSaida;
		this.valor = valor;
	}
	
	public LocalDateTime getData(){
		return(dataSaida);
	}
	
	public float getValor(){
		return(valor);
	}
}
