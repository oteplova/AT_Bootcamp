package net.comments.sample;

/**
 * The class represents a student who learns very bad.
 */

public class BadStudent implements Student {
    private final String name;

    /**
     * Allows to create AttentiveStudent's object with a given name.
     *
     * @param name
     */
    public BadStudent(String name) {
        this.name = name;
    }

    public void learn(Subject someSubject) {
        System.out.println(this.name + " is slipping");
    }

    public String getName() {
        return this.name;
    }
}
