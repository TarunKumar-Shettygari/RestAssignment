package com.accolite.au.restAssignment.RestAssignment.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accolite.au.restAssignment.RestAssignment.model.Profile;

public class ProfileService {
	Connection con;
	Statement stmt;
	public ProfileService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/au","root","root");
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
	}
	
	public Profile getProfile(String name) {
		Profile profile=new Profile();
		try {
			ResultSet rs=stmt.executeQuery("select * from profile where name='"+name+"'");
			if(rs.next()) {
				profile.setName(rs.getString("name"));
				profile.setEmail_id(rs.getString("email_id"));
				profile.setPassword(rs.getString("password"));
				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return profile;
	}
	
	public List<Profile> getAllProfiles() {
		List<Profile> profiles=new ArrayList<Profile>();
		try {
			ResultSet rs=stmt.executeQuery("select * from profile");
			while(rs.next()) {
				Profile profile=new Profile();
				profile.setName(rs.getString("name"));
				profile.setEmail_id(rs.getString("email_id"));
				profile.setPassword(rs.getString("password"));
				profiles.add(profile);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return profiles;
	}
	
	public String addProfile(Profile profile) {
		try {
			stmt.executeUpdate("insert into profile(name,email_id,password) values('"+profile.getName()+"','"+profile.getEmail_id()+"','"+profile.getPassword()+"')");
			return "Profile created";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Profile creatation failed";
		}
	}
	
	public String updateProfile(Profile profile) {
		try {
			stmt.executeUpdate("update profile set email_id='"+profile.getEmail_id()+"',password='"+profile.getPassword()+"' where name='"+profile.getName()+"'");
			return "Updated profile";
		} catch (SQLException e) {
			e.printStackTrace();
			return "profile update failed";
		}
	}
	
	public String deleteProfile(String name) {
		try {
			stmt.executeUpdate("delete from profile where name='"+name+"'");
			return "profile deleted";
		} catch (SQLException e) {
			e.printStackTrace();
			return "profile delete failed";
		}
	}


}
