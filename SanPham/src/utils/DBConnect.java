package utils;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class DBConnect {
    
    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DBNAME = "PoLyBop_01";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "123456";

    public static Connection getConnection() {
        String url = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";" + "databaseName=" + DBNAME;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, USERNAME, PASSWORD);     
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    
    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Kết nối thành công!");
            } else {
                System.out.println("Kết nối thất bại!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}