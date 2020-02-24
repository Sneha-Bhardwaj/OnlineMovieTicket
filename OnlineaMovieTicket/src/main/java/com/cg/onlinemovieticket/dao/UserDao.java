package com.cg.onlinemovieticket.dao;

import java.util.List;

import com.cg.onlinemovieticket.model.Admin;
import com.cg.onlinemovieticket.model.User;

public interface UserDao{

	public void setAdminData();
	public boolean setUserData(User u);
	public List<User> getUser();
	public List<Admin> getAdmin();
}
