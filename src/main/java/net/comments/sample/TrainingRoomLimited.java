package net.comments.sample;

// The class represents a room with limited size

import java.util.ArrayList;
import java.util.List;

public class TrainingRoomLimited implements Room {
    private final int size;
    private final List<Person> enteredPerson;

    // Allows to create a room with a given size

    public TrainingRoomLimited(int size) {
        enteredPerson = new ArrayList<Person>(size);
        this.size = size;
    }

    // Allows to come into the room.

    public void accept(Person somePerson) {

        if (enteredPerson.size() < this.size) {
            System.out.println(somePerson.getName() + " went into the room");
            enteredPerson.add(somePerson);
        } else {
            System.out.println(somePerson.getName() + " cannot enter into the room due to all seats are occupied");
        }
    }

    public List<Person> getEnteredPerson() {
        return enteredPerson;
    }
}
