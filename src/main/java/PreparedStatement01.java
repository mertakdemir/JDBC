import java.sql.*;

public class PreparedStatement01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        //1. Step: Registration to the driver
        Class.forName("org.postgresql.Driver");


        //2. Step: Create connection with database
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "23030086080Ab");


        //3. Step: Create statement
        Statement st = con.createStatement();


        //1.Example: Update the number of employees to 9999 if the company name is IBM by using prepared statement
        //1st Step: Create Prepared Statement Query
        String sql1 = "update companies set number_of_employees = ? where company = ?";

        //2nd Step: Create Prepared Statement Object
        PreparedStatement ps1 = con.prepareStatement(sql1);

        //3rd Step: Assign the values by using 'setInt(), setString()....' methods
        ps1.setInt(1, 9999);
        ps1.setString(2, "IBM");

        //4th Step: Execute the Query

        int numOfRecordsUpdated = ps1.executeUpdate();
        System.out.println("numOfRecordsUpdated = " + numOfRecordsUpdated);

        String sql2 = "SELECT*FROM companies";
        ResultSet resultSet1 = st.executeQuery(sql2);

        while (resultSet1.next()){

            System.out.println(resultSet1.getInt(1) + "-> " + resultSet1.getString(2) + "-> " + resultSet1.getInt(3));
        }


        //2.Example: Update the number of employees to 5555 if the company name is GOOGLE by using prepared statement

        ps1.setInt(1,5555);
        ps1.setString(2,"GOOGLE");

        int numOfRecordsUpdated2 = ps1.executeUpdate();
        System.out.println("numOfRecordsUpdated2 = " + numOfRecordsUpdated2);

        ResultSet resultSet2 = st.executeQuery(sql2);
        while (resultSet2.next()) {
            System.out.println(resultSet2.getInt("company_id") + "--" + resultSet2.getString("company") + "--" + resultSet2.getInt("number_of_employees"));
        }

        con.close();
        st.close();
        ps1.close();
        }
    }

