package net.comments.sample;

//Class represents subjects.

public class TechSubject implements Subject {
    private final String subjectName = "use Git";

    // Returns subject's name

    public String getSubjectName() {
        return this.subjectName;
    }

    public void readBy(Teacher someTeacher) {
        System.out.println("Teacher " + someTeacher.getName() + " tells about:");
        System.out.println("1. VCS;");
        System.out.println("2. how Git tracks code changes;");
        System.out.println("3. how to install and configure the system;");
        System.out.println("4. how to create branches, merge them and fix conflicts in the code;");
    }

    public void learnBy(Student someStudent) {
        System.out.println("Student " + someStudent.getName() + " will learn about:");
        System.out.println("1. VCS");
        System.out.println("2. how Git tracks code changes;");
        System.out.println("3. how to install and configure the system;");
        System.out.println("4. how to create branches, merge them and fix conflicts in the code;");

    }
}
