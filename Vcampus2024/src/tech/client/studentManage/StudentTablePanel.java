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
	List<UserEntity> result = null;
	String[][] rowData = null;
	DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int a, int b) {
			return false;
		}
	};

	/**
	 * Create the panel.
	 */
	public StudentTablePanel() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.setLayout(null);
		infoTable = new JTable();
		infoTable.setBounds(0, 67, 774, 477);
		String[] head = { "一卡通号", "学号", "专业", "姓名" };
		JScrollPane jsp = new JScrollPane(infoTable);
		jsp.setBounds(160, 98, 882, 604);
		model.setDataVector(rowData, head);
		infoTable.setModel(model);
		this.add(jsp);
		JComboBox comboAcademy = new JComboBox();
		comboAcademy.setBounds(90, 60, 243, 35);
		this.add(comboAcademy);

		JLabel lblAcademy = new JLabel("院系");
		lblAcademy.setBounds(46, 68, 30, 18);
		this.add(lblAcademy);

		JLabel lblGrade = new JLabel("年级");
		lblGrade.setBounds(347, 68, 30, 18);
		this.add(lblGrade);

		textGrade = new JTextField();
		textGrade.setBounds(391, 60, 121, 35);
		this.add(textGrade);
		textGrade.setColumns(10);
		
		JButton buttonSearch = new JButton("查询");


	}}
