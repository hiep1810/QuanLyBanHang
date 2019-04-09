import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.AbstractDocument.Content;

/**
 * @author John B. Matthews; distribution per LGPL
 * 11-Jul-2011 Correct item listener in ValueEditor
 */
public class JTableTest extends JPanel {

    private static DecimalFormat df = new DecimalFormat("#0.00");
    private DataModel model = new DataModel();
    private JTable table = new JTable(model);

    public JTableTest() {
    	this.setBounds(0, 0, 500, 800);
        this.setLayout(new BorderLayout());
        table.setDefaultRenderer(Value.class, new ValueRenderer());
        table.setDefaultEditor(Value.class, new ValueEditor());
        table.setRowHeight(24);
        this.add(table.getTableHeader());
        this.add(table);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setBounds(100,100,1000,1000);
                JPanel contentPane = new JPanel();
                contentPane.setBorder(new EmptyBorder(5,5,5,5)); 
                f.setContentPane(contentPane);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JTableTest jtb = new JTableTest();
                jtb.setBounds(0,0,100,1000);
                contentPane.add(jtb);
                
                //set locationrelate to la gi ??
                
                f.setVisible(true);
            }
        });
    }

    private static class Value implements Comparable<Value> {

        private Boolean selected;
        private Double value;

        public Value(Boolean selected, Double value) {
            this.selected = selected;
            this.value = value;
        }

        @Override
        public int compareTo(Value v) {
            return this.value.compareTo(v.value);
        }

        @Override
        public boolean equals(Object v) {
            return v instanceof Value && this.value.equals(((Value) v).value);
        }

        @Override
        public int hashCode() {
            return this.value.hashCode();
        }
    }

    private static class DataModel extends AbstractTableModel {

        private static final int MAX = 8;
        private static final String[] names = {"Number", "Value"};
        private List<Value> values = new ArrayList<Value>();

        public DataModel() {
            for (int i = 0; i < MAX; i++) {
                values.add(new Value(false, (i + 1) * 1.1));
            }
        }

        @Override
        public int getRowCount() {
            return MAX;
        }

        @Override
        public int getColumnCount() {
            return names.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            if (col == 0) {
                return row + 1;
            } else if (col == 1) {
                return values.get(row);
            } else {
                return null;
            }
        }

        @Override
        public void setValueAt(Object aValue, int row, int col) {
            if (col == 1) {
                values.get(row).selected = (Boolean) aValue;
                this.fireTableCellUpdated(row, col);
            }
        }

        @Override
        public Class<?> getColumnClass(int col) {
            if (col == 0) {
                return Integer.class;
            } else if (col == 1) {
                return Value.class;
            } else {
                return null;
            }
        }

        @Override
        public String getColumnName(int col) {
            return names[col];
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return col == 1;
        }
    }

    private static class ValueRenderer extends JCheckBox
        implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int col) {
            Value v = (Value) value;
            this.setSelected(v.selected);
            this.setText(df.format(v.value));
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }
            return this;
        }
    }

    private class ValueEditor extends AbstractCellEditor
        implements TableCellEditor, ItemListener {

        private ValueRenderer vr = new ValueRenderer();

        public ValueEditor() {
            vr.addItemListener(this);
        }

        @Override
        public Object getCellEditorValue() {
            return vr.isSelected();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int col) {
            Value v = (Value) value;
            vr.setSelected(v.selected);
            vr.setText(df.format(v.value));
            return vr;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            this.fireEditingStopped();
        }
    }
}