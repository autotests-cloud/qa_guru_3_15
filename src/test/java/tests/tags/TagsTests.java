package tests.tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TagsTests {

    //add task smoke in build.gradle file
    @Test
    @Tag("smoke")
    @Tag("regress")
    void simpleSmokeTest() {
        assertEquals(2, 2);
    }

    //add task regress in build.gradle file
    @Test
    @Tag("regress")
    void simpleRegressTest() {
        assertEquals(2, 2);
    }

    //add task feature in build.gradle file
    @Test
    @Tag("feature")
    @Tag("regress")
    void simpleFeatureTest() {
        assertEquals(2, 2);
    }
}
