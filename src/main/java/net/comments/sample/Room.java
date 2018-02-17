package net.comments.sample;

/**
 * The interface represents a room.
 */

import java.util.List;

public interface Room {
    /**
     * Allows person to come into the room.
     *
     * @param somePerson
     */
    void accept(Person somePerson);

    /**
     * Returns list of persons which came into the room
     */
    List<Person> getEnteredPerson();

}
