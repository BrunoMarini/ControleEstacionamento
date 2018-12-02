package estacionamento;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.*;

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
	private SistemaEstacionamento sis = SistemaEstacionamento.getInstance();
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
    private JTextField leHoraSaida;
    private JLabel msgHoraSaida;
    private JTextField leDataSaida;
    
    private LocalDateTime entrou, saiu;
    private float valor;
    private int vagaOcupada;
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
        
        Listener list = new Listener();
        
        p[0][0].setLayout(new GridLayout(1, 1));
        titulo = new JLabel("Retirada de veiculo", (int)CENTER_ALIGNMENT);
        titulo.setFont(new Font("Century", Font.PLAIN, 35));
        p[0][0].add(titulo);
        
        p[1][0].setLayout(new GridLayout(2, 3));
        msgHoraSaida = new JLabel("Hora/Data saida", (int)CENTER_ALIGNMENT);
        msgHoraSaida.setFont(new Font("Arial", Font.PLAIN, 16));
        
        leHoraSaida = new JTextField("hh:mm");
        leHoraSaida.setHorizontalAlignment(JTextField.CENTER);
        leHoraSaida.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				leHoraSaida.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {	
				if(leHoraSaida.getText().equals(""))
					leHoraSaida.setText("hh:mm");
			}
        });
        
        p[1][0].add(msgHoraSaida);
        p[1][0].add(leHoraSaida);
        
        leDataSaida = new JTextField("DD/MM/AAAA");
        leDataSaida.setHorizontalAlignment(JTextField.CENTER);
        leDataSaida.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				leDataSaida.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {	
				if(leDataSaida.getText().equals(""))
					leDataSaida.setText("DD/MM/AAAA");
			}
        });
        
        p[1][0].add(leDataSaida);
        msgPlaca = new JLabel("Digite o codigo", (int)CENTER_ALIGNMENT);
        msgPlaca.setFont(new Font("Arial", Font.PLAIN, 16));
        codigo = new JTextField();
        codigo.setHorizontalAlignment(JTextField.CENTER);
        verifica = new JButton("Verificar");
        verifica.addActionListener(list);
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
        placa.setFont(new Font("Arial", Font.PLAIN, 16));
        modelo = new JLabel("Modelo", (int)CENTER_ALIGNMENT);
        modelo.setFont(new Font("Arial", Font.PLAIN, 16));
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
        cancelar.addActionListener(list);
        confirmar.addActionListener(list);
        p[8][0].add(cancelar);
        p[8][0].add(confirmar);
        
        
        
    }
    
    public class Listener implements ActionListener
    {
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			if(event.getSource() == cancelar)
			{
				dispose();
			}
			else if (event.getSource() == confirmar)
			{
				sis.saidaVeiculo(vagaOcupada, saiu, valor);
				dispose();
			}
			else if (event.getSource() == verifica)
			{	
				int dia, mes, ano, hora, min;
				
            	ano = Integer.parseInt(leDataSaida.getText().substring(6, 10));
            	mes = Integer.parseInt(leDataSaida.getText().substring(3, 5));
            	dia = Integer.parseInt(leDataSaida.getText().substring(0, 2));
            	
            	hora = Integer.parseInt(leHoraSaida.getText().substring(0, 2));
            	min = Integer.parseInt(leHoraSaida.getText().substring(3, 5));
				
            	saiu = LocalDateTime.of(ano, mes, dia, hora, min);
            	
				for(VeiculoEstacionado v : sis.listaDados)
				{					
					if(v.getPlaca().equals(codigo.getText()))
					{
						vagaOcupada = v.getVagaOcupada();
						
						entrou = sis.getDataEntrada(codigo.getText());
						
						valor = sis.calculaCusto(entrou, saiu, v.getTipo(), v.getPacote());
						
						String aux = Integer.toString(sis.getDiasEstacionado(entrou, saiu)) +" Dia(s) "+ 
									 Integer.toString(sis.getMesEstacionado(entrou, saiu)) + " Mese(s) "+
									 Integer.toString(sis.getAnoEstacionado(entrou, saiu)) +" Ano(s) "+
									 Integer.toString(sis.getHorasEstacionado(entrou, saiu)) +" Hora(s) "+
									 Integer.toString(sis.getMinEstacionado(entrou, saiu)) +" Minuto(s) ";
									 
														; 
						
						placaVeiculo.setText(v.getPlaca());
						modeloVeiculo.setText(v.getModelo());
						dataEntrada.setText(entrou.toString());
						dataSaida.setText(saiu.toString());
						tempo.setText(aux);
						custo.setText(Float.toString(valor));
					}
						
				}
			}
		}
    	
    }
}
