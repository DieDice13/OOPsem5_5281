package Model;

import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Core.Student;

public class ModelClassList implements iGetModel {

    // Поля
    private List<Student> students; // Список студентов

    // Конструктор класса
    public ModelClassList(List<Student> students) {
        this.students = students;
    }

    // Метод для получения списка студентов
    public List<Student> getStudents()
    {
        return students;
    }

    // Метод для удаления студента по идентификатору
    @Override
    public void deleteStudent(int id) {
        List<Student> students = getStudents();
        students.removeIf(student -> student.getId() == id);
    }

    @Override
    public Student getStudent(int id) {
        List<Student> students = getStudents();
    for (Student student : students) {
        if (student.getId() == id) {
            return student;
        }
    }
    return null;
    }

}
