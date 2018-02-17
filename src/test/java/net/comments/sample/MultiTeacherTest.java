package net.comments.sample;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class MultiTeacherTest {

    @Test
    public void testGetName() {
        MatcherAssert.assertThat(new MultiTeacher("Valentin").getName(), Matchers.is("Valentin"));
    }
}
