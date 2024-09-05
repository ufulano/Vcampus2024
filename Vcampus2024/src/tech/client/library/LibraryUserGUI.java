package tech.client.library;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import tech.client.main.MainStudent;
import tech.client.studentManage.SMStudentPersonal;

/**
 * 图书馆界面GUI，学生端和老师端
 */
public class LibraryUserGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel mainContentPane;
    private JButton backButton;
    private JScrollPane hotBookScrollPane;

    /**
     * Create the frame.
     */
    public LibraryUserGUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Vcampus·图书馆");
        setIconImage(Toolkit.getDefaultToolkit().getImage(LibraryManagerGUI.class.getResource("/resources/icon/icon2/library.png")));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        mainContentPane = new JPanel();
        mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainContentPane);
        mainContentPane.setLayout(null);

        // 初始化组件
        initHeader();
        initNavigationButtons();
        initHotBookList();
        initBackground();

        setVisible(true);
    }

    private void initHeader() {
        JLabel lblVcampus = new JLabel("图书馆", SwingConstants.CENTER);
        lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        lblVcampus.setBounds(21, 10, 117, 43);
        mainContentPane.add(lblVcampus);

        backButton = new JButton("返回");
        backButton.setBounds(784, 10, 99, 46);
        backButton.addActionListener(this::backButtonActionPerformed);
        backButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        backButton.setContentAreaFilled(false);
        mainContentPane.add(backButton);
    }

    private void initNavigationButtons() {
        JButton myBorrowingsButton = new JButton("我的借阅");
        myBorrowingsButton.setBounds(0, 77, 172, 84);
        myBorrowingsButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        myBorrowingsButton.addActionListener(this::myBorrowingsButtonActionPerformed);
        mainContentPane.add(myBorrowingsButton);

        JButton returnBooksButton = new JButton("还书");
        returnBooksButton.setBounds(0, 171, 172, 84);
        returnBooksButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        returnBooksButton.addActionListener(this::returnBooksButtonActionPerformed);
        mainContentPane.add(returnBooksButton);

        JButton borrowBooksButton = new JButton("借阅与检索");
        borrowBooksButton.setBounds(0, 265, 172, 84);
        borrowBooksButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        borrowBooksButton.addActionListener(this::borrowBooksButtonActionPerformed);
        mainContentPane.add(borrowBooksButton);
    }

    private void initHotBookList() {
        JPanel hotBookPanel = new JPanel();
        hotBookPanel.setBackground(new Color(255, 255, 255));
        hotBookPanel.setLayout(new GridLayout(0, 1));
        hotBookScrollPane = new JScrollPane(hotBookPanel);
        hotBookScrollPane.setBounds(318, 115, 462, 403);
        mainContentPane.add(hotBookScrollPane);
        hotBookScrollPane.setViewportView(hotBookPanel);
        hotBookPanel.setPreferredSize(new Dimension(hotBookScrollPane.getWidth() - 50, 300 * 5));
    }


    private void initBackground() {
        JLabel backgroundLabel = new JLabel(new ImageIcon(LibraryManagerGUI.class.getResource("/resources/picture/老师课表背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        mainContentPane.add(backgroundLabel);
    }


    private void backButtonActionPerformed(ActionEvent e) {
        System.out.println("返回按钮被点击");
        System.out.println("返回学生主界面");
		boolean windowOpen = false;
        Window[] windows = JFrame.getWindows();//获取所有打开窗口
        for (Window window : JFrame.getWindows()) {
            if (window instanceof MainStudent&&window.isVisible()) {
                windowOpen = true;
                dispose();
                window.toFront(); // 将窗口带到最前面
                break;
            }
        }
        
        if (!windowOpen) {
        	MainStudent window = new MainStudent();
        	dispose();
            window.setVisible(true);
        } else {
            System.out.println("Manager main window is already open.");
        }
    }

    private void myBorrowingsButtonActionPerformed(ActionEvent e) {
        System.out.println("我的借阅");
        System.out.println("Student was clicked!");
        boolean windowOpen = false;
        Window[] windows = JFrame.getWindows();//获取所有打开窗口
        for (Window window : JFrame.getWindows()) {
            if (window instanceof MyBookGUI &&window.isVisible()) {
                windowOpen = true;
                window.toFront(); // 将窗口带到最前面
                break;
            }
        }
        
        if (!windowOpen) {
        	MyBookGUI studentWindow = new MyBookGUI();
            studentWindow.setVisible(true);
        } else {
            System.out.println("Student window is already open.");
        }
    }

    private void returnBooksButtonActionPerformed(ActionEvent e) {
        System.out.println("还书");
    }

    private void borrowBooksButtonActionPerformed(ActionEvent e) {
        System.out.println("借阅");
    }

    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(LibraryUserGUI::new);
    }
    */
}