package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Core.Student;

public class ModelClassHash implements iGetModel{
    // Поля
    private HashMap<Integer, Student> storage; // Хранилищем типа HashMap<int,Student>

    public ModelClassHash() {
        this.storage = new HashMap<>();
        storage.put(1, new Student("John Doe", 20));
        storage.put(2, new Student("Jane Doe", 22));
    }

    // Метод для добавления студента в хранилище
    public void addModel(int id, Student student) {
        this.storage.put(id, student);
    }

    @Override
    public List<Student> getStudents() {
        return new ArrayList<>(this.storage.values());
    }

    @Override
    public void deleteStudent(int id) {
        if (storage.containsKey(id)) {
            storage.remove(id);
        }
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
