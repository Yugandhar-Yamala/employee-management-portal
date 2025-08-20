package com.naidu.p2;
import java.util.*;
import com.naidu.p1.Employee;
public interface empDoa {
	List getEmployees();
	Employee getEmployee(int id);
	boolean insertEmployee(int id,String name,int salary);
	boolean updateEmployee(int id);
	boolean deleteEmployee(int id);
	
}
