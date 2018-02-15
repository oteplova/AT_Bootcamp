package net.comments.sample;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TrainingRoomUnlimitedTest {

    @Test
    public void testGetEnteredPersonExactOrder() {

        List<Person> enteredPerson = new ArrayList<Person>();
        AttentiveStudent student1 = new AttentiveStudent("Student1");
        AttentiveStudent student2 = new AttentiveStudent("Student2");
        BadStudent student3 = new BadStudent("Student3");
        BadStudent student4 = new BadStudent("Student4");
        MultiTeacher teacher1 = new MultiTeacher("Teacher1");
        MultiTeacher teacher2 = new MultiTeacher("Teacher2");

        enteredPerson.add(student1);
        enteredPerson.add(student2);
        enteredPerson.add(student3);
        enteredPerson.add(student4);
        enteredPerson.add(teacher1);
        enteredPerson.add(teacher2);

        MatcherAssert.assertThat(enteredPerson, IsIterableContainingInOrder.contains(student1, student2, student3, student4, teacher1, teacher2));

    }

    @Test
    public void testGetEnteredPersonAnyOrder() {

        List<Person> enteredPerson = new ArrayList<Person>();
        AttentiveStudent student1 = new AttentiveStudent("Student1");
        AttentiveStudent student2 = new AttentiveStudent("Student2");
        BadStudent student3 = new BadStudent("Student3");
        BadStudent student4 = new BadStudent("Student4");
        MultiTeacher teacher1 = new MultiTeacher("Teacher1");
        MultiTeacher teacher2 = new MultiTeacher("Teacher2");

        enteredPerson.add(student1);
        enteredPerson.add(student2);
        enteredPerson.add(student3);
        enteredPerson.add(student4);
        enteredPerson.add(teacher1);
        enteredPerson.add(teacher2);

        MatcherAssert.assertThat(enteredPerson, IsIterableContainingInAnyOrder.containsInAnyOrder(teacher1, student3, student1, student4, student2, teacher2));
    }

}
