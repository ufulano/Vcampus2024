package tech.client.shopping;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

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
public class CartPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPopupMenu popupMenu;
    private List<ProductEntity> products;
    private JTable productTable;
    private JScrollPane scrollPane;
    private JLabel lblTotalPrice; // 用于显示总金额的标签

    // 缺省构造函数
     public CartPanel() {
        setBackground(Color.YELLOW);
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

        productTable.getColumn("商品图").setCellRenderer(new ImageRenderer());
        productTable.getColumn("价格").setCellRenderer(new DefaultTableCellRenderer());
        productTable.getColumn("价格").setCellEditor(new DefaultCellEditor(new JTextField()));
        

        // 设置表格自动调整
        productTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        productTable.setRowHeight(60); // 设置默认行高
        // 假设 "购买数量"列宽
        TableColumn column = productTable.getColumnModel().getColumn(2);
        // 设置列宽
        column.setWidth(20);
        setLayout(null);
        
        int columnIndex = 1; 
        TableColumn nameColumn = productTable.getColumnModel().getColumn(columnIndex);
        nameColumn.setCellRenderer(new WrappingTableCellRenderer());

        JButton btnNewButton = new JButton("移除商品"); // 要添加图标！
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setBounds(541, 43, 92, 32);
        add(btnNewButton);

        scrollPane = new JScrollPane(productTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(26, 85, 607, 393);
        add(scrollPane);

        JLabel lblNewLabel = new JLabel("购物车"); // 要添加图标！
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 26));
        lblNewLabel.setBounds(26, 20, 92, 55);
        add(lblNewLabel);

        JButton btnNewButton_1 = new JButton("结算");
        btnNewButton_1.setBackground(Color.WHITE);
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        btnNewButton_1.setBounds(512, 528, 121, 55);
        add(btnNewButton_1);

        lblTotalPrice = new JLabel("总金额: $0.000");
        lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTotalPrice.setFont(new Font("微软雅黑", Font.BOLD, 22));
        lblTotalPrice.setBounds(356, 477, 277, 55);
        add(lblTotalPrice);

        initializeDefaultProducts();
    }

    private void initializeDefaultProducts() {
        List<ProductEntity> productList = getProductList();
        if (productList != null) {
            for (ProductEntity product : productList) {
                addProduct(product, 1); // 缺省购买一件
            }
            updateTotalPrice(); // 更新总金额
        }
    }

    private List<ProductEntity> getProductList() {
        // 这里应该是调用后端接口获取产品列表的逻辑
        // 暂时使用一个空列表来代替
        return List.of(
                new ProductEntity(1, "Product 111111111111111111111111111111111111111111111111111111111111", new BigDecimal("9.99"), 100, "image1.png", 4.5f, "Daily", "Intro1", "AuthorIntro1"),
                new ProductEntity(2, "Product 2", new BigDecimal("19.99"), 150, "image2.png", 4.7f, "Stationery", "Intro2", "AuthorIntro2"),
                new ProductEntity(3, "Product 3", new BigDecimal("29.99"), 200, "image3.png", 4.9f, "Food", "Intro3", "AuthorIntro3"),
                new ProductEntity(3, "Product 3", new BigDecimal("29.99"), 200, "image3.png", 4.9f, "Food", "Intro3", "AuthorIntro3"),
                new ProductEntity(3, "Product 3", new BigDecimal("29.99"), 200, "image3.png", 4.9f, "Food", "Intro3", "AuthorIntro3"),
                new ProductEntity(3, "Product 3", new BigDecimal("29.99"), 200, "image3.png", 4.9f, "Food", "Intro3", "AuthorIntro3"),
                new ProductEntity(3, "Product 3", new BigDecimal("29.99"), 200, "image3.png", 4.9f, "Food", "Intro3", "AuthorIntro3"),
                new ProductEntity(3, "Product 3", new BigDecimal("29.99"), 200, "image3.png", 4.9f, "Food", "Intro3", "AuthorIntro3"),
                new ProductEntity(3, "Product 3", new BigDecimal("29.99"), 200, "image3.png", 4.9f, "Food", "Intro3", "AuthorIntro3"),
                new ProductEntity(3, "Product 3", new BigDecimal("29.99"), 200, "image3.png", 4.9f, "Food", "Intro3", "AuthorIntro3"),
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
        updateTotalPrice(); // 更新总金额
    }

    private void updateTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        for (ProductEntity product : products) {
            total = total.add(product.getpPrice().multiply(new BigDecimal(products.indexOf(product) + 1)));
        }
        lblTotalPrice.setText("总金额: $" + total.toString());
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
            JFrame frame = new JFrame("VCampus·购物车");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(670,670);
            frame.setResizable(false);

            CartPanel productDisplayPanel = new CartPanel();
            frame.getContentPane().add(productDisplayPanel);

            // 设置窗口居中显示
            frame.setLocationRelativeTo(null); // 相对于屏幕居中
            
            // 设置窗口图标

            frame.setIconImage(new ImageIcon(CartPanel.class.getResource("/resources/icon/icon2/shopping.png")).getImage());

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
                setHorizontalAlignment(SwingConstants.CENTER);
            } else {
                setIcon(null);
            }
            return this;
        }
    }
    
    class WrappingTableCellRenderer extends DefaultTableCellRenderer {
        private static final long serialVersionUID = 1L;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setHorizontalAlignment(JLabel.LEFT);
            // 设置文本自动换行
            String text = value != null ? value.toString() : "";
            String wrappedText = wrapText(text, table.getFontMetrics(table.getFont()), table.getColumnModel().getColumn(column).getWidth());
            setText(wrappedText);
            return this;
        }

        private String wrapText(String text, FontMetrics fm, int width) {
            StringBuilder wrappedText = new StringBuilder();
            String[] words = text.split(" ");
            for (String word : words) {
                if (fm.stringWidth(wrappedText.toString() + word + " ") <= width) {
                    wrappedText.append(word).append(" ");
                } else {
                    wrappedText.append("\n").append(word).append(" ");
                }
            }
            return wrappedText.toString();
        }
    }
}