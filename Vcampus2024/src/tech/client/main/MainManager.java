package tech.client.main;
import java.awt.Color;
/**
 * 用户主页，管理员
 */
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window;
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
import tech.client.studentManage.SMManagerSide;
import tech.client.schedule.scheduleManagerSide;
import tech.client.shopping.ShopManagerGUI;
import tech.client.library.LibraryManagerGUI;

public class MainManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ImageSlider imageSlider;
	private JTextField txtVcampus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainManager frame = new MainManager();
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
	public MainManager() {

		UserEntity user = UserSession.getInstance().getUser();
		System.out.println("Manager:");
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
		panel.setBounds(0, 0, 887, 600);
		panel.setOpaque(false); // 设置面板不透明，允许背景显示
		contentPane.add(panel);
		panel.setLayout(null);
		
		String name=user.getuName();
		String number=user.getuNumber();
		LocalDate today = LocalDate.now();

		ImageSlider imageSlider = new ImageSlider();
        // 测试图片地址
        String[] imageUrls = {
            "https://example.com/image1.jpg",
            "https://example.com/image2.jpg",
            "https://example.com/image3.jpg"
        };
        imageSlider.setImageUrls(imageUrls);
        imageSlider.setVisible(true);
        imageSlider.setBounds(152, 103, 590, 327);
        panel.add(imageSlider);
		
        txtVcampus = new JTextField();
		txtVcampus.setOpaque(false);
		txtVcampus.setFont(new Font("幼圆", Font.BOLD, 30));
		txtVcampus.setText("虚拟校园系统");
		txtVcampus.setBounds(55, 2, 199, 83);
		txtVcampus.setBorder(null);
		panel.add(txtVcampus);
		
        JLabel labelWelcome = new JLabel(greeting()+"! "+number+" "+name+" 今天是 "+today);
		labelWelcome.setForeground(new Color(141, 102, 75));
		labelWelcome.setFont(new Font("幼圆", Font.BOLD, 16));
		labelWelcome.setBounds(332, 10, 460, 42);
		panel.add(labelWelcome);
		
		// 学籍信息按钮点击事件处理代码
				JButton btnStudentStatus = new JButton();
				btnStudentStatus.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				       
				    }
				});
				
				ImageIcon originalIcon = new ImageIcon(MainStudent.class.getResource("/resources/icon/icon2/学籍.png"));
				Image scaledImage = originalIcon.getImage().getScaledInstance(85,85, Image.SCALE_SMOOTH);
				btnStudentStatus.setIcon(new ImageIcon(scaledImage));
				btnStudentStatus.setContentAreaFilled(false);
				btnStudentStatus.setBorderPainted(false);
				btnStudentStatus.setBounds(89, 454, 117, 114);

				
				JButton btnClass = new JButton("");
				ImageIcon originalIcon1 = new ImageIcon(MainStudent.class.getResource("/resources/icon/icon2/选课.png"));
				Image scaledImage1 = originalIcon1.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
				btnClass.setIcon(new ImageIcon(scaledImage1));
				btnClass.setContentAreaFilled(false);
				btnClass.setBorderPainted(false);
				btnClass.setBorder(null);
				btnClass.setBounds(297, 454,104, 114);

				
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
				btnLibrary.setBounds(698, 451,117, 117);

				
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
				btnShop.setBounds(501, 440,117, 136);
				
				
				
				JLabel lblShop = new JLabel("商店管理");
				lblShop.setForeground(new Color(102, 0, 0));
				lblShop.setFont(new Font("微软雅黑", Font.BOLD, 14));
				lblShop.setBounds(539, 542, 67, 26);
				panel.add(lblShop);
				
				JLabel lblLibrary = new JLabel("图书管理");
				lblLibrary.setForeground(new Color(102, 0, 0));
				lblLibrary.setFont(new Font("微软雅黑", Font.BOLD, 14));
				lblLibrary.setBounds(725, 535, 67, 41);
				panel.add(lblLibrary);

				JLabel lblXuanke = new JLabel("选课管理");
				lblXuanke.setForeground(new Color(102, 0, 0));
				lblXuanke.setFont(new Font("微软雅黑", Font.BOLD, 14));
				lblXuanke.setBounds(325, 542, 67, 26);
				panel.add(lblXuanke);
				
				JLabel lblStudentStatus = new JLabel("学籍管理系统");
				lblStudentStatus.setForeground(new Color(102, 0, 0));
				lblStudentStatus.setFont(new Font("微软雅黑", Font.BOLD, 14));
				lblStudentStatus.setLabelFor(btnStudentStatus);
				lblStudentStatus.setBounds(108, 542, 86, 26);
				panel.add(lblStudentStatus);

				panel.add(btnStudentStatus);
				panel.add(btnClass);
				panel.add(btnLibrary);
				panel.add(btnShop);
				
				JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/4功能主页背景.png")));
				backgroundLabel.setBounds(0, 0, 900, 600);
				contentPane.add(backgroundLabel);
				
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
				                    MainManager.this.dispose();
				                    loginGUI.setVisible(true);
				                } else {
				                    System.out.println("取消操作");
				                    // 可以在这里执行用户取消登出的操作
				                }
				  
				            }
				        });
		        
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
				                    if (window instanceof SMManagerSide&&window.isVisible()) {
				                        windowOpen = true;
				                        window.toFront(); // 将窗口带到最前面
				                        break;
				                    }
				                }
				                
				                if (!windowOpen) {
				                	SMManagerSide window = new SMManagerSide();
				                    window.setVisible(true);
				                } else {
				                    System.out.println("Manager window is already open.");
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
		                    if (window instanceof scheduleManagerSide&&window.isVisible()) {
		                        windowOpen = true;
		                        window.toFront(); // 将窗口带到最前面
		                        break;
		                    }
		                }
		                
		                if (!windowOpen) {
		                	scheduleManagerSide window = new scheduleManagerSide();
		                    window.setVisible(true);
		                } else {
		                    System.out.println("Manager window is already open.");
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
		                    if (window instanceof LibraryManagerGUI&&window.isVisible()) {
		                        windowOpen = true;
		                        window.toFront(); // 将窗口带到最前面
		                        break;
		                    }
		                }
		                
		                if (!windowOpen) {
		                	LibraryManagerGUI window = new LibraryManagerGUI();
		                    window.setVisible(true);
		                } else {
		                    System.out.println("Manager window is already open.");
		                }
		            }
		        });
				//商城
				btnShop.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // 点击按钮时执行的代码
		                System.out.println("Shop was clicked!");
		                boolean windowOpen = false;
		                Window[] windows = JFrame.getWindows();//获取所有打开窗口
		                for (Window window : JFrame.getWindows()) {
		                    if (window instanceof ShopManagerGUI &&window.isVisible()) {
		                        windowOpen = true;
		                        window.toFront(); // 将窗口带到最前面
		                        break;
		                    }
		                }
		                
		                if (!windowOpen) {
		                	ShopManagerGUI window = new ShopManagerGUI();
		                    window.setVisible(true);
		                } else {
		                    System.out.println("Shopping is already open.");
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
