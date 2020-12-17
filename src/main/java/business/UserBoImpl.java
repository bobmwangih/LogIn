package business;

import dao.UserDao;
import models.User;

public class UserBoImpl implements UserBo {
	private UserDao dao;

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public int createUser(User u) throws Exception {
		int i = dao.Save(u);
		return i;
	}

	public boolean logInUser(String email, String password) throws Exception {
		
		return dao.findBy(email, password);
	}
	
	}

	
