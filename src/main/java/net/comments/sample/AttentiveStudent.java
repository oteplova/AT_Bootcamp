package net.comments.sample;

// The class represents a student who learns very well.

public class AttentiveStudent implements Student {
    private final String name;

    // Allows to create AttentiveStudent's object with a given name.

    public AttentiveStudent(String name){
        this.name = name;
    }

    // Allows to study the given subject

    public void learn(Subject someSubject) {
        System.out.println(this.name + " is listening how to " + someSubject.getSubjectName());
        someSubject.learnBy(this);
    }

    // Return  AttentiveStudent's name
    public String getName() {
        return this.name;
    }
}
