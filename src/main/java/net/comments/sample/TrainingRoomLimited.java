package net.comments.sample;

// The class represents a room with limited size

import java.util.ArrayList;
import java.util.List;

public class TrainingRoomLimited implements Room {
    private final int size;
    private List<Person> enteredPerson;
    private Teacher someteacher;


    // Allows to create a room with a given size

    public TrainingRoomLimited(int size, Teacher someTeacher) {
        enteredPerson = new ArrayList<Person>(size);
        this.size = size;
        this.someteacher = someTeacher;
    }

    // Allows to come into the room. Only one teacher can be in the room.

    public void accept(Person somePerson) {

            if (enteredPerson.size() < this.size - 1) {
                System.out.println("Student " + somePerson.getName() + " went into the room");
                enteredPerson.add(somePerson);

            } else {
                System.out.println("We don’t learn a student if it is not in the room.");
                System.out.println("--------------------------------------");
                //enteredPerson.add(somePerson);
            }

        }

    public Teacher getTeacher() {
        return this.someteacher;
    }

    public List<Person> getEnteredPerson() {
        return enteredPerson;
    }
}
