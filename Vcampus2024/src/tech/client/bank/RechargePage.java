package tech.client.bank;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Base64;

public class RechargePage extends JFrame {
    private JTextField amountField;
    private JButton confirmButton;

    public RechargePage() {
    	getContentPane().setBackground(new Color(255, 255, 255));
    	setIconImage(Toolkit.getDefaultToolkit().getImage(RechargePage.class.getResource("/resources/icon/icon2/银行.png")));
        setTitle("充值页面");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 设置窗口在屏幕中央

        // 创建输入充值数额的文本框
        amountField = new JTextField(20);
        amountField.setBounds(127, 86, 188, 37);
        amountField.setHorizontalAlignment(JTextField.CENTER);

        // 创建确认按钮
        confirmButton = new JButton("确认充值");
        confirmButton.setBackground(new Color(255, 255, 255));
        confirmButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        confirmButton.setBounds(144, 152, 130, 49);
        confirmButton.addActionListener(this::confirmButtonActionPerformed);

        getContentPane().setLayout(null);

        // 添加组件到布局
        getContentPane().add(amountField);
        getContentPane().add(confirmButton);

        JLabel lblNewLabel = new JLabel("充值金额：");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        lblNewLabel.setBounds(35, 97, 82, 15);
        getContentPane().add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(253, 226, 183));
        panel.setBounds(23, 38, 335, 195);
        getContentPane().add(panel);

        // 设置窗口不可调整大小
        setResizable(false);

        setVisible(true);
    }

    private void confirmButtonActionPerformed(ActionEvent e) {
        String amount = amountField.getText();
        if (amount.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入充值数额", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 调用后端接口生成二维码
        String base64QRCode = generateBase64QRCode(amount);
        if (base64QRCode != null) {
            try {
                // 解码Base64字符串为图像
                ImageIcon qrCodeIcon = new ImageIcon(decodeBase64Image(base64QRCode));
                showQRCodePopup(qrCodeIcon);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "无法加载二维码", "错误", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "生成二维码失败", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String generateBase64QRCode(String amount) {
        //调试

        String base64QRCode = "data:image/png;base64,iVBORw0K...";
        return base64QRCode;
    }

    private Image decodeBase64Image(String base64String) {
        try {
            // 将Base64编码的字符串解码为图像
            byte[] imageBytes = Base64.getDecoder().decode(base64String.split(",")[1]);
            return ImageIO.read(new java.io.ByteArrayInputStream(imageBytes));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void showQRCodePopup(ImageIcon qrCodeIcon) {
        JFrame qrCodeFrame = new JFrame("二维码");
        qrCodeFrame.setSize(400, 400);
        qrCodeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        qrCodeFrame.getContentPane().setLayout(new BorderLayout());
        qrCodeFrame.setLocationRelativeTo(null); // 设置窗口在屏幕中央
        qrCodeFrame.setResizable(false); // 设置窗口不可调整大小

        JLabel qrCodeLabel = new JLabel();
        qrCodeLabel.setIcon(qrCodeIcon);

        qrCodeFrame.getContentPane().add(qrCodeLabel, BorderLayout.CENTER);
        qrCodeFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RechargePage());
    }
}