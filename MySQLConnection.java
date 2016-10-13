import java.sql.*;

public class MySQLConnection {
    public static void main(String args[]) {
        Connection con = null;
        String host = System.getenv("DB_HOST");
        String port = System.getenv("DB_PORT");
        String database = System.getenv("DB_NAME");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
            Statement statement = con.createStatement();
            String sql = "select * from users";
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
               int id = result.getInt("id");
               System.out.println("result -> " + id);
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println("Failed to load JDBC driver");
        } catch (SQLException e) {
            System.out.println("Could not connect to the database server");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Could not close the database connection");
                }
            }
        }
    }
}
