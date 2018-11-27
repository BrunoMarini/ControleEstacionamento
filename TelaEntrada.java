package estacionamento;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TelaEntrada extends JFrame
{
    
    private JLabel titulo;
    private JLabel imagem;
    private JLabel msgPlaca;
    private JTextField placa;
    private JLabel msgModelo;
    private JTextField modelo;
    private JLabel msgTipo;
    private JComboBox tipo;
    private JLabel pacote;
    private JRadioButton horaB;
    private JRadioButton mensalista;
    private JRadioButton pernoite;
    private ButtonGroup radioGroup;
    private JButton cadastrar;
    private JButton cancelar;
    private JLabel msgData;
    private JTextField data;
    private JLabel msgHora;
    private JTextField hora;

    
    private static final String[] tipos = {"", "Moto", "Carro", "Caminhonete"}; 
    int i, x;
    String tipoPacote, tipoVeiculo;
    
    public TelaEntrada()
    {
        
        super("Entrada");
        Listener list = new Listener();
        setLayout(new GridLayout(6, 1));
        JPanel[][] p = new JPanel[6][1];
        
        Icon parada      = new ImageIcon(getClass().getResource("p.png"));
        Icon moto        = new ImageIcon(getClass().getResource("moto.png"));
        Icon carro       = new ImageIcon(getClass().getResource("carro.png"));
        Icon caminhonete = new ImageIcon(getClass().getResource("caminhonete.png"));
        
       
        for(i = 0; i < 6; i++){
            p[i][0] = new JPanel();
            add(p[i][0]);
        }
        
        p[0][0].setLayout(new GridLayout(1, 2));
        titulo = new JLabel("Entrada de Veiculos", (int)CENTER_ALIGNMENT);
        titulo.setFont(new Font("Century", Font.PLAIN, 35));
        imagem = new JLabel("", (int)CENTER_ALIGNMENT);
        imagem.setIcon(parada);
        
        p[0][0].add(titulo);
        p[0][0].add(imagem);
        
        p[1][0].setLayout(new GridLayout(2, 4));
        
        msgPlaca = new JLabel("Placa", (int) CENTER_ALIGNMENT);
        msgPlaca.setFont(new Font("Arial", Font.PLAIN, 15));
        placa = new JTextField();
        msgModelo = new JLabel("Modelo", (int)CENTER_ALIGNMENT);
        msgModelo.setFont(new Font("Arial", Font.PLAIN, 15));
        modelo = new JTextField();
        msgTipo = new JLabel("Tipo de veiculo:", (int) CENTER_ALIGNMENT);
        msgTipo.setFont(new Font("Arial", Font.PLAIN, 15));
        
        msgData = new JLabel("Data entrada", (int)CENTER_ALIGNMENT);
        msgData.setFont(new Font("Arial", Font.PLAIN, 15));
        data = new JTextField("DD/MM/AAAA");
        data.setHorizontalAlignment(JTextField.CENTER);
        msgHora = new JLabel("Horario de entrada", (int)CENTER_ALIGNMENT);
        msgHora.setFont(new Font("Arial", Font.PLAIN, 15));
        hora = new JTextField(8);
        hora.setText("hh:mm:ss");
        hora.setHorizontalAlignment(JTextField.CENTER);
        
        tipo = new JComboBox(tipos);
        tipo.setMaximumRowCount(4);
        
        tipo.addItemListener(
                new ItemListener()
                {
                    @Override
                    public void itemStateChanged(ItemEvent e)
                    {
                        if(e.getStateChange() == ItemEvent.SELECTED)
                            x = tipo.getSelectedIndex();
                        
                        switch(x){
                            case 0:
                                imagem.setIcon(parada);
                            break;
                            case 1:
                                imagem.setIcon(moto);
                                tipoVeiculo = "Moto";
                            break;
                            case 2:
                                imagem.setIcon(carro);
                                tipoVeiculo = "Carro";
                            break;
                            case 3:
                                imagem.setIcon(caminhonete);
                                tipoVeiculo = "Caminhonete";
                            break;
                        }
                    }
                });
                
        p[1][0].add(msgPlaca);//
        p[1][0].add(msgModelo);//
        p[1][0].add(new JPanel());//
        p[1][0].add(new JPanel());//
        
        p[1][0].add(placa);
        p[1][0].add(modelo);
        p[1][0].add(msgHora);
        p[1][0].add(hora);
        
        p[2][0].setLayout(new GridLayout(2, 4));
        
        p[2][0].add(new JPanel());
        p[2][0].add(new JPanel());
        p[2][0].add(new JPanel());
        p[2][0].add(new JPanel());
        
        p[2][0].add(msgTipo);
        p[2][0].add(tipo);
        p[2][0].add(msgData);
        p[2][0].add(data);
        
        p[3][0].setLayout(new GridLayout(1, 1));
        
        pacote = new JLabel("Tipo de Pacote: ", (int)CENTER_ALIGNMENT);
        pacote.setFont(new Font("Century", Font.PLAIN, 25));
        
        horaB = new JRadioButton("Hora", true);
        horaB.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        horaB.setFont(new Font("Arial", Font.PLAIN, 20));
        tipoPacote = "Hora";
        
        mensalista = new JRadioButton("Mensalista", false);
        mensalista.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        mensalista.setFont(new Font("Arial", Font.PLAIN, 20));
        
        pernoite = new JRadioButton("Pernoite", false);
        pernoite.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        pernoite.setFont(new Font("Arial", Font.PLAIN, 20));
        
        p[3][0].add(pacote);
        
        p[4][0].setLayout(new GridLayout(1, 3));
        
        /*hora.addItemListener(
            new RadioButtonHandler(0));
        mensalista.addItemListener(
            new RadioButtonHandler(1));
        pernoite.addItemListener(
            new RadioButtonHandler(2));*/
        
        
        p[4][0].add(horaB);
        p[4][0].add(mensalista);
        p[4][0].add(pernoite);
        
        radioGroup = new ButtonGroup();
        radioGroup.add(horaB);
        radioGroup.add(mensalista);
        radioGroup.add(pernoite);
        
        p[5][0].setLayout(new GridLayout(1,4));
        cadastrar = new JButton("Cadastrar");
        cancelar = new JButton("Cancelar");
        
        cancelar.addActionListener(list);
        cadastrar.addActionListener(list);
        
        horaB.addActionListener(list);
        mensalista.addActionListener(list);
        pernoite.addActionListener(list);
        
        p[5][0].add(cancelar);
        p[5][0].add(cadastrar);
        
    }
        
    private class Listener implements ActionListener //TO MEXENDO AQUUIIIIIII PRA VOCÊ LEMBRAR BRUNO SEU IDIOTA DATA
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == cancelar)
                dispose();
            else if(e.getSource() == cadastrar)
            {
            	int dia, mes, ano, hora, min, seg;
            	
            	ano = Integer.parseInt(data.getText().substring(6, 10)); //AQUIIIIIIIIIII
            	System.out.println(ano);
            	
            	//LocalDateTime d = new Date();
            	
            	//System.out.println(d);
            	
                SistemaEstacionamento sis = SistemaEstacionamento.getInstance();
                sis.EntradaVeiculo(placa.getText(), modelo.getText(), tipoVeiculo, tipoPacote, 1);
            }

            
            else if(e.getSource() == horaB)
            {
                tipoPacote = "Hora";
            }
            
            else if(e.getSource() == mensalista)
            {
                tipoPacote = "mensalista";
            }
            
            else if(e.getSource() == pernoite)
            {
                tipoPacote = "Pernoite";
            }
            
        }
    }
}
