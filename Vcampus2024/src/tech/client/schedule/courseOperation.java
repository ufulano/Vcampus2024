package tech.client.schedule;

import java.util.List;

import Entity.CourseEntity;
import Entity.UserEntity;
import tech.connection.Message;
import tech.connection.SocketClientWorker;

public class courseOperation {
	public static void courseOperation() {}
	public static List<CourseEntity> getCourselist(String s) {
		//管理员登录获取课程
		//s为查询的内容，置空时返回全部
		System.out.println("Getting courses...");
		//用于建立连接和消息
		Message message=new Message(Message.MessageType.STU);
		message.setdata("SHOW_STUDENT_LIST_BY_DATA",s);//...为搜索内容（姓名/ID...支持部分查找）
		System.out.println(message);
		//发送消息
		SocketClientWorker connection = SocketClientWorker.getInstance();
		connection.SetMessage(message);
		if(connection.Connect()){
		//成功连接
		connection.SendMessage();
		message=connection.ReceiveMessage();
		System.out.println(message);
		return message.getcourselist();
		}else{
			System.out.println("连接失败");//失败
			return null;
			}
	}
	/*
	//新增课程?
		public static boolean newCourse(UserEntity student) {
			System.out.println("New Course...");
			//用于建立连接和消息
			Message message;
			message = new Message(Message.MessageType.STU,"New Course");
			message.setuserentity(student);
			System.out.println(message);
			//发送消息
			SocketClientWorker connection = SocketClientWorker.getInstance();
			connection.SetMessage(message);
			if(connection.Connect()){
			//成功连接
			connection.SendMessage();
			message=connection.ReceiveMessage();
			System.out.println(message);
			return true;
			}else{
				System.out.println("连接失败");//失败
				return false;
				}
		}
		*/

	public static List<UserEntity> getStudentlist(String s) {
		//管理员登录获取学生信息
		//s为当前选中课程？
		System.out.println("Getting students...");
		//用于建立连接和消息
		Message message=new Message(Message.MessageType.STU);
		message.setdata("SHOW_STUDENT_LIST_BY_DATA",s);//...为搜索内容（姓名/ID...支持部分查找）
		System.out.println(message);
		//发送消息
		SocketClientWorker connection = SocketClientWorker.getInstance();
		connection.SetMessage(message);
		if(connection.Connect()){
		//成功连接
		connection.SendMessage();
		message=connection.ReceiveMessage();
		System.out.println(message);
		return message.getuserlist();
		}else{
			System.out.println("连接失败");//失败
			return null;
			
			}
	}
	/*
	//删除学生
		public static boolean deleteStu(UserEntity student) {
			System.out.println("Deleting students...");
			//用于建立连接和消息
			Message message;
			message = new Message(Message.MessageType.STU,"DELETE STU");
			message.setuserentity(student);
			System.out.println(message);
			//发送消息
			SocketClientWorker connection = SocketClientWorker.getInstance();
			connection.SetMessage(message);
			if(connection.Connect()){
			//成功连接
			connection.SendMessage();
			message=connection.ReceiveMessage();
			System.out.println(message);
			return true;
			}else{
				System.out.println("连接失败");//失败
				return false;
				}
		}
		
		//新建学生
		public static boolean newStu(UserEntity student) {
			System.out.println("Refreshing students...");
			//用于建立连接和消息
			Message message;
			message = new Message(Message.MessageType.STU,"REFRESH STU");
			message.setuserentity(student);
			System.out.println(message);
			//发送消息
			SocketClientWorker connection = SocketClientWorker.getInstance();
			connection.SetMessage(message);
			if(connection.Connect()){
			//成功连接
			connection.SendMessage();
			message=connection.ReceiveMessage();
			System.out.println(message);
			return true;
			}else{
				System.out.println("连接失败");//失败
				return false;
				}
		}
		*/
}
