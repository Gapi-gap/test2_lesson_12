package org.testng.testng;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class TodosTest {

    Task task1 = new Meeting(0, "работа", "тестирование", "13.12.2025");
    Task task2 = new SimpleTask(3, "стирка");
    String [] array = {"учеба","уборка", "хобби"};
    Task task3 = new Epic(5, array);
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    private void Initalizator(Todos todos)
    {

        todos.add(task1);
        todos.add(task2);
        todos.add(task3);
    }
    @Test
    public void checkingSearchItemsTodos()
    {
        Todos todos = new Todos();
        Initalizator(todos);
        String []result;
        Task[] resultSearch = todos.search("хобби");
        Task[] expected = {task3};
        Assertions.assertArrayEquals(expected, resultSearch);
    }

    @Test
    public void checkingSearchItemsTodosNegative()
    {
        Todos todos = new Todos();
        Initalizator(todos);
        String []result;
        Task[] resultSearch = todos.search("отдых");
        Task[] expected = {};
        Assertions.assertArrayEquals(expected, resultSearch);
    }
}
