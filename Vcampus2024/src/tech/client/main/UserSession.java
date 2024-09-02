package tech.client.main;

import Entity.UserEntity;
//用于在不同窗口都可调用保存的用户信息
public class UserSession {
	 private static UserSession instance;//单例类
	    private UserEntity user;

	    private UserSession() {}

	    public static UserSession getInstance() {
	        if (instance == null) {
	            instance = new UserSession();
	        }
	        return instance;
	    }

	    public UserEntity getUser() {
	        return user;
	    }

	    public void setUser(UserEntity user) {
	        this.user = user;
	    }
}
