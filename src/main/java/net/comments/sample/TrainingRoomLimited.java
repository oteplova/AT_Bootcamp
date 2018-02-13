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
                System.out.println("We don’t learn a student if it is not in the room.");
                System.out.println("--------------------------------------");
                //enteredPerson.add(somePerson);
            }

        }

    public List<Person> getEnteredPerson() {
        return enteredPerson;
    }
}
