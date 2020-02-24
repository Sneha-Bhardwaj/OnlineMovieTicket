package com.cg.onlinemovieticket.service;

import com.cg.onlinemovieticket.model.User;

public interface LoginService {
	public boolean loginAsAdmin(String id,String pass);
	public boolean loginAsUser(Integer id,String pass); 
	public boolean userRegistration(User u);
	public boolean isValidation(Integer id, String userName, String password);
	public boolean signOut();
}
