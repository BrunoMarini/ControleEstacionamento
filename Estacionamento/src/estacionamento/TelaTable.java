package estacionamento;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaTable extends JFrame
{
    private String[] colunas = {"Vaga", "Placa do Veículo", "Modelo", "Tipo"};
    private String[][] data;
    private JTable table;
    private JScrollPane js;
    
    int i;
    
    public TelaTable()
    {
        super("Tabela");
//        setLayout(new FlowLayout());
//        data = new String[QTD DE LINHAS][4];
//        
//        for(i = 0; i < QTD DE LINHAS; i++)
//        {
//            data[i][0] = VAGA[I];
//            data[i][1] = PLACA[I];
//            data[i][2] = MODELO[I];
//            data[i][3] = TIPO[I];
//        }
//        
//        table = new JTable(data, colunas);
//        table.setEnabled(false);
//        add(table);
//        
//        js = new JScrollPane(table);
//        add(js);

    }
}
