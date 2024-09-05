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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
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
		System.out.println("Student:");
		System.out.println(user);
		
		int width = 110; 
		int height = 110; //icon大小
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainStudent.class.getResource("/resources/icon/icon1/school.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 606);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(239, 0, 609, 569);
		panel.setOpaque(false); // 设置面板不透明，允许背景显示
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/学生主页背景.png")));
		backgroundLabel.setBounds(0, 0, 900, 600);
		contentPane.add(backgroundLabel);

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
		btnStudentStatus.setBounds(104, 184, 151, 154);

		
		JButton btnClass = new JButton("");
		ImageIcon originalIcon1 = new ImageIcon(MainStudent.class.getResource("/resources/icon/icon2/选课.png"));
		Image scaledImage1 = originalIcon1.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		btnClass.setIcon(new ImageIcon(scaledImage1));
		btnClass.setContentAreaFilled(false);
		btnClass.setBorderPainted(false);
		btnClass.setBorder(null);
		btnClass.setBounds(277, 184,151, 154);

		
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
		btnLibrary.setBounds(448, 184,151, 154);

		
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
		btnShop.setBounds(104, 364,151, 154);
		
		
		
		JLabel lblShop = new JLabel("校园超市");
		lblShop.setForeground(new Color(102, 0, 0));
		lblShop.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblShop.setBounds(154, 492, 60, 26);
		panel.add(lblShop);
		
		JLabel lblLibrary = new JLabel("图书馆");
		lblLibrary.setForeground(new Color(102, 0, 0));
		lblLibrary.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblLibrary.setBounds(506, 305, 60, 41);
		panel.add(lblLibrary);

		
		JButton btnNewButton_1_4 = new JButton("New button");
		btnNewButton_1_4.setBounds(303, 388, 113, 130);
		panel.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("New button");
		btnNewButton_1_5.setBounds(476, 388, 113, 130);

		JLabel lblXuanke = new JLabel("自主选课");
		lblXuanke.setForeground(new Color(102, 0, 0));
		lblXuanke.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblXuanke.setBounds(325, 312, 68, 26);
		panel.add(lblXuanke);
		
		JLabel lblStudentStatus = new JLabel("学籍信息");
		lblStudentStatus.setForeground(new Color(102, 0, 0));
		lblStudentStatus.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblStudentStatus.setLabelFor(btnStudentStatus);
		lblStudentStatus.setBounds(153, 312, 60, 26);
		panel.add(lblStudentStatus);

		panel.add(btnStudentStatus);
		panel.add(btnClass);
		panel.add(btnLibrary);
		panel.add(btnShop);
		panel.add(btnNewButton_1_5);
		
		JButton btnOut = new JButton("登出");
		btnOut.setFont(new Font("幼圆", Font.BOLD, 12));
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOut.setBounds(1049, 21, 111, 36);
		contentPane.add(btnOut);

		panel.add(btnStudentStatus);
		panel.add(btnClass);
		panel.add(btnLibrary);
		panel.add(btnShop);
		panel.add(btnNewButton_1_5);
		
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
		
		String name=user.getuName();
		String number=user.getuNumber();
		LocalDate today = LocalDate.now();
		JLabel labelWelcome = new JLabel(greeting()+"! "+number+" "+name+" 今天是 "+today);
		labelWelcome.setBounds(120, 80, 460, 50);
		panel.add(labelWelcome);


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
	
	




