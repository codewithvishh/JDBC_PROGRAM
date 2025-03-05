package jdbcprogram2;
import java.sql.*;
import java.util.Scanner;
public class DBCon2 {
 //construct JDBC application to select employee details based on salary
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1522:xe", "C##VISHAL", "JAVA41");
			Statement stm=con.createStatement();
			System.out.println("Enter Emp Sal");
			int sal=sc.nextInt();
			ResultSet rs=stm.executeQuery("SELECT * FROM EMP WHERE SAL="+sal+"");
			if(rs.next()) {
				System.out.println(rs.getLong(1)+"\t"
			                                 +rs.getString(2)+"\t"
						                     +rs.getString(3)+"\t"
			                                 +rs.getLong(4)+"\t"
						                     +rs.getString(5)+"\t"
			                                 +rs.getLong(6));
			}
			else {
				System.out.println("Invalid EName");
			}
			con.close();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
