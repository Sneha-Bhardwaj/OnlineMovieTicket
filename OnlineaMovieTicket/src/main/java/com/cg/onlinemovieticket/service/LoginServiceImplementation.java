package com.cg.onlinemovieticket.service;
import java.util.List;
import com.cg.onlinemovieticket.dao.UserDaoImplement;
import com.cg.onlinemovieticket.model.Admin;
import com.cg.onlinemovieticket.model.User;

public class LoginServiceImplementation implements LoginService{
	public LoginServiceImplementation() {
		
		}
	UserDaoImplement userDao=new UserDaoImplement();
	public boolean loginAsAdmin(String id,String pass) {
		List<Admin> adminList=userDao.getAdmin();
		boolean flag=false;
		if(!(adminList.isEmpty())) {
			for(Admin a:adminList) {
				if(a.getAdminId().equals(id) && a.getAdminPassword().equals(pass)) {
					flag=true;
					break;
				}
			}
		}
		
		return flag;
	}
	public boolean loginAsUser(Integer id,String pass) {
		List<User> userList=userDao.getUser();
		boolean flag=false;
		if(!(userList.isEmpty())) {
			for(User u:userList) {
				if(u.getUserId().equals(id) && u.getPassword().equals(pass)) {
					flag=true;
					break;
				}
			}
		}
		
		return flag;
	}
	public boolean userRegistration(User u) {
		boolean flag=userDao.setUserData(u);
		return flag;
	}
	public boolean isValidation(Integer id, String userName, String password) {
		boolean flag=true;
		List<User> userList=userDao.getUser();
			if(userName.isEmpty() || password.isEmpty() || password.length()<8) {
				  flag=false;
			}
			if(flag) {
				if(userList.isEmpty()) {
					flag=true;
				}
				else {
						for(User u:userList) {
							if(u.getUserId().equals(id)) {
								flag=true;
								break;
							}
						}
					}
				}
	
			return flag;			
}
	public boolean signOut() {
		return true;
		
	}
}
