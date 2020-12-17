package business;

import models.User;

public interface UserBo {
	public int createUser(User u) throws Exception;
	public boolean logInUser(String email,String password) throws Exception;
	
}

