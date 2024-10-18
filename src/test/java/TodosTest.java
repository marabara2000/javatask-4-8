import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.Console;
import java.lang.reflect.Array;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);
        todos.add(epic);
        todos.add(simpleTask);

        Task[] expected = {meeting, epic, simpleTask};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryInMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Boolean expected = false;
        Boolean actual = meeting.matches("вторник");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryInMeeting2() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Boolean expected = true;
        Boolean actual = meeting.matches("версии");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryInMeeting1() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");

        Boolean expected = true;
        Boolean actual = meeting.matches("НетоБанк");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryInSimpleTask1() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Boolean expected = false;
        Boolean actual = simpleTask.matches("НетоБанк");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryInSimpleTask2() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Boolean expected = true;
        Boolean actual = simpleTask.matches("родителям");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryInEpic1() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Boolean expected = false;
        Boolean actual = epic.matches("вторник");

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldSearchQueryInEpic2() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Boolean expected = true;
        Boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void shouldSearchQueryInTodos1() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);
        todos.add(epic);
        todos.add(simpleTask);

        Task[] expected = {meeting};
        Task[] actual = todos.search("НетоБанк");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryInTodos0() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);
        todos.add(epic);
        todos.add(simpleTask);

        Task[] expected = {};
        Task[] actual = todos.search("Мама");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchQueryInTodos2() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить Одежда");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Одежда",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);
        todos.add(epic);
        todos.add(simpleTask);

        Task[] expected = {meeting, simpleTask};
        Task[] actual = todos.search("Одежда");
        Assertions.assertArrayEquals(expected, actual);

    }

}

