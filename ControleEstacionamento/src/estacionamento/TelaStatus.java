package estacionamento;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class TelaStatus extends JFrame
{
    private JLabel title;
    private JLabel carros;
    private JLabel motos;
    private JLabel caminhonetes;
    private JLabel hora;
    private JLabel mensalista;
    private JLabel pernoite;
    private JTextField estacionadosHora;
    private JTextField estacionadosMensalista;
    private JTextField estacionadosPernoite;
    private JTextField carrosEstacionados;
    private JTextField motosEstacionados;
    private JTextField caminhonetesEstacionados;
    private JButton checar;
    private JLabel msgDataEntrada;
    private JLabel msgDataSaida;
    private JTextField dataEntrada;
    private JTextField dataSaida;
    private JButton verificar;
    private JTextField resultado;
    
    SistemaEstacionamento sis = SistemaEstacionamento.getInstance();
    
    int i;
    
    public TelaStatus()
    {
        super("Status");
        
        setLayout(new GridLayout(3, 1));
        
        JPanel[][] p = new JPanel[3][1];
        for(i = 0; i < 3; i++){
            p[i][0] = new JPanel();
            add(p[i][0]);
        }
        
        TitledBorder tituloVagas = new TitledBorder("Vagas Ocupadas");
        TitledBorder tituloEstacionados = new TitledBorder("Estacionados");
        TitledBorder tituloPacotes = new TitledBorder("Pacotes Selecionados");
        TitledBorder tituloLucro = new TitledBorder("Lucro por tempo");
        
        Listener list = new Listener();
        
        Icon parada = new ImageIcon(getClass().getResource("p.png"));
        
        p[0][0].setLayout(new GridLayout(1, 1));
        title = new JLabel("Status do Estacionamento", (int)CENTER_ALIGNMENT);
        title.setFont(new Font("Century", Font.PLAIN, 35));
        p[0][0].add(title);
        
        p[1][0].setLayout(new GridLayout(1, 2));
        JPanel vagas = new JPanel();
        vagas.setLayout(new GridLayout(3, 2));
        vagas.setBorder(tituloVagas);
        
        carros = new JLabel("Carros", (int)CENTER_ALIGNMENT);
        motos = new JLabel("Motos", (int)CENTER_ALIGNMENT);
        caminhonetes = new JLabel("Caminhonetes", (int)CENTER_ALIGNMENT);
        carrosEstacionados = new JTextField(Integer.toString(sis.getCarrosEstacionados()));
        carrosEstacionados.setHorizontalAlignment(JTextField.CENTER);
        carrosEstacionados.setEditable(false);
        motosEstacionados = new JTextField(Integer.toString(sis.getMotosEstacionados()));
        motosEstacionados.setEditable(false);
        motosEstacionados.setHorizontalAlignment(JTextField.CENTER);
        caminhonetesEstacionados = new JTextField(Integer.toString(sis.getCaminhonetesEstacionados()));
        caminhonetesEstacionados.setEditable(false);
        caminhonetesEstacionados.setHorizontalAlignment(JTextField.CENTER);
        
        vagas.add(motos);
        vagas.add(motosEstacionados);
        vagas.add(carros);
        vagas.add(carrosEstacionados);
        vagas.add(caminhonetes);
        vagas.add(caminhonetesEstacionados);
                
        p[1][0].add(vagas);
        
        JPanel estacionados = new JPanel();
        estacionados.setLayout(new GridLayout(3, 1));
        estacionados.add(new JPanel());
        estacionados.setBorder(tituloEstacionados);
        checar = new JButton("Verificar veiculos estacionados");
        checar.addActionListener(list);
        estacionados.add(checar);
        estacionados.add(new JPanel());
        
        p[1][0].add(estacionados);
        
        p[2][0].setLayout(new GridLayout(1, 2));
        JPanel pacotes = new JPanel();
        pacotes.setLayout(new GridLayout(3, 1));
        pacotes.setBorder(tituloPacotes);
        hora = new JLabel("Hora", (int)CENTER_ALIGNMENT);
        mensalista = new JLabel("Mensalista", (int)CENTER_ALIGNMENT);
        pernoite = new JLabel("Pernoite", (int)CENTER_ALIGNMENT);
        estacionadosHora = new JTextField(Integer.toString(sis.getQtdPacoteHora()));
        estacionadosHora.setEditable(false);
        estacionadosHora.setHorizontalAlignment(JTextField.CENTER);
        
        estacionadosMensalista = new JTextField(Integer.toString(sis.getQtdPacoteMensalista()));
        estacionadosMensalista.setEditable(false);
        estacionadosMensalista.setHorizontalAlignment(JTextField.CENTER);
        
        estacionadosPernoite = new JTextField(Integer.toString(sis.getQtdPacotePernoite()));
        estacionadosPernoite.setEditable(false);
        estacionadosPernoite.setHorizontalAlignment(JTextField.CENTER);
        
        pacotes.add(hora);
        pacotes.add(estacionadosHora);
        pacotes.add(pernoite);
        pacotes.add(estacionadosPernoite);
        pacotes.add(mensalista);
        pacotes.add(estacionadosMensalista);
 
        p[2][0].add(pacotes);
        
        JPanel lucro = new JPanel();
        lucro.setLayout(new GridLayout(3, 2));        
        lucro.setBorder(tituloLucro);
        lucro.add(msgDataEntrada = new JLabel("Data Entrada", (int)CENTER_ALIGNMENT));
        dataEntrada = new JTextField("dd/mm/aaaa");
        dataEntrada.setHorizontalAlignment(JTextField.CENTER);
        dataEntrada.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				dataEntrada.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(dataEntrada.getText().equals(""))
					dataEntrada.setText("dd/mm/aaaa");
			}
        });
        lucro.add(dataEntrada);
        lucro.add(msgDataSaida = new JLabel("Data Saida", (int)CENTER_ALIGNMENT));
        dataSaida = new JTextField("dd/mm/aaaa");
        dataSaida.setHorizontalAlignment(JTextField.CENTER);
        dataSaida.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				dataSaida.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(dataSaida.getText().equals(""))
					dataSaida.setText("dd/mm/aaaa");
			}
        });
        lucro.add(dataSaida);
        lucro.add(verificar = new JButton("Verificar"));
        verificar.addActionListener(list);
        resultado = new JTextField();
        resultado.setHorizontalAlignment(JTextField.CENTER);
        resultado.setEditable(false);
        
        
        
        
        lucro.add(resultado);
        
        p[2][0].add(lucro);
        
        
    }
    
    private class Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == checar)
            {
                TelaTable telaTable = new TelaTable();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int height = screenSize.height;
                int width = screenSize.width;
                telaTable.setSize(width/2, height/2);
                telaTable.setVisible(true);
                telaTable.setLocationRelativeTo(null);
            }
            else if(e.getSource() == verificar)
            {
            	int qtdVeiculos;
                float lucroPeriodo;
                
                int dia, mes, ano;
        		
                try{
                
            	ano = Integer.parseInt(dataEntrada.getText().substring(6, 10));
            	mes = Integer.parseInt(dataEntrada.getText().substring(3, 5));
            	dia = Integer.parseInt(dataEntrada.getText().substring(0, 2)); 
            	
            	LocalDateTime entrada = LocalDateTime.of(ano, mes, dia, 0, 0);
            	
            	ano = Integer.parseInt(dataSaida.getText().substring(6, 10));
            	mes = Integer.parseInt(dataSaida.getText().substring(3, 5));
            	dia = Integer.parseInt(dataSaida.getText().substring(0, 2));
                
            	LocalDateTime saida = LocalDateTime.of(ano, mes, dia, 0, 0);
            	
                qtdVeiculos  = sis.getVeiculosPeriodo(entrada, saida);
                lucroPeriodo = sis.getValorPeriodo(entrada, saida);
                
                resultado.setText(qtdVeiculos + " Veiculos " + lucroPeriodo + " Lucro");
                
                }
                catch(NumberFormatException exception)
            	{
            		JOptionPane.showMessageDialog(null, "Valores inseridos invalidos\nFormato data (HH:MM) e (dd/mm/aaaa)", "Erro", JOptionPane.INFORMATION_MESSAGE);
            	}
            	catch(DateTimeException exception)
            	{
            		JOptionPane.showMessageDialog(null, "Valores inseridos invalidos\nFormato data (HH:MM) e (dd/mm/aaaa)", "Erro", JOptionPane.INFORMATION_MESSAGE);
            	}
            	catch(StringIndexOutOfBoundsException exception)
            	{
            		JOptionPane.showMessageDialog(null, "Valores inseridos invalidos\nFormato data (HH:MM) e (dd/mm/aaaa)", "Erro", JOptionPane.INFORMATION_MESSAGE);
            	}
            }
        }
    }
    
}
