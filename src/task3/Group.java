package task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group {
    private final String name;
    public HashMap<Integer, List<String>> students = new HashMap<>();

    public Group(String name, int size) {
        this.name = name;
        generate(size);
    }

    private void generate(int size) {
        for (int i = 0; i < size; i++) {
            this.students.put(i + 1, new ArrayList<>());
        }
    }

    public String getName() {
        return name;
    }
}
