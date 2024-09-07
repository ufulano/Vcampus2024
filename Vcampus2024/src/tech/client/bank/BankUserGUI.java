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
import java.awt.Color;

/**
 * 图书馆界面GUI，学生端和老师端
 */
public class BankUserGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mainContentPane;
    private JButton backButton;

    public BankUserGUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Vcampus·网上银行");
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
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(144, 109, 640, 300);
        mainContentPane.add(panel);
        JLabel labelVcampus = new JLabel("网上银行", SwingConstants.CENTER);
        labelVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        labelVcampus.setBounds(65, 27, 161, 43);
        mainContentPane.add(labelVcampus);

        backButton = new JButton("返回");
        backButton.setBounds(762, 29, 99, 46);
        backButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        backButton.setContentAreaFilled(false);
        mainContentPane.add(backButton);
    }

    private void initNavigationButtons() {
        JButton cardRechargeButton = new JButton("卡片充值");
        cardRechargeButton.setBounds(103, 419, 172, 84);
        cardRechargeButton.setContentAreaFilled(false);
        cardRechargeButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        
        mainContentPane.add(cardRechargeButton);

        JButton myBillButton = new JButton("我的账单");
        myBillButton.setBounds(365, 419, 172, 84);
        myBillButton.setContentAreaFilled(false);
        myBillButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        
        mainContentPane.add(myBillButton);

        JButton passwordChangeButton = new JButton("密码修改");
        passwordChangeButton.setBounds(618, 419, 172, 84);
        passwordChangeButton.setContentAreaFilled(false);
        passwordChangeButton.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        mainContentPane.add(passwordChangeButton);
    }
    
    private void initBackground() {
        JLabel backgroundLabel = new JLabel(new ImageIcon(ShopUserGUI.class.getResource("/resources/picture/商店背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        mainContentPane.add(backgroundLabel);
    }
}