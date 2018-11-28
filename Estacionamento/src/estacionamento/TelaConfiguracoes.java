package estacionamento;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class TelaConfiguracoes extends JFrame
{
    private JLabel titulo;
    private JLabel timeBonus;
    private JLabel horaMoto;
    private JLabel horaCarro;
    private JLabel horaCaminhonete;
    private JTextField precoHoraMoto;
    private JTextField precoHoraCarro;
    private JTextField precoHoraCaminhonete;   
    private JLabel pernoiteMoto;
    private JLabel pernoiteCarro;
    private JLabel pernoiteCaminhonete;
    private JTextField precoPernoiteMoto;
    private JTextField precoPernoiteCarro;
    private JTextField precoPernoiteCaminhonete;
    private JLabel mensalistaMoto;
    private JLabel mensalistaCarro;
    private JLabel mensalistaCaminhonete;
    private JTextField precoMensalistaMoto;
    private JTextField precoMensalistaCarro;
    private JTextField precoMensalistaCaminhonete;
    private JRadioButton bonusSim;
    private JRadioButton bonusNao;
    private JButton cancelar;
    private JButton confirmar;
    private JTextField tempoBonus;
    private ButtonGroup grupo;
    
    int i;
    
    public TelaConfiguracoes()
    {
        super("Configuracoes");
        
        setLayout(new GridLayout(4, 1));
        JPanel[][] p = new JPanel[4][1];
        
        for(i = 0; i < 4; i++){
            p[i][0] = new JPanel();
            add(p[i][0]);
        }
        
        Listener list = new Listener();
        
        SistemaEstacionamento sis = SistemaEstacionamento.getInstance();
        
        p[0][0].setLayout(new GridLayout(1, 1));
        titulo = new JLabel("Configuracoes", (int)CENTER_ALIGNMENT);
        p[0][0].add(titulo);
        
        TitledBorder tituloHora = new TitledBorder("Configuracoes Hora");
        TitledBorder tituloPernoite = new TitledBorder("Configuracoes Pernoite");
        TitledBorder tituloMensalista = new TitledBorder("Configuracoes Mensalista");
        TitledBorder tituloBonus = new TitledBorder("Tempo Bonus");
        TitledBorder tituloDesconto = new TitledBorder("Promocoes");
        TitledBorder tituloSave = new TitledBorder("Confirmar/Cancelar");
        
        //Configurações preco hora
        p[1][0].setLayout(new GridLayout(1, 2));
        JPanel hora = new JPanel();
        hora.setBorder(tituloHora);
        hora.setLayout(new GridLayout(3, 2));
        horaMoto = new JLabel("Preco moto", (int)CENTER_ALIGNMENT);
        horaCarro = new JLabel("Preco carro", (int)CENTER_ALIGNMENT);
        horaCaminhonete = new JLabel("Preco caminhonete", (int)CENTER_ALIGNMENT);
        
        precoHoraMoto = new JTextField(10);
        precoHoraMoto.setHorizontalAlignment(JTextField.CENTER);
        
        precoHoraCarro = new JTextField(10);
        precoHoraCarro.setHorizontalAlignment(JTextField.CENTER);
        
        precoHoraCaminhonete = new JTextField(10);
        precoHoraCaminhonete.setHorizontalAlignment(JTextField.CENTER);
        
        hora.add(horaMoto);
        hora.add(precoHoraMoto);
        hora.add(horaCarro);
        hora.add(precoHoraCarro);
        hora.add(horaCaminhonete);
        hora.add(precoHoraCaminhonete);
        p[1][0].add(hora);
       //Configurações preco hora
       
       //Configurações tempo bonus
        JPanel bonus = new JPanel();
        bonus.setBorder(tituloBonus);
        
        bonus.setLayout(new GridLayout(2, 1));
        
        JPanel[][] aux = new JPanel[2][1];
        aux[0][0] = new JPanel(); aux[1][0] = new JPanel();
        
        aux[0][0].setLayout(new GridLayout(1, 2));
        
        bonusSim = new JRadioButton("Sim", false);
        bonusSim.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        aux[0][0].add(bonusSim);
        bonusNao = new JRadioButton("Nao", true);
        bonusNao.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        aux[0][0].add(bonusNao);
        
        grupo = new ButtonGroup();
        grupo.add(bonusSim);
        grupo.add(bonusNao);
        
         bonusSim.addItemListener(
            new TelaConfiguracoes.RadioButtonHandler(true));
        bonusNao.addItemListener(
            new TelaConfiguracoes.RadioButtonHandler(false));
        
        tempoBonus = new JTextField(15);
        tempoBonus.setEditable(false);
        tempoBonus.setText("");
        aux[1][0].add(tempoBonus);
        
        bonus.add(aux[0][0]);
        bonus.add(aux[1][0]);
        
        p[1][0].add(bonus);
        //Configurações tempo bonus
        
        //Configurações preco pernoite
        p[2][0].setLayout(new GridLayout(1, 2));
        JPanel pernoite = new JPanel();
        pernoite.setBorder(tituloPernoite);
        pernoite.setLayout(new GridLayout(3, 2));
        pernoiteMoto = new JLabel("Preco moto", (int)CENTER_ALIGNMENT);
        pernoiteCarro = new JLabel("Preco carro", (int)CENTER_ALIGNMENT);
        pernoiteCaminhonete = new JLabel("Preco caminhonete", (int)CENTER_ALIGNMENT);
        
        precoPernoiteMoto = new JTextField(10);
        precoPernoiteMoto.setHorizontalAlignment(JTextField.CENTER);
        
        precoPernoiteCarro = new JTextField(10);
        precoPernoiteCarro.setHorizontalAlignment(JTextField.CENTER);
        
        precoPernoiteCaminhonete = new JTextField(10);
        precoPernoiteCaminhonete.setHorizontalAlignment(JTextField.CENTER);
        
        pernoite.add(pernoiteMoto);
        pernoite.add(precoPernoiteMoto);
        pernoite.add(pernoiteCarro);
        pernoite.add(precoPernoiteCarro);
        pernoite.add(pernoiteCaminhonete);
        pernoite.add(precoPernoiteCaminhonete);
        p[2][0].add(pernoite);
        //Configurações preco pernoite
        
        //Configurações Desconto
        JPanel desconto = new JPanel();
        desconto.setBorder(tituloDesconto);
        p[2][0].add(desconto);
        //Configurações Desconto
        
        //Configurações preco mensalista
        p[3][0].setLayout(new GridLayout(1, 2));
        JPanel mensalista = new JPanel();
        mensalista.setBorder(tituloMensalista);
        mensalista.setLayout(new GridLayout(3, 2));
        
        mensalistaMoto = new JLabel("Preco moto", (int)CENTER_ALIGNMENT);
        mensalistaCarro = new JLabel("Preco carro", (int)CENTER_ALIGNMENT);
        mensalistaCaminhonete = new JLabel("Preco caminhonete", (int)CENTER_ALIGNMENT);
        
        precoMensalistaMoto = new JTextField(10);
        precoMensalistaMoto.setHorizontalAlignment(JTextField.CENTER);
        precoMensalistaMoto.setText(Float.toString(sis.getMensalistaMoto()));
        
        precoMensalistaCarro = new JTextField(10);
        precoMensalistaCarro.setHorizontalAlignment(JTextField.CENTER);
        precoMensalistaCarro.setText(Float.toString(sis.getMensalistaCarro()));
        
        precoMensalistaCaminhonete = new JTextField(10);
        precoMensalistaCaminhonete.setHorizontalAlignment(JTextField.CENTER);
        precoMensalistaCaminhonete.setText(Float.toString(sis.getMensalistaCaminhonete()));
        
        mensalista.add(mensalistaMoto);
        mensalista.add(precoMensalistaMoto);
        mensalista.add(mensalistaCarro);
        mensalista.add(precoMensalistaCarro);
        mensalista.add(mensalistaCaminhonete);
        mensalista.add(precoMensalistaCaminhonete);
        p[3][0].add(mensalista);
        //Configurações preco mensalista
        
        //Configurações Botoes
        JPanel botoes = new JPanel();
        botoes.setBorder(tituloSave);
        
        cancelar = new JButton("Cancelar");
        confirmar = new JButton("Confirmar");
        
        confirmar.addActionListener(list);
        cancelar.addActionListener(list);
        
        botoes.add(new JPanel());
        botoes.add(cancelar);
        botoes.add(confirmar);
        p[3][0].add(botoes);
        //Configurações Botoes
    }
    
    private class RadioButtonHandler implements ItemListener
    {
        boolean x;
        
        public RadioButtonHandler(boolean p)
        {
           x = p;
        }
        
        public void itemStateChanged(ItemEvent e)
        {
           tempoBonus.setEditable(x);
           tempoBonus.setText("");
        }
    }
    
    private class Listener implements ActionListener //TO MEXENDO AQUUIIIIIII PRA VOC� LEMBRAR BRUNO SEU IDIOTA DATA
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == confirmar)
            {
            	
            }
            else if(e.getSource() == cancelar)
            {
            	dispose();
            }
        }
    }
}
