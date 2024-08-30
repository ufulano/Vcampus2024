package tech.client.studentManage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.BevelBorder;
import java.awt.Font;
import Entity.UserEntity; 

public class StudentTablePanel extends JPanel {

    private JTable infoTable;
    private JTextField textGrade;
    private List<UserEntity> result;
    private DefaultTableModel model;

    /**
     * Create the panel.
     */
    @SuppressWarnings("serial")
	public StudentTablePanel() {
        setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        setLayout(null); 
        // 初始化表格模型
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int a, int b) {
                return false;
            }
        };

        // 初始化表格
        String[] columnNames = {"一卡通号", "学号", "专业", "姓名"};
        infoTable = new JTable(model);
        JScrollPane jsp = new JScrollPane(infoTable);
        jsp.setBounds(42, 100, 619, 464); // 调整大小和位置以适应面板

        // 初始化文本框和下拉框
        textGrade = new JTextField();
        textGrade.setBounds(287, 50, 113, 30); // 调整位置和大小
        textGrade.setColumns(10);

        JComboBox<String> comboMajor = new JComboBox<>(new String[] {"计算机科学", "电子工程", "机械工程"}); // 示例数据
        comboMajor.setBounds(89, 49, 151, 30); // 调整位置和大小

        // 初始化标签
        JLabel lblMajor = new JLabel("专业");
        lblMajor.setBounds(50, 55, 100, 20); // 调整位置

        JLabel lblGrade = new JLabel("年级");
        lblGrade.setBounds(250, 55, 100, 20); // 调整位置

        // 初始化查询按钮
        JButton btnSearch = new JButton("查询");
        btnSearch.setBounds(428, 49, 80, 30); // 调整位置和大小
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 查询逻辑
            }
        });

        // 添加组件到面板
        add(jsp);
        add(textGrade);
        add(comboMajor);
        add(lblMajor);
        add(lblGrade);
        add(btnSearch);

        // 设置面板大小
        this.setSize(900, 600);
        this.setOpaque(false);

        // 由于使用绝对布局，需要调用 validate() 来应用布局
        this.validate();
    }
}