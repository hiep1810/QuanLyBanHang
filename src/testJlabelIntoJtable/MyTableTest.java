package testJlabelIntoJtable;

import javax.swing.*;

public class MyTableTest extends JFrame{
    public MyTableTest(String title){
 
        super(title);
        showGUI();
 
    }
 
    public void showGUI(){
 
        JTable table = new JTable();
        table.setModel(new MyModel());//invoking our custom model
        table.setDefaultRenderer(JLabel.class,  new Renderer());// for the rendering of cell
        JScrollPane jp = new JScrollPane(table);
        getContentPane().add(jp);
        setVisible(true);
        setSize(500,300);
 
    }
 
    public static void main(String[] args) {
        MyTableTest t = new MyTableTest("Table Custom");
    }
 
}