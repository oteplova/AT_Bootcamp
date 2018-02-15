package net.comments.sample;

/**
 * The interface represents a room.
 */

import java.util.List;

public interface Room {
    /**
     * Allows person to come into the room.
     */
    void accept(Person somePerson);

    /**
     * Retuns list of persons which came into the room
     *
     * @return
     */
    List<Person> getEnteredPerson();

}
