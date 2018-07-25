package MavenDemo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
	
	Statement stmt=conn.createStatement();  
	/*int i=stmt.executeUpdate("create table employee1(emp_id int,emp_name varchar(15),emp_city varchar(10))");
	if(i>0)
	{
		System.out.println("Table Created");
	}*/
	ResultSet rs=stmt.executeQuery("select * from Employee");  
	while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	conn.close();  
}
	

}


class Employee{
	private String Name;
	private int id;
	private int salary;
	public Employee(String name, int id, int salary) {
		super();
		Name = name;
		this.id = id;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [Name=" + Name + ", id=" + id + ", salary=" + salary + "]";
	}
	
	
	
	
}