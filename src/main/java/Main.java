public class Main {
    public static void main(String[] args){
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
        JdbcExecuter.showCustomersRecords();
        JdbcExecuter.selectNameFromCustomers();
        JdbcExecuter.showNameOfCustomerId_1();
        JdbcExecuter.updateRecOnCustomerId_1();
        JdbcExecuter.deleteRecOnCustomerId_2();
        JdbcExecuter.selectUniqueStatusFromOrders();
        JdbcExecuter.showMaxPaymentFromPayments();
    }
}