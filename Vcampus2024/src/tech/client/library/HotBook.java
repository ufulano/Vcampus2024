package tech.client.library;

import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class HotBook extends JPanel {

	/**
	 * 热门书籍模块
	 * 用于图书馆主页进行展示
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public HotBook(String img_url, String bBookName, String bAuthor) {
		setBackground(new Color(240, 240, 240));
		setLayout(null);

		JEditorPane editPicture = new JEditorPane();
		editPicture.setEditable(false);
		editPicture.setBounds(14, 13, 185, 260);
		editPicture.setContentType("text/html");
		add(editPicture);
		editPicture.setText("<html><body><img src=\"" + img_url + "\"></body><html>");

		JLabel lblAuthor = new JLabel("");
		lblAuthor.setIcon(new ImageIcon(HotBook.class.getResource("")));
		lblAuthor.setBounds(209, 121, 32, 32);
		add(lblAuthor);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(HotBook.class.getResource("")));
		label.setBounds(209, 33, 32, 32);
		add(label);

		JTextArea txtTitle = new JTextArea();
		txtTitle.setEditable(false);
		txtTitle.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		txtTitle.setBounds(253, 26, 140, 55);
		txtTitle.setText(bBookName);
		
		txtTitle.setLineWrap(true);
		
		add(txtTitle);

		JTextArea txtAuthor = new JTextArea();
		txtAuthor.setEditable(false);
		txtAuthor.setFont(new Font("微软雅黑", Font.PLAIN,20));
		txtAuthor.setBounds(252, 114, 140, 55);
		txtAuthor.setText(bAuthor);
		
		txtAuthor.setLineWrap(true);
		
		add(txtAuthor);


	}
}
