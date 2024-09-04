import java.util.List;

public class ResultDisplay {
    public void displayResults(List<Student> students, double classAverage) {
        System.out.println("------------------------------");
        System.out.println("| Student | Grades | Avg |");
        System.out.println("------------------------------");

        for (Student student : students) {
            System.out.printf("| %-7s | ", student.getName());
            List<Integer> grades = student.getGrades();
            for (int i = 0; i < grades.size(); i++) {
                System.out.print(grades.get(i));
                if (i < grades.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.printf(" | %.1f |\n", student.getAverage());
        }

        System.out.println("------------------------------");
        System.out.printf("Class Average: %.2f\n", classAverage);
    }
}
