package com.naidu.p2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.naidu.p1.Employee;
import com.naidu.p3.ConnectionFactory;

public class EmpDoaimp implements empDoa {

	@Override
	public List getEmployees() {
		// TODO Auto-generated method stub
		Employee e=null;
		ArrayList<Employee> a=new ArrayList<Employee>();
		try {
			Connection con=ConnectionFactory.requestConnection();
			String quary="Select*from emp1";
			Statement st=con.createStatement();
			ResultSet res=st.executeQuery(quary);
			while(res.next()) {
				int id=res.getInt(1);
				String name=res.getString(2);
				int sal=res.getInt(3);
				e=new Employee(id,name,sal);
				a.add(e);
			}
			
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return a;
		
	}

	@Override
	public Employee getEmployee(int id) {
		Employee e=null;
		try {
			Connection con=ConnectionFactory.requestConnection();
			String quary="Select*from emp1 where id=?";
			PreparedStatement pst=con.prepareStatement(quary);
			pst.setInt(1, id);
			ResultSet res=pst.executeQuery();
			res.next();
			e=new Employee(res.getInt(1),res.getString(2),res.getInt(3));
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	@Override
	public boolean insertEmployee(int id, String name, int salary) {
		Connection con;
		boolean se=false;
		try {
			con = ConnectionFactory.requestConnection();
			String quary="insert into emp1 (id,name,salary)values(?,?,?)";
			PreparedStatement pmt=con.prepareStatement(quary);
			pmt.setInt(1,id);
			pmt.setString(2,name);
			pmt.setInt(3, salary);
			pmt.execute();
			se=true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return se;
	}

	@Override
	public boolean updateEmployee(int id) {
		Connection con=null;
		String quary=null;
		boolean se=false;
		// TODO Auto-generated method stub
		try {
			con = ConnectionFactory.requestConnection();
			Scanner sc=new Scanner(System.in);
			System.out.println("Please click 1 for update name: ");
			System.out.println("Please click 2 for update Salary: ");
			int choice=sc.nextInt();
			if(choice==1) {
				quary="update emp1 set name=? where id=?";
				PreparedStatement pmt=con.prepareStatement(quary);
				System.out.println("Enter the new name: ");
				String name=sc.next();
				pmt.setString(1,name);
				pmt.setInt(2, id);
				pmt.execute();
				se=true;
			}
			else {
				quary="update emp1 set salary=? where id=?";
				PreparedStatement pmt=con.prepareStatement(quary);
				System.out.println("Enter the new salary: ");
				int sal=sc.nextInt();
				pmt.setInt(1,sal);
				pmt.setInt(2, id);
				pmt.execute();
				se=true;
			}
			
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return se;
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Connection con=null;
		boolean se=false;
		try {
			con = ConnectionFactory.requestConnection();
			String quary="delete from emp1 where id=?";
			PreparedStatement pmt=con.prepareStatement(quary);
			pmt.setInt(1, id);
			pmt.execute();
			se=true;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return se;
	}
	
}
