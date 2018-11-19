package estacionamento;

public class VeiculoEstacionado extends FrameEstacionamento
{
    private String placa;
    private String modelo;
    private String pacote;
    private int vagaOcupada;
    private boolean ocupado;
    
    public VeiculoEstacionado(String placa, String modelo, String pacote)
    {
        this.placa = placa;
        this.modelo = modelo;
        this.pacote = pacote;
        ocupado = true;
        
        if(modelo.equals("Carro"))     
            vagaOcupada = OcuparVagaCarro();
        else if(modelo.equals("Moto"))
            vagaOcupada = OcuparVagaMoto();
        else if(modelo.equals("Caminhonete"))
            vagaOcupada = OcuparVagaCaminhonete();
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
    
    public boolean getOcupado(){
        return(ocupado);
    }
}
