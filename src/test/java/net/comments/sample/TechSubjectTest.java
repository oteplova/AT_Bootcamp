package net.comments.sample;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class TechSubjectTest {

    @Test
    public void testGetSubjectName() {
        MatcherAssert.assertThat(new TechSubject().getSubjectName(), Matchers.is("use Git"));
    }
}