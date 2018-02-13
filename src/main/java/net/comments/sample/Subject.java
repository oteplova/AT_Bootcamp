package net.comments.sample;

//
public interface Subject {

    // Return subject's name.

    String getSubjectName();

    void readBy(Teacher someTeacher);

    void learnBy(Student someStudent);

}
