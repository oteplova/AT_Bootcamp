package net.comments.sample;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class AttentiveStudentTest {

    @Test
    public void testGetName() {
        MatcherAssert.assertThat(new AttentiveStudent("Alisa").getName(), Matchers.is("Alisa"));
    }
}