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
		Message message;
		message = new Message(Message.MessageType.USER,"LOGIN",cardNumber, password);
		System.out.println(message);
		//发送消息
		
		SocketClientWorker connection = new SocketClientWorker(message);
		if(connection.Connect()){
		    //成功连接
		connection.SendMessage();
		message=connection.ReceiveMessage();
		System.out.println(message);
		//if(message.getresponse()=="FAIL"||message.toString()=="ERROR")
			//return null;
		return message;
		}else{
			System.out.println("连接失败");//失败
			return null;
			}
	}
}