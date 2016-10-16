import java.sql.*;

public class MySQLConnection {
    public ResultSet[] main(String args[]) {
        Connection con = null;
        ResultSet[] resultSet = new ResultSet[args.length];
        String host = System.getenv("DB_HOST");
        String port = System.getenv("DB_PORT");
        String database = System.getenv("DB_NAME");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
            Statement statement = con.createStatement();
            for (int i = 0; i < args.length; i++){
               String sql = "select * from " + args[i];
               ResultSet result = statement.executeQuery(sql);
               resultSet[i] = result;
            };
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
      return resultSet;
    }
}
