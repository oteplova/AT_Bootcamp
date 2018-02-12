package net.comments.sample;

// The class represents a room with unlimited size

public class TrainingRoomUnlimited implements Room {

    private Teacher teacherInRoom = null;

// Allows to come into the room. Only one teacher can be in the room.

    public boolean accept(Person somePerson) {
        if (somePerson instanceof Teacher && teacherInRoom == null) {
            this.teacherInRoom = (Teacher) somePerson;
            System.out.println("Teacher " + somePerson.getName() + " went into the room");

            return true;
        } else if (somePerson instanceof Student) {
            System.out.println("Student " + somePerson.getName() + " went into the room");

            return true;
        }
        return false;
    }
}
