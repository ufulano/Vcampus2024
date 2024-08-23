package tech.client.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JRadioButton;

/**
 * 登陆界面GUI
 * 施工中
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
					frame.setSize(465,300);//设置窗口大小 
					frame.setResizable(false);
					frame.setTitle("Login");//设置标题
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		JLabel lblUsername = new JLabel("用户名：");
		lblUsername.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblUsername, 63, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblUsername, 68, SpringLayout.WEST, contentPane);
		contentPane.add(lblUsername);//第二种构造
		
		JButton btnLogin = new JButton("登录");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnLogin, 151, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnLogin, -210, SpringLayout.EAST, contentPane);
		btnLogin.setFont(new Font("幼圆", Font.PLAIN, 16));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnLogin, -34, SpringLayout.SOUTH, contentPane);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnLogin);
		
		JLabel lblPassword = new JLabel("密码：");
		lblPassword.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtUsername, 8, SpringLayout.NORTH, lblUsername);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtUsername, 3, SpringLayout.EAST, lblUsername);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtPassword, 32, SpringLayout.SOUTH, txtUsername);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtUsername, 0, SpringLayout.EAST, txtPassword);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtPassword, 151, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPassword, -8, SpringLayout.NORTH, txtPassword);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPassword, -3, SpringLayout.WEST, txtPassword);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnSignin = new JButton("注册");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSignin, 237, SpringLayout.WEST, contentPane);
		btnSignin.setFont(new Font("幼圆", Font.PLAIN, 16));
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSignin, 0, SpringLayout.NORTH, btnLogin);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSignin, 0, SpringLayout.SOUTH, btnLogin);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSignin, 86, SpringLayout.EAST, btnLogin);
		contentPane.add(btnSignin);
		
		Component verticalGlue = Box.createVerticalGlue();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, verticalGlue, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, verticalGlue, 0, SpringLayout.EAST, btnLogin);
		contentPane.add(verticalGlue);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		sl_contentPane.putConstraint(SpringLayout.WEST, verticalGlue_1, 0, SpringLayout.WEST, btnSignin);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, verticalGlue_1, 0, SpringLayout.SOUTH, verticalGlue);
		contentPane.add(verticalGlue_1);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		sl_contentPane.putConstraint(SpringLayout.EAST, txtPassword, -108, SpringLayout.WEST, horizontalGlue);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, horizontalGlue, -122, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, horizontalGlue, -10, SpringLayout.EAST, contentPane);
		contentPane.add(horizontalGlue);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton rdbtnStudent = new JRadioButton("学生");
		rdbtnStudent.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnStudent, 6, SpringLayout.SOUTH, txtPassword);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnLogin, 6, SpringLayout.SOUTH, rdbtnStudent);
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnStudent, 0, SpringLayout.WEST, btnLogin);
		contentPane.add(rdbtnStudent);
		group.add(rdbtnStudent);

		
		JRadioButton rdbtnManager = new JRadioButton("管理员");
		rdbtnManager.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, rdbtnManager, -6, SpringLayout.NORTH, btnLogin);
		contentPane.add(rdbtnManager);
		group.add(rdbtnManager);
		
		JRadioButton rdbtnTeacher = new JRadioButton("老师");
		rdbtnTeacher.setFont(new Font("微软雅黑 Light", Font.PLAIN, 12));
		sl_contentPane.putConstraint(SpringLayout.NORTH, rdbtnTeacher, 6, SpringLayout.SOUTH, txtPassword);
		sl_contentPane.putConstraint(SpringLayout.EAST, rdbtnTeacher, -195, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, rdbtnManager, 6, SpringLayout.EAST, rdbtnTeacher);
		contentPane.add(rdbtnTeacher);
		group.add(rdbtnTeacher);
	}
}
