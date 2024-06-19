package studentGradeCalculator;

import java.text.DecimalFormat;

public class GradeCalculator {
	public int calcSum(int[] subjectMarks, int numberOfSubjects) {
		int totalMarks = 0;
		for(int i = 0; i < numberOfSubjects; i++) {
			totalMarks += subjectMarks[i];
		}
		return totalMarks;
	}
	
	public double calcPercent(int totalMarks, int numberOfSubjects) {
		double percent = ((double)totalMarks/numberOfSubjects);	//		Since % = (total * 100)/500 for 5 subjects and 0s are cancelled.
//		Round value to 2 decimal places.
		DecimalFormat df = new DecimalFormat("#.##");
		String formattedPercent = df.format(percent);
		percent = Double.parseDouble(formattedPercent);
		return percent;
	}
	
	public String calcGrade(double percent) {
		/*
		 * (inclusive lower limit)
		 * A+: >90 - 100
		 * A: >80 - 90
		 * B+: >70 - 80
		 * B: >60 - 70
		 * C+: >50 - 60
		 * C: >40 - 50
		 * D: >33 - 40
		 * F: <=33
		 */
		
		if(percent > 90.0) {
			return "A+";
		}
		else if(percent > 80 && percent <= 90) {
			return "A";
		}
		else if(percent > 70 && percent <= 80) {
			return "B+";
		}
		else if(percent > 60 && percent <= 70) {
			return "B";
		}
		else if(percent > 50 && percent <= 60) {
			return "C+";
		}
		else if(percent > 40 && percent <= 50) {
			return "C";
		}
		else if(percent > 33 && percent <= 40) {
			return "D";
		}
		else{
			return "F";
		}
	}
	
	public void display(int totalMarks, double percent, String grade) {
		System.out.println("Total Marks: " + totalMarks + "\nPercentage: " + percent + "%\nGrade: " + grade);
	}
}
