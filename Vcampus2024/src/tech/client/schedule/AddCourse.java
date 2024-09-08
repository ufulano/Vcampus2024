package tech.client.schedule;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AddCourse extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane = new JPanel();
    private JTable tableAddedTimes; // 用于显示已添加的排课时间
    private List<String[]> addedTimesList = new ArrayList<>(); // 存储排课时间数据

    public AddCourse() {
    	 // 使用 DISPOSE_ON_CLOSE 替代 EXIT_ON_CLOSE
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        setResizable(false) ;
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        
        contentPane.setBackground(new Color(135, 206, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(315, 21, 404, 483);
        contentPane.add(panel);
        panel.setOpaque(false);
        panel.setLayout(null);

        // head
        JLabel lblNewLabel = new JLabel("课程详情");
        lblNewLabel.setBounds(116, 18, 133, 43);
        panel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));

        JButton button = new JButton("确认");
        button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button.setBounds(587, 503, 132, 48);
        button.setBackground(Color.white);
        contentPane.add(button);

        JLabel lblName = new JLabel("课程名称：");
        lblName.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblName.setBounds(116, 63, 208, 45);
        panel.add(lblName);

        JLabel lblGender = new JLabel("课程ID：");
        lblGender.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblGender.setBounds(116, 106, 208, 45);
        panel.add(lblGender);

        JLabel lblCredits = new JLabel("学分：");
        lblCredits.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblCredits.setBounds(116, 150, 208, 45);
        panel.add(lblCredits);

        JLabel lblProfession = new JLabel("专业：");
        lblProfession.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblProfession.setBounds(116, 192, 208, 45);
        panel.add(lblProfession);

        JLabel lblGrade = new JLabel("年级：");
        lblGrade.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblGrade.setBounds(116, 242, 208, 37);
        panel.add(lblGrade);

        JTextField textFieldName = new JTextField();
        textFieldName.setBounds(209, 71, 189, 37);
        panel.add(textFieldName);
        textFieldName.setColumns(10);

        JTextField textFieldID = new JTextField();
        textFieldID.setColumns(10);
        textFieldID.setBounds(209, 114, 189, 37);
        panel.add(textFieldID);

        JTextField textFieldAge = new JTextField();
        textFieldAge.setColumns(10);
        textFieldAge.setBounds(209, 158, 189, 37);
        panel.add(textFieldAge);

        JTextField textFieldBirthplace = new JTextField();
        textFieldBirthplace.setColumns(10);
        textFieldBirthplace.setBounds(209, 242, 189, 37);
        panel.add(textFieldBirthplace);

        JTextField textFieldProfession = new JTextField();
        textFieldProfession.setColumns(10);
        textFieldProfession.setBounds(209, 200, 189, 37);
        panel.add(textFieldProfession);

        JTextField textFieldCapacity = new JTextField();
        textFieldCapacity.setColumns(10);
        textFieldCapacity.setBounds(209, 285, 189, 37);
        panel.add(textFieldCapacity);

        JLabel lblCapacity = new JLabel("课容量：");
        lblCapacity.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblCapacity.setBounds(116, 285, 208, 37);
        panel.add(lblCapacity);

        JButton buttonAddTime = new JButton("添加");
        buttonAddTime.setBackground(new Color(255, 255, 255));
        buttonAddTime.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        buttonAddTime.setBounds(204, 439, 83, 34);
        panel.add(buttonAddTime);
        buttonAddTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddTimeDialog addTimeDialog = new AddTimeDialog();
                addTimeDialog.setVisible(true);
            }
        });

        // 初始化表格模型
        String[] columnNames = {"星期", "时间"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        tableAddedTimes = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableAddedTimes);
        scrollPane.setBounds(209, 332, 189, 97);
        panel.add(scrollPane);

        JButton buttonDeleteTime = new JButton("删除");
        buttonDeleteTime.setBackground(new Color(255, 255, 255));
        buttonDeleteTime.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        buttonDeleteTime.setBounds(315, 439, 83, 34);
        panel.add(buttonDeleteTime);
        
        JLabel lblCapacity_1 = new JLabel("排课时间：");
        lblCapacity_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lblCapacity_1.setBounds(116, 332, 208, 37);
        panel.add(lblCapacity_1);
        buttonDeleteTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableAddedTimes.getSelectedRow();
                if (selectedRow >= 0) {
                    addedTimesList.remove(selectedRow);
                    updateTable();
                }
            }
        });

        // 背景
        JLabel backgroundLabel = new JLabel(new ImageIcon(AddCourse.class.getResource("/resources/picture/左喷泉背景.png")));
        backgroundLabel.setBounds(0, 0, 900, 600);
        contentPane.add(backgroundLabel);
    }

    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) tableAddedTimes.getModel();
        model.setRowCount(0); // 清空表格
        for (String[] time : addedTimesList) {
            model.addRow(time);
        }
    }

    public enum sDayOfWeek {
        星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期日
    }

    class AddTimeDialog extends JDialog {
        /**
		 * 添加课程时间的弹窗
		 */
		private static final long serialVersionUID = 1L;
		private JComboBox<sDayOfWeek> comboBoxDayOfWeek;
        private JComboBox<String> comboBoxTimePeriod;

        public AddTimeDialog() {
        	setResizable(false) ;
        	setLocationRelativeTo(null);
            getContentPane().setBackground(Color.WHITE);
            setSize(300,150);
            getContentPane().setLayout(null);

            comboBoxDayOfWeek = new JComboBox<>(sDayOfWeek.values());
            comboBoxDayOfWeek.setFont(new Font("微软雅黑", Font.PLAIN, 16));
            comboBoxDayOfWeek.setBounds(40, 30, 100, 30);
            getContentPane().add(comboBoxDayOfWeek);

            comboBoxTimePeriod = new JComboBox<>();
            comboBoxTimePeriod.setFont(new Font("微软雅黑", Font.PLAIN, 16));
            comboBoxTimePeriod.setBounds(150, 30, 100, 30);
            getContentPane().add(comboBoxTimePeriod);
            comboBoxTimePeriod.addItem("1-2节");
            comboBoxTimePeriod.addItem("3-4节");
            comboBoxTimePeriod.addItem("5-6节");
            comboBoxTimePeriod.addItem("7-8节");

            JButton buttonConfirm = new JButton("确认");
            buttonConfirm.setBounds(100, 70, 100, 30);
            getContentPane().add(buttonConfirm);
            buttonConfirm.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedDay = comboBoxDayOfWeek.getSelectedItem().toString();
                    String selectedTime = (String) comboBoxTimePeriod.getSelectedItem();
                    String[] newRow = {selectedDay, selectedTime};
                    addedTimesList.add(newRow);
                    updateTable();
                    AddTimeDialog.this.dispose();
                }
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AddCourse().setVisible(true);
            }
        });
    }
}