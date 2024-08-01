import java.util.Scanner;

public class StudentGradeCalculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks for 5 subjects:");
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int s3 = sc.nextInt();
        int s4 = sc.nextInt();
        int s5 = sc.nextInt();
        int totalMarks = s1 + s2 + s3 + s4 + s5;
        int numberOfSubjects = 5;
        int averagePercentage = totalMarks / numberOfSubjects;
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }
        System.out.println("Total marks: " + totalMarks + "/" + (numberOfSubjects * 100));
        System.out.println("Average percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);
        sc.close();
    }
}

