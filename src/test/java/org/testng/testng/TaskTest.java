package org.testng.testng;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class TaskTest {
    @Test
    public void positiveVerificationMatchesEpicClass() {
        String[] array = {"уборка", "учеба", "работа"};
        Task task = new Epic(1, array);
        boolean expected = true;
        Assertions.assertEquals(expected, task.matches("уборка"));
    }

    @Test
    public void negativeVerificationMatchesEpicClass() {
        String[] array = {"уборка", "учеба", "работа"};
        Task task = new Epic(1, array);
        boolean expected = false;
        Assertions.assertEquals(expected, task.matches("отдых"));
    }

    @Test
    public void positiveVerificationMatchesSimpleTaskClass() {
        Task task = new SimpleTask(1, "отдых");
        boolean expected = true;
        Assertions.assertEquals(expected, task.matches("отдых"));
    }

    @Test
    public void negativeVerificationMatchesSimpleTaskClass() {
        Task task = new SimpleTask(1, "работа");
        boolean expected = false;
        Assertions.assertEquals(expected, task.matches("отдых"));
    }

    @Test
    public void positiveVerificationMatchesMeetingTopicClass() {
        Task task = new Meeting(1, "разговоры о задачах", "перерыв", "13.12.2025 23.16");

        boolean expected = true;
        Assertions.assertEquals(expected, task.matches("разговоры о задачах"));
    }

    @Test
    public void positiveVerificationMatchesMettingProjectClass() {
        Task task = new Meeting(1, "разговоры о задах", "перерыв", "13.12.2025 23.16");
        boolean expected = true;
        Assertions.assertEquals(expected, task.matches("перерыв"));
    }

    @Test
    public void negativeVerificationMatchesMeetingClass() {
        Task task = new Meeting(1, "разговоры о задах", "перерыв", "13.12.2025 23.16");
        boolean expected = false;
        Assertions.assertEquals(expected, task.matches("работа"));
    }


}
