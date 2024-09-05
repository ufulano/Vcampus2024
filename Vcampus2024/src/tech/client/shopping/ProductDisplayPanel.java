package tech.client.shopping;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDisplayPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPopupMenu popupMenu;
    private List<ProductBlock> productBlocks;
    private JPanel productPanel; // 用于存放商品的面板
    private JScrollPane scrollPane; // 用于提供滚动功能的滚动面板

    // 缺省构造函数
    public ProductDisplayPanel() {
        popupMenu = new JPopupMenu();
        productBlocks = new ArrayList<>();
        setOpaque(false);
        setLayout(new BorderLayout());

        productPanel = new JPanel();
        productPanel.setLayout(new GridLayout(0, 1)); // 使用 GridLayout
        productPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 添加一些边距

        // 将面板添加到滚动面板中
        scrollPane = new JScrollPane(productPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);

        // 获取并添加默认的ProductBlock实例
        initializeDefaultProducts();
    }

    private void initializeDefaultProducts() {
        // 模拟从服务器获取产品列表
        List<Product> productList = getProductList();
        if (productList != null) {
            for (Product product : productList) {
                addProductBlock(new ProductBlock(
                    product.getPicture(), 
                    product.getInformation(), 
                    product.getType(), 
                    product.getPrice()
                ));
            }
        }
    }

    private List<Product> getProductList() {
        // 这里应该是调用后端接口获取产品列表的逻辑
        // 暂时使用一个空列表来代替
        return List.of(
            new Product("image1.png", "Product 1 Information", "Category 1", 9.99f),
            new Product("image2.png", "Product 2 Information", "Category 2", 19.99f),
            new Product("image3.png", "Product 3 Information", "Category 3", 29.99f)
        );
    }

    public void addProductBlock(ProductBlock productBlock) {
        productBlocks.add(productBlock);
        productPanel.add(productBlock);
        productPanel.revalidate(); // 重新验证布局
        productPanel.repaint(); // 重新绘制面板
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
            JFrame frame = new JFrame("Product Display Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            ProductDisplayPanel productDisplayPanel = new ProductDisplayPanel();
            frame.getContentPane().add(productDisplayPanel);

            JButton button = new JButton("Show Products");
            button.addActionListener(e -> productDisplayPanel.showDropdown(button, new Point(0, button.getHeight())));
            frame.getContentPane().add(button, BorderLayout.NORTH);

            frame.setVisible(true);
        });
    }
}

class Product {
    private String picture;
    private String information;
    private String type;
    private float price;

    public Product(String picture, String information, String type, float price) {
        this.picture = picture;
        this.information = information;
        this.type = type;
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public String getInformation() {
        return information;
    }

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }
}