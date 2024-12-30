import models.Student;
import models.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class InputUtil {

    public static List<Student> loadStudents(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<Student> students = new ArrayList<>();

        while (scanner.hasNext()) {
            String name = scanner.next();
            String surname = scanner.next();
            int age = scanner.nextInt();
            boolean gender = scanner.next().equalsIgnoreCase("Male");

            Student student = new Student(name, surname, age, gender);
            while (scanner.hasNextInt()) {
                student.addGrade(scanner.nextInt());
            }

            students.add(student);
        }

        return students;
    }

    public static List<Teacher> loadTeachers(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<Teacher> teachers = new ArrayList<>();

        while (scanner.hasNext()) {
            String name = scanner.next();
            String surname = scanner.next();
            int age = scanner.nextInt();
            boolean gender = scanner.next().equalsIgnoreCase("Male");

            String subject = scanner.next();
            int yearsOfExperience = scanner.nextInt();
            int salary = scanner.nextInt();

            Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
            teachers.add(teacher);
        }

        return teachers;
    }
}
