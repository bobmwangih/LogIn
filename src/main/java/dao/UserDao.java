package dao;

import models.User;

public interface UserDao {
	
	public int Save(User u) throws Exception;
	public boolean findBy(String email,String password)throws Exception;

}
