import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private String user = "root";
    private String password = "05070383598";
    private String dbUrl = "jdbc:mysql://localhost:3306/sys";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,user,password);
    }

    public void showErrorMessage (SQLException exception){
        System.out.println("Error Message "+exception.getMessage());
        System.out.println("Errpr Code "+exception.getErrorCode());
    }
}
