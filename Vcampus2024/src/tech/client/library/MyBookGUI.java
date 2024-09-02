package tech.client.library;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import tech.client.main.MainStudent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 我的借阅页面
 */
public class MyBookGUI extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tblBeborrowed;
	private DefaultTableModel model;
	private List<Book> list = null;
	private JTextField txtISBN;

	/**
	 * Create the dialog.
	 */
	
	public MyBookGUI() {

		setModal(true);

		setTitle("我的借阅");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MyBookGUI.class.getResource("/resources/icon/icon2/library。png")));
		setResizable(false);
		setSize(871,723);
		setBounds(100, 100, 623, 457);
		getContentPane().setLayout(new BorderLayout());
		
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		String[] tblhead = { "图书编号", "标题", "作者", "借阅时间" };
		model = new DefaultTableModel(null, tblhead) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int a, int b) {
				return false;
			}
		};

		Long timeStamp = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));

		tblBeborrowed = new JTable();
		tblBeborrowed.setModel(model);
		tblBeborrowed.setBounds(2, 2, 300, 300);
		JScrollPane jsp = new JScrollPane(tblBeborrowed);
		jsp.setBounds(221, 103, 589, 270);
		tblBeborrowed.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 1) {
					int row = ((JTable) e.getSource()).rowAtPoint(e.getPoint());
					txtISBN.setText(list.get(row).getISBN());
				}
			}
		});
		contentPanel.setLayout(null);
		contentPanel.add(jsp);

		JLabel lblNewLabel = new JLabel("我的借阅");
		lblNewLabel.setBounds(21, 10, 133, 43);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		contentPanel.add(lblNewLabel);

		JButton btnReturn = new JButton("还书");
		btnReturn.setBounds(0, 86, 170, 80);
		btnReturn.setIcon(new ImageIcon(MyBookGUI.class.getResource("/resources/icon/还书.svg")));
		btnReturn.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 这里要添加错误提示

			}
		});
		contentPanel.add(btnReturn);

		JButton btnRenew = new JButton("续借");
		btnRenew.setBounds(0, 176, 170, 80);
		btnRenew.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnRenew.setIcon(new ImageIcon(MyBookGUI.class.getResource("/resources/assets/icon/导出.png")));
		btnReturn.setIcon(new ImageIcon(LibraryStudentGUI.class.getResource("/resources/assets/icon/导出.png")));
		btnReturn.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		btnRenew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		contentPanel.add(btnRenew);

		txtISBN = new JTextField();
		txtISBN.setBounds(291, 383, 186, 27);
		txtISBN.setEditable(false);
		contentPanel.add(txtISBN);
		txtISBN.setColumns(10);

		JLabel lblISBN = new JLabel("图书编号");
		lblISBN.setBounds(221, 387, 60, 18);
		contentPanel.add(lblISBN);
		
		JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/老师课表背景.png")));
		backgroundLabel.setBounds(0, 0, 900, 600);
		contentPanel.add(backgroundLabel);
		

		// list = ResponseUtils.getResponseByHash();

		/*
		if (list == null || list.size() == 0) {
			SwingUtils.showMessage(null, "暂无借阅书籍！", "提示");
			this.dispose();
		} else {
			model.setRowCount(0);
			int len = list.size();
			for (int i = 0; i < len; i++) {
				Object[] toAdd = { list.get(i).getISBN(), list.get(i).getTitle(), list.get(i).getAuthor(),
						list.get(i).getBorrowTime() };
				model.addRow(toAdd);
			}
		}
		*/

	}
}
