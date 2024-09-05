package tech.client.library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import tech.client.main.MainManager;
import tech.client.studentManage.SMManagerSide;

/**
 * 图书馆界面GUI，学生端和老师端
 */
public class LibraryManagerGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Boolean click = true;

    int nowPos = 0;

    /**
     * Create the frame.
     */
    public LibraryManagerGUI() {
        setTitle("Vcampus·图书馆管理系统");
        setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryManagerGUI.class.getResource("/resources/icon/icon2/library.png")));
        setResizable(false);
        setSize(1019, 758);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 882, 689);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setLayout(null);
        
        // 创建 BookTablePanel
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        // 创建 BookTablePanel
        BookTable bookPanel = new BookTable();
        bookPanel.setBackground(new Color(255, 255, 255));
        bookPanel.setBorder(null);
        bookPanel.setBounds(214, 86, 644, 477);
        contentPane.add(bookPanel);


        // Head
        JLabel lblVcampus = new JLabel("图书管理系统");
        lblVcampus.setBounds(21, 10, 220, 43);
        lblVcampus.setHorizontalAlignment(SwingConstants.CENTER);
        lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        contentPane.add(lblVcampus);

        JButton btnBack = new JButton("返回");
        btnBack.setBounds(784, 10, 99, 46);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("返回按钮被点击");
                System.out.println("返回管理员主界面");
				boolean windowOpen = false;
                Window[] windows = JFrame.getWindows();//获取所有打开窗口
                for (Window window : JFrame.getWindows()) {
                    if (window instanceof MainManager&&window.isVisible()) {
                        windowOpen = true;
                        LibraryManagerGUI.this.dispose();
                        window.toFront(); // 将窗口带到最前面
                        break;
                    }
                }
                
                if (!windowOpen) {
                	MainManager window = new MainManager();
                	LibraryManagerGUI.this.dispose();
                    window.setVisible(true);
                } else {
                    System.out.println("Manager main window is already open.");
                }
            }
        });
        btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        btnBack.setContentAreaFilled(false);
        contentPane.add(btnBack);

        // 左侧按钮
        JButton btnBooklist = new JButton("图书总览");
        btnBooklist.setBounds(1, 77, 171, 84);
        btnBooklist.setIcon(new ImageIcon(LibraryManagerGUI.class.getResource("")));
        btnBooklist.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        btnBooklist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("图书总览按钮被点击");
                // 添加图书总览逻辑
            }
        });
        contentPane.add(btnBooklist);

        JButton btnManage = new JButton("借阅管理");
        btnManage.setBounds(0, 171, 172, 84);
        btnManage.setIcon(new ImageIcon(LibraryManagerGUI.class.getResource("")));
        btnManage.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        btnManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("借阅管理按钮被点击");
                // 添加借阅管理逻辑
            }
        });
        contentPane.add(btnManage);

        JButton btnPush = new JButton("推送管理");
        btnPush.setBounds(0, 265, 172, 84);
        btnPush.setIcon(new ImageIcon(LibraryManagerGUI.class.getResource("")));
        btnPush.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        btnPush.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("推送管理按钮被点击");
                // 添加推送管理逻辑
            }
        });
        contentPane.add(btnPush);

        // 背景
        JLabel backgroundLabel = new JLabel(new ImageIcon(LibraryManagerGUI.class.getResource("/resources/picture/老师课表背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        backgroundLabel.setLayout(null);
        contentPane.add(backgroundLabel);

        setVisible(true); // 确保窗口可见
        setSize(900, 600);
    }
}


