import java.util.List;

public class UpdatedGradeBookCalculator {
    private List<Student> students;
    private InputHandler inputHandler;
    private GradeCalculator gradeCalculator;
    private ResultDisplay resultDisplay;

    public UpdatedGradeBookCalculator() {
        inputHandler = new InputHandler();
        gradeCalculator = new GradeCalculator();
        resultDisplay = new ResultDisplay();
    }

    public void run() {
        students = inputHandler.getStudentData();
        gradeCalculator.calculateAverages(students);
        double classAverage = gradeCalculator.calculateClassAverage(students);
        resultDisplay.displayResults(students, classAverage);
    }
}
