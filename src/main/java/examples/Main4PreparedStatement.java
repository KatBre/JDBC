package examples;

import java.sql.*;

import static examples.Configuration.*;

public class Main4PreparedStatement {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT age FROM animal WHERE name=?");
        preparedStatement.setString(1, "Benio");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int age = resultSet.getInt("age");
            System.out.println(age);
        }
        preparedStatement.close();
        connection.close();
    }
}
