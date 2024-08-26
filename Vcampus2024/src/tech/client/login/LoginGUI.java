package tech.client.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.SpringLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

/**
 * 登陆界面GUI
 * 基本完成
 * 
 * 
 */
public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);//显示窗口/隐藏窗口
					frame.setSize(800, 600);//设置窗口大小 
					frame.setTitle("Vcampus ");//设置标题
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
	
	public LoginGUI() {

		setForeground(new Color(240, 240, 240));
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\learngit\\Vcampus2024\\Vcampus2024\\Vcampus2024\\src\\resources\\icon\\icon1\\school.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 602);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JPanel panelType = new JPanel();
		panelType.setBounds(311, 331, 203, 29);
		contentPane.add(panelType);
		panelType.setOpaque(false);
		panelType.setBackground(null);

		JLabel lblIcon = new JLabel();
		lblIcon.setIcon(new ImageIcon(LoginGUI.class.getResource("/resources/icon/icon1/schoolSmall.png")));
		lblIcon.setBounds(299, 209, 60, 51);
		contentPane.add(lblIcon);
		JLabel lblTitle = new JLabel("虚拟校园系统");
		lblTitle.setFont(new Font("幼圆", Font.PLAIN, 24));
		lblTitle.setBounds(369, 224, 163, 44);
		contentPane.add(lblTitle);
		setContentPane(contentPane);
		
		//登录按钮
		JButton btnLogin = new JButton();
		btnLogin.setBounds(377, 377, 73, 44);
		Image loginIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icon/icon1/loginsmall.png"));
		btnLogin.setIcon(new ImageIcon(loginIcon));
		btnLogin.setForeground(SystemColor.activeCaption);
		btnLogin.setFont(new Font("幼圆", Font.PLAIN, 16));
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setBorder(null);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnLogin);
		
        // 创建用户名文本框并设置圆角灰色边框
        txtUsername = new JTextField();
        txtUsername.setBounds(312, 271, 202, 29);
        txtUsername.setText("  一卡通号/唯一ID");
        txtUsername.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true)); 
        txtUsername.setColumns(10);
        contentPane.add(txtUsername);

        // 创建密码文本框并设置圆角灰色边框
        txtPassword = new JPasswordField();
        txtPassword.setBounds(312, 310, 203, 23);
        txtPassword.setToolTipText("请输入密码");
        txtPassword.setBorder(new LineBorder(SystemColor.controlHighlight, 1, true)); 
        txtPassword.setColumns(10);
        contentPane.add(txtPassword);
		
        
        //用户类型按钮组
		ButtonGroup group = new ButtonGroup();
		
		Image studentImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icon/icon1/ic_student.png"));
		Image smallStudentImage = studentImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH); // 正确使用SCALE_SMOOTH常量
		ImageIcon studentIcon = new ImageIcon(smallStudentImage);
		JRadioButton rdbtnStudent = new JRadioButton("学生", studentIcon);
		rdbtnStudent.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		rdbtnStudent.setOpaque(false);
		rdbtnStudent.setBackground(null);
		panelType.add(rdbtnStudent);
		group.add(rdbtnStudent);
		
		Image teacherImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icon/icon1/jteacher.png"));
		Image smallTeacherImage = teacherImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH); // 正确使用SCALE_SMOOTH常量
		ImageIcon teacherIcon = new ImageIcon(smallTeacherImage);
		JRadioButton rdbtnTeacher = new JRadioButton("老师", teacherIcon);
		rdbtnTeacher.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		rdbtnTeacher.setOpaque(false);
		rdbtnTeacher.setBackground(null);
		panelType.add(rdbtnTeacher);
		group.add(rdbtnTeacher);


		Image managerImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icon/icon1/manager.png"));
		Image smallManagerImage = managerImage.getScaledInstance(20, 20, Image.SCALE_SMOOTH); // 正确使用SCALE_SMOOTH常量
		ImageIcon managerIcon = new ImageIcon(smallManagerImage);
		JRadioButton rdbtnManager = new JRadioButton("管理员", managerIcon);
		rdbtnManager.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		rdbtnManager.setOpaque(false);
		rdbtnManager.setBackground(null);
		panelType.add(rdbtnManager);
		group.add(rdbtnManager);
		
		
		JLabel backgroundLabel = new JLabel(new ImageIcon(LoginGUI.class.getResource("/resources/picture/loginBackground1.jpg")));
		backgroundLabel.setBounds(10, 10, 784, 563);
		contentPane.add(backgroundLabel);
		



		

	}
}
