package Controller.Interfaces;

import java.util.List;

import Model.Core.Student;

public interface iGetModel {
    public List<Student> getStudents();
    void deleteStudent(int id);
    Student getStudent(int id);
}
