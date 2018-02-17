package net.comments.sample;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.testng.annotations.Test;

public class TrainingRoomLimitedTest {

    @Test
    public void testGetEnteredPerson() {
        AttentiveStudent student1 = new AttentiveStudent("Student1");
        BadStudent student2 = new BadStudent("Student2");
        MultiTeacher teacher1 = new MultiTeacher("Teacher1");

        Room room = new TrainingRoomLimited(3);

        room.accept(student1);
        room.accept(student2);
        room.accept(teacher1);

        MatcherAssert.assertThat(room.getEnteredPerson(), IsIterableContainingInOrder.contains(student1, student2, teacher1));
    }
}
