package com.java8.covariantrturntype;
interface Interviewer {
    default Object submitInterviewStatus() {
        System.out.println("Interviewer:Accept");
        return "Interviewer:Accept";
    }
}
class Manager implements Interviewer {
    @Override
    public String submitInterviewStatus() {
        System.out.println("Manager:Accept");
        return "Manager:Accept";
    }
}
class Project {
    public static void main(String args[]) {
        Interviewer interviewer = new Manager();
        interviewer.submitInterviewStatus();
        Manager mgr = new Manager();
        mgr.submitInterviewStatus();
    }
}