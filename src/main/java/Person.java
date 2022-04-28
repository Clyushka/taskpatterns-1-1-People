import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private String name;
    private String surname;
    private OptionalInt age = OptionalInt.empty();
    private String currentCity;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, OptionalInt age) {
        this(name, surname);
        this.age = age;
    }

    public Person(String name, String surname, String currentCity) {
        this(name, surname);
        this.currentCity = currentCity;
    }

    public Person(String name, String surname, OptionalInt age, String currentCity) {
        this(name, surname, age);
        this.currentCity = currentCity;
    }

    public boolean hasAge() {
        return !this.age.isEmpty();
    }

    public boolean hasAddress() {
        if (this.currentCity == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        return this.age;
    }

    public String getAddress() {
        return this.currentCity;
    }

    public void setAddress(String currentCity) {
        this.currentCity = currentCity;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age = OptionalInt.of(this.age.getAsInt() + 1);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s. Возраст: %s. Город: %s",
                this.name,
                this.surname,
                this.hasAge() ? this.age.getAsInt() : "неизвестно",
                this.hasAddress() ? this.currentCity : "неизвестно");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder pb =  new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0);
        if (this.hasAddress()) {
            return pb.setAddress(this.currentCity);
        }
        return pb;
    }
}
