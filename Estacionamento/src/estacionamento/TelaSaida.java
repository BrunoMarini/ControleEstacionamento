package estacionamento;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class TelaSaida extends JFrame
{
    private JLabel titulo;
    private JTextField placaVeiculo;
    private JTextField modeloVeiculo;
    private JLabel msgPlaca;
    private JTextField codigo;
    private JButton verifica;
    private JLabel msgEntrada;
    private JLabel msgSaida;
    private JTextField dataEntrada;
    private JTextField dataSaida;
    private JLabel msgTempo;
    private JLabel msgCusto;
    private JTextField tempo;
    private JTextField custo;
    private JButton cancelar;
    private JButton confirmar;
    private JLabel placa;
    private JLabel modelo;
    
    int i;
    
    public TelaSaida()
    {
        super("Saida");
        setLayout(new GridLayout(9, 1));
        JPanel[][] p = new JPanel[9][1];
        
        for(i = 0; i < 9; i++){
            p[i][0] = new JPanel();
            add(p[i][0]);
        }
        
        p[0][0].setLayout(new GridLayout(1, 1));
        titulo = new JLabel("Retirada de veiculo", (int)CENTER_ALIGNMENT);
        titulo.setFont(new Font("Century", Font.PLAIN, 35));
        p[0][0].add(titulo);
        
        p[1][0].setLayout(new GridLayout(2, 3));
        p[1][0].add(new JPanel());
        p[1][0].add(new JPanel());
        p[1][0].add(new JPanel());
        msgPlaca = new JLabel("Digite o codigo", (int)CENTER_ALIGNMENT);
        msgPlaca.setFont(new Font("Arial", Font.PLAIN, 16));
        codigo = new JTextField();
        codigo.setHorizontalAlignment(JTextField.CENTER);
        verifica = new JButton("Verificar");
        p[1][0].add(msgPlaca);
        p[1][0].add(codigo);
        p[1][0].add(verifica);
        
        p[2][0].setLayout(new GridLayout(1, 2));
        msgEntrada = new JLabel("Entrada", (int)CENTER_ALIGNMENT);
        msgEntrada.setFont(new Font("Arial", Font.PLAIN, 16));
        msgSaida = new JLabel("Saida", (int)CENTER_ALIGNMENT);
        msgSaida.setFont(new Font("Arial", Font.PLAIN, 16));
        p[2][0].add(msgEntrada);
        p[2][0].add(msgSaida);
        
        p[3][0].setLayout(new GridLayout(1, 2));
        dataEntrada = new JTextField();
        dataEntrada.setHorizontalAlignment(JTextField.CENTER);
        dataEntrada.setEditable(false);
        dataSaida = new JTextField();
        dataSaida.setHorizontalAlignment(JTextField.CENTER);
        dataSaida.setEditable(false);
        p[3][0].add(dataEntrada);
        p[3][0].add(dataSaida);
        
        p[4][0].setLayout(new GridLayout(1, 2));
        msgTempo = new JLabel("Permanencia", (int)CENTER_ALIGNMENT);
        msgTempo.setFont(new Font("Arial", Font.PLAIN, 16));
        msgCusto = new JLabel("Custo total", (int)CENTER_ALIGNMENT);
        msgCusto.setFont(new Font("Arial", Font.PLAIN, 16));
        p[4][0].add(msgTempo);
        p[4][0].add(msgCusto);
        
        p[5][0].setLayout(new GridLayout(1, 2));
        tempo = new JTextField();
        tempo.setHorizontalAlignment(JTextField.CENTER);
        tempo.setEditable(false);
        custo = new JTextField();
        custo.setHorizontalAlignment(JTextField.CENTER);
        custo.setEditable(false);
        p[5][0].add(tempo);
        p[5][0].add(custo);
        
        p[6][0].setLayout(new GridLayout(1, 2));
        placa = new JLabel("Placa", (int)CENTER_ALIGNMENT);
        modelo = new JLabel("Modelo", (int)CENTER_ALIGNMENT);
        p[6][0].add(placa);
        p[6][0].add(modelo);
        
        p[7][0].setLayout(new GridLayout(1, 2));
        placaVeiculo = new JTextField();
        placaVeiculo.setEditable(false);
        placaVeiculo.setHorizontalAlignment(JTextField.CENTER);
        modeloVeiculo = new JTextField();
        modeloVeiculo.setEditable(false);
        modeloVeiculo.setHorizontalAlignment(JTextField.CENTER);
        
        p[7][0].add(placaVeiculo);
        p[7][0].add(modeloVeiculo);
        
        p[8][0].setLayout(new GridLayout(1, 2));
        cancelar = new JButton("Cancelar");
        confirmar = new JButton("Confirmar");
        p[8][0].add(cancelar);
        p[8][0].add(confirmar);
    }
}
