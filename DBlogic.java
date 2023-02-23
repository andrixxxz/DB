import java.sql.*;

public class DBlogic {

        String DB = "jdbc:mysql://localhost:3306/java_sql";
        String USER = "root";
        String PASS = "Pikmens123";

        //method - insert, connection, insert
    public void insert(String email) throws SQLException {
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String sql = "INSERT INTO users (email) VALUES ('"+ email +"')";

        stmt.executeUpdate(sql);

        System.out.println("Dati ievaditi");

    }


        //method - delete, conenction, delete
    public void delete(int id) throws SQLException{
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String sql = "DELETE from users WHERE id = '"+ id +"'";

        stmt.executeUpdate(sql);

        System.out.println("Dati tika dzēsti");
    }

    //method - select, connection, select
    public void select()throws SQLException{
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();
        ResultSet resultset = stmt.executeQuery("SELECT id, email FROM users");

        while(resultset.next()){
            System.out.println("id:" + resultset.getInt("id"));
            System.out.println("E-mail: " +resultset.getString("email"));
            System.out.println();
        }
    }

    //method updaye, conenction
    public void update(String email, int id)throws SQLException{
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String sql = "UPDATE users SET email = '"+ email +"' WHERE id = '"+ id + "'";

        stmt.executeUpdate(sql);

        System.out.println("Dati atjaunoti");
    }

}
