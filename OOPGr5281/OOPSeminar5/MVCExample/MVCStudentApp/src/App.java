import java.util.ArrayList;
import java.util.List;

import Controller.ControllerClass;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.ModelClassFile;
import Model.ModelClassHash;
import Model.ModelClassList;
import Model.Core.Student;
import View.ViewClass;
import View.ViewClassEng;

public class App {
    public static void main(String[] args) throws Exception {
       // System.out.println("Hello, World!");

        // Студенты
        Student student1 = new Student("Иван", 21);
        Student student2 = new Student("Анна", 20);
        Student student3 = new Student("Сергей", 23);
        Student student4 = new Student("Василий", 21);
        Student student5 = new Student("Марина", 22);
        Student student6 = new Student("Виталий", 25);
        Student student7 = new Student("Добрыня", 44);
        Student student8 = new Student("Владимир", 24);
        Student student9 = new Student("Виктория", 21);
        Student student10 = new Student("Александра", 22);
        Student student11 = new Student("Корнелия", 23);
        Student student12 = new Student("Ева", 21);

        // Формиурем списки
        List<Student> students1 = new ArrayList<>();
        students1.add(student1);
        students1.add(student2);
        students1.add(student3);
        students1.add(student4);
        students1.add(student5);
        students1.add(student6);
        students1.add(student7);
        students1.add(student8);
        students1.add(student9);
        students1.add(student10);
        students1.add(student11);
        students1.add(student12);

        iGetModel modelFile = new ModelClassFile("StudentDB.csv");
       // modelFile.saveAllStudentToFile(students1);

        iGetModel modelList = new ModelClassList(students1);
        iGetView viewSimple = new ViewClass();

        ControllerClass controller1 = new ControllerClass(modelFile, viewSimple);
        controller1.run();//.update();


        // Создание экземпляра класса ViewClassEng
        iGetView viewEng = new ViewClassEng();
        ControllerClass controller2 = new ControllerClass(modelFile, viewEng);

        controller2.run();


        ModelClassHash modelHash = new ModelClassHash();
        ControllerClass controller3 = new ControllerClass(modelHash, viewSimple);

        // Добавляем студента в модель
        modelHash.addModel(1, new Student("Павел", 20));

        // Получаем студента через контроллер
        Student student = controller3.getModel(1);
    }
}
