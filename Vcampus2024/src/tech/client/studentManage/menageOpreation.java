package tech.client.studentManage;
import java.util.List;

import Entity.UserEntity;
import tech.client.main.UserSession;
import tech.connection.Message;
import tech.connection.SocketClientWorker;

public class menageOpreation {
	public static void menageOpreation() {}
	public static List<UserEntity> getStudentManage(String s) {
		//管理员登录获取学生信息
		System.out.println("Getting students...");
		//用于建立连接和消息
		Message message;
		message = new Message(Message.MessageType.STU,"GETTING LISTS",s);
		System.out.println(message);
		//发送消息
		SocketClientWorker connection = new SocketClientWorker(message);
		if(connection.Connect()){
		//成功连接
		connection.SendMessage();
		message=connection.ReceiveMessage();
		System.out.println(message);
		return message.getuserlisty();
		}else{
			System.out.println("连接失败");//失败
			return null;
			
			}
	}
	//删除学生
	public static void deleteStu(UserEntity student) {
		System.out.println("Getting students...");
		//用于建立连接和消息
		Message message;
		message = new Message(Message.MessageType.STU,"DELETE STU");
		message.setuserentity(student);
		System.out.println(message);
		//发送消息
		SocketClientWorker connection = new SocketClientWorker(message);
		if(connection.Connect()){
		//成功连接
		connection.SendMessage();
		message=connection.ReceiveMessage();
		System.out.println(message);
		}else{
			System.out.println("连接失败");//失败
			
			}
	}
	//新建/更新学生
	public static void refreshStu(UserEntity student) {
		System.out.println("Getting students...");
		//用于建立连接和消息
		Message message;
		message = new Message(Message.MessageType.STU,"REFRESH STU");
		message.setuserentity(student);
		System.out.println(message);
		//发送消息
		SocketClientWorker connection = new SocketClientWorker(message);
		if(connection.Connect()){
		//成功连接
		connection.SendMessage();
		message=connection.ReceiveMessage();
		System.out.println(message);
		}else{
			System.out.println("连接失败");//失败
			
			}
	}
}



