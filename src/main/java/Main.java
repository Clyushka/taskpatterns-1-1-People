public class Main {
    public static void main(String[] args) {
        checkBuilderExceptions();
        System.out.println("-----------------------------------------------------");
        System.out.println("РАБОТА КЛАССОВ");
        System.out.println("-----------------------------------------------------");

        System.out.println("Создание объектов:");
        Person parentWithoutAge = new PersonBuilder()
                .setName("Иван")
                .setSurname("Иванов")
                .build();

        Person parentWithAge = new PersonBuilder()
                .setName("Марина")
                .setSurname("Иванова")
                .setAge(25)
                .setAddress("Тюмень")
                .build();

        System.out.println(parentWithAge);
        System.out.println(parentWithoutAge);
        System.out.println();

        System.out.println("День рождения:");
        parentWithoutAge.happyBirthday();
        parentWithAge.happyBirthday();
        System.out.println(parentWithAge);
        System.out.println(parentWithoutAge);
        System.out.println();

        System.out.println("Рождение детей:");
        Person childWithoutCity = parentWithoutAge.newChildBuilder()
                .setName("Петр")
                .build();
        Person childWithCity = parentWithAge.newChildBuilder()
                .setName("Ирина")
                .build();
        System.out.println(childWithoutCity);
        System.out.println(childWithCity);
        System.out.println();

        System.out.println("Переезд:");
        String city = "Москва";
        parentWithoutAge.setAddress(city);
        parentWithAge.setAddress(city);
        childWithCity.setAddress(city);
        childWithoutCity.setAddress(city);
        System.out.println(parentWithAge);
        System.out.println(parentWithoutAge);
        System.out.println(childWithoutCity);
        System.out.println(childWithCity);
    }

    public static void checkBuilderExceptions() {
        System.out.println("Ошибки PersonBuilder:");

        //выброс исключения IllegalStateException, если нет имени
        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        //выброс исключения IllegalStateException, если нет фамилии
        try {
            new PersonBuilder()
                    .setName("Иван")
                    .build();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        //выброс исключения IllegalArgumentException, если направлено некорректное имя
        try {
            new PersonBuilder()
                    //.setName("")
                    .setName(null)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        //выброс исключения IllegalArgumentException, если направлена некорректная фамилия
        try {
            new PersonBuilder()
                    //.setSurname("")
                    .setSurname(null)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        //выброс исключения IllegalArgumentException, если направлен некорректный возраст
        try {
            new PersonBuilder()
                    .setAge(-100)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        //выброс исключения IllegalArgumentException, если направлен некорректный адрес
        try {
            new PersonBuilder()
                    //.setAddress("")
                    .setAddress(null)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
