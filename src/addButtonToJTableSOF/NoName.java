package addButtonToJTableSOF;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class NoName extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoName frame = new NoName();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NoName() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTable table = new JTable(new JTableModel()); 
		table.setFillsViewportHeight(true); 
		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
        table.getColumn("Button1").setCellRenderer(buttonRenderer);
        table.getColumn("Button2").setCellRenderer(buttonRenderer);
        table.addMouseListener(new JTableButtonMouseListener(table));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(5, 5, 424, 251);
		contentPane.add(scrollPane);
	}

}
