package tech.client.shopping;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

/**
 * 管理员管理订单的表格页面
 */
public class OrdersTable extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable ordersTable;
    private JTextField searchText;
    private JComboBox<String> searchType;
    private DefaultTableModel ordersModel;

    @SuppressWarnings("serial")
    public OrdersTable() {
        setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        setLayout(null);
        setOpaque(false);

        // 初始化表格模型
        Object[][] ordersData = {
            // 这里可以添加一些初始数据
        };
        Object[] ordersColumnNames = {"订单ID", "客户名", "订单状态", "总金额", "下单时间"};
        ordersModel = new DefaultTableModel(ordersData, ordersColumnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 禁止编辑
            }
        };

        ordersTable = new JTable(ordersModel);
        JScrollPane ordersScrollPane = new JScrollPane(ordersTable);
        ordersScrollPane.setBounds(30, 61, 566, 401); // 调整大小和位置
        add(ordersScrollPane);

        // 初始化搜索框
        searchText = new JTextField();
        searchText.setBounds(154, 21, 231, 30);
        searchText.setColumns(10);
        add(searchText);

        // 初始化搜索类型下拉框
        searchType = new JComboBox<>();
        searchType.setBounds(30, 21, 114, 30);
        searchType.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        // 添加选项
        searchType.addItem("订单ID");
        searchType.addItem("客户名");
        searchType.addItem("下单时间");
        add(searchType);

        JLabel lblSearch = new JLabel("搜索:");
        lblSearch.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        lblSearch.setBounds(30, 24, 60, 20);
        add(lblSearch);

        // 初始化查询按钮
        JButton btnSearch = new JButton("查询");
        btnSearch.setBounds(414, 21, 80, 30);
        btnSearch.setBackground(Color.white);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 查询逻辑
                // 根据 searchText 文本框的内容和 searchType 下拉框的选项来过滤表格数据
            }
        });
        add(btnSearch);
    }
}