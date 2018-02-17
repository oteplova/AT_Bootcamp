package net.comments.sample;

/**
 * The class represents a student who learns very well.
 */

public class AttentiveStudent implements Student {
    private final String name;

    /**
     * Allows to create AttentiveStudent's object with a given name.
     *
     * @param name
     */
    public AttentiveStudent(String name) {
        this.name = name;
    }

    public void learn(Subject someSubject) {
        System.out.println(this.name + " is listening how to " + someSubject.getSubjectName());
        someSubject.learnBy(this);
    }

    /**
     * Return  AttentiveStudent's name
     */
    public String getName() {
        return this.name;
    }
}
