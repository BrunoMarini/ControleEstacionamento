package estacionamento;

import java.io.Serializable;

public class Data implements Serializable{

	private int dia, mes, ano, hora, min, seg;
	
	public Data(int dia, int mes, int ano, int hora, int min, int seg){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.hora = hora;
		this.min = min;
		this.seg = seg;
	}
}
