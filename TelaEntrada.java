package estacionamento;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
        
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
			Date date = isoFormat.parse("2010-05-23T09:01:02");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
        
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
        placa.setHorizontalAlignment(JTextField.CENTER);
        
        msgModelo = new JLabel("Modelo", (int)CENTER_ALIGNMENT);
        msgModelo.setFont(new Font("Arial", Font.PLAIN, 15));
        modelo = new JTextField();
        modelo.setHorizontalAlignment(JTextField.CENTER);
        
        msgTipo = new JLabel("Tipo de veiculo:", (int) CENTER_ALIGNMENT);
        msgTipo.setFont(new Font("Arial", Font.PLAIN, 15));
        
        msgData = new JLabel("Data entrada", (int)CENTER_ALIGNMENT);
        msgData.setFont(new Font("Arial", Font.PLAIN, 15));
        
        data = new JTextField("DD/MM/AAAA");
        data.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				data.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {	
				if(data.getText().equals(""))
					data.setText("DD/MM/AAAA");
			}
        });
  
        data.setHorizontalAlignment(JTextField.CENTER);
        msgHora = new JLabel("Horario de entrada", (int)CENTER_ALIGNMENT);
        msgHora.setFont(new Font("Arial", Font.PLAIN, 15));
        
        hora = new JTextField(8);
        hora.setText("hh:mm:ss");
        hora.setHorizontalAlignment(JTextField.CENTER);
        hora.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				hora.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(hora.getText().equals(""))
					hora.setText("hh:mm:ss");
			}
        });
        
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
            	int dia, mes, ano, hor, min, seg;
            	
            	ano = Integer.parseInt(data.getText().substring(6, 10));
            	mes = Integer.parseInt(data.getText().substring(3, 5));
            	dia = Integer.parseInt(data.getText().substring(0, 2));
            	
            	hor = Integer.parseInt(hora.getText().substring(0, 2));
            	min = Integer.parseInt(hora.getText().substring(3, 5));
            	seg = Integer.parseInt(hora.getText().substring(6, 8)); 	
          
//            	Parameters:
//            		year the year minus 1900.
//            		month the month between 0-11.
//            		date the day of the month between 1-31.
//            		hrs the hours between 0-23.
//            		min the minutes between 0-59.
//            		sec the seconds between 0-59.
//            	
            	Date d = new Date(ano - 1900, mes - 1, dia, hor, min, seg);
            	
                SistemaEstacionamento sis = SistemaEstacionamento.getInstance();
                System.out.println(placa.getText()+modelo.getText()+tipoVeiculo+tipoPacote+d);
                sis.entradaVeiculo(placa.getText(), modelo.getText(), tipoVeiculo, tipoPacote, d);
                
                dispose();
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
