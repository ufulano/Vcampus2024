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
		jsp.setBounds(112, 103, 882, 604);
		model.setDataVector(rowData, head);
		infoTable.setModel(model);
		this.add(jsp);
		JComboBox comboAcademy = new JComboBox();
		comboAcademy.setBounds(165, 58, 243, 35);
		this.add(comboAcademy);

		JLabel lblMajor = new JLabel("专业");
		lblMajor.setBounds(112, 66, 30, 18);
		this.add(lblMajor);

		JLabel lblGrade = new JLabel("年级");
		lblGrade.setBounds(422, 66, 30, 18);
		this.add(lblGrade);

		textGrade = new JTextField();
		textGrade.setBounds(466, 58, 121, 35);
		this.add(textGrade);
		textGrade.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(632, 58, 121, 35);
		add(btnNewButton);
		
		JButton buttonSearch = new JButton("查询");


	}	
}
