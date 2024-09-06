package tech.client.shopping;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
/**
 * 管理员管理商品的表格页面
 */
public class ProductsTable extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable infoTable;
    private JTextField textName;
    private DefaultTableModel model;

    @SuppressWarnings("serial")
    public ProductsTable() {
        setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        setLayout(null);
        setOpaque(false);

        // 初始化表格模型
        Object[][] data = {
        };
        Object[] columnNames = {"商品ID", "商品名", "价格", "库存余量"};
        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 禁止编辑
            }
        };

        infoTable = new JTable(model);
        JScrollPane jsp = new JScrollPane(infoTable);
        jsp.setBounds(30, 61, 566, 401); // 调整大小和位置
        add(jsp);

        // 初始化文本框和下拉框
        textName = new JTextField();
        textName.setBounds(125, 21, 184, 30);
        textName.setColumns(10);
        add(textName);

        JLabel lblName = new JLabel("商品名或商品ID");
        lblName.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        lblName.setBounds(30, 24, 100, 20);
        add(lblName);

        // 初始化查询按钮
        JButton btnSearch = new JButton("查询");
        btnSearch.setBounds(319, 20, 76, 30);
        btnSearch.setBackground(Color.white);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 查询逻辑
            }
        });
        add(btnSearch);
        
        JButton btnAdd = new JButton("添加商品");
        btnAdd.setBounds(429, 21, 81, 30);
        add(btnAdd);
        
        JButton btnRemove = new JButton("删除商品");
        btnRemove.setBounds(515, 21, 81, 30);
        add(btnRemove);
    }
}