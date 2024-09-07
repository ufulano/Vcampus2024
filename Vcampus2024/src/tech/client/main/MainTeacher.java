package tech.client.main;
import java.awt.Color;
/**
 * 用户主页，老师
 */
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Entity.UserEntity;
import tech.client.login.LoginGUI;

public class MainTeacher extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainTeacher frame = new MainTeacher();
					frame.setVisible(true);
					frame.setSize(900,600);
					frame.setTitle("Vcampus·个人主页");
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
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
	public MainTeacher() {
		
		UserEntity user = UserSession.getInstance().getUser();
		System.out.println(user);
		
		int width = 110; 
		int height = 110; //icon大小
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainStudent.class.getResource("/resources/icon/icon1/school.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 903, 606);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(87, 10, 877, 557);
		panel.setOpaque(false); // 设置面板不透明，允许背景显示
		contentPane.add(panel);
		panel.setLayout(null);

		// 学籍信息按钮点击事件处理代码
		JButton btnStudentStatus = new JButton();
		btnStudentStatus.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		    }
		});
		
		ImageIcon originalIcon = new ImageIcon(MainStudent.class.getResource("/resources/icon/icon2/学籍.png"));
		Image scaledImage = originalIcon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
		btnStudentStatus.setIcon(new ImageIcon(scaledImage));
		btnStudentStatus.setContentAreaFilled(false);
		btnStudentStatus.setBorderPainted(false);
		btnStudentStatus.setBounds(0, 375, 151, 154);

		
		JButton btnClass = new JButton("");
		ImageIcon originalIcon1 = new ImageIcon(MainStudent.class.getResource("/resources/icon/icon2/选课.png"));
		Image scaledImage1 = originalIcon1.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		btnClass.setIcon(new ImageIcon(scaledImage1));
		btnClass.setContentAreaFilled(false);
		btnClass.setBorderPainted(false);
		btnClass.setBorder(null);
		btnClass.setBounds(134, 375,151, 154);

		
		JButton btnLibrary = new JButton("");
		btnLibrary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ImageIcon originalIcon2 = new ImageIcon(MainStudent.class.getResource("/resources/icon/icon2/library.png"));
		Image scaledImage2 = originalIcon2.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		btnLibrary.setIcon(new ImageIcon(scaledImage2));
		btnLibrary.setContentAreaFilled(false);
		btnLibrary.setBorderPainted(false);
		btnLibrary.setBorder(null);
		btnLibrary.setBounds(260, 377,151, 154);

		
		JButton btnShop = new JButton("");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ImageIcon originalIcon3 = new ImageIcon(MainStudent.class.getResource("/resources/icon/icon2/shopping.png"));
		Image scaledImage3 = originalIcon3.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		btnShop.setIcon(new ImageIcon(scaledImage3));
		btnShop.setContentAreaFilled(false);
		btnShop.setBorderPainted(false);
		btnShop.setBorder(null);
		btnShop.setBounds(408, 375,151, 154);
		
		ImageSlider imageSlider = new ImageSlider();
        // 测试图片地址
        String[] imageUrls = {
            "https://example.com/image1.jpg",
            "https://example.com/image2.jpg",
            "https://example.com/image3.jpg"
        };
        imageSlider.setImageUrls(imageUrls);
        imageSlider.setVisible(true);
        imageSlider.setBounds(64, 56, 590, 327);
        panel.add(imageSlider);
        
		JLabel lblShop = new JLabel("校园超市");
		lblShop.setForeground(new Color(102, 0, 0));
		lblShop.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblShop.setBounds(458, 503, 60, 26);
		panel.add(lblShop);
		
		JLabel lblLibrary = new JLabel("图书馆");
		lblLibrary.setForeground(new Color(102, 0, 0));
		lblLibrary.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblLibrary.setBounds(318, 498, 60, 41);
		panel.add(lblLibrary);
		
		JButton btnBank = new JButton("银行");
		btnBank.setBounds(569, 399, 113, 130);

		JLabel lblClass = new JLabel("我的课程");
		lblClass.setForeground(new Color(102, 0, 0));
		lblClass.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblClass.setBounds(182, 503, 68, 26);
		panel.add(lblClass);
		
		JLabel lblStudentStatus = new JLabel("学籍信息");
		lblStudentStatus.setForeground(new Color(102, 0, 0));
		lblStudentStatus.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblStudentStatus.setLabelFor(btnStudentStatus);
		lblStudentStatus.setBounds(49, 503, 60, 26);
		panel.add(lblStudentStatus);

		panel.add(btnStudentStatus);
		panel.add(btnClass);
		panel.add(btnLibrary);
		panel.add(btnShop);
		panel.add(btnBank);

		panel.add(btnStudentStatus);
		panel.add(btnClass);
		panel.add(btnLibrary);
		panel.add(btnShop);
		panel.add(btnBank);
		
		
		
		//功能模块的点击事件监听
		//课表
		btnClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 点击按钮时执行的代码
                System.out.println("Class was clicked!");
                //login();
            }
        });
		//图书
		btnLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 点击按钮时执行的代码
                System.out.println("Library was clicked!");
                //login();
            }
        });
		//商城
		btnShop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 点击按钮时执行的代码
                System.out.println("Shop was clicked!");
                //login();
            }
        });
		JButton btnOut = new JButton("登出");
		btnOut.setBounds(553, 10, 101, 36);
		panel.add(btnOut);
		btnOut.setFont(new Font("幼圆", Font.BOLD, 12));
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		//登出按钮的点击事件监听
		btnOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 弹出确认对话框
                int option = JOptionPane.showConfirmDialog(
                        null,                           // 父组件 (null 使对话框在屏幕中央)
                        "确定要登出吗？",                 // 提示消息
                        "确认登出",                     // 对话框标题
                        JOptionPane.YES_NO_OPTION        // 按钮类型 (YES 和 NO)
                );

                // 根据用户选择执行操作
                if (option == JOptionPane.YES_OPTION) {
                    System.out.println("退出登录");
                    // 执行登出操作
                    LoginGUI loginGUI = new LoginGUI();
                    MainTeacher.this.dispose();
                    loginGUI.setVisible(true);
                } else {
                    System.out.println("取消操作");
                    // 可以在这里执行用户取消登出的操作
                }
  
            }
        });


	}
	


	
	public static String greeting() {
		LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        
        String greeting;
        if (hour >= 5 && hour < 12) {
            greeting = "上午好";
        } else if (hour >= 12 && hour < 18) {
            greeting = "下午好";
        } else {
            greeting = "晚上好";
        }
        return greeting;

	}
}
