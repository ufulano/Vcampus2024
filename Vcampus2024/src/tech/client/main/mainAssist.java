package tech.client.main;

import javax.swing.JFrame;

import type.UserType;

public class mainAssist {

	//主界面的辅助功能
	//界面路由
	public static void requireRouting() {
		JFrame target = null;
		UserType userType = App.session.getUserType();
		target = userType == UserType.STUDENT ? new MainStudent()
				: userType == userType.TEACHER ? new MainTeacher()
						: userType == userType.MANAGER
								? (managerType == ManagerType.LIBRARY ? new AppLibraryManager()
										: managerType == ManagerType.OPENCOURSE ? new AppOpencourseManager()
												: managerType == ManagerType.SHOP ? new AppShopManager()
														: managerType == ManagerType.TEACHING ? new AppTeachingManager() : null)
								: null;
		if (target == null) {
			SwingUtils.showError(null, "界面路由失败！", "错误");
			System.exit(1);
		}
		target.setVisible(true);
	}
}
