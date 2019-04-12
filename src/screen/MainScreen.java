package screen;


import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


import java.text.DecimalFormat;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import models.ButtonColumn;
import models.HDBan;
import models.HDBanDAO;
import models.KhachHang;
import models.KhachHangDAO;
import models.table_models.HienThiBanSanPhamModel;
import models.table_models.HienThiTimKiemSanPhamModel;

import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;


import javax.swing.AbstractAction;
import javax.swing.Action;

import javax.swing.JTextField;


import java.awt.Font;
import javax.swing.JButton;

import javax.swing.border.EtchedBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainScreen extends JPanel {

	/**
	 * 
	 */
	private int maKH = 1;//Ma KH default
	private JPanel contentPane;
	private JTextField searchTxt;
	private JFormattedTextField giamGiaTxt;
	private JTextField tienTraTxt;
	private float tienTraTemp = 0;
	private boolean checkDaTinhNo = false;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
					
					
					JFrame f = new JFrame();
					f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.setVisible(true);
					f.setBounds(0,0,1010,610);
					f.getContentPane().add(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public MainScreen() {
		// Main sreen :
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0,0,1000,600);
		contentPane.setLayout(null);
		add(contentPane);
		
		// TabbedPane :
		//JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		//tabbedPane.setBounds(0, 0, 1000, 600);
		//contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		//tabbedPane.addTab("New tab", null, panel, null);
		panel.setBounds(0, 0, 1000, 600);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(653, 11, 332, 241);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		/*
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./images/1.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Border lineBorder = BorderFactory.createLineBorder(Color.blue);
		*/

		JLabel lblNewLabel = new JLabel("C\u00F4ng n\u1EE3 : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 156, 120, 24);
		panel_4.add(lblNewLabel);

		JLabel lblKhchHng = new JLabel("Kh\u00E1ch h\u00E0ng");
		lblKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKhchHng.setBounds(10, 11, 155, 37);
		panel_4.add(lblKhchHng);

		JLabel tenKH = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng :");
		tenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tenKH.setBounds(10, 51, 145, 24);
		panel_4.add(tenKH);

		JLabel lblNewLabel_2 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 86, 145, 24);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u0110\u1ECBa ch\u1EC9 :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 121, 74, 24);
		panel_4.add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("\u0110\u1ED5i kh\u00E1ch h\u00E0ng");
		
		btnNewButton_1.setBounds(10, 191, 139, 41);
		panel_4.add(btnNewButton_1);
		
		
		
		//Label k
		
		
		JLabel sdtTxt = new JLabel("");
		sdtTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sdtTxt.setBounds(131, 86, 191, 24);
		panel_4.add(sdtTxt);
		
		JLabel diaChiTxt = new JLabel("");
		diaChiTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		diaChiTxt.setBounds(131, 121, 191, 24);
		panel_4.add(diaChiTxt);
		
		JLabel congNoTxt = new JLabel("");
		congNoTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		congNoTxt.setBounds(131, 156, 191, 24);
		panel_4.add(congNoTxt);
		
		JLabel tenTxt = new JLabel("");
		tenTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tenTxt.setBounds(131, 51, 191, 24);
		panel_4.add(tenTxt);

		//Get khach hang default:
		
		KhachHangDAO getDataKH = new KhachHangDAO();
		getDataKH.showKhachHangDefault(tenTxt, sdtTxt, diaChiTxt, congNoTxt);
		getDataKH = null;
		
		JButton btnThmNVo = new JButton("Th\u00EAm n\u1EE3 v\u00E0o h\u00F3a \u0111\u01A1n");
		btnThmNVo.setBounds(159, 191, 163, 41);
		panel_4.add(btnThmNVo);
		/*
		if(Float.parseFloat(congNoTxt.getText() )>= 0) {
			
		}
		*/
		
		
		// Panel chua thong tin tim kiem
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 62, 633, 170);
		panel_1.setLayout(null);
		panel.add(panel_1);

		
		JTable table = new JTable();
		table.setModel(new HienThiTimKiemSanPhamModel());
		table.setRowHeight(50);
		// check first
		/*
		 * table.setModel(new HienThiTimKiemSanPhamModel()); table.setRowHeight(50);
		 * Action delete = new AbstractAction() { public void
		 * actionPerformed(ActionEvent e) { JTable table = (JTable)e.getSource(); int
		 * modelRow = Integer.valueOf( e.getActionCommand() );
		 * ((DefaultTableModel)table.getModel()).removeRow(modelRow); } };
		 * 
		 * 
		 * table.setCellEditor(new ButtonColumn(table, delete, 4));
		 * 
		 */
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 633, 170);

		panel_1.add(scrollPane);

		String chose[] = { "T\u00ECm ki\u1EBFm theo t\u00EAn s\u1EA3n ph\u1EA9m", "T\u00ECm ki\u1EBFm theo m\u00E3 s\u1EA3n ph\u1EA9m" };
		JComboBox comboBox = new JComboBox(chose);
		comboBox.setBounds(436, 11, 207, 40);
		panel.add(comboBox);
		/*
		 * Action delete = new AbstractAction() { public void
		 * actionPerformed(ActionEvent e) { JTable table = (JTable)e.getSource(); int
		 * modelRow = Integer.valueOf( e.getActionCommand() );
		 * ((DefaultTableModel)table.getModel()).removeRow(modelRow); } };
		 * 
		 */

		searchTxt = new JTextField();
		searchTxt.setBounds(10, 11, 416, 40);
		panel.add(searchTxt);
		searchTxt.setColumns(10);

		// Panel chua thong tin san pham
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 273, 633, 288);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JTable table1 = new JTable();
		table1.setModel(new HienThiBanSanPhamModel());
		table1.getColumnModel().getColumn(4).setMaxWidth(45);
		table1.getColumnModel().getColumn(6).setMaxWidth(40);
		table1.setRowHeight(50);

		JScrollPane scrollPane1 = new JScrollPane(table1);
		scrollPane1.setBounds(0, 0, 633, 288);

		panel_2.add(scrollPane1);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(653, 256, 332, 305);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblGiaBan = new JLabel("T\u1ED5ng Ti\u1EC1n :");
		lblGiaBan.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblGiaBan.setBounds(10, 22, 116, 30);
		panel_3.add(lblGiaBan);

		JLabel lblNewLabel_1 = new JLabel("Gi\u1EA3m gi\u00E1 :");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 106, 116, 30);
		panel_3.add(lblNewLabel_1);
		
		//
		//The key of format 
		//
		//DecimalFormatSymbols formatSym = new DecimalFormatSymbols();
		//formatSym.setNegativeSuffix
		DecimalFormat format = new DecimalFormat();
		
		/*
		int i = 1;
		int j = i+++i---++i;
		
		System.out.println("this"+j);
		
		*/
		
		//format.setNegativePrefix("");
		//NumberFormatter formatter = new NumberFormatter(format);
		//]formatter.setAllowsInvalid(false);//this is the key of format
		format.setGroupingUsed(false);
		
		giamGiaTxt = new JFormattedTextField();
		giamGiaTxt.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
			
				if(giamGiaTxt.getText().isEmpty()) {
				//khong hieu tai sao getText() == "" lai khong duoc phai dung isEmpty()	
					giamGiaTxt.setText("0");
				}
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				/*
				if(giamGiaTxt.getText().isEmpty()) {
				
					giamGiaTxt.setText("0");
				}
				*/
			}
		});
		giamGiaTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				//get the char key input to comare
				char c=arg0.getKeyChar();
				if(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE) {
					
				}
				else {
					//cam hanh dong do khong duoc xay ra (o day la keytyped khong dung dieu kien tren thi khong xay ra hanh dong nhap)
					arg0.consume();
				}
			}
		});
		
		giamGiaTxt.setText("0");
		giamGiaTxt.setBounds(125, 103, 194, 33);
		panel_3.add(giamGiaTxt);
	 	giamGiaTxt.setColumns(10);

		JButton btnNewButton_4 = new JButton("Thanh To\u00E1n");
		
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.setBounds(0, 244, 332, 61);
		panel_3.add(btnNewButton_4);

		JLabel lblTongKet = new JLabel("Phải Trả :");
		lblTongKet.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTongKet.setBounds(10, 147, 116, 30);
		panel_3.add(lblTongKet);

		JLabel showTongTienLabel = new JLabel("0");
		showTongTienLabel.setForeground(Color.RED);
		showTongTienLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		showTongTienLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		showTongTienLabel.setBounds(136, 21, 183, 30);

		panel_3.add(showTongTienLabel);

		JLabel tongTienPhaiTraLabel = new JLabel("0");
		tongTienPhaiTraLabel.setForeground(Color.RED);
		tongTienPhaiTraLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		tongTienPhaiTraLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tongTienPhaiTraLabel.setBounds(125, 147, 194, 30);
		panel_3.add(tongTienPhaiTraLabel);

		JLabel lblKhchTr = new JLabel("Kh\u00E1ch Tr\u1EA3 :");
		lblKhchTr.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblKhchTr.setBounds(10, 188, 183, 30);
		panel_3.add(lblKhchTr);

		tienTraTxt = new JTextField();
		tienTraTxt.setText("0");
		tienTraTxt.setBounds(125, 188, 194, 30);
		panel_3.add(tienTraTxt);
		tienTraTxt.setColumns(10);
		
		JLabel noLabel = new JLabel("Tr\u1EA3 n\u1EE3 : ");
		noLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		noLabel.setBounds(10, 65, 116, 30);
		panel_3.add(noLabel);
		
		JLabel traNoLabel = new JLabel("0");
		traNoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		traNoLabel.setForeground(Color.BLACK);
		traNoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		traNoLabel.setBounds(136, 63, 186, 30);
		panel_3.add(traNoLabel);

		JButton btnXoaHang = new JButton("X\u00F3a h\u00E0ng");
		btnXoaHang.setBounds(505, 243, 138, 23);
		panel.add(btnXoaHang);
		btnXoaHang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int confirm = JOptionPane.showConfirmDialog(null, "B\u1EA1n mu\u1ED1n x\u00F3a nh\u1EEFng m\u1EB7t h\u00E0ng \u0111\u00E3 ch\u1ECDn ?");
				if (confirm == JOptionPane.YES_OPTION) {

					for (int i = table1.getRowCount() - 1; i >= 0; i--) {

						if ((Boolean) table1.getModel().getValueAt(i, 7)) {
							((DefaultTableModel) table1.getModel()).removeRow(i);

						}
					}
				}
			}
		});

		table1.getModel().addTableModelListener(new TableModelListener() {

			public void tableChanged(TableModelEvent e) {
				// cap nhat tong tien khi bang thay doi

				float tienTraNo = Float.parseFloat(traNoLabel.getText());
				float sum = 0;
				
				if (table1.getRowCount() == 0) {
					showTongTienLabel.setText("0");
					if(Integer.parseInt(giamGiaTxt.getText()) > sum) {
						JOptionPane.showMessageDialog(null, "Gi\u1EA3m gi\u00E1 kh\u00F4ng \u0111\u01B0\u1EE3c h\u01A1n ti\u1EC1n ph\u1EA3i tr\u1EA3");
						tongTienPhaiTraLabel.setText(String.valueOf(sum));
						giamGiaTxt.setText("0");
					}
					else {
						tongTienPhaiTraLabel.setText(String.valueOf(sum + tienTraNo - Integer.parseInt(giamGiaTxt.getText())));
					}
				}
				for (int i = 0; i < table1.getRowCount(); i++) {

					int temp1 = (Integer) table1.getModel().getValueAt(i, 5);
					float temp2 = Float.parseFloat(table1.getModel().getValueAt(i, 3).toString());
					sum = sum + temp1 * temp2;
					showTongTienLabel.setText(String.valueOf(sum));

					tongTienPhaiTraLabel.setText(String.valueOf(sum + tienTraNo - Integer.parseInt(giamGiaTxt.getText())));
				}

			}
		});
		Action giamSL = new AbstractAction() {
			
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int i = Integer.valueOf(e.getActionCommand());
				if ((Integer) table.getValueAt(i, 5) > 1) {
					((DefaultTableModel) table.getModel()).setValueAt((Integer) table.getValueAt(i, 5) - 1, i, 5);
				} else {
					int confirm = JOptionPane.showConfirmDialog(null, "X\u00F3a s\u1EA3n ph\u1EA9m?" );
					if (confirm == JOptionPane.YES_OPTION) {
						((DefaultTableModel) table.getModel()).removeRow(i);
					} else {

					}
				}
			}
		};
		Action tangSL = new AbstractAction() {
			
			public void actionPerformed(ActionEvent e) {
				// Check xem lieu so luong ban hon so luong co khong

				JTable table = (JTable) e.getSource();
				int i = Integer.valueOf(e.getActionCommand());
				if ((Integer) table1.getModel().getValueAt(i, 5) < Integer
						.parseInt((String) table1.getModel().getValueAt(i, 2))) {

					((DefaultTableModel) table.getModel()).setValueAt((Integer) table.getValueAt(i, 5) + 1, i, 5);
				} else {
					JOptionPane.showMessageDialog(null, "S\u1ED1 l\u01B0\u1EE3ng b\u00E1n kh\u00F4ng \u0111\u01B0\u1EE3c h\u01A1n s\u1ED1 l\u01B0\u1EE3ng c\u00F3");
				}
			}
		};
		// Button Column: set column 4 and 6 clickable
		table1.setCellEditor(new ButtonColumn(table1, tangSL, 4));
		table1.setCellEditor(new ButtonColumn(table1, giamSL, 6));

		Action add = new AbstractAction() {
		
			public void actionPerformed(ActionEvent e) {
				JTable table = (JTable) e.getSource();
				int i = Integer.valueOf(e.getActionCommand());

				boolean check = true;
				for (int j = 0; j < table1.getRowCount(); j++) {

					if (table1.getModel().getValueAt(j, 0).equals(table.getModel().getValueAt(i, 0))) {

						if ((Integer) table1.getModel().getValueAt(j, 5) < Integer
								.parseInt((String) table1.getModel().getValueAt(j, 2))) {

							table1.getModel().setValueAt((Integer) table1.getValueAt(j, 5) + 1, j, 5);
							check = false;
						} else {
							JOptionPane.showMessageDialog(null, "S\u1ED1 s\u1EA3n ph\u1EA9m b\u00E1n kh\u00F4ng \u0111\u01B0\u1EE3c l\u1EDBn h\u01A1n s\u1ED1 s\u1EA3n ph\u1EA9m \u0111ang c\u00F3"
									);
							check = false;
						}
					}
				}
				if (check) {
					Vector<Object> values = new Vector<Object>();

					values.addElement(((DefaultTableModel) table.getModel()).getValueAt(i, 0));
					values.addElement(((DefaultTableModel) table.getModel()).getValueAt(i, 1));
					values.addElement(((DefaultTableModel) table.getModel()).getValueAt(i, 2));
					values.addElement(((DefaultTableModel) table.getModel()).getValueAt(i, 3));
					values.addElement("+");
					values.addElement(1);
					values.addElement("-");
					values.addElement(new Boolean(false));

					((DefaultTableModel) table1.getModel()).addRow(values);
				}
			}
		};
		
		Action action = new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					table.setModel(new HienThiTimKiemSanPhamModel(searchTxt.getText().toString(), false));
					table.setCellEditor(new ButtonColumn(table, add, 4));
					//System.out.println(comboBox.getSelectedIndex());
				} else {
					table.setModel(new HienThiTimKiemSanPhamModel(searchTxt.getText().toString(), true));
					table.setCellEditor(new ButtonColumn(table, add, 4));
					System.out.println(comboBox.getSelectedIndex());
				}

			}
		};

		searchTxt.addActionListener(action);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				traNoLabel.setText("0");
				KhachHangDialog dialog = new KhachHangDialog();
				dialog.setLocationRelativeTo(contentPane);
				dialog.setModal(true);
				dialog.setVisible(true);
				KhachHang temp = dialog.getKhachHang();
				
				if(temp == null) {
					//do nothing
				}else {
					tenTxt.setText(temp.getTenKH());
					sdtTxt.setText(temp.getSdt());
					diaChiTxt.setText(temp.getDiaChi());
					congNoTxt.setText(Float.toString(temp.getCongNo()));
					
					//ghi ma khach hang ma ta tinh no vao bien toan cuc maKH
					maKH = temp.getMaKH();
				}
			}
		});
		
		btnThmNVo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CongNoDialog cn = new CongNoDialog(Float.parseFloat(congNoTxt.getText()));
				cn.setLocationRelativeTo(contentPane);
				cn.setModal(true);
				cn.setVisible(true);
				if(checkDaTinhNo) {
					//showTongTienLabel.setText( Float.toString(Float.parseFloat(showTongTienLabel.getText()) );
					
					traNoLabel.setText(Float.toString(cn.getTienTra()));
					
					tongTienPhaiTraLabel.setText(Float.toString(Float.parseFloat(tongTienPhaiTraLabel.getText()) -
												tienTraTemp + 
												cn.getTienTra() -
												Integer.parseInt(giamGiaTxt.getText())));
					tienTraTemp = cn.getTienTra();
				}else {
					//showTongTienLabel.setText( Float.toString(Float.parseFloat(showTongTienLabel.getText()) + 
					//							cn.getTienTra()) );
					tongTienPhaiTraLabel.setText(Float.toString(Float.parseFloat(showTongTienLabel.getText()) +cn.getTienTra()-
													Integer.parseInt(giamGiaTxt.getText())));
					traNoLabel.setText(Float.toString(cn.getTienTra()));
					checkDaTinhNo = true;
					tienTraTemp = cn.getTienTra();
				}
				cn = null;
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				
				HDBanDAO st = new HDBanDAO();
				st.addHDBan(maKH);
				HDBan hd = st.getHDBan();
				System.out.println("Giam gia:"+Float.parseFloat(giamGiaTxt.getText()));
				InHoaDonDialog dl = new InHoaDonDialog(maKH,hd,
													   table1,
													   Float.parseFloat(giamGiaTxt.getText()),
													   Float.parseFloat(congNoTxt.getText()),
													   Float.parseFloat(tienTraTxt.getText()));
				dl.setLocationRelativeTo(contentPane);
				dl.setModal(true);
				dl.setVisible(true);
				
				//reset tat ca:
				table.setModel(new HienThiTimKiemSanPhamModel());
				table1.setModel(new HienThiBanSanPhamModel());
				KhachHangDAO getDataKH = new KhachHangDAO();
				getDataKH.showKhachHangDefault(tenTxt, sdtTxt, diaChiTxt, congNoTxt);
				giamGiaTxt.setText("0");
				congNoTxt.setText("0");
				tienTraTxt.setText("0");
				showTongTienLabel.setText("0");
				tongTienPhaiTraLabel.setText("0");
			}
		});
		giamGiaTxt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				float sum = 0;
				if (table1.getRowCount() == 0) {
					//khi bang khong co san pham
					showTongTienLabel.setText(String.valueOf(sum));
					tongTienPhaiTraLabel.setText(String.valueOf(sum));
					//tongTienPhaiTraLabel.setText(String.valueOf(sum - Integer.parseInt(giamGiaTxt.getText())));
					JOptionPane.showMessageDialog(null, "Kh\u00F4ng c\u00F3 h\u00E0ng \u0111\u1EC3 tr\u1EED ti\u1EC1n ");
					giamGiaTxt.setText("0");
				}
				else {
					float tienConNo = Float.parseFloat(traNoLabel.getText());
					for (int i = 0; i < table1.getRowCount(); i++) {
						
						int temp1 = (Integer) table1.getModel().getValueAt(i, 5);
						float temp2 = Float.parseFloat(table1.getModel().getValueAt(i, 3).toString());
						sum = sum + temp1 * temp2;
						
						
					}
					
					if(sum - Integer.parseInt(giamGiaTxt.getText()) < 0) {
						giamGiaTxt.setText("0");
						JOptionPane.showMessageDialog(null, "Kh\u00F4ng \u0111\u01B0\u1EE3c gi\u1EA3m gi\u00E1 h\u01A1n gi\u00E1 h\u00E0ng !!!");
						showTongTienLabel.setText(String.valueOf(sum));
						tongTienPhaiTraLabel.setText(String.valueOf(sum + tienConNo));
					}else {
						showTongTienLabel.setText(String.valueOf(sum));
						tongTienPhaiTraLabel.setText(String.valueOf(sum + tienConNo - Integer.parseInt(giamGiaTxt.getText())));
					}
				}
			}
		});

	}
}
