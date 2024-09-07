package tech.client.shopping;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Entity.ProductEntity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

/**
 * 购物车窗口，后续还需要调整图标
 */
public class OrderDetail extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPopupMenu popupMenu;
    private List<ProductEntity> products;
    private JTable productTable;
    private JScrollPane scrollPane;

    // 缺省构造函数
    public OrderDetail() {
    	setBackground(new Color(216, 238, 248));
        popupMenu = new JPopupMenu();
        products = new ArrayList<>();
        setOpaque(false);

        String[] columnNames = {"商品图", "商品名称", "购买数量", "价格"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            /**
			 * 创建表格模型
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public boolean isCellEditable(int row, int column) {
                // 所有单元格均不可编辑
                return false;
            }
        };
        productTable = new JTable(model);


        // 注意这里的列名要与上面定义的columnNames一致
        productTable.getColumn("商品图").setCellRenderer(new ImageRenderer());
        productTable.getColumn("价格").setCellRenderer(new DefaultTableCellRenderer());
        productTable.getColumn("价格").setCellEditor(new DefaultCellEditor(new JTextField()));
        setLayout(null);

        scrollPane = new JScrollPane(productTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(26, 70, 387, 312);
        add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("订单详情");
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 26));
        lblNewLabel.setBounds(26, 10, 162, 55);
        add(lblNewLabel);
        
        JButton btnNewButton_1 = new JButton("确认支付");
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        btnNewButton_1.setBounds(256, 463, 157, 55);
        btnNewButton_1.setContentAreaFilled(false);
        add(btnNewButton_1);
        
        JLabel lblNewLabel_1 = new JLabel("总价：<>");
        lblNewLabel_1.setForeground(new Color(128, 64, 0));
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 26));
        lblNewLabel_1.setBounds(232, 412, 178, 41);
        add(lblNewLabel_1);

        initializeDefaultProducts();
    }
    

    // 使用传入的产品列表初始化products
    public OrderDetail(List<ProductEntity> initialProducts) {
        this(); 
        products = new ArrayList<>(initialProducts);
        initializeDefaultProducts(); 
    }
    
    private void initializeDefaultProducts() {
        List<ProductEntity> productList = getProductList();
        if (productList != null) {
            for (ProductEntity product : productList) {
                addProduct(product, 1); // 缺省购买一件
            }
        }
    }

    private List<ProductEntity> getProductList() {
        // 这里应该是调用后端接口获取产品列表的逻辑
        // 暂时使用一个空列表来代替
        return List.of(
                new ProductEntity(1, "Product 1", new BigDecimal("9.99"), 100, "image1.png", 4.5f, "Daily", "Intro1", "AuthorIntro1"),
                new ProductEntity(2, "Product 2", new BigDecimal("19.99"), 150, "image2.png", 4.7f, "Stationery", "Intro2", "AuthorIntro2"),
                new ProductEntity(3, "Product 3", new BigDecimal("29.99"), 200, "image3.png", 4.9f, "Food", "Intro3", "AuthorIntro3")
        );
    }

    public void addProduct(ProductEntity product, int quantity) {
        products.add(product);
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        Object[] row = new Object[]{
            loadImage(product.getpImg_url()),
            product.getpName(),
            quantity, // 显示购买的件数
            product.getpPrice().toString() // 确保价格以字符串形式显示
        };
        model.addRow(row);
    }

    private ImageIcon loadImage(String path) {
        URL location = getClass().getResource(path);
        if (location != null) {
            try {
                BufferedImage image = ImageIO.read(location);
                return new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH)); // 调整图片大小
            } catch (IOException e) {
                System.err.println("Error loading image: " + path);
            }
        } else {
            System.err.println("Resource not found: " + path);
        }
        return new ImageIcon(new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB)); // 返回一个空白图片
    }

    public void showDropdown(Component invoker, Point location) {
        // 清空下拉框内容
        popupMenu.removeAll();

        // 将整个滚动面板添加到下拉框中
        popupMenu.add(scrollPane);

        // 显示下拉框
        popupMenu.show(invoker, location.x, location.y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("确认订单");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450,600);
            frame.setResizable(false); // 设置窗口大小不可调整

            OrderDetail productDisplayPanel = new OrderDetail();
            frame.getContentPane().add(productDisplayPanel);
            
         // 设置窗口居中显示
            frame.setLocationRelativeTo(null); // 相对于屏幕居中


            frame.setVisible(true);
        });
    }

    class ImageRenderer extends JLabel implements TableCellRenderer {
        private static final long serialVersionUID = 1L;

        public ImageRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                        boolean isSelected, boolean hasFocus,
                                                        int row, int column) {
            if (value != null) {
                setIcon((ImageIcon) value);
            } else {
                setIcon(null);
            }
            return this;
        }
    }
}