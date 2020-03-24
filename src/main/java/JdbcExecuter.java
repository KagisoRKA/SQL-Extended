import java.sql.*;
public class JdbcExecuter {
    static DatabaseConnectionManager dcm = new DatabaseConnectionManager("umuzi", "user","pass");
    static void showCustomersRecords(){
        try{
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM customers";
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData rsMetaData = resultSet.getMetaData();

            int colCount = rsMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int j = 1; j <= colCount; j++) {
                    String colName = rsMetaData.getColumnName(j);
                    System.out.print(colName.toUpperCase() + ": ");
                    System.out.print(resultSet.getString(j)+", ");
                }
                System.out.println();
            }
            System.out.println();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    static void selectNameFromCustomers(){
        try{
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM customers";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("FIRST_NAMES: ");
            while (resultSet.next()){
                System.out.print(resultSet.getString("firstname")+" | ");
            }
            System.out.println("\n");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    static void showNameOfCustomerId_1(){
        try{
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT firstname FROM customers WHERE customerid = 1";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("FIRST_NAME: ");
            while (resultSet.next()){
                System.out.print(resultSet.getString("firstname")+" | ");
            }
            System.out.println("\n");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    static void updateRecOnCustomerId_1(){
        try{
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            String sql = "UPDATE customers SET firstname='Lerato', lastname='Mabitso' WHERE customerid=1";
            statement.executeUpdate(sql);
            sql = "SELECT * FROM customers";
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData rsMetaData = resultSet.getMetaData();

            int colCount = rsMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int j = 1; j <= colCount; j++) {
                    String colName = rsMetaData.getColumnName(j);
                    System.out.print(colName.toUpperCase() + ": ");
                    System.out.print(resultSet.getString(j)+", ");
                }
                System.out.println();
            }
            System.out.println();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    static void deleteRecOnCustomerId_2(){
        try {
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM customers WHERE customerId=2";
            statement.executeUpdate(sql);
            sql = "SELECT * FROM customers";
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData rsMetaData = resultSet.getMetaData();
            int colCount = rsMetaData.getColumnCount();
            while (resultSet.next()){
                for (int i = 1;i<=colCount;i++){
                    String colName = rsMetaData.getColumnName(i);
                    System.out.print(colName.toUpperCase()+": ");
                    System.out.print(resultSet.getString(i)+", ");
                }
                System.out.println();
            }
            System.out.println();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    static void selectUniqueStatusFromOrders(){
        try {
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT DISTINCT status FROM orders";
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData rsMetaData = resultSet.getMetaData();
            String colName = rsMetaData.getColumnName(1);
            System.out.print(colName.toUpperCase()+": ");
            while (resultSet.next()){
                System.out.print(resultSet.getString(1)+" | ");
            }
            System.out.println("\n");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    static void showMaxPaymentFromPayments(){
        try {
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT MAX(amount) FROM payments";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.print("AMOUNT: ");
            while (resultSet.next()){
                System.out.print(resultSet.getString(1)+" | ");
            }
            System.out.println();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}