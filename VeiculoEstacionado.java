package estacionamento;

import java.io.Serializable;
import java.util.Date;

public class VeiculoEstacionado implements Serializable
{
    private String placa;
    private String modelo;
    private String pacote;
    private int vagaOcupada;
    private int entrada;
    private Date data;
    
    public VeiculoEstacionado(String placa, String modelo, String pacote, int vagaOcupada, java.util.Date d)
    {
        this.placa = placa;
        this.modelo = modelo;
        this.pacote = pacote;
        this.vagaOcupada = vagaOcupada;
        this.entrada = entrada;
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
    
    public int getVagaOcupada(){
        return(vagaOcupada);
    }
    
    public int getEntrada(){
    	return(entrada);
    }
    
    public Date getData(){
    	return(data);
    }
}
