/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylisttest;

/**
 *
 * @author alex
 */
public class IBExam {
    private String mySubject;
    private int myScore;
    
    // CONSTRUCTORS
    public IBExam() {
        this.mySubject = "";
        this.myScore = 1;
    }
    public IBExam(String mySubject, int myScore) {
        this.mySubject = mySubject;
        this.myScore = myScore;
    }
    
    // ACCESSORS
    public String getSubject() {
        return mySubject;
    }
    public int getScore() {
        return myScore;
    }
    
    // MUTATORS
    public void setSubject(String subject) {
        this.mySubject = subject;
    }
    public void setScore(int score) {
        this.myScore = score;
    }
    
}
