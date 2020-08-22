package examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2Statement {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(Configuration.URL, Configuration.USER, Configuration.PASSWORD);
        Statement statementOne = connection.createStatement();
        int amount = statementOne.executeUpdate("UPDATE animal SET name='Jasio' WHERE id=2");
        System.out.println(amount);
        statementOne.close();

        Statement statementTwo = connection.createStatement();
        boolean execute = statementTwo.execute("SELECT * FROM animal");
        System.out.println(execute);
        statementTwo.close();

        connection.close();

    }
}
