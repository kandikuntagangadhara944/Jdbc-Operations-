package com.palletech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcOperations 

{
	static String url="jdbc:mysql://localhost:3306/jdbc";
	static String user="root";
	static String password="Ganga@123";
	static String createstatement="create table student1(sid int,sname varchar(20),"
			+ "course varchar(20))";
	static String insert="insert into student1 values(?,?,?) ";
	static String delete="delete from student1 where sid=?";
	static String update="update student1 set sname=?,course=? where sid=?";
	static Connection con=null;
	static Statement s=null;
	static PreparedStatement ps=null;
	ResultSet rs=null;
	public static void connections()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void create()
	{
		
		try {
			connections();
			s=con.createStatement();
			s.executeUpdate(createstatement);
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally
		{
			try {
				s.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void  insertion(int id,String name,String course)
	{
		try {
			connections();
			ps=con.prepareStatement(insert);
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setString(3,course);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void delete(int id)
	{
		try {
			connections();
			ps=con.prepareStatement(delete);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void update(String name,String course,int id)
	{
		try {
			connections();
			ps=con.prepareStatement(update);
			ps.setString(1, name);
			ps.setString(2, course);
			ps.setInt(3,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
