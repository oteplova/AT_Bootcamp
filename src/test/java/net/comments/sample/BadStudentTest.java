package net.comments.sample;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class BadStudentTest {

    @Test
    public void testGetName() {
        MatcherAssert.assertThat(new BadStudent("Egor Egir").getName(), Matchers.is("Egor Egir"));
    }
}