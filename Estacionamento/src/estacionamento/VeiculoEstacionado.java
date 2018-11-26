package estacionamento;

import java.io.Serializable;

public class VeiculoEstacionado implements Serializable
{
    private String placa;
    private String modelo;
    private String pacote;
    private int vagaOcupada;
    
    public VeiculoEstacionado(String placa, String modelo, String pacote, int vagaOcupada)
    {
        this.placa = placa;
        this.modelo = modelo;
        this.pacote = pacote;
        this.vagaOcupada = vagaOcupada;
               
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
}
