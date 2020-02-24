package com.cg.onlinemovieticket.dao;
import java.util.ArrayList;
import java.util.List;
import com.cg.onlinemovieticket.model.Admin;
import com.cg.onlinemovieticket.model.User;

public class UserDaoImplement implements UserDao {
	static List<Admin> adminList=new ArrayList<Admin>();
	static List<User> userList=new ArrayList<User>();
		
	public UserDaoImplement() {
		
		setAdminData();
	}

	public void setAdminData() {
	
		adminList.add(new Admin("1235","Manas","34@manas"));
		adminList.add(new Admin("1236","Shiv","1354@shiv"));
		adminList.add(new Admin("1237","Kanak","2134@knk"));	
		
 }
	public boolean setUserData(User u) {
		userList.add(u);	
		return true;
		
	}
	public List<User> getUser(){
		return userList;
	}
	public List<Admin> getAdmin(){
		return adminList;
	}
	
}
