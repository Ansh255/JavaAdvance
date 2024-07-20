package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.RegisterVo;

public class RegisterDao {
	public void inst(RegisterVo v) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/mvc", "root", "root");
			Statement F = c.createStatement();
			F.executeUpdate("INSERT INTO register_table(fn,ln) VALUES('" + v.getFn() + "','" + v.getLn() + "')");

		} catch (Exception e) {
		}
	}

	public List search_edit(RegisterVo v) {
		List ls = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/mvc", "root", "root");
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM register_table where id ='"+v.getId()+"'");
			while(r.next()){
				RegisterVo registerVo = new RegisterVo();
				
				int i = r.getInt("id");
				String d = r.getString("fn");
				String d1 = r.getString("ln");
				
				registerVo.setId(i);
				registerVo.setFn(d);
				registerVo.setLn(d1);
				
				ls.add(registerVo);
			}

		} catch (Exception e) {
		}
		return ls;
	}
	public List search_ta() {
		List ls = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/mvc", "root", "root");
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM register_table");
			while(r.next()){
				RegisterVo registerVo = new RegisterVo();
				
				int i = r.getInt("id");
				String d = r.getString("fn");
				String d1 = r.getString("ln");
				
				registerVo.setId(i);
				registerVo.setFn(d);
				registerVo.setLn(d1);
				
				ls.add(registerVo);
			}

		} catch (Exception e) {
		}
		return ls;
	}
	
	
	
	public void delete(RegisterVo v){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/mvc", "root", "root");
			Statement s = c.createStatement();
			s.executeUpdate("DELETE from register_table WHERE id ='"+v.getId()+"'");
		}
		catch(Exception e){}
	
	}
	public void update(RegisterVo v){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/mvc", "root", "root");
			Statement s = c.createStatement();
			s.executeUpdate("UPDATE register_table set fn='"+v.getFn()+"', ln='"+v.getLn()+"' where id ='"+v.getId()+"'");
			
		}catch(Exception e){}
	}
}
