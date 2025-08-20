package com.naidu.p3;
import java.util.List;
import java.util.Scanner;
import com.naidu.p1.Employee;
import com.naidu.p2.*;
public class DoaDriver {
	public static Scanner sc=new Scanner(System.in);
	public static EmpDoaimp em=new EmpDoaimp();
	 public static void main(String args[]) {
		 System.out.println("<<<<<<<---WELLCOME TO EMPLOYEE MANAGEMENT PORTAL--->>>>>>>");
		 while (true) {
	            System.out.println("1. View All Employees");
	            System.out.println("2. Get Employee Details");
	            System.out.println("3. Add New Employee");
	            System.out.println("4. Update Employee Details");
	            System.out.println("5. Delete Employee");
	            System.out.println("6. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = sc.nextInt();

	            switch (choice) {
	                case 1:
	                    getAllEmployees();
	                    System.out.println();
	                    break;
	                case 2:
	                    getEmployeeDetails();
	                    System.out.println();
	                    break;
	                case 3:
	                    addEmployee();
	                    System.out.println();
	                    break;
	                case 4:
	                    updateEmployeeDetails();
	                    System.out.println();
	                    break;
	                case 5:
	                    deleteEmployee(); 
	                    System.out.println();
	                    break;
	                case 6:
	                    System.out.println("Exiting... Goodbye!");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid Choice! Try Again.");
	            }
	        }
	    }
	 

	 //View All Employees
	 public static void getAllEmployees() {
		 List<Employee> a=em.getEmployees();
		 for(Employee e:a) {
			 System.out.println(e);
		 }
	 }
	 //Get Employee Details
	 public static void getEmployeeDetails() {
		 System.out.println("Enter the Employee Id ");
		 int id=sc.nextInt();
		 Employee e=em.getEmployee(id);
		 System.out.println(e);
	 }
	 //Add new Details Employee
	 public static void addEmployee() {
		 System.out.println("Enter the Employee Id");
		 int id=sc.nextInt();
		 System.out.println("Enter the Employee Name");
		 String name =sc.next();
		 System.out.println("Enter the Employee Salary");
		 int salary=sc.nextInt();
		 boolean se=em.insertEmployee(id,name,salary);
		 if(se) {
			 System.out.println("Successfully Added Employee Details");
		 }else {
			 System.out.println("Successfully Not Added Employee Details");
		 }
	 }
	 //Update Employee Details
	 public static void updateEmployeeDetails() {
		 System.out.println("Enter the Employee id want to Update ");
		 int id=sc.nextInt();
		 boolean se=em.updateEmployee(id);
		 if(se) {
			 System.out.println("Successfully Updated Employee Details");
		 }else {
			 System.out.println("Employee Details Not Updated");
		 }
	 }
	 //Delete Employee details
	 public static void deleteEmployee() {
		 System.out.println("Enter the Employee id want to Delete ");
		 int id=sc.nextInt();
		 boolean se=em.deleteEmployee(id);
		 if(se) {
			 System.out.println("Successfully Deleted Employee Details");
		 }else {
			 System.out.println("Employee Details Not Deleted");
		 }
	 }
	 
	 

	 
}
