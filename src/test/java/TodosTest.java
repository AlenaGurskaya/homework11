import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    SimpleTask task1 = new SimpleTask(1, "Добавить задачу SimpleTask");
    Epic task2 = new Epic(2, new String[]{"Найти тему", "Написать реферат!"});
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
    public void shouldSearchQuery() {
        Todos todos = new Todos();

        todos.add(task1);
        todos.add(task2);
        todos.add(task3);

        Task[] expected1 = {task1};
        Task[] expected2 = {task2};
        Task[] expected3 = {task3};
        Task[] expected4 = {task2};
        Task[] expected5 = {task1, task2, task3};
        Task[] expected6 = {task1, task3};
        Task[] actuale1 = todos.search("simpletask"); //нижний регистр + задача SimpleTask
        Task[] actuale2 = todos.search("РЕФЕРАТ");    //верхний регистр + задача Epic
        Task[] actuale3 = todos.search("обсуждение"); //нижний регистр + задача Meeting
        Task[] actuale4 = todos.search("!");          //спецсимвол
        Task[] actuale5 = todos.search("");           //0 символов
        Task[] actuale6 = todos.search("д");          //1 символ

        Assertions.assertArrayEquals(expected1, actuale1);
        Assertions.assertArrayEquals(expected2, actuale2);
        Assertions.assertArrayEquals(expected3, actuale3);
        Assertions.assertArrayEquals(expected4, actuale4);
        Assertions.assertArrayEquals(expected5, actuale5);
        Assertions.assertArrayEquals(expected6, actuale6);

    }
}
