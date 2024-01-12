package Controller;

import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.ModelClassList;
import Model.Core.Student;
import View.ViewClass;

public class ControllerClass {

    private iGetModel model; // Модель данных
    private iGetView view; // Представление данных
    private List<Student> studentBuffer = new ArrayList<>(); // Буфер для хранения студентов

    // Конструктор класса
    public ControllerClass(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }

    // Метод для проверки данных
    private boolean testData(List<Student> stud) {
        if (stud.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // Метод для обновления данных
    public void update() {

        // MVP
        studentBuffer = model.getStudents();

        if (testData(studentBuffer)) {
            view.printAllStudents(studentBuffer);
        } else {
            System.out.println("Список студентов пуст!");
        }

        // MVC
        // view.printAllStudents(model.getStudents());
    }

    // Метод для запуска контроллера
    public void run() {
        Command com = (Command) Command.NONE;
        boolean getNewIter = true;
        while (getNewIter) {
            String command = view.prompt("Введите команду:");
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIter = false;
                    System.out.println("Выход из программы");
                    break;
                case LIST:
                    view.printAllStudents(model.getStudents());
                    break;
                case DELETE:
                    int id = Integer.parseInt(view.prompt("Введите номер студента для удаления:"));
                    model.deleteStudent(id);
                    if (getModel(id) == null) {
                        System.out.println("Студент удален.");
                    } else {
                        System.out.println("Студент с таким номером не найден.");
                    }
                    break;
            }
        }
    }

    public Student getModel(int id) {
        return model.getStudent(id);
    }
}
