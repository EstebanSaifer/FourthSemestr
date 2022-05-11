
import java.util.*;

public class ListDemo {

    public static List<Human> listOfTheSamePatronymic(List<Human> humans, Human human) {

        List<Human> newHuman = new ArrayList<>();

        for (Human humanss : humans) {
            if (humanss.getLastName().equals(human.getLastName())) {
                newHuman.add(humanss);
            }
        }
        return newHuman;
    }

    public static List<Human> removeHuman(List<Human> humans, Human human) {

        List<Human> newHuman = new ArrayList<>();
        for (Human humanss : humans) {
            if (humanss.equals(human)) {
                continue;
//                newHuman.add(new Human(human)); //почему не работает :(
//                newHuman.remove(new Human(human));
            }
            newHuman.add(new Human(humanss));
        }
        return newHuman;
    }

    public static List<Set<Integer>> mnojestva (List<Set<Integer>> sets, Set<Integer> set) {

        List<Set<Integer>> newSet = new ArrayList<>(); //создаем списком множеств в который будем записывать ответ

        for (Set<Integer> setss : sets) {

            Set<Integer> temporarySet = new HashSet<>(setss);

            temporarySet.retainAll(set);
            if (temporarySet.isEmpty()) {
                newSet.add(setss);
            }
        }
        return newSet;
    }

    // Напишите метод класса ListDemo, который получает на вход список, состоящий из
    // объектов типа Human и его производных классов. Результат — множество людей из
    // входного списка с максимальным возрастом.

    public static List<Human> getHumanMaxAge (List<Human> humans) {

        List<Human> newHuman = new ArrayList<>();
        int maxAge = 0;
        for(Human humanss : humans) {
            if(maxAge <= humanss.getAge()) {
                if(maxAge < humanss.getAge()) {
                    maxAge = humanss.getAge();
                    newHuman.clear();
                }
                newHuman.add(humanss);
            }
        }
        return newHuman;
    }

    public static List<Human> peopleWhoContainsInFirstMap (List<Integer> intInt, Map<Integer, Human> map ) {
        List<Human> newHuman = new ArrayList<>();
        for (int k : intInt) {
            if(map.containsKey(k)) {
                newHuman.add(map.get(k));
            }
        }
        return newHuman;
    }

    public static List<Integer> peopleWhoMoreThan18AndContainsInFirstMap (Map<Integer, Human> map) {
        List<Integer> newInteger = new ArrayList<>();

        for(Map.Entry<Integer, Human> item : map.entrySet()){
            if(item.getValue().getAge() >= 18) {
                newInteger.add(item.getKey());
            }
        }
        return newInteger;
    }

    public static Map<Integer, Integer> peopleWithEgualsIdAndAge(Map<Integer, Human> map) {
        Map<Integer, Integer> newMap = new HashMap<>();
        for (int k : map.keySet()) {
            newMap.put(k, map.get(k).getAge());
        }
        return newMap;
    }
}