package tech.client.bank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Entity.TransactionRecordEntity;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 银行账本记录面板
 */
public class BankAccountPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable transactionTable;
    private JScrollPane scrollPane;
    private JTextField textField;

    // 缺省构造函数
    public BankAccountPanel(List<TransactionRecordEntity> transactionList) {
        setBackground(new Color(240, 240, 240));
        setOpaque(false);

        String[] columnNames = {"交易编号", "交易类型", "交易金额", "交易日期"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                // 所有单元格均不可编辑
                return false;
            }
        };
        setLayout(null);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        comboBox.setBounds(137, 108, 92, 37);
     // 添加项目
        comboBox.addItem("全部类型");
        comboBox.addItem("出账");
        comboBox.addItem("入账");
        add(comboBox);
        
        // 创建并设置日期选择器
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1); // 设置为2000年1月1日
        java.util.Date defaultDate = calendar.getTime();
        SpinnerDateModel model1 = new SpinnerDateModel(defaultDate, null, null, Calendar.DAY_OF_MONTH);
        JSpinner daySpinner = new JSpinner(model1);
        daySpinner.setEditor(new JSpinner.DateEditor(daySpinner, "yyyy-MM-dd"));
        daySpinner.setBounds(239, 108, 123, 37);
        add(daySpinner);
       

        transactionTable = new JTable(model);

        scrollPane = new JScrollPane(transactionTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(137, 163, 651, 426);
        add(scrollPane);

        // Head
        JLabel lblVcampus = new JLabel("我的账单", SwingConstants.CENTER);
        lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        lblVcampus.setBounds(21, 27, 149, 43);
        add(lblVcampus);

        JButton backButton = new JButton("返回");
        backButton.setBounds(742, 29, 99, 46);
        backButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        backButton.setContentAreaFilled(false);
        add(backButton);
        
        
        JButton btnQ = new JButton("查询");
        btnQ.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        btnQ.setBackground(new Color(255, 255, 255));
        btnQ.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnQ.setBounds(372, 109, 93, 34);
        add(btnQ);

        // 填充交易数据到表格
        for (TransactionRecordEntity transaction : transactionList) {
            Object[] row = new Object[]{
                transaction.gettID(),
                transaction.gettType(),
                transaction.gettTransactionAmount(),
                transaction.gettDate()
            };
            model.addRow(row);
        }

        // 背景
        JLabel backgroundLabel = new JLabel(new ImageIcon(BankAccountPanel.class.getResource("/resources/picture/商店背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        backgroundLabel.setLayout(null);
        add(backgroundLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 创建 JFrame 实例
            JFrame frame = new JFrame("银行账本记录");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 600);
            frame.setResizable(false); // 设置窗口大小不可调整

            // 创建示例交易记录列表
            
            // 这里的构造函数有问题！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
            List<TransactionRecordEntity> transactionList = new ArrayList<>();
            transactionList.add(new TransactionRecordEntity(1, "存款", new BigDecimal("2000.00"), new Date(System.currentTimeMillis())));
            transactionList.add(new TransactionRecordEntity(2, "取款", new BigDecimal("500.00"), new Date(System.currentTimeMillis())));
            transactionList.add(new TransactionRecordEntity(3, "转账", new BigDecimal("1200.00"), new Date(System.currentTimeMillis())));

            // 创建银行账本记录面板实例
            BankAccountPanel bankAccountPanel = new BankAccountPanel(transactionList);

            // 将面板添加到 JFrame 的内容面板
            frame.getContentPane().add(bankAccountPanel);

            // 设置窗口居中显示
            frame.setLocationRelativeTo(null); // 相对于屏幕居中

            // 设置窗口可见
            frame.setVisible(true);
        });
    }
}