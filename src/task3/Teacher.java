package task3;

import java.util.List;

public class Teacher implements Runnable {
    private final String name;
    private final List<String> groupNames;
    private final Journal journal;
    private final int nWeeks;

    public Teacher(String teacherName, List<String> groupNames, int nWeeks, Journal journal) {
        this.name = teacherName;
        this.groupNames = groupNames;
        this.journal = journal;
        this.nWeeks = nWeeks;
    }

    @Override
    public void run() {
        for (int i = 0; i < nWeeks; i++) {
            for (String groupName : groupNames) {
                for (Integer studentName : this.journal.groups.get(groupName).students.keySet()) {
                    Double mark = (double) (Math.round(100 * Math.random() * 100)) / 100;
                    journal.addMark(groupName, studentName, mark + " (" + this.name + ")");
                }
            }
        }
    }
}
