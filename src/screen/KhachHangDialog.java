package screen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import models.KhachHang;
import models.KhachHangDAO;
import models.KhachHangTblModel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KhachHangDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField maKHTxt;
	private JTextField sdtTxt;
	private JTextField diaChiTxt;
	private JTextField congNoTxt;
	private JTextField tenKHTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			KhachHangDialog dialog = new KhachHangDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public KhachHangDialog() {
		setBounds(100, 100, 809, 390);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//table
		JTable table = new JTable();
		table.setModel(new KhachHangTblModel());
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 412, 350);

		contentPanel.add(scrollPane);
		
		maKHTxt = new JTextField();
		maKHTxt.setBounds(538, 8, 234, 20);
		contentPanel.add(maKHTxt);
		maKHTxt.setColumns(10);
		
		JLabel lblTnKhchHng = new JLabel("M\u00E3 kh\u00E1ch h\u00E0ng:");
		lblTnKhchHng.setBounds(422, 11, 114, 14);
		contentPanel.add(lblTnKhchHng);
		
		JLabel lblSinThoii = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblSinThoii.setBounds(422, 73, 114, 14);
		contentPanel.add(lblSinThoii);
		
		sdtTxt = new JTextField();
		sdtTxt.setColumns(10);
		sdtTxt.setBounds(538, 70, 234, 20);
		contentPanel.add(sdtTxt);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblaCh.setBounds(422, 104, 114, 14);
		contentPanel.add(lblaCh);
		
		JLabel lblCngN = new JLabel("C\u00F4ng n\u1EE3:");
		lblCngN.setBounds(422, 135, 114, 14);
		contentPanel.add(lblCngN);
		
		diaChiTxt = new JTextField();
		diaChiTxt.setColumns(10);
		diaChiTxt.setBounds(538, 101, 234, 20);
		contentPanel.add(diaChiTxt);
		
		congNoTxt = new JTextField();
		congNoTxt.setColumns(10);
		congNoTxt.setBounds(538, 132, 234, 20);
		congNoTxt.setEditable(false);
		congNoTxt.setText("0");
		contentPanel.add(congNoTxt);
		
		
		JButton timKiemBtn = new JButton("T\u00ECm ki\u1EBFm");
		
		timKiemBtn.setBounds(645, 199, 127, 47);
		contentPanel.add(timKiemBtn);
		
		JButton themBtn = new JButton("Th\u00EAm");
		
		themBtn.setBounds(448, 199, 127, 47);
		contentPanel.add(themBtn);
		
		JButton btnNewButton_1 = new JButton("Ch\u1ECDn");
		btnNewButton_1.setBounds(447, 278, 325, 62);
		contentPanel.add(btnNewButton_1);
		
		JLabel lblTnKhchHng_1 = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng:");
		lblTnKhchHng_1.setBounds(422, 42, 114, 14);
		contentPanel.add(lblTnKhchHng_1);
		
		tenKHTxt = new JTextField();
		tenKHTxt.setColumns(10);
		tenKHTxt.setBounds(538, 39, 234, 20);
		contentPanel.add(tenKHTxt);
		
		JLabel label = new JLabel("");
		label.setBounds(487, 160, 296, 28);
		contentPanel.add(label);
		
		//Action:
		//Click vao bang hien thi len textfield
		table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = table.rowAtPoint(evt.getPoint());
		      
		        if (row >= 0) {
		            maKHTxt.setText((String) table.getValueAt(row, 0));
		            tenKHTxt.setText((String) table.getValueAt(row, 1));
		            sdtTxt.setText((String) table.getValueAt(row, 2));
		            diaChiTxt.setText((String) table.getValueAt(row, 3));
		            congNoTxt.setText((String) table.getValueAt(row, 4));
		        }
		    }
		});
		
		//Add btn:
		themBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				KhachHang khach = new KhachHang();
				
				khach.setTenKH(tenKHTxt.getText());
				khach.setSdt(sdtTxt.getText());
				khach.setDiaChi(diaChiTxt.getText());
				
				table.setModel(new KhachHangTblModel(khach));
			}
		});
		
		//Tim kiem btn:
		timKiemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new KhachHangTblModel(maKHTxt.getText(),
						 tenKHTxt.getText(),
						 sdtTxt.getText(),
						 diaChiTxt.getText()));
			}
		});
	}
}
