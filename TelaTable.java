package estacionamento;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaTable extends JFrame
{
    private String[] colunas = {"Vaga", "Placa do Veiculo", "Modelo", "Pacote", "Entrada"};
    private String[][] data;
    private JTable table;
    private JScrollPane js;
    
    int i;
    int qtdLinhas;
    
    public TelaTable()
    {
        super("Tabela");
        
        SistemaEstacionamento sis = SistemaEstacionamento.getInstance();
        VeiculoEstacionado vei;
        
        setLayout(new GridLayout());
        
//        JPanel p = new JPanel();
//        
//        add(p);
        
        qtdLinhas = sis.getNumeroCarros();
        
        data = new String[qtdLinhas][5];
        
        i = 0;    
        
        for(VeiculoEstacionado v : sis.lista)
        {
        	//System.out.println(v.getData());
        	        	 
            data[i][0] = Integer.toString(v.getVagaOcupada());
            data[i][1] = v.getPlaca();
            data[i][2] = v.getModelo();
            data[i][3] = v.getPacote();
            data[i][4] = v.getData().toString();	
                    
            i++;        
        }
        
        table = new JTable(data, colunas);
        table.setEnabled(false);
        table.setMaximumSize(this.getSize());
        table.createScrollPaneForTable(table);
        
        
        add(table);
        
        js = new JScrollPane(table);
        add(js);

    }
}
