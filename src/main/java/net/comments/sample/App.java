package net.comments.sample;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // Arrays with student's and teacher's names
        String[] studentNamesAttentive = {"Andrey", "Nastya", "Dima", "Kolya"};
        String[] studentNamesBad = {"Anya", "Vova", "Zina"};
        String[] teacherNames = {"Ivan", "Petro"};

        List<Student> studentList = new ArrayList();
        List<Teacher> teacherList = new ArrayList();

        Subject gitSubject = new GeneralSubject("use git");
        Subject cookingSubject = new GeneralSubject("bake a cake");

        Room limitedRoom = new TrainingRoomLimited(6);
        Room unlimitedRoom = new TrainingRoomUnlimited();

        // Fill collection with Student's objects
        for (String studentName : studentNamesAttentive) {
            studentList.add(new AttentiveStudent(studentName));
        }

        // Fill collection with Student's objects
        for (String studentName : studentNamesBad) {
            studentList.add(new BadStudent(studentName));
        }

        // Fill collection with Teacher's objects
        for (String teacherName : teacherNames) {
            teacherList.add(new MultiTeacher(teacherName));
        }

        // Allows Persons (Students, Teachers) to come into the room to study/teach the subgect
        enterInToRoom(studentList, teacherList, limitedRoom, gitSubject);
        enterInToRoom(studentList, teacherList, unlimitedRoom, cookingSubject);
    }

    private static void go(Student someone, Subject someSubject) {
        System.out.println(String.format("There is %s in the room!", someone.getName()));
        someone.learn(someSubject);
    }

    private static void say(Teacher someone, Subject someSubject) {
        System.out.println(String.format("There is the teacher %s in the room!", someone.getName()));
        someone.teach(someSubject);
    }

    private static void enterInToRoom(List<Student> someStudent, List<Teacher> someTeacher, Room someRoom, Subject someSubject) {
        for (Student student : someStudent) {
            someRoom.accept(student);
            System.out.println("--------------------------------------");
        }

        for (Teacher teacher : someTeacher) {
            someRoom.accept(teacher);
            System.out.println("--------------------------------------");
        }

        for (Person somePerson : someRoom.getEnteredPerson()) {
            if (somePerson instanceof Student) {
                go((Student) somePerson, someSubject);
                System.out.println("--------------------------------------");
            } else if (somePerson instanceof Teacher) {
                say((Teacher) somePerson, someSubject);
                System.out.println("--------------------------------------");
            }
        }
    }
}