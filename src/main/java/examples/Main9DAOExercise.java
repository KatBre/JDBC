package examples;

import examples.DAO.TaskDAO;
import examples.model.Task;

import java.sql.SQLException;

public class Main9DAOExercise {

    public static void main(String[] args) {
        try (TaskDAO taskDAO = new TaskDAO()) {
            taskDAO.create(new Task(1L, "To jest pierwsze zadanie pierwszego uzytkownika", 13L));
            taskDAO.create(new Task(2L, "To jest drugie zadanie pierwszego uzytkownika", 14L));
            taskDAO.create(new Task(3L, "To jest pierwsze zadanie drugiego uzytkownika", 15L));
            taskDAO.readAll().forEach(System.out::println);
            System.out.println("---> Stworzono trzy taski\n");

            taskDAO.read(14L).ifPresent(System.out::println);
            taskDAO.update(new Task(14L, "To jest zaktualizowane zadanie pierwszego użytkownika. Teraz właścicielem jest 2 użytkownik", 14L));
            taskDAO.read(14L).ifPresent(System.out::println);
            System.out.println("---> Zaktualizowano drugi task\n");

            taskDAO.readAllForUser("Ala").forEach(System.out::println);
            System.out.println("---> Wyświetlono wszystkie taski użytkownika Ala\n");

            taskDAO.delete(13L);
            taskDAO.readAll().forEach(System.out::println);
            System.out.println("---> Usunięto pierwszy task\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
