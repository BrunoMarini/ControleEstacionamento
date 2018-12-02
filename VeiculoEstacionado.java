package estacionamento;

import java.io.Serializable;
import java.util.Date;

public class VeiculoEstacionado implements Serializable
{
    private String placa;
    private String modelo;
    private String pacote;
    private String tipo;
    private int vagaOcupada;
    private Date data;
    
    public VeiculoEstacionado(String placa, String modelo, String pacote, String tipo, int vagaOcupada, Date d)
    {
        this.placa = placa;
        this.modelo = modelo;
        this.pacote = pacote;
        this.tipo = tipo;
        this.vagaOcupada = vagaOcupada;
        this.data = (Date) d;
    }
    
    public String getPlaca(){
        return(placa);
    }
    
    public String getModelo(){
        return(modelo);
    }
    
    public String getPacote(){
        return(pacote);
    }
    
    public String getTipo(){
    	return(tipo);
    }
    
    public int getVagaOcupada(){
        return(vagaOcupada);
    }
    
    public Date getData(){
    	return((Date)data);
    }
}
