package org.example;

import org.example.entity.Priority;
import org.example.entity.Status;
import org.example.entity.Task;
import org.example.entity.TaskData;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        testGetUnion();
        testGetIntersect();
        testGetDifference();

    }

    private static void testGetUnion() {
        Set<Task> annsTasks = new HashSet<>();
        annsTasks.add(new Task("ProjectA", "Task 1", "Ann", Priority.HIGH, Status.IN_PROGRESS));

        Set<Task> bobsTasks = new HashSet<>();
        bobsTasks.add(new Task("ProjectB", "Task 2", "Bob", Priority.MED, Status.ASSIGNED));

        Set<Task> carolsTasks = new HashSet<>();
        carolsTasks.add(new Task("ProjectC", "Task 3", "Carol", Priority.LOW, Status.IN_QUEUE));

        TaskData taskData = new TaskData(annsTasks, bobsTasks, carolsTasks, new HashSet<>());

        Set<Task> unionResult = taskData.getUnion(annsTasks, bobsTasks, carolsTasks);
        System.out.println("Union Result: " + unionResult.size());
        System.out.println("Union contains Task 1: " + unionResult.containsAll(annsTasks));
        System.out.println("Union contains Task 2: " + unionResult.containsAll(bobsTasks));
        System.out.println("Union contains Task 3: " + unionResult.containsAll(carolsTasks));
    }
    public static void testGetIntersect() {
        Set<Task> annsTasks = new HashSet<>();
        Task task1 = new Task("ProjectA", "Task 1", "Ann", Priority.HIGH, Status.IN_PROGRESS);
        annsTasks.add(task1);

        Set<Task> bobsTasks = new HashSet<>();
        bobsTasks.add(task1);

        TaskData taskData = new TaskData(annsTasks, bobsTasks, new HashSet<>(), new HashSet<>());

        Set<Task> intersection = taskData.getIntersect(annsTasks, bobsTasks);
        System.out.println("Intersection size: " + intersection.size());
        System.out.println("Intersection contains Task 1: " + intersection.contains(task1));
    }
    public static void testGetDifference() {
        Set<Task> annsTasks = new HashSet<>();
        Task task1 = new Task("ProjectA", "Task 1", "Ann", Priority.HIGH, Status.IN_PROGRESS);
        annsTasks.add(task1);

        Set<Task> bobsTasks = new HashSet<>();
        bobsTasks.add(task1);

        TaskData taskData = new TaskData(annsTasks, bobsTasks, new HashSet<>(), new HashSet<>());

        Set<Task> difference = taskData.getDifference(annsTasks, bobsTasks);
        System.out.println("Difference size: " + difference.size());
        System.out.println("Difference contains Task 1: " + difference.isEmpty());
    }


}