package net.comments.sample;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // Arrays with student's and teacher's names
        String[] studentNamesAttentive = {"Andrey", "Nastya", "Dima", "Kolya"};
        String[] studentNamesBad = {"Anya", "Vova", "Zina"};
        String[] teacherNames = {"Ivan", "Petro"};

        List<Person> personList = new ArrayList();

        Room limitedRoom = new TrainingRoomLimited(6);
        Room unlimitedRoom = new TrainingRoomUnlimited();

        Subject gitSubject = new GeneralSubject("use git");
        Subject cookingSubject = new GeneralSubject("bake a cake");

        // Fill collection with Student's objects
        for (int i = 0; i < studentNamesAttentive.length; i++) {
            personList.add(new AttentiveStudent(studentNamesAttentive[i]));
        }

        // Fill collection with Student's objects
        for (int i = 0; i < studentNamesBad.length; i++) {
            personList.add(new BadStudent(studentNamesBad[i]));
        }

        // Fill collection with Teacher's objects
        for (int i = 0; i < teacherNames.length; i++) {
            personList.add(new MultiTeacher(teacherNames[i]));
        }

        // Allows Persons (Students, Teachers) to come into the room to study/teach the subgect
        enterInToRoom(personList, limitedRoom, gitSubject);
        enterInToRoom(personList, unlimitedRoom, cookingSubject);

    }

    public static void go(Student someone, Subject someSubject) {
        System.out.println(String.format("There is %s in the room!", someone.getName()));
        someone.learn(someSubject);
    }

    public static void say(Teacher someone, Subject someSubject) {
        System.out.println(String.format("There is the teacher %s in the room!", someone.getName()));
        someone.teach(someSubject);
    }

    public static void enterInToRoom(List<Person> somePerson, Room someRoom, Subject someSubject) {

        for (int i = 0; i < somePerson.size(); i++) {
            boolean validEnterence = someRoom.accept(somePerson.get(i));

            if (validEnterence) {
                if (somePerson.get(i) instanceof Student) {
                    go((Student) somePerson.get(i), someSubject);
                    System.out.println("--------------------------------------");
                } else {
                    say((Teacher) somePerson.get(i), someSubject);
                    System.out.println("--------------------------------------");
                }
            }
        }
    }
}