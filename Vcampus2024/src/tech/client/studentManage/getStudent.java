package tech.client.studentManage;

import Entity.UserEntity;
import tech.client.main.UserSession;

public class getStudent {
	public static void getStudentManage() {
		//获取当前登录用户
		UserEntity user = UserSession.getInstance().getUser();
		if(!"Student".equals(user.getuRole())){
			return;
		}

	}
}
