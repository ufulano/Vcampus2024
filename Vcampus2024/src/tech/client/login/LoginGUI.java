package tech.client.login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import tech.connection.Message;
import tech.connection.SocketClientWorker;
import tech.client.main.mainAssist;
import tech.client.main.UserSession;
import Entity.UserEntity;

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
        setIconImage(Toolkit.getDefaultToolkit().getImage(LoginGUI.class.getResource("/resources/icon/icon1/school.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 804, 602);
        setTitle("Vcampus·登录");
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        JLabel lblIcon = new JLabel();
        lblIcon.setIcon(new ImageIcon(LoginGUI.class.getResource("/resources/icon/icon1/schoolSmall.png")));
        lblIcon.setBounds(290, 224, 60, 51);
        contentPane.add(lblIcon);
        JLabel lblTitle = new JLabel("虚拟校园系统");
        lblTitle.setFont(new Font("幼圆", Font.BOLD, 24));
        lblTitle.setBounds(360, 239, 163, 44);
        contentPane.add(lblTitle);
        setContentPane(contentPane);

        // 创建用户名文本框并设置圆角灰色边框
        txtUsername = new JTextField("一卡通号/学号");
        txtUsername.setBounds(293, 287, 202, 29);
        txtUsername.setBorder(new LineBorder(Color.GRAY, 1, true)); 
        txtUsername.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtUsername.setForeground(Color.GRAY);
        txtUsername.setColumns(10);
        contentPane.add(txtUsername);

        // 创建密码文本框并设置圆角灰色边框
        txtPassword = new JPasswordField("密码");
        txtPassword.setBounds(292, 326, 203, 23);
        txtPassword.setToolTipText("请输入密码");
        txtPassword.setBorder(new LineBorder(Color.GRAY, 1, true)); 
        txtPassword.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        txtPassword.setForeground(Color.GRAY);
        txtPassword.setColumns(10);
        contentPane.add(txtPassword);

        // 登录按钮
        JButton btnLogin = new JButton("");
        btnLogin.setIcon(new ImageIcon(LoginGUI.class.getResource("/resources/icon/icon1/loginSmall.png")));
        btnLogin.setBounds(357, 370, 73, 44);
        btnLogin.setFont(new Font("幼圆", Font.PLAIN, 16));
        btnLogin.setContentAreaFilled(false);
        btnLogin.setBorderPainted(false);
        contentPane.add(btnLogin);

        // 背景标签
        JLabel backgroundLabel = new JLabel(new ImageIcon(LoginGUI.class.getResource("/resources/picture/loginBackground1.jpg")));
        backgroundLabel.setBounds(0, 0, 800, 600);
        contentPane.add(backgroundLabel);

        // 登录按钮的点击事件监听
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 点击按钮时执行的代码
                login();
            }
        });

        // 文本框焦点监听，用于移除提示标签
        txtUsername.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUsername.getText().equals("一卡通号/学号")) {
                    txtUsername.setText("");
                    txtUsername.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtUsername.getText().isEmpty()) {
                    txtUsername.setText("一卡通号/学号");
                    txtUsername.setForeground(Color.GRAY);
                }
            }
        });

        txtPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(txtPassword.getPassword()).equals("密码")) {
                    txtPassword.setText("");
                    txtPassword.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtPassword.getPassword().length == 0) {
                    txtPassword.setText("密码");
                    txtPassword.setForeground(Color.GRAY);
                }
            }
        });

        // 确保没有任何输入框自动获得焦点
        contentPane.setFocusable(true);
        setFocusTraversalPolicy(new FocusTraversalPolicy() {
            @Override
            public Component getInitialComponent(Window window) {
                return null; // 不自动设置焦点
            }

            public Component getDefaultComponent(Window window) {
                return null; // 不自动设置焦点
            }

            public Component getFirstComponent(Window window) {
                return null; // 不自动设置焦点
            }

            public Component getLastComponent(Window window) {
                return null; // 不自动设置焦点
            }

            @Override
            public Component getComponentAfter(Container focusCycleRoot, Component aComponent) {
                return null; // 不自动设置焦点
            }

            @Override
            public Component getComponentBefore(Container focusCycleRoot, Component aComponent) {
                return null; // 不自动设置焦点
            }

            @Override
            public Component getFirstComponent(Container aContainer) {
                return null; // 不自动设置焦点
            }

            @Override
            public Component getLastComponent(Container aContainer) {
                return null; // 不自动设置焦点
            }

            @Override
            public Component getDefaultComponent(Container aContainer) {
                return null; // 不自动设置焦点
            }
        });
    }

    // 登录操作的用户界面响应
    public void login() {
        errorLabel.setText("");
        if (txtUsername.getText().trim().equals("") || new String(txtPassword.getPassword()).trim().equals("")) {
            errorLabel.setForeground(Color.RED);
            contentPane.add(errorLabel);
            errorLabel.setText("有字段为空！");
            return;
        }

        System.out.println("测试用用户");
        UserEntity user = new UserEntity("1", "1", "和学校爆了", "2024830",
                "1", "1", 2, 1, new Date(System.currentTimeMillis()), "1", 1, "1");
        System.out.println("Main:");
        System.out.println(user);
        UserSession session = UserSession.getInstance();
        session.setUser(user);
        mainAssist.requireRouting();
        dispose();
    }
}