import javax.swing.*;
import java.sql.Statement;

public class Runner {

    //1. Step: Registration to the driver
    //2. Step: Create connection with database

    public static void main(String[] args) {
        JdbcUtils.connectToDatabase("localhost", "postgres", "postgres", "23030086080Ab");


        //3. Step: Create statement
        Statement statement = JdbcUtils.createStatement();

        //4. Step: Execute the query
        JdbcUtils.createTable("Students","name VARCHAR(20)","id INT","address VARCHAR(50)","tel BIGINT");

        JdbcUtils.insertDataIntoTable("Students","name 'John'");
        JdbcUtils.insertDataIntoTable("Students","name 'Mark'","id 123","tel 1234567890","address 'Ankara'");

        //JdbcUtils.dropTable("Students");

        //5th Step: Close the connection and Statement
        JdbcUtils.closeConnectionAndStatement();
    }
}
