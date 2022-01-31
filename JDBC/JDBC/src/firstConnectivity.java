import java.sql.*;
public class firstConnectivity {
	/*
	* 1. import java.sql.*;
	* 2. load and register the driver (com.mysql.jdbc.Driver)
	* 3. Create connection
	* 4. Create a statement
	* 5. Execute the query
	* 6. process the results
	* 7. close0
	*/
	public static void main(String[] args) throws Exception{
		String url="jdbc:mysql://localhost:3306/basics",uname="root",pass="rithik66@mysql";
		String query="insert into student values(?,?)";
		//Class.forName("com.mysql.jdbc.Driver");
		Connection connect = DriverManager.getConnection(url,uname,pass);
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, 7);
		statement.setString(2, "NewName");
		int count = statement.executeUpdate();
		statement.close();
		connect.close();
	}
}