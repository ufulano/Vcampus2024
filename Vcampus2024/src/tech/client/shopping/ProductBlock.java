package tech.client.shopping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class ProductBlock extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField jtxtPrice;
    private JTextField jtxtType;
    private String name;
    private JTextField textFieldNumber;


    // 缺省构造函数
    public ProductBlock() {
        initialize("", "", "", 0);
        setBorder(new LineBorder(new Color(205, 226, 235), 3, true));
        setSize(350, 309);
        setVisible(false); // 设置整个JPanel不可见
    }

    // 带参数的构造函数
    public ProductBlock(String picture, String information, String type, float price) {
        initialize(picture, information, type, price);
    }

    private void initialize(String picture, String information, String type, float price) {
        setBackground(Color.WHITE);
        

        // 设置全局字体为微软雅黑
        Font yaheiFont = new Font("微软雅黑", Font.PLAIN, 18);

        // 加入购物车按钮
        JButton btnAddProduct = createButton("加入购物车", 264, 221, 195, 49, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProductToCart(name, price);
            }
        });

        // 创建和配置图片显示区域
        JEditorPane edpPicture = createEditorPane(picture, 14, 10, 236, 261);

        // 创建和配置价格显示文本框
        jtxtPrice = createTextField(String.valueOf(price), 339, 149, 120, 59, Font.BOLD);

        // 创建和配置信息显示区域
        JTextArea txtAInformation = createTextArea(information, 264, 10, 195, 78, yaheiFont);

        // 创建和配置类型显示文本框
        jtxtType = createTextField(type, 339, 90, 120, 59, Font.BOLD);
        {
            textFieldNumber = new JTextField();
            textFieldNumber.setBounds(199, 192, 67, 39);
            textFieldNumber.setText("0.0");
            textFieldNumber.setHorizontalAlignment(SwingConstants.CENTER);
            textFieldNumber.setFont(new Font("微软雅黑", Font.PLAIN, 14));
            textFieldNumber.setColumns(10);
            add(textFieldNumber);
        }
        {
            JLabel label = new JLabel("库存:<dynamic>件");
            label.setBounds(199, 156, 120, 49);
            label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
            add(label);
        }
        {
            JLabel label = new JLabel("件");
            label.setBounds(276, 192, 24, 39);
            label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
            add(label);
        }
    }

    private JButton createButton(String text, int x, int y, int width, int height, ActionListener actionListener) {
        JButton buttonCart = new JButton(text);
        buttonCart.setBounds(199, 241, 113, 39);
        buttonCart.setBackground(new Color(255, 235, 205));
        buttonCart.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        buttonCart.addActionListener(actionListener);
        setLayout(null);
        add(buttonCart);
        return buttonCart;
    }

    private JEditorPane createEditorPane(String html, int x, int y, int width, int height) {
        JEditorPane editorPane = new JEditorPane();
        editorPane.setBounds(14, 30, 157, 233);
        editorPane.setEditable(false);
        editorPane.setContentType("text/html");
        editorPane.setText("<html><body>" + html + "</body></html>");
        add(editorPane);
        return editorPane;
    }

    private JTextField createTextField(String text, int x, int y, int width, int height, int fontStyle) {
        JTextField textFieldPrice = new JTextField();
        textFieldPrice.setBounds(199, 109, 113, 49);
        textFieldPrice.setBackground(new Color(255, 255, 255));
        textFieldPrice.setFont(new Font("微软雅黑", fontStyle, 20));
        textFieldPrice.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldPrice.setEditable(false);
        textFieldPrice.setText(text);
        textFieldPrice.setColumns(10);
        add(textFieldPrice);
        return textFieldPrice;
    }

    private JTextArea createTextArea(String text, int x, int y, int width, int height, Font font) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(199, 30, 113, 69);
        textArea.setFont(font);
        textArea.setEditable(false);
        textArea.setText(text);
        add(textArea);
        return textArea;
    }

    private void addProductToCart(String name, float price) {
        // 实现添加到购物车的功能
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    private void hideAllComponents() {
        edpPicture.setVisible(false);
        btnAddProduct.setVisible(false);
        jtxtPrice.setVisible(false);
        txtAInformation.setVisible(false);
        jtxtType.setVisible(false);
        lblInventory.setVisible(false);
        textFieldNumber.setVisible(false);
        lblInventoryCount.setVisible(false);
        lblType.setVisible(false);
    }

}