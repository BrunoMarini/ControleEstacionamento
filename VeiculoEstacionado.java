package estacionamento;

public class VeiculoEstacionado
{
    private String placa;
    private String modelo;
    private String tipoVeiculo;
    private String pacote;
    
    public VeiculoEstacionado(String placa, String modelo, String tipoVeiculo, String pacote)
    {
        this.placa = placa;
        this.modelo = modelo;
        this.tipoVeiculo = tipoVeiculo;
        this.pacote = pacote;
    }
    
    public String getPlaca(){
        return(placa);
    }
    
    public String getModelo(){
        return(modelo);
    }
    
    public String getTipoVeiculo(){
        return(tipoVeiculo);
    }
    
    public String getPacote(){
        return(pacote);
    }
}
