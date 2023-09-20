import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Murderer {
    private Map<String, Integer> murderersMap = new HashMap<>();
    private Set<String> murderedSet = new HashSet<>();

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

        Map<String, Integer> sortedMurderersMap = getSortedMurderersMap(murderersMap);

        sortedMurderersMap.forEach((nameOfMurdered, amountKillers) ->
                System.out.println(nameOfMurdered + " " + amountKillers)
        );
    }

    public Map<String, Integer> getSortedMurderersMap(Map<String, Integer> murderersMap) {
        return murderersMap.entrySet().stream()
                .filter(x -> !murderedSet.contains(x.getKey()))
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
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