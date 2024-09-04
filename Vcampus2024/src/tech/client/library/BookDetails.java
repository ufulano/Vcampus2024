package tech.client.library;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tech.client.main.MainStudent;

public class BookDetails extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	private JTextField textFieldCapacity;


	/**
	 * Create the dialog.
	 */
	
	public BookDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(207, 10, 643, 444);
		contentPane.add(panel);
		panel.setOpaque(false); 
		panel.setLayout(null);
		
		// head

		
		JButton button = new JButton("确认");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button.setBounds(718, 464, 132, 48);
		button.setBackground(Color.white);
		contentPane.add(button);
		
		JLabel lblName = new JLabel("书名：");
		lblName.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblName.setBounds(116, 117, 208, 45);
		panel.add(lblName);
		
		JLabel lblGender = new JLabel("书籍ID：");
		lblGender.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblGender.setBounds(116, 160, 208, 45);
		panel.add(lblGender);
		
		JLabel lblAuthor = new JLabel("作者：");
		lblAuthor.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblAuthor.setBounds(116, 204, 208, 45);
		panel.add(lblAuthor);
		
		JLabel lblAvailable = new JLabel("余量：");
		lblAvailable.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblAvailable.setBounds(116, 386, 208, 37);
		panel.add(lblAvailable);
		
		JLabel lblPublisher = new JLabel("出版社：");
		lblPublisher.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblPublisher.setBounds(116, 246, 208, 45);
		panel.add(lblPublisher);
		
		JLabel lblISBN = new JLabel("ISBN");
		lblISBN.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblISBN.setBounds(116, 296, 208, 37);
		panel.add(lblISBN);
		
		JTextField textFieldName = new JTextField();
		textFieldName.setEnabled(false);
		textFieldName.setEditable(false);
		textFieldName.setBounds(209, 125, 189, 37);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JTextField textFieldID = new JTextField();
		textFieldID.setEnabled(false);
		textFieldID.setEditable(false);
		textFieldID.setColumns(10);
		textFieldID.setBounds(209, 168, 189, 37);
		panel.add(textFieldID);
		
		JTextField textFieldAuthor = new JTextField();
		textFieldAuthor.setEnabled(false);
		textFieldAuthor.setEditable(false);
		textFieldAuthor.setColumns(10);
		textFieldAuthor.setBounds(209, 212, 189, 37);
		panel.add(textFieldAuthor);
		
		JTextField textISBN = new JTextField();
		textISBN.setEnabled(false);
		textISBN.setEditable(false);
		textISBN.setColumns(10);
		textISBN.setBounds(209, 296, 189, 37);
		panel.add(textISBN);
		
		JTextField textFieldPublisher = new JTextField();
		textFieldPublisher.setEnabled(false);
		textFieldPublisher.setEditable(false);
		textFieldPublisher.setColumns(10);
		textFieldPublisher.setBounds(209, 254, 189, 37);
		panel.add(textFieldPublisher);
		
		JTextField textFieldAvailable = new JTextField();
		textFieldAvailable.setEnabled(false);
		textFieldAvailable.setEditable(false);
		textFieldAvailable.setColumns(10);
		textFieldAvailable.setBounds(209, 386, 189, 37);
		panel.add(textFieldAvailable);
		
		textFieldCapacity = new JTextField();
		textFieldCapacity.setEnabled(false);
		textFieldCapacity.setEditable(false);
		textFieldCapacity.setColumns(10);
		textFieldCapacity.setBounds(209, 339, 189, 37);
		panel.add(textFieldCapacity);
		
		JLabel lblCapacity = new JLabel("总量：");
		lblCapacity.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblCapacity.setBounds(116, 339, 208, 37);
		panel.add(lblCapacity);
		
		JEditorPane editPicture = new JEditorPane();
		editPicture.setEditable(false);
		editPicture.setBounds(424, 142, 197, 260);
		editPicture.setContentType("textml");
		// editPicture.setText("<html><body><img src=\"" + img_url + "\"></body><html>");
		panel.add(editPicture);
		
		JLabel lblNewLabel = new JLabel("书籍详情");
		lblNewLabel.setBounds(116, 64, 133, 43);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		
		//背景
		JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/左喷泉背景.png")));
		backgroundLabel.setBounds(0, 0, 900, 600);
		contentPane.add(backgroundLabel);

	}
}
