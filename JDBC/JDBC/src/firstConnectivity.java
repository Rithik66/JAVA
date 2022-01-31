import java.sql.*;
public class firstConnectivity {
	/*
	* 
	* 1. import java.sql.*;
	* 2. load and register the driver (com.mysql.jdbc.Driver)
	* 3. Create connection
	* 4. Create a statement
	* 5. Execute the query
	* 6. process the results
	* 7. close
	* 
	*/
	public static void main(String[] args) throws Exception{
		String url="jdbc:mysql://localhost:3306/basics",uname="root",pass="rithik66@mysql";
		String query="select name from student";
		//Class.forName("com.mysql.jdbc.Driver");
		Connection connect = DriverManager.getConnection(url,uname,pass);
		Statement statement = connect.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()){
			String name = rs.getString("name");
			System.out.println(name);
		}
		statement.close();
		connect.close();
	}
}