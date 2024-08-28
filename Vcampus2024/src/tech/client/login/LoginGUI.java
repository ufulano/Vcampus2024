package tech.client.login;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import type.UserType;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
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
	private JPasswordField txtPassword;//密码
	
	private JLabel errorLabel = new JLabel();//错误信息
	
	private JRadioButton rdbtnManager;
	private JRadioButton rdbtnStudent;
	private JRadioButton rdbtnTeacher;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("/resources/icon/icon1/school.png"));
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

		
		//登录按钮的点击事件监听
				btnLogin.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			                // 点击按钮时执行的代码
			                System.out.println("Button was clicked!");
			                login();
			            }
			        });
}
//登录操作的用户界面响应
public void login()
{
	errorLabel.setText("");//初始化
	/*判断用户名和密码是否为空
	*getText()无法用于获取JPasswordField类的文本
	*.getPassword()将返回char数组
	*/
    if (txtUsername.getText().trim().equals("") || new String(txtPassword.getPassword()).trim().equals("")) {
    	
    	errorLabel.setForeground(Color.RED);
    	contentPane.add(errorLabel);
    	errorLabel.setText("有字段为空！");
        return;
    }
    
    //向服务器发送连接  //初始化用户类型
    UserType type = null;
    Boolean flag=LoginVerify.verify(txtUsername.getText(),new String(txtPassword.getPassword()));
if(!flag) {
	System.out.println("登陆失败");
	return;
}
    //判断用户类型
   if (rdbtnStudent.isSelected()) {
		type = UserType.STUDENT;
		System.out.println("Student");
		//身份验证
		/*Student res = AuthHelper.verifyStudent(txtUsername.getText(), txtPassword.getPassword());
		if (res != null) {
			SwingUtils.showMessage(null, "学生登录成功！", "信息");
			// 填充App.session
			App.hasLogon = true;
			App.session = new Session(res);
			setVisible(false);
			// 要求界面路由
			App.requireRouting();
		} else {*/
			errorLabel.setForeground(Color.RED);
			contentPane.add(errorLabel);
			errorLabel.setText("密码错误，登录失败！");
			txtPassword.setText("");
		//}
		// -------------
	} else if (rdbtnTeacher.isSelected()) {
		type = UserType.TEACHER;
		System.out.println("Teacher");
		/*Teacher res = AuthHelper.verifyTeacher(txtUsername.getText(), txtPassword.getText());
		if (res != null) {
			SwingUtils.showMessage(null, "欢迎您，" + res.getName() + " 教师！", "信息");
			App.hasLogon = true;
			App.session = new Session(res);
			setVisible(false);
			App.requireRouting();
		} else {*/
			errorLabel.setForeground(Color.RED);
			contentPane.add(errorLabel);
			errorLabel.setText("密码错误，登录失败！");
			txtPassword.setText("");
		//}
		// -------------*/
	} else if (rdbtnManager.isSelected()) {
		type = UserType.MANAGER;
		System.out.println("Manager");
		/*Manager res = AuthHelper.verifyManager(txtUsername.getText(), txtPassword.getText());
		if (res != null) {
			SwingUtils.showMessage(null, res.getManagerType().toString() + " 管理员登陆成功！", "信息");
			App.hasLogon = true;
			App.session = new Session(res);
			setVisible(false);
			App.requireRouting();
		} else {*/
			errorLabel.setForeground(Color.RED);
			contentPane.add(errorLabel);
			errorLabel.setText("密码错误，登录失败！");
			txtPassword.setText("");
		//}*/
	}

}



}

