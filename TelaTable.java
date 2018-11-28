package estacionamento;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaTable extends JFrame
{
    private String[] colunas = {"Vaga", "Placa do Veiculo", "Modelo", "Pacote"};
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
        
        setLayout(new FlowLayout());
        
        qtdLinhas = sis.getNumeroCarros();
        
        data = new String[qtdLinhas][4];
        
        i = 0;
        
        for(VeiculoEstacionado v : sis.lista)
        {
            data[i][0] = Integer.toString(v.getVagaOcupada());
            data[i][1] = v.getPlaca();
            data[i][2] = v.getModelo();
            data[i][3] = v.getPacote();
                    
            i++;        
        }
        
        table = new JTable(data, colunas);
        table.setEnabled(false);
        add(table);
        
        js = new JScrollPane(table);
        add(js);

    }
}
