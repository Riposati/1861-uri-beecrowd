package treemapversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Murderer {
    private final Map<String, Integer> murderersMap = new TreeMap<>();
    private final Set<String> murderedSet = new HashSet<>();

    public void putInMurderersMap(String name) {
        murderersMap.putIfAbsent(name, 0);
    }

    public void addInMurderedSet(String name) {
        murderedSet.add(name);
    }

    public void murderersMapReplace(String name) {
        murderersMap.replace(name, murderersMap.get(name) + 1);
    }

    public void showSortedMap() {
        System.out.println("HALL OF MURDERERS");

        murderersMap.forEach((nameOfMurdered, amountKillers) -> {
            if (!murderedSet.contains(nameOfMurdered))
                System.out.println(nameOfMurdered + " " + amountKillers);
            }
        );
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Murderer murderer = new Murderer();

        while ((str = in.readLine()) != null) {

            String murdererNameInput = str.split(" ")[0];
            String murderedNameInput = str.split(" ")[1];

            murderer.putInMurderersMap(murdererNameInput);
            murderer.addInMurderedSet(murderedNameInput);
            murderer.murderersMapReplace(murdererNameInput);
        }
        murderer.showSortedMap();
    }
}