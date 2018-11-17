package estacionamento;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    private JLabel icone;
    
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
        
        Icon parada      = new ImageIcon(getClass().getResource("p.png"));
        
        p[0][0].setLayout(new GridLayout(1, 1));
        title = new JLabel("Status do Estacionamento", (int)CENTER_ALIGNMENT);
        p[0][0].add(title);
        
        p[1][0].setLayout(new GridLayout(1, 2));
        JPanel vagas = new JPanel();
        vagas.setLayout(new GridLayout(3, 2));
        vagas.setBorder(tituloVagas);
        
        carros = new JLabel("Carros", (int)CENTER_ALIGNMENT);
        motos = new JLabel("Motos", (int)CENTER_ALIGNMENT);
        caminhonetes = new JLabel("Caminhonetes", (int)CENTER_ALIGNMENT);
        carrosEstacionados = new JTextField(15);
        carrosEstacionados.setEditable(false);
        motosEstacionados = new JTextField(15);
        motosEstacionados.setEditable(false);
        caminhonetesEstacionados = new JTextField(15);
        caminhonetesEstacionados.setEditable(false);
        
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
        estacionadosHora = new JTextField(15);
        estacionadosHora.setEditable(false);
        estacionadosMensalista = new JTextField(15);
        estacionadosMensalista.setEditable(false);
        estacionadosPernoite = new JTextField(15);
        estacionadosPernoite.setEditable(false);
        
        pacotes.add(hora);
        pacotes.add(estacionadosHora);
        pacotes.add(pernoite);
        pacotes.add(estacionadosPernoite);
        pacotes.add(mensalista);
        pacotes.add(estacionadosMensalista);
 
        p[2][0].add(pacotes);
        icone = new JLabel("", (int)CENTER_ALIGNMENT);
        icone.setIcon(parada);
        
        p[2][0].add(icone);
        
        
        
    }
}
