package Model.Core;

/**
 * Родительский класс
 */
public class Person {
    // Поля
    private String name;
    private int age;

    /**
     * Конструктор
     * 
     * @param name // Имя
     * @param age  // Возраст
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Методы
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return String.format("Имя = %s; Возраст = %d", getName(), getAge());
    }
}
