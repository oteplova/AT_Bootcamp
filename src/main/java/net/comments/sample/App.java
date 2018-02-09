package net.comments.sample;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main (String [] args){
     /*  Student andrey = new AttentiveStudent("Andrey"); // JVM know who's method should be run
       Student nastya = new AttentiveStudent("Nastya");
       Student dima = new BadStudent("Dima");
       Teacher ivan = new ProgrammingTeacher("Ivan");
       Room room = new TrainingRoom();
       ArrayList <Person> list = new ArrayList();
       list.add(andrey);
       list.add(nastya);
       list.add(dima);
       list.add(ivan);

       go(andrey);
       go(nastya);
       go(dima);
       say(ivan);
       room.accept(andrey);

       for (int i = 0; i < list.size(); i++){
           room.accept(list.get(i));
       }*/

     String [] studentNames = {"Andrey", "Nastya", "Dima"};
     String [] teacherNames = {"Ivan", "Petro"};

     ArrayList <Student> studentList = new ArrayList();
     ArrayList <Teacher> teacherList = new ArrayList();
     ArrayList <Person> personList = new ArrayList();
     Room room = new TrainingRoom();

     for (int i = 0; i < studentNames.length-1; i++){
         Student student = new AttentiveStudent(studentNames[i]);
         studentList.add(student);
     }

     for (int i = studentList.size(); i < studentNames.length; i++){
         Student student = new BadStudent(studentNames[i]);
         studentList.add(student);
     }

     for (int i = 0; i < studentNames.length-1; i++){
         Teacher teacher = new ProgrammingTeacher(teacherNames[i]);
         teacherList.add(teacher);
     }

     for (int i = 0; i < studentList.size(); i++){
         go(studentList.get(i));
     }

     for (int i = 0; i < teacherList.size(); i++){
         say(teacherList.get(i));
     }

     personList.addAll(studentList);
     personList.addAll(teacherList);
        for (int i = 0; i < personList.size(); i++){
            room.accept(personList.get(i));
        }


    }

    public static void go(Student someone){
        System.out.println(String.format("There is %s in the room!", someone.getName()));
        someone.learn();
    }

    public static void say (Teacher someone){
        System.out.println(String.format("There is the teacher %s in the room!", someone.getName()));
        someone.teach();
    }
}
