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
    private JTextField praca;
    private JLabel msgPlaca;
    private JTextField placa;
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
    
    int i;
    
    public TelaSaida()
    {
        super("Saida");
        setLayout(new GridLayout(7, 1));
        JPanel[][] p = new JPanel[7][1];
        
        for(i = 0; i < 7; i++){
            p[i][0] = new JPanel();
            add(p[i][0]);
        }
        
        p[0][0].setLayout(new GridLayout(1, 2));
        titulo = new JLabel("Retirada de veiculo", (int)CENTER_ALIGNMENT);
        titulo.setFont(new Font("Century", Font.PLAIN, 35));
        praca = new JTextField("Placa do veículo");
        praca.setEditable(false);
        praca.setHorizontalAlignment(JTextField.CENTER);
        p[0][0].add(titulo);
        p[0][0].add(praca);
        
        p[1][0].setLayout(new GridLayout(2, 3));
        p[1][0].add(new JPanel());
        p[1][0].add(new JPanel());
        p[1][0].add(new JPanel());
        msgPlaca = new JLabel("Digite o codigo", (int)CENTER_ALIGNMENT);
        msgPlaca.setFont(new Font("Arial", Font.PLAIN, 16));
        placa = new JTextField();
        placa.setHorizontalAlignment(JTextField.CENTER);
        verifica = new JButton("Verificar");
        p[1][0].add(msgPlaca);
        p[1][0].add(placa);
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
        cancelar = new JButton("Cancelar");
        confirmar = new JButton("Confirmar");
        p[6][0].add(cancelar);
        p[6][0].add(confirmar);
        
        
        
        
        
        
        
    }
}
