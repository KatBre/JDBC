package examples;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

public class Main1Preparation {


    /*
        1.  Przygotowanie bazy danych:
            CREATE SCHEMA jdbc_schema;
            CREATE TABLE animal(id BIGINT NOT NULL, name VARCHAR(50), age INT, PRIMARY KEY (id));
            INSERT INTO animal VALUES (1, 'Reksio', 5), (2, 'Mruczek', 4), (3, 'Benio', 10);
        2.  Parametry konfiguracyjne URL, USER, PASSWORD znajdują sie w com.example.Configuration.java
            Przykładowo:
            DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_schema?serverTimezone=Europe/Warsaw", "root", "michal1");
    */


    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_schema?serverTimezone=Europe/Warsaw", "root", "root");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");

        // DESIGN PATTERN "ITERATOR"
//        List<Object> list = new ArrayList<>();
//        Iterator<Object> iterator = list.iterator();
//        boolean b = iterator.hasNext(); // hasNext -> boolean -> "czy nastepny"
//        Object next = iterator.next(); // next -> Object -> "czy nastepny + wyciagniecie obiektu"

        while (resultSet.next()) {
            BigDecimal id = resultSet.getBigDecimal(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            System.out.println(String.format("id: %s name: %s age: %s", id, name, age));
        }
        statement.close();
        connection.close();
    }

    //  inny sposób z try/catch
//            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//    Statement statement = connection.createStatement()) {
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");
//        while (resultSet.next()) {
//            long id = resultSet.getLong(1);
//            String name = resultSet.getString(2);
//            int age = resultSet.getInt(3);
//            System.out.println(String.format("Id: %s Name: %s, Age: %s", id, name, age));
//        }
//        // po wyjściu z ciała bloku try wywoływane jest w kolejności: statement.close() i następnie connection.close()
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }

}
