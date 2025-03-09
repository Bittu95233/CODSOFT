import java.util.Scanner;

class StudentGradeCalculator{
    public static void main(String[] args) {
            System.out.println("Enter the number of subject: \n");
            Scanner sc = new Scanner(System.in);
            int numSubjects = sc.nextInt();
            
            int totalMarks = 0;
            int []marks = new int[numSubjects];
            
            for(int i = 0;i < numSubjects;i++) {
                System.out.println("Enter marks for each subject "+(i+1)+" (out of 100)");
                marks[i]=sc.nextInt();
                totalMarks = totalMarks + marks[i];
            }
            double avgPercentage = totalMarks/numSubjects;
            
            char grade;
            
            if(avgPercentage>90 && avgPercentage<=100) {
                grade = 'A';
            }else if(avgPercentage>80 && avgPercentage<=90) {
                grade='B';
            }else if(avgPercentage>70 && avgPercentage<=80) {
                grade='C';
            }else if(avgPercentage>60 && avgPercentage<=70) {
                grade='D';
            }else if(avgPercentage>45 && avgPercentage<=60) {
                grade='E';
            }else {
                grade='F';
            }
            System.out.println("Result of students.....");
            System.out.println("Total Marks : "+ totalMarks);
            System.out.println("Percentage  : "+ avgPercentage);
            System.out.println("Grade		: "+ grade);
            
            sc.close();
        }
}