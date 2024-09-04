package tech.client.main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import type.UserType;

import Entity.UserEntity;

public class mainAssist {

	//主界面的辅助功能
	//界面路由
	public static void requireRouting(UserEntity user) {
		JFrame target = null;
		String userType = user.getuRole().toString();
		System.out.print(userType);
		//根据身份跳转到对应窗口
		target = "学生".equals(userType) ? new MainStudent()
				: "教师".equals(userType) ? new MainTeacher()
				: "管理员".equals(userType) ? new MainManager()
				: null;
		if (target == null) {
		       JOptionPane.showMessageDialog(
		               null,               // 父组件，设置为 null 表示对话框没有父组件，会显示在屏幕中央
		               "界面路由失败！",            // 显示的消息
		               "错误",             // 对话框的标题
		               JOptionPane.ERROR_MESSAGE // 对话框的类型，这里设置为错误信息
		           );
			System.exit(1);
		}
		target.setVisible(true);
	}
	//测试用
	public static void requireRouting() {
		JFrame target = null;
		System.out.println("管理员");
		//根据身份跳转到对应窗口
		target = new MainManager();
		target.setVisible(true);
	}
}
