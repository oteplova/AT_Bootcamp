package net.comments.sample;

//The interface represents a room.

import java.util.List;

public interface Room {

    // Returns if there is student and/or teacher in the room.

    void accept(Person somePerson);

    Teacher getTeacher();

    List<Person> getEnteredPerson();

}
