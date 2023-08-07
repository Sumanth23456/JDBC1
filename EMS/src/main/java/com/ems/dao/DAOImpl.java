package com.ems.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


import com.ems.domain.Employee;

public class DAOImpl implements EmployeeDAO{
	 Connection con=null;
	 public DAOImpl() {
       try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bitlabs","root","Sumanth1123*");
   }
       catch(Exception e) {

           System.out.println(e);

       }
	 }
	public boolean addEmployee(Employee emp) {
		boolean c=false;
		try {
		PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
		 ps.setInt(1, emp.getEid());

	       ps.setString(2, emp.getEname());

	       ps.setInt(3, emp.getAge());

	       ps.setString(4, emp.getContactNumber());
	       
	       int b=ps.executeUpdate();
	       if(b>0) {
	    	   c=true;
	       }
	       

		}
		 catch(Exception e) {

	           System.out.println(e);

	       }
		return c;
		
	}
	public boolean updateEmployee(Employee emp) {
		boolean b=false;
    
    	try {
    		
    	PreparedStatement pstmt =con.prepareStatement("Update student set marks=?,sname=?,city=? where sid=? ");

    	pstmt.setInt(1,emp.getEid());
    	   pstmt.setString(2, emp.getEname());
    	   pstmt.setInt(3, emp.getAge());
    	   pstmt.setString(4, emp.getContactNumber());
    	   
	       
	       
    	int i=pstmt.executeUpdate();
    	
    	if(i>=0) {
    		b=true;
    	}		
    	}
    	catch(Exception e ) {
    		System.out.println(e);
    	}
    	return b;
	}
	public boolean deleteEmployee(int employeeId) {
		boolean c=false;
		try {
		PreparedStatement ps=con.prepareStatement("delete from employee where eid=?");
		ps.setInt(1,employeeId);
		int b=ps.executeUpdate();
		if(b>0) {
			c=true;
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return false;
	}
	public Employee getEmployeeById(int employeeId) {
		Employee e=new Employee();
	
		try {
	       
		
			PreparedStatement ps=con.prepareStatement("select * from employee where eid=?");
			ps.setInt(1,employeeId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				e.setEid(rs.getInt("sid"));
				e.setEname(rs.getString("ename"));
				e.setAge(rs.getInt("age"));
				e.setContactNumber(rs.getString("contact"));
			}
		}
		catch(Exception e2) {
			System.out.println(e2);
		}
		return e;
	}
	public List<Employee> getAllEmployees() {
		List<Employee> al=new ArrayList<Employee>();
		Employee e=new Employee();
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from employee ");
		ResultSet rs=	ps.executeQuery();
		while(rs.next()) {
			e.setEid(rs.getInt("eid"));
			e.setEname(rs.getString("ename"));
			e.setAge(rs.getInt("age"));
			e.setContactNumber(rs.getString("contact"));
		}
		}
		catch(Exception e2) {
			System.out.println(e2);
		}
			
		
		return al;
	}
	
	
}
