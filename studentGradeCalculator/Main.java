package studentGradeCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int numberOfSubjects = 5;
		int[] subjectMarks = new int[numberOfSubjects];
		// No need to initialize array elements to 0 since the elements in the array
		// allocated by new will automatically be initialized to zero (for numeric
		// types)

		Scanner sc = new Scanner(System.in);

//		User Input for marks of each subject
		for (int i = 0; i < numberOfSubjects; i++) {
            int marks;
            do {
                try {
                    System.out.println("Enter marks for subject " + (i + 1) + ": ");
                    marks = sc.nextInt();
                    if (marks < 1 || marks > 100) {
                        System.out.println("Invalid marks. Please enter a value between 1 and 100.");
                    }
                } catch (InputMismatchException e) {
//                	InputMismatchException is raised when int was expected, but some other datatype was encountered.
                    System.out.println("Invalid input. Please enter an integer.");
                    sc.next(); // Clear the buffer
                    marks = Integer.MIN_VALUE; // Set a flag to indicate invalid input
                }
            } while (marks < 1 || marks > 100);
            subjectMarks[i] = marks;
        }
		
		sc.close();

		
		GradeCalculator gc = new GradeCalculator();
		
		int totalMarks = gc.calcSum(subjectMarks, numberOfSubjects);
		double percent = gc.calcPercent(totalMarks, numberOfSubjects);
		String grade = gc.calcGrade(percent);
		gc.display(totalMarks, percent, grade);
	}
}
