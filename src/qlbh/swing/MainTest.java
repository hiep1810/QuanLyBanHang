package qlbh.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainTest extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTabbedPane tabbedPane =  new JTabbedPane();
    LichSuNhap lsn = new LichSuNhap();
    LichSuBan lsb = new LichSuBan();
    JPanel pnBottom;
   
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dimension = new Dimension(toolkit.getScreenSize());
    int height = (int) dimension.getHeight();
    int width = (int) dimension.getWidth();
    public MainTest(){
    	
        setSize(width,height);//set fullscreen
      //  setLocation(120,100);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel pnLeft = new JPanel(); //panel trái quản lý các danh mục
        leftPane(pnLeft);
        pnLeft.setVisible(true);

        JPanel pnRight = new JPanel(); //panel phải - khung làm việc
        rightPane(pnRight);
        this.add(pnRight);
        pnRight.setVisible(true);

        pnBottom = new JPanel(); //panel danh mục chi tiết góc dưới bên trái
        bottomPane(pnBottom);
        pnBottom.setVisible(true);
    }
    private void bottomPane(JPanel pnBottom){
        add(pnBottom);
        pnBottom.setLayout(new GridLayout(7,1,0,5));
        pnBottom.setBounds(0,400,300,300);

    }
    private void rightPane(JPanel pnRight) {
        pnRight.setBounds(300,0, width-300,height);
        pnRight.setLayout(new CardLayout());

        tabbedPane.setBounds(200,0,1000,600);
        pnRight.add(tabbedPane);
        tabbedPane.setVisible(true);
               
    }

    public void leftPane(JPanel pnLeft){
        add(pnLeft);
        pnLeft.setLayout(new GridLayout(7,1,0,5));
        pnLeft.setBounds(0,0,300,300);

       
        JButton btQL2 = new JButton("Thống kê");
      //  btQL2.setBounds(0,70,200,30);
        pnLeft.add(btQL2);
        btQL2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	pnBottom.removeAll();
            	
            	 JButton btlsn = new JButton("Lịch sử nhập");
                 //  btQL.setBounds(0,0,300,30);
                   pnBottom.add(btlsn);
                   btlsn.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           lsn.setVisible(true);
                           tabbedPane.addTab("Lịch sử nhập",lsn);
                           tabbedPane.updateUI();
                       }
                   });
                   JButton btlsb = new JButton("Lịch sử bán");
                //   btQL1.setBounds(0,35,200,30);
                   pnBottom.add(btlsb);
                   btlsb.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           lsb.setVisible(true);
                           //tabbedPane.removeAll();
                           tabbedPane.addTab("Lịch sử bán",lsb);
                           tabbedPane.updateUI();
                       }
                   });
                pnBottom.updateUI();
            }
        });

        JButton btQL1 = new JButton("Quản lý sản phẩm");
        pnLeft.add(btQL1);
        btQL1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnBottom.removeAll();
                pnBottom.updateUI();
            }
        });

        JButton btLogout = new JButton("Đăng xuất");
        //btLogout.setBounds(0,100,200,40);
        pnLeft.add(btLogout);
        btLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int ok = JOptionPane.showConfirmDialog(null, "Bạn sẽ đăng xuất?");
				if(ok == JOptionPane.YES_OPTION )
                {
                    DangNhap dn = new DangNhap();
                    dn.setVisible(true);
                    setVisible(false);
                }


			}
        	
        });

        JButton btExit = new JButton("Thoát");
        pnLeft.add(btExit);
        btExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }


   /* public static void main(String[] args) {
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
    	MainTest mainTest = new MainTest();
        mainTest.setVisible(true);
    }*/
}
