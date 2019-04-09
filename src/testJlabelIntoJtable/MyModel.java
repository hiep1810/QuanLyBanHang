package testJlabelIntoJtable;

import javax.swing.JLabel;
 
class MyModel extends javax.swing.table.DefaultTableModel{
 
    Object[][] row = {{new JLabel("Row 1 Col 1"), "Row 1 Col 2", "Row 1 Col3"},
                      {new JLabel("Row 2 Col 1"), "Row 2 Col 2", "Row 2 Col3"},
                      {new JLabel("Row 3 Col 1"), "Row 3 Col 2", "Row 3 Col3"},
                      {new JLabel("Row 4 Col 1"), "Row 4 Col 2", "Row 4 Col3"}};
 
    Object[] col = {"Column 1", "Column 2", "Column 3"};
 
    public MyModel (){
 
    //Adding columns
        for(Object c: col)
            this.addColumn(c);
 
    //Adding rows
        for(Object[] r: row)
            addRow(r);
 
    }
 
    @Override
 
    public Class getColumnClass(int columnIndex) {
        if(columnIndex == 0)return getValueAt(0, columnIndex).getClass();
 
        else return super.getColumnClass(columnIndex);
 
    }
 
}