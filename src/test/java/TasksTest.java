import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TasksTest {

    @ParameterizedTest
    @CsvSource({
            "true,SIMPLETASK",
            "true,simpletask",
            "true,Д",
            "true,0",
//            "true,",
            "true,!"
    })
    public void shouldSimpleTaskMatchesQuery(boolean expected, String query) {
        SimpleTask simpleTask = new SimpleTask(1, "Добавить задачу SimpleTask 15.06!");

        Assertions.assertEquals(expected, simpleTask.matches(query));
    }

//    @Test
//    public void shouldSimpleTaskMatchesQueryTest() {
//        SimpleTask simpleTask = new SimpleTask(1, "Добавить задачу SimpleTask 15.06!");
//
//        boolean expected = true;
//        boolean actuale = simpleTask.matches("");
//        Assertions.assertEquals(expected, actuale);
//    }

    @Test
    public void shouldSimpleTaskNotMatchesQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "Добавить задачу SimpleTask");

        boolean expected = false;
        boolean actual = simpleTask.matches("Прогулка");

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "true,EPIC",
            "true,epic",
            "true,p",
            "true,1",
            "true,!"
    })
    public void shouldEpicTaskMatchesQuery(boolean expected, String query) {
        Epic epic = new Epic(1, new String[]{"Открыть планировщик!", "Нажать добавить задачу Epic123"});

        Assertions.assertEquals(expected, epic.matches(query));
    }

    @Test
    public void shouldEpicTaskNotMatchesQuery() {
        Epic epic = new Epic(1, new String[]{"Открыть планировщик!", "Нажать добавить задачу Epic123"});

        boolean expected = false;
        boolean actual = epic.matches("сделать дз");

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "true,ОБСУЖДЕНИЕ",
            "true,обсуждение",
            "true,о",
            "true,9",
            "true,!"
    })
    public void shouldMeetingMatchesQuery(boolean expected, String query) {
        Meeting meeting = new Meeting(2, "Встреча!!!", "Обсуждение текущих задач 19.06", "19.06");

        Assertions.assertEquals(expected, meeting.matches(query));
    }

    @Test
    public void shouldMeetingNotMatchesQuery() {
        Meeting meeting = new Meeting(2, "Встреча", "Обсуждение текущих задач", "19.06");

        boolean expected = false;
        boolean actuale = meeting.matches("прогулка");

        Assertions.assertEquals(expected, actuale);
    }
}
