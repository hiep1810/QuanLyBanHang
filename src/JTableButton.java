import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public final class JTableButton extends JFrame {
  private JTable __table;
  private JScrollPane __scrollPane;

  public JTableButton() {
    super("JTableButton Demo");
    TableCellRenderer defaultRenderer;

    __table = new JTable(new JTableButtonModel());
    defaultRenderer = __table.getDefaultRenderer(JButton.class);
    __table.setDefaultRenderer(JButton.class,
			       new JTableButtonRenderer(defaultRenderer));
    __table.setPreferredScrollableViewportSize(new Dimension(400, 200));
    __table.addMouseListener(new JTableButtonMouseListener(__table));

    __scrollPane = new JScrollPane(__table);
    setContentPane(__scrollPane);
  }


  public static void main(String[] args) {
    Frame frame;
    WindowListener exitListener;

    exitListener = new WindowAdapter() {
	
      public void windowClosing(WindowEvent e) {
	Window window = e.getWindow();
	window.setVisible(false);
	window.dispose();
	System.exit(0);
      }
    };

    frame = new JTableButton();
    frame.addWindowListener(exitListener);
    frame.pack();
    frame.setVisible(true);
  }
}