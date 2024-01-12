package Model.Core;

/**
 * Дочерний класс для студента
 */
public class Student extends Person implements Comparable<Student> {
    // Поля
    private int id;
    private static int generalID;

    // Статическое поле для идентификатора студента
    static {
        generalID = 0;
    }

    /**
     * Конструктор
     * 
     * @param name // Имя
     * @param age  // Возраст
     */
    public Student(String name, int age) {
        super(name, age);
        this.id = generalID;
        generalID++;
    }

    // Методы
    public int getId() {
        return id;
    }

    // Переопределение метода toString
    @Override
    public String toString() {
        return super.toString() + String.format("; id = %s", getId());
    }

    // Переопределение метода compareTo
    @Override
    public int compareTo(Student o) {
        System.out.println(super.getName() + "-" + o.getName());
        if (super.getAge() < o.getAge())
            return -1;
        else if (super.getAge() > o.getAge())
            return 1;
        if (this.getId() < o.getId())
            return -1;
        else if (this.getId() > o.getId())
            return 1;
        return 0;
    }
}
