package controller;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import javafx.scene.effect.Shadow;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CongNoDialog extends JDialog {
	private JFormattedTextField textField;
	private float congNoTraVe = 0f;
	
	/**
	 * Create the panel.
	 */
	public float getTienTra() {
		return congNoTraVe;
	}
	public CongNoDialog(float congNo) {
		initComponent(congNo);
		
		//Action down there:
		
	}
	public void initComponent(float congNo) {
		getContentPane().setLayout(null);
		setBounds(0,0,385,236);
		JLabel lblCngN = new JLabel("C\u00F4ng n\u1EE3 :");
		lblCngN.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblCngN.setBounds(10, 21, 92, 29);
		getContentPane().add(lblCngN);
		
		
		JLabel label = new JLabel(Float.toString(congNo));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(112, 21, 247, 29);
		getContentPane().add(label);
	
		NumberFormat format = DecimalFormat.getInstance();
		format.setMinimumFractionDigits(2);
		format.setMaximumFractionDigits(2);
		format.setRoundingMode(RoundingMode.HALF_UP);
		format.setGroupingUsed(false);
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setAllowsInvalid(false);//this is the key of format
		
		textField = new JFormattedTextField(formatter);
		textField.addKeyListener(new KeyAdapter() {
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
		textField.setText(Float.toString(congNo));
		textField.setBounds(112, 72, 247, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTinTrVo = new JLabel("Nh\u1EADp ti\u1EC1n ");
		lblTinTrVo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblTinTrVo.setBounds(10, 72, 95, 29);
		getContentPane().add(lblTinTrVo);
		
		JButton btnXcNhn = new JButton("X\u00E1c nh\u1EADn");
		btnXcNhn.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnXcNhn.setBounds(94, 145, 176, 41);
		getContentPane().add(btnXcNhn);
		
		JLabel canhBaoLabel = new JLabel("");
		canhBaoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		canhBaoLabel.setBounds(42, 112, 292, 23);
		getContentPane().add(canhBaoLabel);
		
		
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Float.parseFloat(textField.getText()) <= congNo){
					//do nothing
					
					congNoTraVe = Float.parseFloat(textField.getText());
					
					dispose();
				}
				else {
					canhBaoLabel.setText("Số tiền nhập không được lớn hơn công nợ !!");
				}
			}
		});
		
		btnXcNhn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Float.parseFloat(textField.getText()) <= congNo){
					//do nothing
					
					congNoTraVe = Float.parseFloat(textField.getText());
					
					
					dispose();
				}
				else {
					canhBaoLabel.setText("Số tiền nhập không được lớn hơn công nợ !!");
				}
			}
		});
	}
	/*
	public static void main(String[] args) {
		CongNoDialog cn = new CongNoDialog(1);
		JFrame frame = new JFrame();
		cn.setModal(true);
		frame.setVisible(true);
		frame.setBounds(0,0,500,500);
		cn.setVisible(true);
		float i = cn.getTienTra();
		System.out.println(i);
		cn = null;
	}
	*/
}
