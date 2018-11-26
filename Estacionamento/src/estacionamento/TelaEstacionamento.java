
package estacionamento;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaEstacionamento extends JFrame 
{
    private JLabel vagas[] = new JLabel[100];
    private JPanel rua[] = new JPanel[25];
    private JLabel andar;
    private JLabel primeiro;
    private JLabel carros;
    private JTextField qtdCarros;
    private JLabel motos;
    private JTextField qtdMotos;
    private JLabel caminhonetes;
    private JTextField qtdCaminhonetes;
    private JButton entrada;
    private JButton saida;
    private JButton status;
    private JButton configuracoes;
    private JButton trocaAndar;    
    
    int i, j;
    
    int contadorVagas = 0, contadorRua = 0, contadorMenu = 0;
    int cont = 0;
    
    javax.swing.border.Border borda = BorderFactory.createLineBorder(Color.BLACK, 1);
    
    public TelaEstacionamento()
    {
        super("Primeiro Andar");
        setLayout(new GridLayout(15, 6));
        JPanel[][] p = new JPanel[15][6];
        Listener list = new Listener();
        
        for(i = 0; i < 15; i++){
            for(j = 0; j < 6; j++){
                p[i][j] = new JPanel();
                add(p[i][j]);
            }
        }
        
        for(i = 0; i < 15; i++)
        {
            for(j = 0; j < 6; j++)
            {
               if(i != 1 && i != 4 && i != 7 && i != 10 && i != 13 && j != 5)
               {
                   p[i][j].setLayout(new GridLayout(1, 2));
                   
                   vagas[contadorVagas] = new JLabel(Integer.toString(j + i), (int) CENTER_ALIGNMENT);
                   vagas[contadorVagas].setBackground(Color.green);
                   vagas[contadorVagas].setOpaque(true);
                   vagas[contadorVagas].setBorder(borda);
                   
                   p[i][j].add(vagas[contadorVagas]);
                   
                   contadorVagas++;
                   
                   vagas[contadorVagas] = new JLabel(Integer.toString(j + i + 1), (int) CENTER_ALIGNMENT);
                   vagas[contadorVagas].setBackground(Color.green);
                   vagas[contadorVagas].setOpaque(true);
                   vagas[contadorVagas].setBorder(borda);
                   
                   p[i][j].add(vagas[contadorVagas]);
                   
                   contadorVagas++;   
               }
               else if(j != 5)
               {
                   p[i][j].setLayout(new GridLayout(1, 1));
                   
                   rua[contadorRua] = new JPanel();
                   rua[contadorRua].setBackground(Color.GRAY);
                   rua[contadorRua].setOpaque(true);
                   
                   p[i][j].add(rua[contadorRua]);
               }
            }
        }
        
        for(i = 0; i < 15; i++)
            p[i][5].setLayout(new GridLayout(1,1));
        
        andar =  new JLabel("Andar:", (int)CENTER_ALIGNMENT);
        primeiro = new JLabel("Primeiro", (int)CENTER_ALIGNMENT);
        andar.setFont(new Font("Century", Font.PLAIN, 30));
        andar.setForeground(Color.BLUE);
        primeiro.setFont(new Font("Century", Font.PLAIN, 30));
        primeiro.setForeground(Color.BLUE);
        
        p[0][5].add(andar);
        p[1][5].add(primeiro);
                
        carros = new JLabel("Total de Carros", (int)CENTER_ALIGNMENT);
        carros.setFont(new Font("Arial", Font.PLAIN, 20));
        p[3][5].add(carros);
        qtdCarros = new JTextField("x/100");
        qtdCarros.setFont(new Font("Arial", Font.PLAIN, 20));
        qtdCarros.setHorizontalAlignment(JTextField.CENTER);
        qtdCarros.setEditable(false);
        p[4][5].add(qtdCarros);
       
        caminhonetes = new JLabel("Total de Caminhonetes", (int)CENTER_ALIGNMENT);
        caminhonetes.setFont(new Font("Arial", Font.PLAIN, 20));
        p[5][5].add(caminhonetes);
        qtdCaminhonetes = new JTextField("x/20");
        qtdCaminhonetes.setHorizontalAlignment(JTextField.CENTER);
        qtdCaminhonetes.setFont(new Font("Arial", Font.PLAIN, 20));
        qtdCaminhonetes.setEditable(false);
        p[6][5].add(qtdCaminhonetes);
           
        motos = new JLabel("Total de motos", (int)CENTER_ALIGNMENT);
        motos.setFont(new Font("Arial", Font.PLAIN, 20));
        p[7][5].add(motos);
        qtdMotos = new JTextField("x/20");
        qtdMotos.setHorizontalAlignment(JTextField.CENTER);
        qtdMotos.setFont(new Font("Arial", Font.PLAIN, 20));
        qtdMotos.setEditable(false);
        p[8][5].add(qtdMotos);
               
        entrada = new JButton("Entrada");
        entrada.addActionListener(list);
        p[9][5].add(entrada);
        saida = new JButton("Saida");
        saida.addActionListener(list);
        p[10][5].add(saida);
        status = new JButton("Status");
        p[11][5].add(status);
        configuracoes = new JButton("Configuracoes");
        p[12][5].add(configuracoes);
        trocaAndar = new JButton("Trocar Andar");
        p[14][5].add(trocaAndar);
               
    }
    
        private class Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == entrada)
            {
               TelaEntrada telaEntrada = new TelaEntrada();
               telaEntrada.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

               Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
               int height = screenSize.height;
               int width = screenSize.width;

               telaEntrada.setSize(width/2, height/2);
               telaEntrada.setLocationRelativeTo(null);

               telaEntrada.setVisible(true); 
            }
            else if(e.getSource() == saida)
            {
               TelaSaida telaSaida = new TelaSaida();
               telaSaida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

               Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
               int height = screenSize.height;
               int width = screenSize.width;

               telaSaida.setSize(width/2, height/2);
               telaSaida.setLocationRelativeTo(null);

               telaSaida.setVisible(true); 
            }
        }
    }
}
