
import java.util.ArrayList;
import java.util.Objects;

public class Human {

    private String firstName;
    private String lastName;
    private String patronymic; //отчество
    private int age;

    public Human(String firstName, String lastName, String patronymic, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.age = age;
    }

    public Human(Human human) {
        firstName = human.getFirstName();
        lastName = human.getLastName();
        patronymic = human.getPatronymic();
        age = human.getAge();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(firstName, human.firstName) && Objects.equals(lastName, human.lastName) && Objects.equals(patronymic, human.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, patronymic, age);
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", patronymic = '" + patronymic + '\'' +
                ", age = " + age +
                '}';
    }
}