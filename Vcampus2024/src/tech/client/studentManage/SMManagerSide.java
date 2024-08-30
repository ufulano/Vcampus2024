package tech.client.studentManage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import tech.client.main.MainStudent;
import javax.swing.JTable;
import javax.swing.JButton;

public class SMManagerSide extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SMManagerSide frame = new SMManagerSide();
                frame.setVisible(true);
                frame.setTitle("Vcampus·学籍信息");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SMManagerSide() {
        // 设置窗口图标
        ImageIcon icon = new ImageIcon(SMStudentPersonal.class.getResource("/resources/icon/icon1/ic_student.png"));
        this.setIconImage(icon.getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 移除了setBounds，使用setSize代替
        setSize(898, 609);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(135, 206, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        // 使用绝对定位
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // 创建 StudentTablePanel 的实例并设置大小和位置
        StudentTablePanel studentPanel = new StudentTablePanel();
        studentPanel.setBounds(0, 0, 886, 575); // 根据需要调整大小和位置
        contentPane.add(studentPanel);

        // 其他组件初始化和添加逻辑...
    }
}