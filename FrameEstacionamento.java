package estacionamento;

import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FrameEstacionamento extends JFrame
{
	SistemaEstacionamento sistema = SistemaEstacionamento.getInstance();
	private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panelPrincipal;
	private JLabel vagasCarro, labelPiso;
	private JButton buttonTrocaAndar;
	private static int ocupadosPiso1[][];
	private static int ocupadosTerreo[][];
	private static int andarAtual = 0; // 0 T�rreo e 1 Piso1
	GridBagConstraints gbc = null;
	
	JMenuBar menuBar;
	JMenu veiculos, status, config;
	JMenuItem ventrada, vsaida;
        JMenuItem statusIn, configIn;
	
	JLabel[][] espacosBrancoT = new JLabel[2][10];
        JLabel[][] vagasCarroT = new JLabel[10][10];

        JLabel[][] espacosBrancoP = new JLabel[2][10];
        JLabel[][] vagasCarroP = new JLabel[10][10];
        
	public FrameEstacionamento() 
	{
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            gbc = new GridBagConstraints();
            
            //ButtonHandler handler = new ButtonHandler();
            Listener handler = new Listener();
            
            setTitle("Controle de Estacionamento");
            panel1 = new JPanel();
            panel2 = new JPanel();
            panel3 = new JPanel();
            panel4 = new JPanel();
            panel5 = new JPanel();
            panel6 = new JPanel();

            buttonTrocaAndar = new JButton("Trocar Andar");
            panelPrincipal = new JPanel();

            exibeTerreo();

            // CRIANDO MENU

            menuBar = new JMenuBar();

            veiculos = new JMenu("Veiculos");
            menuBar.add(veiculos);
                    // SUB ITENS DE VEICULOS
                    ventrada = new JMenuItem("Entrada", KeyEvent.VK_E);
                    veiculos.add(ventrada);

                    vsaida = new JMenuItem("Saida", KeyEvent.VK_S);
                    veiculos.add(vsaida);
                    // FIM SUB ITENS DE VEICULOS

            status = new JMenu("Status");
            menuBar.add(status);
                    statusIn = new JMenuItem("Status", KeyEvent.VK_P);
                    status.add(statusIn);
                    

            config = new JMenu("Configuracoes");
            menuBar.add(config);
                    configIn = new JMenuItem("Configuracoes", KeyEvent.VK_C);
                    config.add(configIn);

            // FIM CRIANDO MENU
            setJMenuBar(menuBar);
            add(panelPrincipal);	

            // HANDLERS
            
            buttonTrocaAndar.addActionListener(handler);
            ventrada.addActionListener(handler);
            vsaida.addActionListener(handler);
            status.addActionListener(handler);
            config.addActionListener(handler);
            statusIn.addActionListener(handler);
            configIn.addActionListener(handler);
            // FIM HANDLERS
    }

    void exibePiso1()
    {
            int cont = 100;
            panelPrincipal.setLayout(new GridBagLayout());
            panel1.setLayout(new GridLayout(2, 10, -1, -1));
            panel2.setLayout(new GridLayout(2, 10, -1, -1));
            panel3.setLayout(new GridLayout(2, 10, -1, -1));
            panel4.setLayout(new GridLayout(2, 10, -1, -1));
            panel5.setLayout(new GridLayout(2, 10, -1, -1));
            panel6.setLayout(new GridLayout(2, 10, -1, -1));

            int[][] ocupadosPiso1 = new int[10][10];
            labelPiso = new JLabel("Piso 1");
            labelPiso.setFont(new Font("Cloud", Font.PLAIN, 25));

//            // TESTE OCUPADOS
//            ocupadosPiso1[1][7] = 1;
//            ocupadosPiso1[3][9] = 1;
//            ocupadosPiso1[2][1] = 1;
//            ocupadosPiso1[6][8] = 1;
//            // FIM TESTE OCUPADOS


//            JLabel[][] espacosBranco = new JLabel[2][10];
//            JLabel[][] vagasCarro = new JLabel[10][10];

            for(int i = 0; i < 2; i++)
            {
                    for(int j = 0; j < 10; j++)
                    {
                            vagasCarroP[i][j] = new JLabel(String.valueOf(cont), JLabel.CENTER);
                            if (sistema.isOcupado(cont))
                            {
                                    vagasCarroP[i][j].setBackground(Color.RED);
                            }
                            else
                            {
                                    vagasCarroP[i][j].setBackground(Color.GREEN);
                            }
                            vagasCarroP[i][j].setOpaque(true);
                            vagasCarroP[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            panel1.add(vagasCarroP[i][j]);
                            cont++;
                    }
            }

            for(int i = 2; i < 4; i++)
            {
                    for(int j = 0; j < 10; j++)
                    {
                            vagasCarroP[i][j] = new JLabel(String.valueOf(cont), JLabel.CENTER);
                            if (sistema.isOcupado(cont))
                            {
                                    vagasCarroP[i][j].setBackground(Color.RED);
                            }
                            else
                            {
                                    vagasCarroP[i][j].setBackground(Color.GREEN);
                            }
                            vagasCarroP[i][j].setOpaque(true);
                            vagasCarroP[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            panel2.add(vagasCarroP[i][j]);
                            cont++;
                    }
            }

            for(int i = 4; i < 6; i++)
            {
                    for(int j = 0; j < 10; j++)
                    {
                            vagasCarroP[i][j] = new JLabel(String.valueOf(cont), JLabel.CENTER);
                            if (sistema.isOcupado(cont))
                            {
                                    vagasCarroP[i][j].setBackground(Color.RED);
                            }
                            else
                            {
                                    vagasCarroP[i][j].setBackground(Color.GREEN);
                            }
                            vagasCarroP[i][j].setOpaque(true);
                            vagasCarroP[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            panel3.add(vagasCarroP[i][j]);
                            cont++;
                    }
            }

            for(int i = 6; i < 8; i++)
            {
                    for(int j = 0; j < 10; j++)
                    {
                            vagasCarroP[i][j] = new JLabel(String.valueOf(cont), JLabel.CENTER);
                            if (sistema.isOcupado(cont))
                            {
                                    vagasCarroP[i][j].setBackground(Color.RED);
                            }
                            else
                            {
                                    vagasCarroP[i][j].setBackground(Color.GREEN);
                            }
                            vagasCarroP[i][j].setOpaque(true);
                            vagasCarroP[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            panel4.add(vagasCarroP[i][j]);
                            cont++;
                    }
            }

            for(int i = 7; i < 8; i++)
            {
                    for(int j = 0; j < 10; j++)
                    {
                            vagasCarroP[i][j] = new JLabel(String.valueOf(cont), JLabel.CENTER);
                            if (sistema.isOcupado(cont))
                            {
                                    vagasCarroP[i][j].setBackground(Color.RED);
                            }
                            else
                            {
                                    vagasCarroP[i][j].setBackground(Color.GREEN);
                            }
                            vagasCarroP[i][j].setOpaque(true);
                            vagasCarroP[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            panel5.add(vagasCarroP[i][j]);
                            cont++;
                    }
            }

            // COLOCANDO ESPACOSS EM BRANCO
            for (int j = 0; j < 10; j++)
            {
                    espacosBrancoP[0][j] = new JLabel("", JLabel.CENTER);
                    panel5.add(espacosBrancoP[0][j]);
            }


            for(int i = 9; i < 10; i++)
            {
                    for(int j = 0; j < 10; j++)
                    {
                            vagasCarroP[i][j] = new JLabel(String.valueOf(cont), JLabel.CENTER);
                            if (sistema.isOcupado(cont))
                            {
                                    vagasCarroP[i][j].setBackground(Color.RED);
                            }
                            else
                            {
                                    vagasCarroP[i][j].setBackground(Color.GREEN);
                            }
                            vagasCarroP[i][j].setOpaque(true);
                            vagasCarroP[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                            panel6.add(vagasCarroP[i][j]);
                            cont++;
                    }
            }

            // COLOCANDO ESPA�OS EM BRANCO
            for (int j = 0; j < 10; j++)
            {
                    espacosBrancoP[1][j] = new JLabel("", JLabel.CENTER);
                    panel6.add(espacosBrancoP[1][j]);
            }

            GridBagConstraints gbc = new GridBagConstraints();

            gbc.insets = new Insets(10, 20, 5, 0);
            gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelPiso, gbc);
        
        gbc.insets = new Insets(10, 20, 5, 22);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(buttonTrocaAndar, gbc);
	 	
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        
        
        gbc.insets = new Insets(0, 20, 20, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(panel1, gbc);
        
        gbc.insets = new Insets(0, 20, 20, 20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelPrincipal.add(panel2, gbc);
        
        gbc.insets = new Insets(0, 20, 20, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(panel3, gbc);
        
        gbc.insets = new Insets(0, 20, 20, 20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelPrincipal.add(panel4, gbc);
        
        gbc.insets = new Insets(0, 20, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelPrincipal.add(panel5, gbc);
        
        gbc.insets = new Insets(0, 20, 0, 20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelPrincipal.add(panel6, gbc);
	}

	void exibeTerreo()
	{
		int cont = 0;
		panelPrincipal.setLayout(new GridBagLayout());
		panel1.setLayout(new GridLayout(2, 10, -1, -1));
		panel2.setLayout(new GridLayout(2, 10, -1, -1));
		panel3.setLayout(new GridLayout(2, 10, -1, -1));
		panel4.setLayout(new GridLayout(2, 10, -1, -1));
		panel5.setLayout(new GridLayout(2, 10, -1, -1));
		panel6.setLayout(new GridLayout(2, 10, -1, -1));
		
		int[][] ocupadosTerreo = new int[10][10];
		labelPiso = new JLabel("Terreo");
		labelPiso.setFont(new Font("Cloud", Font.PLAIN, 25));
		
//		// TESTE OCUPADOS
//		ocupadosTerreo[1][7] = 1;
//		ocupadosTerreo[3][9] = 1;
//		ocupadosTerreo[4][8] = 1;
//		ocupadosTerreo[0][2] = 1;
//		// FIM TESTE OCUPADOS
		
		
//		JLabel[][] espacosBranco = new JLabel[2][10];
//		JLabel[][] vagasCarro = new JLabel[10][10];
		
		for(int i = 0; i < 2; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				vagasCarroT[i][j] = new JLabel((String.valueOf(cont)), JLabel.CENTER);
				if (sistema.isOcupado(cont))
				{
					vagasCarroT[i][j].setBackground(Color.RED);
				}
				else
				{
					vagasCarroT[i][j].setBackground(Color.YELLOW);
				}
				vagasCarroT[i][j].setOpaque(true);
				vagasCarroT[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				panel1.add(vagasCarroT[i][j]);
				cont++;
			}
		}
		
		for(int i = 2; i < 4; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				vagasCarroT[i][j] = new JLabel((String.valueOf(cont)), JLabel.CENTER);
				if (sistema.isOcupado(cont))
				{
					vagasCarroT[i][j].setBackground(Color.RED);
				}
				else
				{
					vagasCarroT[i][j].setBackground(Color.ORANGE);
				}
				vagasCarroT[i][j].setOpaque(true);
				vagasCarroT[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				panel2.add(vagasCarroT[i][j]);
				cont++;
			}
		}
		
		for(int i = 4; i < 6; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				vagasCarroT[i][j] = new JLabel(String.valueOf(cont), JLabel.CENTER);
				if (sistema.isOcupado(cont))
				{
					vagasCarroT[i][j].setBackground(Color.RED);
				}
				else
				{
					vagasCarroT[i][j].setBackground(Color.GREEN);
				}
				vagasCarroT[i][j].setOpaque(true);
				vagasCarroT[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				panel3.add(vagasCarroT[i][j]);
				cont++;
			}
		}
		
		for(int i = 6; i < 8; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				vagasCarroT[i][j] = new JLabel(String.valueOf(cont), JLabel.CENTER);
				if (sistema.isOcupado(cont))
				{
					vagasCarroT[i][j].setBackground(Color.RED);
				}
				else
				{
					vagasCarroT[i][j].setBackground(Color.GREEN);
				}
				vagasCarroT[i][j].setOpaque(true);
				vagasCarroT[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				panel4.add(vagasCarroT[i][j]);
				cont++;
			}
		}
		
		for(int i = 7; i < 8; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				vagasCarroT[i][j] = new JLabel(String.valueOf(cont), JLabel.CENTER);
				if (sistema.isOcupado(cont))
				{
					vagasCarroT[i][j].setBackground(Color.RED);
				}
				else
				{
					vagasCarroT[i][j].setBackground(Color.GREEN);
				}
				vagasCarroT[i][j].setOpaque(true);
				vagasCarroT[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				panel5.add(vagasCarroT[i][j]);
				cont++;
			}
		}
		
		// COLOCANDO ESPA�OS EM BRANCO
		for (int j = 0; j < 10; j++)
		{
			espacosBrancoT[0][j] = new JLabel("", JLabel.CENTER);
			panel5.add(espacosBrancoT[0][j]);
		}
		
		
		for(int i = 9; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				vagasCarroT[i][j] = new JLabel(String.valueOf(cont), JLabel.CENTER);
				if (sistema.isOcupado(cont))
				{
					vagasCarroT[i][j].setBackground(Color.RED);
				}
				else
				{
					vagasCarroT[i][j].setBackground(Color.GREEN);
				}
				vagasCarroT[i][j].setOpaque(true);
				vagasCarroT[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				panel6.add(vagasCarroT[i][j]);
				cont++;
			}
		}
		
		// COLOCANDO ESPA�OS EM BRANCO
		for (int j = 0; j < 10; j++)
		{
			espacosBrancoT[1][j] = new JLabel("", JLabel.CENTER);
			panel6.add(espacosBrancoT[1][j]);
		}
				
	 	GridBagConstraints gbc = new GridBagConstraints();
	 	
	 	gbc.insets = new Insets(10, 20, 5, 0);
	 	gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(labelPiso, gbc);
        
        gbc.insets = new Insets(10, 20, 5, 22);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(buttonTrocaAndar, gbc);
	 	
        
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        
        
        gbc.insets = new Insets(0, 20, 20, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelPrincipal.add(panel1, gbc);
        
        gbc.insets = new Insets(0, 20, 20, 20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelPrincipal.add(panel2, gbc);
        
        gbc.insets = new Insets(0, 20, 20, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(panel3, gbc);
        
        gbc.insets = new Insets(0, 20, 20, 20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelPrincipal.add(panel4, gbc);
        
        gbc.insets = new Insets(0, 20, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelPrincipal.add(panel5, gbc);
        
        gbc.insets = new Insets(0, 20, 0, 20);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelPrincipal.add(panel6, gbc);
	}
	
	private class Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) 
		{
			if(event.getSource() == buttonTrocaAndar )
			{
				// REMOVENDO O PAINEL DAS VAGAS
				panel1.removeAll();
				panel2.removeAll();
				panel3.removeAll();
				panel4.removeAll();
				panel5.removeAll();
				panel6.removeAll();
				panelPrincipal.removeAll();
				// FIM REMOVE
				
				if(andarAtual == 0)
				{
					exibePiso1();
					andarAtual = 1;
				}
				else 
				{
					exibeTerreo();
					andarAtual = 0;
				}
				
				add(panelPrincipal);
				panelPrincipal.setVisible(false); // REFRESH DO PAINEL
				panelPrincipal.setVisible(true);
			}
			// OPCOES DO MENU SUPERIOR
			else if (event.getSource() == ventrada)
			{
				TelaEntrada telaEntrada = new TelaEntrada();
                                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                                int height = screenSize.height;
                                int width = screenSize.width;
                                telaEntrada.setSize(width/2, height/2);
                                telaEntrada.setVisible(true);
                                telaEntrada.setLocationRelativeTo(null);
			}
			
			else if (event.getSource() == vsaida)
			{
                            TelaSaida telaSaida = new TelaSaida();
                            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                            int height = screenSize.height;
                            int width = screenSize.width;
                            telaSaida.setSize(width/2, height/2);
                            telaSaida.setVisible(true);
                            telaSaida.setLocationRelativeTo(null);
			}
			else if (event.getSource() == status || event.getSource() == statusIn) 			
			{
                            TelaStatus telaStatus = new TelaStatus();
                            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                            int height = screenSize.height;
                            int width = screenSize.width;
                            telaStatus.setSize(width/2, height/2);
                            telaStatus.setVisible(true);
                            telaStatus.setLocationRelativeTo(null);
                        }
			else if (event.getSource() == config || event.getSource() == configIn)
			{
                            TelaConfiguracoes telaConfig = new TelaConfiguracoes();
                            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                            int height = screenSize.height;
                            int width = screenSize.width;
                            telaConfig.setSize(width/2, height/2);
                            telaConfig.setVisible(true);
                            telaConfig.setLocationRelativeTo(null);
                        }
			// FIM OPCOES DO MENU SUPERIOR
		}
	}
        
        public boolean Disponibilidade(String tipo){
            //Fazer função que retorna a disponibilidade de vaga de acordo com o tipo de veiculo
            return(false);
        }
                
        public int OcuparVagaCarro()
        {
            //Fazer função que ocupe a vaga para o carro e retorne a posição a deixando vermelha
            return(1);
        }
        public int OcuparVagaMoto()
        {
            //Fazer função que ocupe a vaga para a moto e retorne a posição a deixando vermelha
            return(1);
        } 
        public int OcuparVagaCaminhonete()
        {
            //Fazer função que ocupe a vaga para a caminhonete e retorne a posição a deixando vermelha
            return(1);
        } 
}
