package tech.client.shopping;

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

public class ProductDetails extends JDialog {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane = new JPanel();
	private JTextField textFieldLabel;
	private JTextField textFieldAuthorIntro;


	/**
	 * Create the dialog.
	 */
	
	public ProductDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(207, 10, 643, 487);
		contentPane.add(panel);
		panel.setOpaque(false); 
		panel.setLayout(null);
		
		// head

		
		JButton button = new JButton("确认");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button.setBounds(698, 491, 132, 48);
		button.setBackground(Color.white);
		contentPane.add(button);
		
		JLabel lblName = new JLabel("商品名：");
		lblName.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblName.setBounds(116, 117, 208, 45);
		panel.add(lblName);
		
		JLabel lblID = new JLabel("商品ID：");
		lblID.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblID.setBounds(116, 160, 208, 45);
		panel.add(lblID);
		
		JLabel lblAuthor = new JLabel("商品价格：");
		lblAuthor.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblAuthor.setBounds(116, 204, 208, 45);
		panel.add(lblAuthor);
		
		JLabel lblAuthorIntro = new JLabel("作者介绍：");
		lblAuthorIntro.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblAuthorIntro.setBounds(116, 386, 208, 37);
		panel.add(lblAuthorIntro);
		
		JLabel lblPublisher = new JLabel("库存数量：");
		lblPublisher.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblPublisher.setBounds(116, 246, 208, 45);
		panel.add(lblPublisher);
		
		JLabel lblISBN = new JLabel("商品评分：");
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
		
		JTextField textFieldPrice = new JTextField();
		textFieldPrice.setEnabled(false);
		textFieldPrice.setEditable(false);
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(209, 212, 189, 37);
		panel.add(textFieldPrice);
		
		JTextField textScore = new JTextField();
		textScore.setEnabled(false);
		textScore.setEditable(false);
		textScore.setColumns(10);
		textScore.setBounds(209, 296, 189, 37);
		panel.add(textScore);
		
		JTextField textFieldInventory = new JTextField();
		textFieldInventory.setEnabled(false);
		textFieldInventory.setEditable(false);
		textFieldInventory.setColumns(10);
		textFieldInventory.setBounds(209, 254, 189, 37);
		panel.add(textFieldInventory);
		
		JTextField textFieldIntro = new JTextField();
		textFieldIntro.setEnabled(false);
		textFieldIntro.setEditable(false);
		textFieldIntro.setColumns(10);
		textFieldIntro.setBounds(421, 339, 197, 138);
		panel.add(textFieldIntro);
		
		textFieldLabel = new JTextField();
		textFieldLabel.setEnabled(false);
		textFieldLabel.setEditable(false);
		textFieldLabel.setColumns(10);
		textFieldLabel.setBounds(209, 339, 189, 37);
		panel.add(textFieldLabel);
		
		JLabel lblCapacity = new JLabel("商品标签：");
		lblCapacity.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblCapacity.setBounds(116, 339, 208, 37);
		panel.add(lblCapacity);
		
		JEditorPane editPicture = new JEditorPane();
		editPicture.setEditable(false);
		editPicture.setBounds(421, 122, 197, 202);
		editPicture.setContentType("textml");
		// editPicture.setText("<html><body><img src=\"" + img_url + "\"></body><html>");
		panel.add(editPicture);
		
		JLabel lblNewLabel = new JLabel("商品详情");
		lblNewLabel.setBounds(116, 64, 133, 43);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		
		textFieldAuthorIntro = new JTextField();
		textFieldAuthorIntro.setEnabled(false);
		textFieldAuthorIntro.setEditable(false);
		textFieldAuthorIntro.setColumns(10);
		textFieldAuthorIntro.setBounds(209, 386, 189, 91);
		panel.add(textFieldAuthorIntro);
		
		//背景
		JLabel backgroundLabel = new JLabel(new ImageIcon(MainStudent.class.getResource("/resources/picture/左喷泉背景.png")));
		backgroundLabel.setBounds(0, 0, 900, 600);
		contentPane.add(backgroundLabel);

	}
}
