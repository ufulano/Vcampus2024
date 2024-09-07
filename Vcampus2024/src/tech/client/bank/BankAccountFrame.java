package tech.client.bank;

import Entity.TransactionRecordEntity;
import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BankAccountFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public BankAccountFrame() {
        setTitle("银行账本记录");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setResizable(false); // 设置窗口大小不可调整
        setLocationRelativeTo(null); // 相对于屏幕居中

        // 创建示例交易记录列表
        List<TransactionRecordEntity> transactionList = createSampleTransactions();

        // 创建银行账本记录面板实例
        BankAccountPanel bankAccountPanel = new BankAccountPanel(transactionList);

        // 将面板添加到 JFrame 的内容面板
        getContentPane().add(bankAccountPanel);

        // 设置窗口可见
        setVisible(true);
    }

    // 创建示例交易记录列表
    private static List<TransactionRecordEntity> createSampleTransactions() {
        List<TransactionRecordEntity> transactionList = new ArrayList<>();
        transactionList.add(new TransactionRecordEntity(1, "存款", new BigDecimal("2000.00"), new Date(System.currentTimeMillis())));
        transactionList.add(new TransactionRecordEntity(2, "取款", new BigDecimal("500.00"), new Date(System.currentTimeMillis())));
        transactionList.add(new TransactionRecordEntity(3, "转账", new BigDecimal("1200.00"), new Date(System.currentTimeMillis())));
        return transactionList;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankAccountFrame::new);
    }
}