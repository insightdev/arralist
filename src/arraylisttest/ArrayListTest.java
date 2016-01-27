/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylisttest;

import java.util.*;

/**
 *
 * @author alex
 */
public class ArrayListTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Variable declarations
        String firstName;
        String lastName;
        String myString;
        ArrayList<String> subjects = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();
        boolean areScoresValid = false;
        
        // New instance of Scanner for input
        Scanner in = new Scanner(System.in);
        
        // Ask for student's name (make sure to get newline character!)
        System.out.print("Student first name: ");
        firstName = in.nextLine();
        System.out.print("Student last name: ");
        lastName = in.nextLine();
        
        // Check to see if the scores are valid (0<= score <= 7)
        while (!areScoresValid) {
            
            // Clear lists by re-initializing
            subjects = new ArrayList<>();
            scores = new ArrayList<>();
            
            // Get subjects & scores in that order
            System.out.println("Student IB subjects & scores (separated by spaces and followed by keyword 'end'): ");
            myString = in.nextLine();
            
            // Split the input by space into an array
            String[] inputArray = myString.split(" ");
            
            // Every odd element is a subject, every even is a grade
            // Therefore we need a counter -- start with first element
            int count = 1;
            
            // For every element in the array
            for (String item : inputArray) {
                
                // If it's not the "end" keyword
                if (!item.equals("end")) {
                    
                    // If odd (order/2 has a remainder), it's a subject
                    if (count % 2 != 0) {
                        subjects.add(item);
                    } 
                    
                    // Otherwise, it's a score -- parse it as int and add
                    else {
                        scores.add(Integer.parseInt(item));
                    }
                    
                    // Don't forget to increase the count
                    count++;
                }
            }
            
            // Check at the end of the loop if the scores are valid
            // If not, areScoresValid stays false and loop continues
            areScoresValid = validateScores(scores);
            
            // Error message prints out if scores are invalid
            if (!areScoresValid) System.out.println("Sorry, invalid scores.");
            
        }
        
        // New instance of the IBStudent class with inputted attributes
        IBStudent student = new IBStudent(firstName, lastName);
        
        // For every subject entered, create a new IBExam with specified
        // subject and respective score
        for (String subject : subjects) {
            IBExam exam = new IBExam (subject, scores.get(subjects.indexOf(subject)));
            
            // Add the create IBExam to the student instance
            student.addExam(exam);
        }
        
        // RESULTS
        System.out.println("------------------------");
        System.out.println("CALCULATED:");
        
        // Highest grade
        System.out.println("Highest score: " + student.findHighestExamScore());
        
        // Average
        double sum = student.computeExamSum();
        double average = (float)(sum/(student.getExams().size()));
        System.out.println("Average score: " + average);
        System.out.println("Average (rounded): " + Math.round(average));
        
        // Number of fives
        int numberFives = student.numberOfFives();
        System.out.println("Number of fives: " + numberFives);

    }
    
    // Method used for validating scores (returns bool value)
    public static boolean validateScores(ArrayList<Integer> scores) {
        boolean valid = true;
        for (int score : scores) {
            if (score > 7 || score < 0) {
                valid = false;
            }
        }
        return valid;
    }

}
