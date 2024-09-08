package tech.client.schedule;

import java.util.List;

import Entity.*;
import tech.connection.Message;
import tech.connection.SocketClientWorker;

public class courseOperation {
	public static void courseOperation() {}
	//管理员
	public static List<CourseEntity> getCourselist(String s) {
		//管理员登录获取课程
		//s为查询的内容，置空时返回全部
		System.out.println("Getting courses...");
		//用于建立连接和消息
		Message message=new Message(Message.MessageType.COURSE);
		message.setdata("SHOW_COURSE_LIST_BY_DATA",s);//...为搜索内容（姓名/ID...支持部分查找）
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
	//增加课程
	public String[] addcourse(ScheduleEntity scheduleentity)
    {
    Message message=new Message(Message.MessageType.COURSE);
    message.setdata("ADDCOURSE");
    message.setscheduleentity(scheduleentity);
    SocketClientWorker connection = SocketClientWorker.getInstance();
    connection.SetMessage(message);
    if (connection.Connect()) {
        // 成功连接
        connection.SendMessage();
        message = connection.ReceiveMessage();
        System.out.println(message);
    } else {
        System.out.println("连接失败");// 失败

    }
    return message.getdata();
    }
	//删除课程
    public String[] removecourse(CourseEntity courseentity)
    {
        Message message=new Message(Message.MessageType.COURSE);
        message.setdata("REMOVECOURSE");
        message.setcourseentity(courseentity);
        SocketClientWorker connection = SocketClientWorker.getInstance();
        connection.SetMessage(message);
        if (connection.Connect()) {
            // 成功连接
            connection.SendMessage();
            message = connection.ReceiveMessage();
            System.out.println(message);
        } else {
            System.out.println("连接失败");// 失败
    
        }
        return message.getdata();
    }

    //修改课程
    public String[] changecourse(ScheduleEntity scheduleentity)
    {
        Message message=new Message(Message.MessageType.COURSE);
        message.setdata("UPDATECOURSE");
        message.setscheduleentity(scheduleentity);
        SocketClientWorker connection = SocketClientWorker.getInstance();
        connection.SetMessage(message);
        if (connection.Connect()) {
            // 成功连接
            connection.SendMessage();
            message = connection.ReceiveMessage();
            System.out.println(message);
        } else {
            System.out.println("连接失败");// 失败
    
        }
        return message.getdata();
    }
    
    //查看某个学生已选的所有课程
    public static List<CourseEntity> checkusercourse(UserEntity userentity)
    {
        Message message=new Message(Message.MessageType.COURSE);
        message.setdata("CHECKUSERCOURSE");
        message.setuserentity(userentity);
        SocketClientWorker connection = SocketClientWorker.getInstance();
        connection.SetMessage(message);
        if (connection.Connect()) {
            // 成功连接
            connection.SendMessage();
            message = connection.ReceiveMessage();
            System.out.println(message);
        } else {
            System.out.println("连接失败");// 失败
    
        }
        return message.getcourselist();
    }
    //帮助某个学生选择课程
    public String[] userselectcourse(UserEntity userentity,CourseEntity courseentity)
    {
        Message message=new Message(Message.MessageType.COURSE);
        message.setdata("USERSELECTCOURSE");
        message.setcourseentity(courseentity);
        message.setuserentity(userentity);
        SocketClientWorker connection = SocketClientWorker.getInstance();
        connection.SetMessage(message);
        if (connection.Connect()) {
            // 成功连接
            connection.SendMessage();
            message = connection.ReceiveMessage();
            System.out.println(message);
        } else {
            System.out.println("连接失败");// 失败
    
        }
        return message.getdata();
    }
    
    //帮助某个学生退课
    public String[] userbackcourse(UserEntity userentity,CourseEntity courseentity)
    {
        Message message=new Message(Message.MessageType.COURSE);
        message.setdata("USERBACKCOURSE");
        message.setcourseentity(courseentity);
        message.setuserentity(userentity);
        SocketClientWorker connection = SocketClientWorker.getInstance();
        connection.SetMessage(message);
        if (connection.Connect()) {
            // 成功连接
            connection.SendMessage();
            message = connection.ReceiveMessage();
            System.out.println(message);
        } else {
            System.out.println("连接失败");// 失败
    
        }
        return message.getdata();
    }
    
    //查找学生
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
	 *学生操作
	 */
	public String[] takecourse(CourseEntity courseentity)//选课
	 {
	    Message message=new Message(Message.MessageType.COURSE);
	    message.setdata("SELECTCOURSE");
	    message.setcourseentity(courseentity);
	    SocketClientWorker connection = SocketClientWorker.getInstance();
	    connection.SetMessage(message);
	    if (connection.Connect()) {
	        // 成功连接
	        connection.SendMessage();
	        message = connection.ReceiveMessage();
	        System.out.println(message);
	    } else {
	        System.out.println("连接失败");// 失败

	    }
	    return message.getdata();
	 }

	 public static String[] backcourse(CourseEntity courseentity)//退课
	 {
	    Message message=new Message(Message.MessageType.COURSE);
	    message.setdata("DROPCOURSE");
	    message.setcourseentity(courseentity);
	    SocketClientWorker connection = SocketClientWorker.getInstance();
	    connection.SetMessage(message);
	    if (connection.Connect()) {
	        // 成功连接
	        connection.SendMessage();
	        message = connection.ReceiveMessage();
	        System.out.println(message);
	    } else {
	        System.out.println("连接失败");// 失败

	    }
	    return message.getdata();
	 }

	 public static List<CourseEntity> checkselectedcourse(UserEntity stu)//查看当前学生的已选课程
	 {
	    Message message=new Message(Message.MessageType.COURSE);
	    message.setdata("CHECKSELECTEDCOURSE");
	    message.setuserentity(stu);
	    SocketClientWorker connection = SocketClientWorker.getInstance();
	    connection.SetMessage(message);
	    if (connection.Connect()) {
	        // 成功连接
	        connection.SendMessage();
	        message = connection.ReceiveMessage();
	        System.out.println(message);
	    } else {
	        System.out.println("连接失败");// 失败

	    }
	    return message.getcourselist();
	 }
	 
	 //获取某个课程的其他信息（按课程ID查找）
	 public static List<ScheduleEntity> getSchedule(CourseEntity course)
	 {
	    Message message=new Message(Message.MessageType.COURSE);
	    message.setdata("GET_COURSE_CSHEDULE",course.getcCourseID());
	    message.setcourseentity(course);
	    SocketClientWorker connection = SocketClientWorker.getInstance();
	    connection.SetMessage(message);
	    if (connection.Connect()) {
	        // 成功连接
	        connection.SendMessage();
	        message = connection.ReceiveMessage();
	        System.out.println(message);
	    } else {
	        System.out.println("连接失败");// 失败

	    }
	    return message.getschedulelist();
	 }

	 public List<CourseEntity> searchcourse(String searchname)//查找老师或课程
	 {
	     Message message=new Message(Message.MessageType.COURSE);
	     message.setdata("SEARCHCOURSE",searchname);
	     SocketClientWorker connection = SocketClientWorker.getInstance();
	     connection.SetMessage(message);
	     if (connection.Connect()) {
	         // 成功连接
	         connection.SendMessage();
	         message = connection.ReceiveMessage();
	         System.out.println(message);
	     } else {
	         System.out.println("连接失败");// 失败
	 
	     }
	     return message.getcourselist();
	 }
}
