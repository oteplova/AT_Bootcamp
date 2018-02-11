package net.comments.sample;

//Class represents subjects.

public class GeneralSubject implements Subject {
    private final String subjectName;

    // Allows to create a Subject's object with given name

    public GeneralSubject(String someSubject) {
        this.subjectName = someSubject;
    }

    // Returns subject's name

    public String getSubjectName() {
        return this.subjectName;
    }
}
