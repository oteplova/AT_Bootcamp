package net.comments.sample;

/**
 * Class represents the concrete teacher
 */

public class MultiTeacher implements Teacher {
    private final String name;

    /**
     * Allows to create Teacher's object with given name
     */
    public MultiTeacher(String name) {
        this.name = name;
    }

    /**
     * Return Teacher's name
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Allows to teach the given subject
     */
    public void teach(Subject someSubject) {
        System.out.println(this.name + " teaches how to " + someSubject.getSubjectName());
    }
}
