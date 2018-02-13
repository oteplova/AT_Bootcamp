package net.comments.sample;

// The class represents a room with unlimited size

import java.util.ArrayList;
import java.util.List;

public class TrainingRoomUnlimited implements Room {
    private Teacher someTeacher;
    private List<Person> enteredPerson;

    public TrainingRoomUnlimited(Teacher someTeacher) {
        this.someTeacher = someTeacher;
        enteredPerson = new ArrayList<Person>();

    }

    // Allows to come into the room. Only one teacher can be in the room.

    public void accept(Person somePerson) {

        System.out.println("Student " + somePerson.getName() + " went into the room");
        enteredPerson.add(somePerson);
    }

    public Teacher getTeacher() {
        return this.someTeacher;
    }

    public List<Person> getEnteredPerson() {
        return enteredPerson;
    }

}
