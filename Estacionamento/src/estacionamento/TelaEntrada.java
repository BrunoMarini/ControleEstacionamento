package estacionamento;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class TelaEntrada extends JFrame{
    
    
    private JLabel titulo;
    private JLabel imagem;
    private JLabel msgPlaca;
    private JTextField placa;
    private JLabel msgModelo;
    private JTextField modelo;
    private JLabel msgTipo;
    private JComboBox tipo;
    private JLabel pacote;
    private JRadioButton hora;
    private JRadioButton mensalista;
    private JRadioButton pernoite;
    private ButtonGroup radioGroup;
    private JButton cadastrar;
    private JButton cancelar;
    
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
        titulo = new JLabel("Entrada de Veículos", (int)CENTER_ALIGNMENT);
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
        
        p[1][0].add(new JPanel());//
        
        p[1][0].add(msgPlaca);//
        p[1][0].add(msgModelo);//
        p[1][0].add(new JPanel());//
        
        p[1][0].add(new JPanel());
        p[1][0].add(placa);
        p[1][0].add(modelo);
        p[1][0].add(new JPanel());
        
        p[2][0].setLayout(new GridLayout(2, 4));
        
        p[2][0].add(new JPanel());
        p[2][0].add(new JPanel());
        p[2][0].add(new JPanel());
        p[2][0].add(new JPanel());
        p[2][0].add(new JPanel());
        
        p[2][0].add(msgTipo);
        p[2][0].add(tipo);
        
        p[2][0].add(new JPanel());
        
        
        p[3][0].setLayout(new GridLayout(1, 1));
        
        pacote = new JLabel("Tipo de Pacote: ", (int)CENTER_ALIGNMENT);
        pacote.setFont(new Font("Century", Font.PLAIN, 25));
        
        hora = new JRadioButton("Hora", true);
        hora.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        hora.setFont(new Font("Arial", Font.PLAIN, 20));
        
        mensalista = new JRadioButton("Mensalista", false);
        mensalista.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        mensalista.setFont(new Font("Arial", Font.PLAIN, 20));
        
        pernoite = new JRadioButton("Pernoite", false);
        pernoite.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        pernoite.setFont(new Font("Arial", Font.PLAIN, 20));
        
        p[3][0].add(pacote);
        
        p[4][0].setLayout(new GridLayout(1, 3));
        
        p[4][0].add(hora);
        p[4][0].add(mensalista);
        p[4][0].add(pernoite);
     
        radioGroup = new ButtonGroup();
        radioGroup.add(hora);
        radioGroup.add(mensalista);
        radioGroup.add(pernoite);
        
        hora.addItemListener(
            new RadioButtonHandler(0));
        mensalista.addItemListener(
            new RadioButtonHandler(1));
        pernoite.addItemListener(
            new RadioButtonHandler(2));
        
        p[5][0].setLayout(new GridLayout(1,4));
        cadastrar = new JButton("Cadastrar");
        cancelar = new JButton("Cancelar");
        
        cancelar.addActionListener(list);
        cadastrar.addActionListener(list);
        
        p[5][0].add(cancelar);
        p[5][0].add(cadastrar);
        
    }
    
    private class RadioButtonHandler implements ItemListener
    {        
        public RadioButtonHandler(int i)
        {
            switch(i)
            {
                case 0:
                   tipoPacote = "Hora";
                break;
                case 1:
                    tipoPacote = "Mensalista";
                break;
                case 2:
                    tipoPacote = "Pernoite";
                break;
            }
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    private class Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == cancelar)
                dispose();
            else if(e.getSource() == cadastrar)
            {
                SistemaEstacionamento sis = SistemaEstacionamento.getInstance();
                sis.EntradaVeiculo(placa.getText(), modelo.getText(), tipoVeiculo, tipoPacote);
            }
        }
    }
}
