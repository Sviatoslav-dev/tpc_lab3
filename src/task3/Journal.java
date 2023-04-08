package task3;

import java.util.HashMap;
import java.util.stream.Collectors;

public class Journal {
    public HashMap<String, Group> groups = new HashMap<>();

    public Journal() {
        Group group1 = new Group("ІС-71", 25);
        Group group2 = new Group("ІС-72", 30);
        Group group3 = new Group("ІС-73", 26);

        this.groups.put(group1.getName(), group1);
        this.groups.put(group2.getName(), group2);
        this.groups.put(group3.getName(), group3);
    }

    public void addMark(String groupName, Integer studentName, String mark) {
        synchronized (this.groups.get(groupName).students.get(studentName)) {
            this.groups.get(groupName).students.get(studentName).add(mark);
        }
    }

    public void show() {
        for (String groupName : groups.keySet().stream().sorted().collect(Collectors.toList())) {
            System.out.printf("Group name: %6s\n", groupName);
            for (Integer studentName :
                    groups.get(groupName).students.keySet().stream().sorted().collect(Collectors.toList())) {
                System.out.printf("Student %5s %5s", studentName, "-");
                for (String mark : groups.get(groupName).students.get(studentName)) {
                    System.out.printf("%30s", mark);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
