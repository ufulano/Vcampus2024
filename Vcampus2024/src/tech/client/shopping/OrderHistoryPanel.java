package tech.client.shopping;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Entity.OrderEntity;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * 历史订单查看面板
 */
public class OrderHistoryPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable orderHistoryTable;
    private JScrollPane scrollPane;
    private JTextField textField;
    private JSpinner daySpinner;
    private JButton btnQ;

    // 缺省构造函数
    public OrderHistoryPanel(List<OrderEntity> orderList) {
        setBackground(new Color(216, 238, 248));
        setOpaque(false);

        String[] columnNames = {"订单编号", "商品名", "支付金额", "订单日期"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                // 所有单元格均不可编辑
                return false;
            }
        };
        setLayout(null);
        
        btnQ = new JButton("查询");
        btnQ.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        btnQ.setBounds(504, 108, 97, 47);
        add(btnQ);
        
        textField = new JTextField();
        textField.setText("请输入商品名");
        textField.setBounds(128, 108, 149, 47);
        add(textField);
        textField.setColumns(10);
        
        orderHistoryTable = new JTable(model);

        scrollPane = new JScrollPane(orderHistoryTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(128, 165, 653, 415);
        add(scrollPane);

        // Head
        JLabel lblVcampus = new JLabel("历史订单");
        lblVcampus.setBounds(10, 25, 191, 43);
        lblVcampus.setHorizontalAlignment(SwingConstants.CENTER);
        lblVcampus.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        add(lblVcampus);

        JButton btnBack = new JButton("返回");
        btnBack.setBounds(784, 10, 99, 46);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 添加返回逻辑
                System.out.println("返回按钮被点击");
                
            }
        });
        btnBack.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        btnBack.setContentAreaFilled(false);
        add(btnBack);
        
        // 创建并设置日期选择器
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1); // 设置为2000年1月1日
        java.util.Date defaultDate = calendar.getTime();
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(defaultDate, null, null, Calendar.DAY_OF_MONTH);
        daySpinner = new JSpinner(spinnerDateModel);
        daySpinner.setEditor(new JSpinner.DateEditor(daySpinner, "yyyy-MM-dd"));
        daySpinner.setBounds(287, 108, 189, 47);
        add(daySpinner);
        
        // 填充订单数据到表格
        for (OrderEntity order : orderList) {
            Object[] row = new Object[]{
                order.getoOrderID(),
                order.getuNumber(),
                order.getoPayment(),
                order.getoDate()
            };
            model.addRow(row);
        }
        
        // 背景
        JLabel backgroundLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/picture/商店背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        backgroundLabel.setLayout(null);
        add(backgroundLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("历史订单");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 600);
            frame.setResizable(false); // 设置窗口大小不可调整

            // 用于调试的数据
            List<OrderEntity> orderList = Arrays.asList(
                new OrderEntity(1, "U123456", new BigDecimal("100.00"), new Date(System.currentTimeMillis()), null),
                new OrderEntity(2, "U654321", new BigDecimal("200.00"), new Date(System.currentTimeMillis()), null)
            );

            OrderHistoryPanel orderHistoryPanel = new OrderHistoryPanel(orderList);
            frame.getContentPane().add(orderHistoryPanel);

            // 设置窗口居中显示
            frame.setLocationRelativeTo(null); // 相对于屏幕居中

            frame.setVisible(true);
        });
    }
}