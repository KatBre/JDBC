package examples;

import java.sql.*;

import static examples.Configuration.*;

public class Main8Transactions {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        connection.setAutoCommit(false);

        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE user SET username='Ambroży' WHERE id=13");
        Savepoint savepoint = connection.setSavepoint();
        statement.executeUpdate("UPDATE user SET username='Eustachy' WHERE id=14");
        connection.rollback(savepoint);
        statement.executeUpdate("UPDATE user SET username='Bożydar' WHERE id=15");
        connection.commit();
        statement.close();
        connection.close();
    }
}
