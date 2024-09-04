import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public List<Student> getStudentData() {
        List<Student> students = new ArrayList<>();
        while (true) {
            System.out.print("Enter student name (or 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            Student student = new Student(name);
            getStudentGrades(student);
            students.add(student);
        }
        return students;
    }

    private void getStudentGrades(Student student) {
        while (true) {
            System.out.print("Enter grade for " + student.getName() + " (or -1 to finish): ");
            try {
                int grade = Integer.parseInt(scanner.nextLine());
                if (grade == -1) {
                    break;
                }
                if (grade >= 0 && grade <= 100) {
                    student.addGrade(grade);
                } else {
                    System.out.println("Invalid grade. Please enter a number between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric grade.");
            }
        }
    }
}
