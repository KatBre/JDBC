package examples;

import java.sql.*;

import static examples.Configuration.*;

public class StatementExercise {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        int amount = statement.executeUpdate("CREATE TABLE IF NOT EXISTS user(id BIGINT NOT NULL AUTO_INCREMENT, username VARCHAR(50), password VARCHAR(50), PRIMARY KEY(id))");
        int updateAmount = statement.executeUpdate("INSERT INTO user(username, password) VALUES ('John', 'cat'), ('Ahmed', 'dog'), ('Mary', 'fish'), ('Unicorn', 'rainbow'), ('Greg', 'mouse'), ('Anna', 'hamster')");
        ResultSet resultSet = statement.executeQuery("SELECT username FROM user");
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            System.out.println(username);
        }
        statement.executeUpdate("DELETE FROM user");
        statement.close();
        connection.close();
    }
}
