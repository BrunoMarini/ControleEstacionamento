package estacionamento;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TelaTable extends JFrame
{
    private String[] colunas = {"Vaga", "Placa do Veiculo", "Modelo", "Tipo", "Pacote", "Entrada"};
    private String[][] data;
    private JTable table;
    private JScrollPane js;
    
    int i;
    int qtdLinhas;
    
    public TelaTable()
    {
        super("Tabela");
        
        SistemaEstacionamento sis = SistemaEstacionamento.getInstance();
        
        setLayout(new GridLayout());
        
//        JPanel p = new JPanel();
//        
//        add(p);
        
        qtdLinhas = sis.getNumeroVeiculos();
        
        data = new String[qtdLinhas][6];
        
        i = 0;    
        
        for(VeiculoEstacionado v : sis.listaDados)
        {
        	//System.out.println(v.getData());
        	        	 
            data[i][0] = Integer.toString(v.getVagaOcupada());
            data[i][1] = v.getPlaca();
            data[i][2] = v.getModelo();
            data[i][3] = v.getTipo();
            data[i][4] = v.getPacote();
            data[i][5] = v.getData().toString();	
                    
            i++;        
        }
        
        table = new JTable(data, colunas);
        table.setEnabled(false);
        table.setMaximumSize(this.getSize());
        table.createScrollPaneForTable(table);
        table.setDefaultRenderer(Object.class, new CellRenderer());
        
        add(table);
        
        js = new JScrollPane(table);
        add(js);

    }
    
    public class CellRenderer extends DefaultTableCellRenderer {
    	public CellRenderer() {
    		super();
    	}
    	public Component getTableCellRendererComponent(JTable table, Object value,
    			boolean isSelected, boolean hasFocus, int row, int column) {
    		this.setHorizontalAlignment(CENTER);
    		return super.getTableCellRendererComponent(table, value, isSelected,
    				hasFocus, row, column);
    	}
    }
}
