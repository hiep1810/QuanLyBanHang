import java.awt.Component;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.Dimension;

public class CustomCell {
    public static void main( String [] args ) { 
        Object [] columnNames = new Object[]{ "Id", "Quantity" };
        Object [][] data        = new Object[][]{ {"06", 1}, {"08", 2} };

        JTable table = new JTable( data, columnNames ) { 
            public TableCellRenderer getCellRenderer( int row, int column ) {
                return new PlusMinusCellRenderer();
            }
         };

        table.setRowHeight( 32 );
        showFrame( table );
    }

    private static void showFrame( JTable table ) {
        JFrame f = new JFrame("Custom Cell Renderer sample" );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.add( new JScrollPane( table ) );
        f.pack();
        f.setVisible( true );
    }
}

class PlusMinusCellRenderer extends JPanel implements TableCellRenderer {
        public Component getTableCellRendererComponent(
                            final JTable table, Object value,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
                this.add( new JTextField( value.toString()  ) );
                this.add( new JButton("+"));
                this.add( new JButton("-"));
                return this;
        }
}