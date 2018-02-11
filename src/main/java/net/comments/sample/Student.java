package net.comments.sample;

// The interface represents a student. The student can learn some subject.

public interface Student extends Person {

    // Allows to study some subject.

    void learn(Subject someSubject);
}
