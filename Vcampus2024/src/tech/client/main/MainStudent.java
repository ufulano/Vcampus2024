package tech.client.main;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import tech.client.login.LoginGUI;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//时间相关
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import tech.client.login.*;
import Entity.UserEntity;
import tech.client.studentManage.SMStudentPersonal;
import tech.client.library.*;
import java.awt.Window;
import tech.client.schedule.*;
/**
 * 用户主页，学生
 */


public class MainStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldWelcom;
	private ImageSlider imageSlider;
	private JTextField txtVcampus;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainStudent frame = new MainStudent();
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
	public MainStudent() {
		
		UserEntity user = UserSession.getInstance().getUser();
        
        System.out.println("Student: " + user);
		System.out.println("Student:");
		System.out.println(user);
				
		int width = 90; 
		int height = 90; //icon大小
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainStudent.class.getResource("/resources/icon/icon1/school.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 903, 606);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 917, 567);
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
		Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		btnStudentStatus.setIcon(new ImageIcon(scaledImage));
		btnStudentStatus.setContentAreaFilled(false);
		btnStudentStatus.setBorderPainted(false);
		btnStudentStatus.setBounds(20, 441, 141, 126);

		
		JButton btnClass = new JButton("");
		ImageIcon originalIcon1 = new ImageIcon(MainStudent.class.getResource("/resources/icon/icon2/选课.png"));
		Image scaledImage1 = originalIcon1.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		btnClass.setIcon(new ImageIcon(scaledImage1));
		btnClass.setContentAreaFilled(false);
		btnClass.setBorderPainted(false);
		btnClass.setBorder(null);
		btnClass.setBounds(159, 432,151, 154);

		
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
		btnLibrary.setBounds(446, 441,132, 126);

		
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
		btnShop.setBounds(599, 459,121, 108);
		
		ImageSlider imageSlider = new ImageSlider();
        // 测试图片地址
        String[] imageUrls = {
            "https://example.com/image1.jpg",
            "https://example.com/image2.jpg",
            "https://example.com/image3.jpg"
        };
        imageSlider.setImageUrls(imageUrls);
        imageSlider.setVisible(true);
        
        JLabel lblXuanke_1 = new JLabel("我的课表");
        lblXuanke_1.setForeground(new Color(102, 0, 0));
        lblXuanke_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
        lblXuanke_1.setBounds(346, 541, 68, 26);
        panel.add(lblXuanke_1);
        
        ImageIcon originalIcon4 = new ImageIcon(MainStudent.class.getResource("/resources/icon/icon2/课表.png"));
		Image scaledImage4 = originalIcon4.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        JButton btnSchedule = new JButton("");
        btnSchedule.setIcon(new ImageIcon(scaledImage4));
        btnSchedule.setContentAreaFilled(false);
        btnSchedule.setBorderPainted(false);
        btnSchedule.setBorder(null);
        btnSchedule.setBounds(308, 432, 151, 154);
        panel.add(btnSchedule);
        
        imageSlider.setBounds(163, 95, 590, 336);
        panel.add(imageSlider);
        
		JLabel lblShop = new JLabel("校园超市");
		lblShop.setForeground(new Color(102, 0, 0));
		lblShop.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblShop.setBounds(636, 541, 60, 26);
		panel.add(lblShop);
		
		JLabel lblLibrary = new JLabel("图书馆");
		lblLibrary.setForeground(new Color(102, 0, 0));
		lblLibrary.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblLibrary.setBounds(492, 534, 60, 41);
		panel.add(lblLibrary);
		
		// 创建银行按钮
		JButton btnBank = new JButton();
		ImageIcon originalIcon5 = new ImageIcon(MainManager.class.getResource("/resources/icon/icon2/银行.png")); // 假设银行图标的路径
		Image scaledImage5 = originalIcon5.getImage().getScaledInstance(85, 85, Image.SCALE_SMOOTH);
		btnBank.setIcon(new ImageIcon(scaledImage5));
		btnBank.setContentAreaFilled(false);
		btnBank.setBorderPainted(false);
		btnBank.setBorder(null);
		btnBank.setBounds(742, 450, 127, 117); // 更新按钮位置和大小以匹配其他按钮
		panel.add(btnBank);

		JLabel lblXuanke = new JLabel("自主选课");
		lblXuanke.setForeground(new Color(102, 0, 0));
		lblXuanke.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblXuanke.setBounds(204, 541, 68, 26);
		panel.add(lblXuanke);
		
		JLabel lblStudentStatus = new JLabel("学籍信息");
		lblStudentStatus.setForeground(new Color(102, 0, 0));
		lblStudentStatus.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblStudentStatus.setLabelFor(btnStudentStatus);
		lblStudentStatus.setBounds(61, 541, 60, 26);
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
		
		JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/6功能主页背景.png")));
		backgroundLabel.setBounds(0, 0, 900, 600);
		contentPane.add(backgroundLabel);
		
		//功能模块的点击事件监听
		//学籍信息
		btnStudentStatus.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // 点击按钮时执行的代码
	                System.out.println("Student was clicked!");
	                boolean windowOpen = false;
	                Window[] windows = JFrame.getWindows();//获取所有打开窗口
	                for (Window window : JFrame.getWindows()) {
	                    if (window instanceof SMStudentPersonal &&window.isVisible()) {
	                        windowOpen = true;
	                        window.toFront(); // 将窗口带到最前面
	                        break;
	                    }
	                }
	                
	                if (!windowOpen) {
	                    SMStudentPersonal studentWindow = new SMStudentPersonal();
	                    studentWindow.setVisible(true);
	                } else {
	                    System.out.println("Student window is already open.");
	                }
	            }
	        });
		//课表
		btnClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 点击按钮时执行的代码
                System.out.println("Class was clicked!");
                boolean windowOpen = false;
                Window[] windows = JFrame.getWindows();//获取所有打开窗口
                for (Window window : JFrame.getWindows()) {
                    if (window instanceof scheduleStudentSide &&window.isVisible()) {
                        windowOpen = true;
                        window.toFront(); // 将窗口带到最前面
                        break;
                    }
                }
                
                if (!windowOpen) {
                	scheduleStudentSide studentWindow = new scheduleStudentSide();
                    studentWindow.setVisible(true);
                } else {
                    System.out.println("Student window is already open.");
                }
            }
        });
		//图书
		btnLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 点击按钮时执行的代码
                System.out.println("Library was clicked!");
                boolean windowOpen = false;
                Window[] windows = JFrame.getWindows();//获取所有打开窗口
                for (Window window : JFrame.getWindows()) {
                    if (window instanceof LibraryUserGUI &&window.isVisible()) {
                        windowOpen = true;
                        window.toFront(); // 将窗口带到最前面
                        break;
                    }
                }
                
                if (!windowOpen) {
                	LibraryUserGUI window = new LibraryUserGUI();
                    window.setVisible(true);
                } else {
                    System.out.println("Library is already open.");
                }
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
		
		String name=user.getuName();
		String number=user.getuNumber();
		LocalDate today = LocalDate.now();
		JLabel labelWelcome = new JLabel(greeting()+"! "+number+" "+name+" 今天是 "+today);
		labelWelcome.setForeground(new Color(141, 102, 75));
		labelWelcome.setFont(new Font("幼圆", Font.BOLD, 16));
		labelWelcome.setBounds(332, 10, 460, 42);
		panel.add(labelWelcome);
		
		JButton btnOut = new JButton("");
		ImageIcon originalIcon6 = new ImageIcon(MainManager.class.getResource("/resources/icon/icon2/退出.png")); // 假设银行图标的路径
		Image scaledImage6 = originalIcon6.getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);
		btnOut.setIcon(new ImageIcon(scaledImage6));
		btnOut.setContentAreaFilled(false);
		btnOut.setBorderPainted(false);
		btnOut.setBorder(null);
		btnOut.setBounds(802, 10, 68, 50);
		panel.add(btnOut);
		btnOut.setFont(new Font("幼圆", Font.BOLD, 12));
		
		JLabel lblShop_1 = new JLabel("网上银行");
		lblShop_1.setForeground(new Color(102, 0, 0));
		lblShop_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblShop_1.setBounds(775, 541, 60, 26);
		panel.add(lblShop_1);
		
		txtVcampus = new JTextField();
		txtVcampus.setOpaque(false);
		txtVcampus.setFont(new Font("幼圆", Font.BOLD, 30));
		txtVcampus.setText("虚拟校园系统");
		txtVcampus.setBounds(55, 2, 199, 83);
		txtVcampus.setBorder(null);
		panel.add(txtVcampus);
		
		
		txtVcampus.setColumns(10);
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
                    MainStudent.this.dispose();
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
	
	




