package jdbctests;

import java.sql.*;

public class TestConnection {

    public static void main(String[] args) throws SQLException {

        String dbUrl = "jdbc:oracle:thin:@18.205.113.195:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM regions");

        //next() --> move pointer to first row
        resultSet.next();

        //getting information with column name
        System.out.println("resultSet.getString(\"region_name\") = " + resultSet.getString("region_name"));

        //getting information with column index number(starts 1)
        System.out.println("resultSet.getString(2) = " + resultSet.getString(2));

        System.out.println(resultSet.getInt(1)); //first row, first column =1

        System.out.println("----------");

           // 1 - Europe
           // 2 - Americas
           // 3 - Asia

        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
        resultSet.next();   //move to next(second) row
        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
        resultSet.next();   //move to next(third) row
        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));


/*
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
        }
*/


        //close connection:
        resultSet.close();
        statement.close();
        connection.close();


    }
}
