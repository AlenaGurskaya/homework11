import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    SimpleTask task1 = new SimpleTask(1, "Добавить задачу SimpleTask");
    Epic task2 = new Epic(2, new String[]{"Найти тему", "Написать реферат!", "Выполнить задачу"});
    Meeting task3 = new Meeting(3, "Встреча", "Обсуждение текуших задач", "19.06");

    @Test
    public void shouldAddTaskWhenNoTasks() {
        Todos todos = new Todos();

        todos.add(task1);

        Task[] expected = {task1};
        Task[] actuale = todos.findAll();

        Assertions.assertArrayEquals(expected, actuale);
    }

    @Test
    public void shouldAddTaskWhenOneTask() {
        Todos todos = new Todos();

        todos.add(task1);
        todos.add(task2);

        Task[] expected = {task1, task2};
        Task[] actuale = todos.findAll();

        Assertions.assertArrayEquals(expected, actuale);
    }

    @Test
    public void shouldSearchNullTasks() {
        Todos todos = new Todos();

        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] expected = {};
        Task[] actuale = todos.search("Прогулка");

        Assertions.assertArrayEquals(expected, actuale);
    }

    @Test
    public void shouldSearchOneTask() {
        Todos todos = new Todos();

        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] expected = {task1};
        Task[] actuale = todos.search("simpletask");

        Assertions.assertArrayEquals(expected, actuale);
    }

    @Test
    public void shouldSearchMoreOneTask() {
        Todos todos = new Todos();

        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] expected = {task1, task2, task3};
        Task[] actuale = todos.search("задач");

        Assertions.assertArrayEquals(expected, actuale);
    }
}
