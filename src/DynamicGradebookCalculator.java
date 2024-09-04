import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicGradebookCalculator {
    private List<String> studentNames;
    private List<List<Integer>> studentGrades;
    private List<Double> studentAverages;
    private Scanner scanner;

    public DynamicGradebookCalculator() {
        scanner = new Scanner(System.in);
        studentNames = new ArrayList<>();
        studentGrades = new ArrayList<>();
        studentAverages = new ArrayList<>();
    }

    public void run() {
        enterStudentData();
        calculateAverages();
        displayResults();
    }

    private void enterStudentData() {
        while (true) {
            System.out.print("Enter student name (or 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            studentNames.add(name);
            List<Integer> grades = new ArrayList<>();
            
            while (true) {
                System.out.print("Enter grade for " + name + " (or -1 to finish): ");
                try {
                    int grade = Integer.parseInt(scanner.nextLine());
                    if (grade == -1) {
                        break;
                    }
                    if (grade >= 0 && grade <= 100) {
                        grades.add(grade);
                    } else {
                        System.out.println("Invalid grade. Please enter a number between 0 and 100.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric grade.");
                }
            }
            studentGrades.add(grades);
        }
    }

    private void calculateAverages() {
        for (List<Integer> grades : studentGrades) {
            double sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            studentAverages.add(sum / grades.size());
        }
    }

    private void displayResults() {
        System.out.println("------------------------------");
        System.out.println("| Student | Grades | Avg |");
        System.out.println("------------------------------");

        for (int i = 0; i < studentNames.size(); i++) {
            System.out.printf("| %-7s | ", studentNames.get(i));
            List<Integer> grades = studentGrades.get(i);
            for (int j = 0; j < grades.size(); j++) {
                System.out.print(grades.get(j));
                if (j < grades.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.printf(" | %.1f |\n", studentAverages.get(i));
        }

        System.out.println("------------------------------");
        System.out.printf("Class Average: %.2f\n", calculateClassAverage());
    }

    private double calculateClassAverage() {
        double sum = 0;
        for (double avg : studentAverages) {
            sum += avg;
        }
        return sum / studentAverages.size();
    }

    public static void main(String[] args) {
        DynamicGradebookCalculator calculator = new DynamicGradebookCalculator();
        calculator.run();
    }
}
