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

import buttontable.ButtonColumn;

import controller.CongNoDialog;
import models.HienThiBanSanPhamModel;
import models.HienThiTimKiemSanPhamModel;
import models.KhachHangDAO;


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

public class MainScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchTxt;
	private JFormattedTextField giamGiaTxt;
	private JTextField textField;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 1200, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// TabbedPane :
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1184, 696);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(793, 11, 376, 297);
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

		JLabel lblNewLabel = new JLabel("Công nợ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 183, 145, 24);
		panel_4.add(lblNewLabel);

		JLabel lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKhchHng.setBounds(10, 11, 155, 37);
		panel_4.add(lblKhchHng);

		JLabel tenKH = new JLabel("Tên khách hàng :");
		tenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tenKH.setBounds(20, 78, 145, 24);
		panel_4.add(tenKH);

		JLabel lblNewLabel_2 = new JLabel("Số điện thoại :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 113, 145, 24);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Địa chỉ :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(20, 148, 74, 24);
		panel_4.add(lblNewLabel_3);

		JButton btnNewButton_1 = new JButton("Đổi khách hàng");
		btnNewButton_1.setBounds(10, 245, 155, 41);
		panel_4.add(btnNewButton_1);
		
		
		
		//Label k
		
		
		JLabel sdtTxt = new JLabel("");
		sdtTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sdtTxt.setBounds(175, 113, 191, 24);
		panel_4.add(sdtTxt);
		
		JLabel diaChiTxt = new JLabel("");
		diaChiTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		diaChiTxt.setBounds(175, 148, 191, 24);
		panel_4.add(diaChiTxt);
		
		JLabel congNoTxt = new JLabel("");
		congNoTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		congNoTxt.setBounds(175, 183, 191, 24);
		panel_4.add(congNoTxt);
		
		JLabel tenTxt = new JLabel("");
		tenTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tenTxt.setBounds(175, 78, 191, 24);
		panel_4.add(tenTxt);

		
		KhachHangDAO getDataKH = new KhachHangDAO();
		getDataKH.showKhachHangDefault(tenTxt, sdtTxt, diaChiTxt, congNoTxt);
		
		JButton btnThmNVo = new JButton("Thêm nợ vào hóa đơn");
		btnThmNVo.setBounds(195, 245, 171, 41);
		panel_4.add(btnThmNVo);
		if(Float.parseFloat(congNoTxt.getText() )>= 0) {
			
		}
		
		
		
		// Panel chua thong tin tim kiem
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 62, 740, 170);
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
		scrollPane.setBounds(0, 0, 740, 170);

		panel_1.add(scrollPane);

		String chose[] = { "Tìm kiếm theo tên sản phẩm", "Tìm kiếm theo mã sản phẩm" };
		JComboBox comboBox = new JComboBox(chose);
		comboBox.setBounds(540, 11, 212, 40);
		panel.add(comboBox);
		/*
		 * Action delete = new AbstractAction() { public void
		 * actionPerformed(ActionEvent e) { JTable table = (JTable)e.getSource(); int
		 * modelRow = Integer.valueOf( e.getActionCommand() );
		 * ((DefaultTableModel)table.getModel()).removeRow(modelRow); } };
		 * 
		 */

		searchTxt = new JTextField();
		searchTxt.setBounds(10, 11, 520, 40);
		panel.add(searchTxt);
		searchTxt.setColumns(10);

		// Panel chua thong tin san pham
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 273, 740, 350);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JTable table1 = new JTable();
		table1.setModel(new HienThiBanSanPhamModel());
		table1.getColumnModel().getColumn(4).setMaxWidth(45);
		table1.getColumnModel().getColumn(6).setMaxWidth(40);
		table1.setRowHeight(50);

		JScrollPane scrollPane1 = new JScrollPane(table1);
		scrollPane1.setBounds(0, 0, 740, 350);

		panel_2.add(scrollPane1);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(793, 319, 376, 304);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblGiaBan = new JLabel("Tổng Tiền :");
		lblGiaBan.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblGiaBan.setBounds(10, 22, 116, 30);
		panel_3.add(lblGiaBan);

		JLabel lblNewLabel_1 = new JLabel("Giảm giá :");
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
		giamGiaTxt.setBounds(125, 103, 142, 33);
		panel_3.add(giamGiaTxt);
	 	giamGiaTxt.setColumns(10);

		JButton btnNewButton_4 = new JButton("Thanh Toán");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InHoaDonDialog dl = new InHoaDonDialog();
				dl.setLocationRelativeTo(contentPane);
				dl.setModal(true);
				dl.setVisible(true);
				

				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.setBounds(0, 244, 376, 60);
		panel_3.add(btnNewButton_4);

		JLabel lblTongKet = new JLabel("Tổng Tiền Phải Trả :");
		lblTongKet.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTongKet.setBounds(10, 147, 183, 30);
		panel_3.add(lblTongKet);

		JLabel showTongTienLabel = new JLabel("0");
		showTongTienLabel.setForeground(Color.RED);
		showTongTienLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		showTongTienLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		showTongTienLabel.setBounds(136, 22, 230, 30);

		panel_3.add(showTongTienLabel);

		JToggleButton toggleButton = new JToggleButton("%");
		toggleButton.setBounds(320, 103, 46, 33);
		panel_3.add(toggleButton);

		JToggleButton toggleButton_1 = new JToggleButton("$");
		toggleButton_1.setBounds(277, 103, 46, 33);
		panel_3.add(toggleButton_1);

		JLabel tongTienPhaiTraLabel = new JLabel("0");
		tongTienPhaiTraLabel.setForeground(Color.RED);
		tongTienPhaiTraLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		tongTienPhaiTraLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tongTienPhaiTraLabel.setBounds(203, 146, 163, 30);
		panel_3.add(tongTienPhaiTraLabel);

		JLabel lblKhchTr = new JLabel("Khách Trả :");
		lblKhchTr.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblKhchTr.setBounds(10, 188, 183, 30);
		panel_3.add(lblKhchTr);

		textField = new JTextField();
		textField.setBounds(203, 188, 163, 30);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel noLabel = new JLabel("Trả nợ : ");
		noLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		noLabel.setBounds(10, 65, 116, 30);
		panel_3.add(noLabel);
		
		JLabel traNoLabel = new JLabel("0");
		traNoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		traNoLabel.setForeground(Color.BLACK);
		traNoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		traNoLabel.setBounds(136, 63, 230, 30);
		panel_3.add(traNoLabel);

		JButton btnXoaHang = new JButton("Xóa hàng");
		btnXoaHang.setBounds(612, 243, 138, 23);
		panel.add(btnXoaHang);
		btnXoaHang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int confirm = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa những mặt hàng đã chọn ?");
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
						JOptionPane.showMessageDialog(null, "Giảm giá không được hơn tiền phải trả");
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
					int confirm = JOptionPane.showConfirmDialog(null, "Xóa sản phẩm?");
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
					JOptionPane.showMessageDialog(null, "Số lượng bán không được hơn số lượng có");
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
							JOptionPane.showMessageDialog(null,
									"Số sản phẩm bán không được lớn hơn số sản phẩm đang có");
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
					JOptionPane.showMessageDialog(null, "Không có hàng để trử tiền ");
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
						JOptionPane.showMessageDialog(null, "Không được giảm giá hơn giá hàng !!!");
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
