package net.comments.sample;

//The interface represents a room.

public interface Room {

    // Returns if there is student and/or teacher in the room.

    boolean accept(Person somePerson);
}
