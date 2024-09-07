package tech.client.bank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 银行账本记录面板
 */
public class BankAccountPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable transactionTable;
    private JScrollPane scrollPane;

    // 缺省构造函数
    public BankAccountPanel(List<Transaction> transactionList) {
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

        transactionTable = new JTable(model);

        scrollPane = new JScrollPane(transactionTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(10, 10, 880, 550);
        add(scrollPane);

        // Head
        JLabel lblBankAccount = new JLabel("银行账本记录");
        lblBankAccount.setBounds(20, 570, 200, 40);
        lblBankAccount.setHorizontalAlignment(SwingConstants.CENTER);
        lblBankAccount.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        add(lblBankAccount);

        // 填充交易数据到表格
        for (Transaction transaction : transactionList) {
            Object[] row = new Object[]{
                transaction.getTransactionId(),
                transaction.getTransactionType(),
                transaction.getTransactionAmount(),
                transaction.getTransactionDate()
            };
            model.addRow(row);
        }

        // 背景
        JLabel backgroundLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/picture/bank_background.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        backgroundLabel.setLayout(null);
        add(backgroundLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("银行账本记录");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 600);
            frame.setResizable(false); // 设置窗口大小不可调整

            /*
            List<Transaction> transactionList = Arrays.asList(
                new Transaction(1, "入账", new BigDecimal("1000.00"), new Date()),
                new Transaction(2, "出账", new BigDecimal("500.00"), new Date())
            );
            */

            BankAccountPanel bankAccountPanel = new BankAccountPanel(transactionList);
            frame.getContentPane().add(bankAccountPanel);

            // 设置窗口居中显示
            frame.setLocationRelativeTo(null); // 相对于屏幕居中

            frame.setVisible(true);
        });
    }

    
}