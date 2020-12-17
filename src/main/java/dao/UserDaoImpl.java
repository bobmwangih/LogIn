package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import models.User;

public class UserDaoImpl implements UserDao {
	//DataSource instantiation to create Driver class and set url
	private DataSource ds;

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	public int Save(User u) throws Exception {
		//open connection to save
		Connection cn = ds.getConnection();
		PreparedStatement ps = cn.prepareStatement("insert into user(name,email,password) values(?,?,?)");
		ps.setString(1, u.getName());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getPassword());
		int i =ps.executeUpdate();
		cn.close();
		
		return i;
	}

	
	public boolean findBy(String email,String password) throws Exception {
		boolean registered;
		Connection cn = ds.getConnection();
		PreparedStatement ps1 = cn.prepareStatement("select * from user where email =? and password=?");
		ps1.setString(1,email);
		ps1.setString(2,password);
		ResultSet user = ps1.executeQuery();
		cn.close();
		 //String em = user.getString(1);
		registered = user.next();
		return registered;
	}
	
	
	
}