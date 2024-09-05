package tech.client.shopping;

import Entity.ProductEntity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.awt.event.ActionEvent;

public class ShopUserGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel HotList; // 定义 HotList 面板

    public ShopUserGUI() {
        initializeUI();
    }

    private void initializeUI() {
        setResizable(false);
        setTitle("Vcampus·商店");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        initUI();
        initBackground();
         // 加载产品到 HotList

        setVisible(true);
    }

    private void initUI() {
        // 初始化 HotList 面板并设置为两列的网格布局
        HotList = new JPanel();
        HotList.setLayout(new GridLayout(0, 2, 10, 10)); // 设置布局为两列，间距为 10
        JScrollPane scrollPane = new JScrollPane(HotList);
        scrollPane.setBounds(183, 117, 693, 436);
        contentPane.add(scrollPane);
        scrollPane.setViewportView(HotList);
        HotList.setPreferredSize(new Dimension(scrollPane.getWidth() - 50, 300 * 5));

        // 获取产品列表
        List<ProductEntity> productList = getProductList();

        // 为方便调试使用缺省的 ProductBlock
        int count = 0;
        for (ProductEntity product : productList) {
            ProductBlock productBlock = new ProductBlock(
                product.getpImg_url(),
                product.getpName(),
                "类型: " + product.getpLabel(),
                product.getpPrice().floatValue()
            );
            productBlock.setName(product.getpName());
            HotList.add(productBlock);
            count++;
        }

        // 如果产品数量不足10个，添加空白的 ProductBlock 填充
        while (count < 10) {
            ProductBlock emptyBlock = new ProductBlock(); // 缺省构造，用于空白块
            HotList.add(emptyBlock);
            count++;
        }

        // 创建购物车按钮
        JButton btnCart = createIconButton("购物车", "/resources/icon/icon2/shopping.png", 40, 40);
        btnCart.setBounds(41, 481, 76, 70);
        contentPane.add(btnCart);

        // 创建分类按钮
        JButton btnDaily = new JButton("日用品");
        btnDaily.setBounds(0, 261, 76, 70);
        contentPane.add(btnDaily);

        JButton btnStationery = new JButton("文具");
        btnStationery.setBounds(0, 177, 76, 70);
        contentPane.add(btnStationery);

        JButton btnFood = new JButton("食品");
        btnFood.setBounds(0, 97, 76, 70);
        contentPane.add(btnFood);

        // 创建返回按钮
        JButton backButton = new JButton("返回");
        backButton.setBounds(775, 10, 99, 46);
        backButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        backButton.setContentAreaFilled(false);
        contentPane.add(backButton);

        // 创建商店标签
        JLabel lblVcampus = new JLabel("商店", SwingConstants.CENTER);
        lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        lblVcampus.setBounds(0, 10, 117, 77);
        contentPane.add(lblVcampus);
    }


    private void loadProducts(JPanel productPanel) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                productPanel.removeAll(); // 清除现有产品
                List<ProductEntity> list = getProductList();
                if (list != null) {
                    for (ProductEntity product : list) {
                    }
                    productPanel.revalidate(); // 重新验证布局
                    productPanel.repaint(); // 重新绘制面板
                }
            }
        });
    }

    private List<ProductEntity> getProductList() {
        // 这里应该是调用后端接口获取产品列表的逻辑
        // 暂时使用一个示例列表来代替
        return List.of(
            new ProductEntity(1, "Product 1", new BigDecimal("9.99"), 100, "image1.png", 4.5f, "Daily", "Intro1", "AuthorIntro1"),
            new ProductEntity(2, "Product 2", new BigDecimal("19.99"), 150, "image2.png", 4.7f, "Stationery", "Intro2", "AuthorIntro2"),
            new ProductEntity(3, "Product 3", new BigDecimal("29.99"), 200, "image3.png", 4.9f, "Food", "Intro3", "AuthorIntro3")
        );
    }

    private JButton createIconButton(String text, String iconPath, int iconWidth, int iconHeight) {
        JButton button = new JButton("");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        try {
            InputStream iconStream = ShopUserGUI.class.getResourceAsStream(iconPath);
            if (iconStream == null) {
                System.err.println("Icon not found: " + iconPath);
                return button;
            }
            BufferedImage iconImage = ImageIO.read(iconStream);
            BufferedImage resizedImage = new BufferedImage(iconWidth, iconHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = resizedImage.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(iconImage.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH), 0, 0, null);
            g2d.dispose();
            button.setIcon(new ImageIcon(resizedImage));
        } catch (Exception e) {
            e.printStackTrace();
        }
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.CENTER);
        return button;
    }

    private void initBackground() {
        JLabel backgroundLabel = new JLabel(new ImageIcon(ShopUserGUI.class.getResource("/resources/picture/老师课表背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        contentPane.add(backgroundLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ShopUserGUI frame = new ShopUserGUI();
                frame.setVisible(true);
            }
        });
    }
}