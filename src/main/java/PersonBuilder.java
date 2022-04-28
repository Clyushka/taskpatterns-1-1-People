import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String currentCity;

    public PersonBuilder() {
        this.age = OptionalInt.empty();
    }

    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Указано некорректное имя человека");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalStateException("Указана некорректная фамилия человека");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (this.age.isEmpty() && age >= 0) {
            this.age = OptionalInt.of(age);
            return this;
        } else {
            throw new IllegalStateException("Указан некорректный возраст человека");
        }
    }

    public PersonBuilder setAddress(String address) throws IllegalArgumentException {
        if (address == null || address.isEmpty()) {
            throw new IllegalStateException("Указан некорректный адрес проживания");
        }
        this.currentCity = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (this.name == null) {
            throw new IllegalStateException("Не указано имя человека");
        }
        if (this.surname == null) {
            throw new IllegalStateException("Не указана фамилия человека");
        }
        if (age.isEmpty()) {
            if (currentCity == null) {
                return new Person(this.name, this.surname);
            } else {
                return new Person(this.name, this.surname, this.currentCity);
            }
        } else {
            if (this.currentCity == null) {
                return new Person(this.name, this.surname, this.age);
            } else {
                return new Person(this.name, this.surname, this.age, this.currentCity);
            }
        }
    }

}
