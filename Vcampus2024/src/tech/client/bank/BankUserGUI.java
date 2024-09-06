package tech.client.bank;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import tech.client.shopping.ShopUserGUI;


/**
 * 图书馆界面GUI，学生端和老师端
 */
public class BankUserGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mainContentPane;
    private JButton backButton;
    private JScrollPane hotBookScrollPane;
    private JPanel HotList; // 定义 HotList 面板

    public BankUserGUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Vcampus·图书馆");
        setIconImage(Toolkit.getDefaultToolkit().getImage(BankUserGUI.class.getResource("/resources/icon/icon2/library.png")));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        mainContentPane = new JPanel();
        mainContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainContentPane);
        mainContentPane.setLayout(null);

        initHeader();
        initNavigationButtons();
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
        backButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        backButton.setContentAreaFilled(false);
        mainContentPane.add(backButton);
    }

    private void initNavigationButtons() {
        JButton myBorrowingsButton = new JButton("我的借阅");
        myBorrowingsButton.setBounds(0, 77, 172, 84);
        myBorrowingsButton.setContentAreaFilled(false);
        myBorrowingsButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        
        mainContentPane.add(myBorrowingsButton);

        JButton returnBooksButton = new JButton("还书");
        returnBooksButton.setBounds(0, 171, 172, 84);
        returnBooksButton.setContentAreaFilled(false);
        returnBooksButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        
        mainContentPane.add(returnBooksButton);

        JButton borrowBooksButton = new JButton("借阅与检索");
        borrowBooksButton.setBounds(0, 265, 172, 84);
        borrowBooksButton.setContentAreaFilled(false);
        borrowBooksButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        mainContentPane.add(borrowBooksButton);
    }
    
    private void initBackground() {
        JLabel backgroundLabel = new JLabel(new ImageIcon(ShopUserGUI.class.getResource("/resources/picture/老师课表背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        mainContentPane.add(backgroundLabel);
    }
}