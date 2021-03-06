package net.comments.sample;

/**
 * The interface represents a teacher. The teacher can teach some subject.
 */
public interface Teacher extends Person {

    /**
     * Allows to teach a some subject.
     *
     * @param someSubject
     */
    void teach(Subject someSubject);
}
