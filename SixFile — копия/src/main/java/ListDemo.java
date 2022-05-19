
import java.util.*;
import java.util.Comparator;

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
            }
            newHuman.add(new Human(humanss));
        }
        return newHuman;
    }

    public static List<Set<Integer>> mnojestva (List<Set<Integer>> sets, Set<Integer> set) {

        List<Set<Integer>> newSet = new ArrayList<>();

        for (Set<Integer> setss : sets) {

            Set<Integer> temporarySet = new HashSet<>(setss);

            temporarySet.retainAll(set);
            if (temporarySet.isEmpty()) {
                newSet.add(setss);
            }
        }
        return newSet;
    }

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

    /**
     *  По множеству объектов типа Human постройте отображение, которое целому числу
     *      (возраст человека) сопоставляет список всех людей данного возраста из входного множества.
     */

    public static Map<Integer, List<Human>> lastTask(Set <Human> set) {

        Map<Integer, List<Human>> newMap = new HashMap<>();

        for (Human human : set) {
            newMap.putIfAbsent(human.getAge(), new ArrayList<>());
            newMap.get(human.getAge()).add(human);
        }
        // это не надо!
//        for (Map.Entry<Integer, List<Human>> tempt : newMap.entrySet()) {
//            tempt.getValue().sort(new Comparator<Human>() {
//                @Override
//                public int compare(Human human1, Human human2) {
//                    int nameCompare = human1.getPatronymic().compareTo(human2.getPatronymic());
//                    if (nameCompare == 0) {
//                        nameCompare = human1.getFirstName().compareTo(human2.getFirstName());
//                        if (nameCompare == 0) {
//                            return human1.getLastName().compareTo(human2.getLastName());
//                        }
//                    }
//                    return nameCompare;
//                }
//            });
//        }
        return newMap;
    }
}