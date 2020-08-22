package examples;

import java.sql.*;
import java.util.List;

import static examples.Configuration.*;

public class Main5PreparedStatementExercise {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        List<String> usernames = List.of("Jan", "Ala", "Mike", "Ola");
        List<String> passwords = List.of("password1", "password2", "password3", "password4");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user(username, password) VALUES(?, ?)");
        for (int i = 0; i < usernames.size(); i++) {
            preparedStatement.setString(1, usernames.get(i));
            preparedStatement.setString(2, passwords.get(i));
            preparedStatement.executeUpdate();
        }

        preparedStatement.close();
        connection.close();
    }
}
