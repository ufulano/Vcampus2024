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
import javax.swing.JTextField;

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
	public static void main(String[] args) {
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
		
		textFieldWelcom = new JTextField();
		textFieldWelcom.setText("欢迎语：【早上/下午/晚上好!,<学号><姓名>，】x今天是<日期>");
		textFieldWelcom.setBounds(120, 80, 460, 50);
		panel.add(textFieldWelcom);
		textFieldWelcom.setColumns(10);

	}
}
