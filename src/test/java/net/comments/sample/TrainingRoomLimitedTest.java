package net.comments.sample;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TrainingRoomLimitedTest {

    @Test
    public void testGetEnteredPerson() {
        List<Person> enteredPerson = new ArrayList<Person>();
        AttentiveStudent student1 = new AttentiveStudent("Student1");
        BadStudent student2 = new BadStudent("Student2");
        MultiTeacher teacher1 = new MultiTeacher("Teacher1");

        enteredPerson.add(student1);
        enteredPerson.add(student2);
        enteredPerson.add(teacher1);

        MatcherAssert.assertThat(enteredPerson, IsIterableContainingInOrder.contains(student1, student2, teacher1));
    }
}
