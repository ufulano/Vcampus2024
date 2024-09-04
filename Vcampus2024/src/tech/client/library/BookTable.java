package tech.client.library;

import java.awt.Color;
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
import java.awt.Font;
/**
 * 管理员总览图书的表格
 */
public class BookTable extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable infoTable;
    private JTextField textGrade;
    private DefaultTableModel model;

    @SuppressWarnings("serial")
    public BookTable() {
        setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        setLayout(null);
        setOpaque(false);

        // 初始化表格模型
        Object[][] data = {
            {"书名1", "作者1", "ISBN1", "借阅中"},
            {"书名2", "作者2", "ISBN2", "未借阅"}
        };
        Object[] columnNames = {"书名", "作者", "ISBN", "借阅状态"};
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
        textGrade = new JTextField();
        textGrade.setBounds(290, 21, 113, 30);
        textGrade.setColumns(10);
        add(textGrade);

        JComboBox<String> comboMajor = new JComboBox<>(new String[] {"所有", "借阅中", "未借阅"});
        comboMajor.setBounds(111, 20, 132, 30);
        add(comboMajor);

        // 初始化标签
        JLabel lblMajor = new JLabel("借阅状态");
        lblMajor.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        lblMajor.setBounds(53, 26, 100, 20);
        add(lblMajor);

        JLabel lblGrade = new JLabel("书名");
        lblGrade.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        lblGrade.setBounds(253, 26, 100, 20);
        add(lblGrade);

        // 初始化查询按钮
        JButton btnSearch = new JButton("查询");
        btnSearch.setBounds(431, 20, 80, 30);
        btnSearch.setBackground(Color.white);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 查询逻辑
            }
        });
        add(btnSearch);
    }
}