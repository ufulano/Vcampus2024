package tech.client.login;

import tech.connection.*;

/*
 * 登录界面相关功能
 * 身份验证和判断
 */
public class LoginVerify {

	public static Message verify(String cardNumber, String password) {
		
		
		System.out.println("Verifing...");
		//用于建立连接和消息
		Message message= new Message(cardNumber,password,"192.168.101.210", 8323,Message.MessageType.LOGIN);
		System.out.println(message);
		//发送消息
		SocketClientWorker connection=new SocketClientWorker(message);
		connection.SendMessage();
		message=connection.ReceiveMessage();
		System.out.println(message);
		//if(message.getresponse()=="FAIL"||message.toString()=="ERROR")
			//return null;
		return message;
	}
	/*public static Student verifyStudent(String cardNumber, String password) {
		return ResponseUtils
				.getResponseByHash(new Request(App.connectionToServer, null, "tech.zxuuu.server.auth.Auth.studentLoginChecker",
						new Object[] { new Student(cardNumber, null, OtherUtils.getMD5(password), null) }).send())
				.getReturn(Student.class);
	}

	public static Teacher verifyTeacher(String cardNumber, String password) {
		return ResponseUtils
				.getResponseByHash(new Request(App.connectionToServer, null, "tech.zxuuu.server.auth.Auth.teacherLoginChecker",
						new Object[] { new Student(cardNumber, null, OtherUtils.getMD5(password), null) }).send())
				.getReturn(Teacher.class);
	}

	public static Manager verifyManager(String cardNumber, String password) {
		return ResponseUtils
				.getResponseByHash(new Request(App.connectionToServer, null, "tech.zxuuu.server.auth.Auth.managerLoginChecker",
						new Object[] { new Student(cardNumber, null, OtherUtils.getMD5(password), null) }).send())
				.getReturn(Manager.class);
	}*/
}
