import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Homework {

    /*
   Given
     User connects to the database
     (Host name: medunna.com, Database name: medunna_db, Usename: medunna_user, Password: medunna_pass_987))

   When
     User sends the query to get the names of created_by column from "room" table

   Then
     Verify that there are some rooms created by "john doe".

   And
     User closes the connection
  */



    public static void main(String[] args) throws SQLException {

        JdbcUtils.connectToDatabase("medunna.com", "medunna_db", "medunna_user", "medunna_pass_987");

        Statement statement = JdbcUtils.createStatement();

        String sql1 = "select created_by from room";

        JdbcUtils.execute(sql1);

        String sql2 = "select created_by from room where created_by like 'john doe' ";
        ResultSet resultSet = statement.executeQuery(sql2);

        while (resultSet.next()){
            System.out.println("created_by : " + resultSet.getString("created_by"));
        }

        JdbcUtils.closeConnectionAndStatement();





    }
}
