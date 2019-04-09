package qlbh.swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import qlbh.jdbc.KTDangNhap;
import qlbh.tam.MainFrame;

public class DangNhap extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUser;
	private JPasswordField tfPass;
	KTDangNhap kt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if("Windows".equals(info.getName())) {
							
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		kt = new KTDangNhap();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 400, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfUser = new JTextField();
		tfUser.setBounds(150, 30, 168, 33);
		contentPane.add(tfUser);
		tfUser.setColumns(10);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(150, 75, 168, 33);
		tfPass.setColumns(10);
		contentPane.add(tfPass);
		tfPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key == KeyEvent.VK_ENTER) {
					lg();
					}
				
				}

			});
		
		JLabel lblUser = new JLabel("TÃªn Ä‘Äƒng nháº­p");
		lblUser.setBounds(40, 30, 100, 33);
		contentPane.add(lblUser);
		
		JLabel lblPass = new JLabel("Máº­t kháº©u");
		lblPass.setBounds(40, 75, 100, 33);
		contentPane.add(lblPass);
		
		JButton btLogin = new JButton("Ä�Äƒng nháº­p");
		btLogin.setBounds(218,130,100,33);
		contentPane.add(btLogin);
		btLogin.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
					lg();		
			}
		});
	}
	
	public void lg() {
		System.out.println("log 1");
		String tk = tfUser.getText().trim();
		String mk = tfPass.getText().trim();

		int check = kt.testLogin(tk, mk);
		System.out.println("check: "+check);
		if(check==1) {
			System.out.println("ok");
			MainTest m = new MainTest();
			m.setVisible(true);
			setVisible(false);
		}else if(check==2) {
			System.out.println("2");
			MainFrame fr = new MainFrame();
			fr.setVisible(true);
			setVisible(false);
		}else
			JOptionPane.showMessageDialog(null, "Sai ", "Lá»—i", 1);	
	}
	}
