package estacionamento;

public class Estacionamento {

    public static void main(String[] args) 
    {

       SistemaEstacionamento sistema = SistemaEstacionamento.getInstance();
       sistema.inicializar();
    }
}