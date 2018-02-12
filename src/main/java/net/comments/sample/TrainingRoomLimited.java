package net.comments.sample;

// The class represents a room with limited size

import java.util.ArrayList;
import java.util.List;

public class TrainingRoomLimited implements Room {
    private final int size;
    List<Person> enteredPerson;
    Teacher teacherInRoom = null;

    // Allows to create a room with a given size

    public TrainingRoomLimited(int size) {
        enteredPerson = new ArrayList<Person>(size);
        this.size = size;
    }

    // Allows to come into the room. Only one teacher can be in the room.

    public boolean accept(Person somePerson) {
        if (somePerson instanceof Teacher && teacherInRoom == null) {
            this.teacherInRoom = (Teacher) somePerson;
            System.out.println("Teacher " + somePerson.getName() + " went into the room");
            enteredPerson.add(this.teacherInRoom);
            return true;
        } else if (somePerson instanceof Student) {
            if (enteredPerson.size() < this.size - 1) {
                System.out.println("Student " + somePerson.getName() + " went into the room");
                enteredPerson.add(somePerson);
                return true;
            } else {
                System.out.println("We don’t learn a student if it is not in the room.");
                System.out.println("--------------------------------------");
            }

        }
        return false;
    }


}
