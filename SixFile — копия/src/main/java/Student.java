public class Student extends Human{

    private String nameOfFacultet;

    public Student(String firstName, String lastName, String patronymic, int age, String nameOfFacultet) {
        super(firstName, lastName, patronymic, age);
        this.nameOfFacultet = nameOfFacultet;
    }

    public String getNameOfFacultet() {
        return nameOfFacultet;
    }

    public void setNameOfFacultet(String nameOfFacultet) {
        this.nameOfFacultet = nameOfFacultet;
    }
}
