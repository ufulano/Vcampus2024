package tech.client.shopping;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JComboBox;

/**
 * 用户商店首页推送管理的表格页面
 */
public class PushManagementPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable pushTable;
    private JTextField textSearch;
    private DefaultTableModel pushModel;
    private JComboBox<String> searchType;

    @SuppressWarnings("serial")
    public PushManagementPanel() {
    	setBackground(Color.WHITE);
        setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        setLayout(null);
        setOpaque(false);

        // 初始化表格模型
        Object[][] pushData = {
            // 这里可以添加一些初始数据
        };
        Object[] pushColumnNames = {"商品ID", "商品名", "价格", "库存余量", "推送状态"};
        pushModel = new DefaultTableModel(pushData, pushColumnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // 允许编辑“是否推送”列
                return column == 4;
            }
        };

        pushTable = new JTable(pushModel);
        JScrollPane jsp = new JScrollPane(pushTable);
        jsp.setBounds(30, 61, 566, 401); // 调整大小和位置
        add(jsp);

        // 初始化搜索框
        textSearch = new JTextField();
        textSearch.setBounds(222, 21, 183, 30);
        textSearch.setColumns(10);
        add(textSearch);

        JLabel lblSearch = new JLabel("搜索商品");
        lblSearch.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        lblSearch.setBounds(153, 24, 64, 20);
        add(lblSearch);
        
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(30, 21, 95, 26);
        searchType.addItem("推送中");
        searchType.addItem("未推送");
        searchType.addItem("全部商品");
        add(comboBox);


        // 初始化查询按钮
        JButton btnSearch = new JButton("查询");
        btnSearch.setBounds(516, 21, 80, 30);
        btnSearch.setBackground(Color.white);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 查询逻辑
                // 这里可以根据 textSearch 文本框的内容来过滤表格数据
            }
        });
        add(btnSearch);

    }
}