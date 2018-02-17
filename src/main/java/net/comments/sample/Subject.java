package net.comments.sample;

/**
 * The interface represents a subject.
 */
public interface Subject {

    /**
     * Return subject's name.
     */
    String getSubjectName();

    /**
     * Allows to teach a subject using programm
     *
     * @param someTeacher
     */
    void readBy(Teacher someTeacher);

    /**
     * Allows to learn a subject using programm
     *
     * @param someStudent
     */
    void learnBy(Student someStudent);

}
