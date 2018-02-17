package net.comments.sample;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.testng.annotations.Test;

public class TrainingRoomUnlimitedTest {

    @Test
    public void testGetEnteredPersonExactOrder() {

        AttentiveStudent student1 = new AttentiveStudent("Student1");
        AttentiveStudent student2 = new AttentiveStudent("Student2");
        BadStudent student3 = new BadStudent("Student3");
        BadStudent student4 = new BadStudent("Student4");
        MultiTeacher teacher1 = new MultiTeacher("Teacher1");
        MultiTeacher teacher2 = new MultiTeacher("Teacher2");
        Room room = new TrainingRoomUnlimited();

        room.accept(student1);
        room.accept(student2);
        room.accept(student3);
        room.accept(student4);
        room.accept(teacher1);
        room.accept(teacher2);

        MatcherAssert.assertThat(room.getEnteredPerson(), IsIterableContainingInOrder.contains(student1, student2, student3, student4, teacher1, teacher2));
    }

    @Test
    public void testGetEnteredPersonAnyOrder() {

        AttentiveStudent student1 = new AttentiveStudent("Student1");
        AttentiveStudent student2 = new AttentiveStudent("Student2");
        BadStudent student3 = new BadStudent("Student3");
        BadStudent student4 = new BadStudent("Student4");
        MultiTeacher teacher1 = new MultiTeacher("Teacher1");
        MultiTeacher teacher2 = new MultiTeacher("Teacher2");

        Room room = new TrainingRoomUnlimited();

        room.accept(teacher1);
        room.accept(student3);
        room.accept(student1);
        room.accept(student4);
        room.accept(student2);
        room.accept(teacher2);

        MatcherAssert.assertThat(room.getEnteredPerson(), IsIterableContainingInAnyOrder.containsInAnyOrder(teacher1, student3, student1, student4, student2, teacher2));
    }
}
