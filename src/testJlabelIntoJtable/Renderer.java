package testJlabelIntoJtable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
 
public class Renderer extends DefaultTableCellRenderer{
	 public void fillColor(JTable t,JLabel l,boolean isSelected ){
	        //setting the background and foreground when JLabel is selected
	        if(isSelected){
	            l.setBackground(t.getSelectionBackground());
	            l.setForeground(t.getSelectionForeground());
	        }
	 
	        else{
	            l.setBackground(t.getBackground());
	            l.setForeground(t.getForeground());
	        }
	 
	    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
         boolean hasFocus, int row, int column)
     {
 
        if(value instanceof JLabel){
           //This time return only the JLabel without icon
        	 JLabel label = (JLabel)value;
             //to make label foreground n background visible you need to
             // setOpaque -> true
        	 BufferedImage img = null;
     		try {
     		    img = ImageIO.read(new File("./images/1.jpg"));
     		} catch (IOException e) {
     		    e.printStackTrace();
     		}
     		
        	 label.setIcon(new ImageIcon(getClass().getResource("./images/1.jpg")));
        	Image dimg = img.getScaledInstance(5, 5,
    		        Image.SCALE_SMOOTH);
     		ImageIcon imageIcon = new ImageIcon(dimg);
     		
     		label.setIcon(imageIcon);
        	 
        	 label.setOpaque(true);
             fillColor(table,label,isSelected);
             return label;        }
 
        else
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
 
     }
}