package tech.client.shopping;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



public class ShopManagerGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Boolean click = true;

    int nowPos = 0;

    /**
     * Create the frame.
     */
    public ShopManagerGUI() {
        setTitle("Vcampus·商店管理系统");
        setIconImage(Toolkit.getDefaultToolkit().getImage(ShopManagerGUI.class.getResource("/resources/icon/icon2/shopping.png")));
        setResizable(false);
        setSize(1019, 758);
        setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 882, 689);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        // 中央工作区
        iniCenterPanel();


        // Head
        JLabel lblVcampus = new JLabel("商店管理系统");
        lblVcampus.setBounds(21, 10, 191, 43);
        lblVcampus.setHorizontalAlignment(SwingConstants.CENTER);
        lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        contentPane.add(lblVcampus);

        JButton btnBack = new JButton("返回");
        btnBack.setBounds(784, 10, 99, 46);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("返回按钮被点击");
                // 添加返回逻辑
                dispose(); // 关闭当前窗口
            }
        });
        btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        btnBack.setContentAreaFilled(false);
        contentPane.add(btnBack);

        // 左侧按钮
        JButton btnBooklist = new JButton("商品总览");
        btnBooklist.setBounds(1, 77, 171, 84);
        btnBooklist.setIcon(new ImageIcon(ShopManagerGUI.class.getResource("")));
        btnBooklist.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        btnBooklist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("商品总览按钮被点击");
                // 添加图书总览逻辑
            }
        });
        contentPane.add(btnBooklist);

        JButton btnManage = new JButton("订单管理");
        btnManage.setBounds(0, 171, 172, 84);
        btnManage.setIcon(new ImageIcon(ShopManagerGUI.class.getResource("")));
        btnManage.setFont(new Font("微软雅黑", Font.PLAIN, 17));
        btnManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("订单管理按钮被点击");
                // 添加订单管理逻辑
            }
        });
        contentPane.add(btnManage);

        JButton btnPush = new JButton("首页推送管理");
        btnPush.setBounds(0, 265, 172, 84);
        btnPush.setIcon(new ImageIcon(ShopManagerGUI.class.getResource("")));
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
        JLabel backgroundLabel = new JLabel(new ImageIcon(ShopManagerGUI.class.getResource("/resources/picture/老师课表背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        backgroundLabel.setLayout(null);
        contentPane.add(backgroundLabel);

        setVisible(true); // 确保窗口可见
        setSize(900, 600);
    }
    
    public void iniCenterPanel() {
    	// 初始化为商品总览界面
        ProductsTable productsTable = new ProductsTable();
        productsTable.setBackground(new Color(255, 255, 255));
        productsTable.setBorder(null);
        productsTable.setBounds(214, 86, 644, 477);
        contentPane.add(productsTable);
    	
    }
}


