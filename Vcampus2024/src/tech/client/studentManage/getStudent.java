package tech.client.studentManage;

import Entity.UserEntity;

public class getStudent {
	public static UserEntity getStudentManage(UserEntity  student) {
		//先判断是否为学生
		if(!"Student".equals(student.getuRole())){
			return null;
		}

	}
}
