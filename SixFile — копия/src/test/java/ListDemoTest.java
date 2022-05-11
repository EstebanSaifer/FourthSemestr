import org.junit.Test;

import javax.swing.*;
import java.util.*;

import static org.junit.Assert.*;

public class ListDemoTest {

    @Test
    public void listOfTheSamePatronymicTest() {

        ArrayList<Human> humans = new ArrayList<Human>();

        humans.add(new Human("Яша", "Иванов", "Отчество", 9));
        humans.add(new Human("Яна", "Иванов", "Отчество", 8));
        humans.add(new Human("Андрей", "Иванов", "Отчество", 10));
        humans.add(new Human("Андрюша", "НеИванов", "Отчество", 11));
        humans.add(new Human("ЕщеАндрей", "НеИванов", "Отчество", 12));
        humans.add(new Human("ПоследнийАндрей", "Иванов", "Отчество", 13));

        ArrayList<Human> newHumans = new ArrayList<Human>();

        newHumans.add(new Human("Яша", "Иванов", "Отчество", 9));
        newHumans.add(new Human("Яна", "Иванов", "Отчество", 8));
        newHumans.add(new Human("Андрей", "Иванов", "Отчество", 10));
        newHumans.add(new Human("ПоследнийАндрей", "Иванов", "Отчество", 13));

        Human human = new Human("Пример", "Иванов", "Отчество", 13);
        assertEquals(newHumans, ListDemo.listOfTheSamePatronymic(humans,human));
    }

    @Test
    public void removeHumanTest() {
        ArrayList<Human> humans = new ArrayList<Human>();

        humans.add(new Human("Яша", "Иванов", "Отчество", 9));
        humans.add(new Human("Яна", "Иванов", "Отчество", 8));
        humans.add(new Human("Андрей", "Иванов", "Отчество", 10));
        humans.add(new Human("Андрюша", "НеИванов", "Отчество", 11));
        humans.add(new Human("ЕщеАндрей", "НеИванов", "Отчество", 12));
        humans.add(new Human("ПоследнийАндрей", "Иванов", "Отчество", 13));

        ArrayList<Human> newHumans = new ArrayList<Human>();

        newHumans.add(new Human("Яна", "Иванов", "Отчество", 8));
        newHumans.add(new Human("Андрей", "Иванов", "Отчество", 10));
        newHumans.add(new Human("Андрюша", "НеИванов", "Отчество", 11));
        newHumans.add(new Human("ЕщеАндрей", "НеИванов", "Отчество", 12));
        newHumans.add(new Human("ПоследнийАндрей", "Иванов", "Отчество", 13));

        Human human = new Human("Яша", "Иванов", "Отчество", 9);

        assertEquals(newHumans, ListDemo.removeHuman(humans,human));
    }

    @Test
    public void mnojestvaTest() {

        // тест делает сначала множесва с числами, потом множество
        // с числами, которые не должны встречаться в списке множеств,
        // подаваемых в метод, записываем в newSet множество
        // в котором нет чисел из множества setToDo

        ArrayList<Set<Integer>> sets = new ArrayList<>();

        HashSet<Integer> set0 = new HashSet<>();
        set0.add(0);
        set0.add(1);
        set0.add(2);
        sets.add(set0);

        HashSet<Integer> set1 = new HashSet<>();
        set1.add(3);
        set1.add(4);
        set1.add(5);
        sets.add(set1);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(6);
        set2.add(7);
        set2.add(8);
        sets.add(set2);

        HashSet<Integer> setToDo = new HashSet<>();
        setToDo.add(0);
        setToDo.add(4);

        ArrayList<HashSet<Integer>> newSet = new ArrayList<>();
        newSet.add(new HashSet<>(set2));

        assertEquals(newSet, ListDemo.mnojestva(sets, setToDo));
    }

    @Test
    public void getHumanMaxAgeTest() {
        ArrayList<Human> humans = new ArrayList<>();

        humans.add(new Human("а", "аа", "ааа", 9));
        humans.add(new Human("б", "бб", "ббб", 9));
        humans.add(new Human("в", "вв", "ввв", 3));
        humans.add(new Human("г", "гг", "ггг", 9));

        ArrayList<Human> newHuman = new ArrayList<>();

        newHuman.add(new Human("а", "аа", "ааа", 9));
        newHuman.add(new Human("б", "бб", "ббб", 9));
        newHuman.add(new Human("г", "гг", "ггг", 9));

        assertEquals(newHuman, ListDemo.getHumanMaxAge(humans));
    }

    @Test
    public void peopleWhichContainsInFirstMapTest() {

        Map<Integer, Human> map = new HashMap<>();
        map.put(0, new Human("а", "аа", "ааа", 9));
        map.put(1, new Human("а", "аа", "ааа", 9));
        map.put(2, new Human("б", "бб", "ббб", 9));

        List<Integer> list = new ArrayList<>();

        list.add(-1);
        list.add(0);
        list.add(1);

        List<Human> resultList = new ArrayList<>();
        resultList.add(new Human("а", "аа", "ааа", 9));
        resultList.add(new Human("а", "аа", "ааа", 9));

        assertEquals(resultList, ListDemo.peopleWhoContainsInFirstMap(list,map));
    }

    @Test
    public void peopleWhoMoreThan18AndContainsInFirstMapTest() {

        Map<Integer, Human> map = new HashMap<>();

        map.put(0, new Human("a", "aa", "aaa", 9));
        map.put(1, new Human("b", "bb", "bbb", 19));
        map.put(2, new Human("c", "cc", "ccc", 18));
        map.put(3, new Human("d", "dd", "ddd", 2147483647));

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(list,ListDemo.peopleWhoMoreThan18AndContainsInFirstMap(map));
    }
}