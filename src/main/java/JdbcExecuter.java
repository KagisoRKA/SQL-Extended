import java.sql.*;
import java.math.*;
public class JdbcExecuter {
    public static void main(String[] args){
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost","umuzi",
                "user","pass");
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        try{
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM customers");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}