package net.comments.sample;

// The class represents a room with unlimited size

import java.util.ArrayList;
import java.util.List;

public class TrainingRoomUnlimited implements Room {
    private Teacher someTeacher;
    private final List<Person> enteredPerson;

    public TrainingRoomUnlimited() {
        enteredPerson = new ArrayList<Person>();

    }

    // Allows to come into the room.

    public void accept(Person somePerson) {

        System.out.println(somePerson.getName() + " went into the room");
        enteredPerson.add(somePerson);
    }

    public List<Person> getEnteredPerson() {
        return enteredPerson;
    }

}
