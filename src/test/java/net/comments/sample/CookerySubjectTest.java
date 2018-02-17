package net.comments.sample;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CookerySubjectTest {

    @Test
    public void testGetSubjectName() {
        MatcherAssert.assertThat(new CookerySubject().getSubjectName(), Matchers.is("bake a cake"));
    }
}
