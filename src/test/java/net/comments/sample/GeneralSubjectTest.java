package net.comments.sample;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class GeneralSubjectTest {

    @Test
    public void testGetSubjectName() {
        MatcherAssert.assertThat(new GeneralSubject("Math").getSubjectName(), Matchers.is("Math"));
    }
}