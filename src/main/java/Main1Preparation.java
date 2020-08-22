import java.math.BigDecimal;
import java.sql.*;

public class Main1Preparation {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_schema?serverTimezone=Europe/Warsaw", "root", "Klusek1982");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");
        while (resultSet.next()) {
            BigDecimal id = resultSet.getBigDecimal(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            System.out.println(String.format("id: %s name: %s age: %s", id, name, age));
        }
        statement.close();
        connection.close();

    }
}
