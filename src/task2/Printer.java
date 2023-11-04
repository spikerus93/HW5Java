package task2;

import java.util.HashMap;

class NamesCounter {
    private HashMap<String, Integer> names = new HashMap<>();

    public void addName (String name) {
        if (names.containsKey(name)) {
            int num = names.get(name);
            num++;
            names.put(name, num);
        } else {
            int num = 1;
            names.put(name, num);
        }
    }

    public void showNameOccurrences() {
        System.out.println(names);
    }
}

public class Printer {
    public static void main (String[] args) {
        String name1;
        String name2;
        String name3;
        String name4;
        String name5;

        if (args.length == 0) {
            name1 = "Elena";
            name2 = "Elena";
            name3 = "Elena";
            name5 = "Elena";
            name4 = "Ivan";
        } else {
            name1 = args[0];
            name2 = args[1];
            name3 = args[2];
            name4 = args[3];
            name5 = args[4];

        }
        NamesCounter namesCounter = new NamesCounter();

        namesCounter.addName(name1);
        namesCounter.addName(name2);
        namesCounter.addName(name3);
        namesCounter.addName(name4);

        namesCounter.addName(name5);

        namesCounter.showNameOccurrences();
    }

}
