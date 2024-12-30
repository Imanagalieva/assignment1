import models.Person;
import models.School;
import models.Student;
import models.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class AssignmentApplication {

    public static void main(String[] args) {
        School school = new School();

        try {
            File studentsFile = new File("resources/students.txt");
            File teachersFile = new File("resources/teachers.txt");

            List<Student> students = InputUtil.loadStudents(studentsFile);
            List<Teacher> teachers = InputUtil.loadTeachers(teachersFile);

            for (Student student : students) {
                school.addMember(student);
            }

            for (Teacher teacher : teachers) {
                school.addMember(teacher);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        // Печать всех членов школы
        System.out.println(school);

        // Пример работы с методами
        for (Person person : school.getMembers()) {
            if (person instanceof Student) {
                Student student = (Student) person;
                System.out.println(student + " GPA: " + student.calculateGPA());
            }

            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                if (teacher.getYearsOfExperience() > 10) {
                    teacher.giveRaise(10);  // даем повышение на 10%
                }
                System.out.println(teacher);
            }
        }
    }
}
