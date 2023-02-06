import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMergeTest {
    @Test
    void test1() {
        final ArrayMerge am = new ArrayMerge();
        assertArrayEquals(
                new int[]{0, 1, 3, 4, 5, 11, 12, 13, 15, 16},
                am.merge(
                        new int[]{1, 3, 5, 11, 13, 15},
                        new int[]{0, 4, 12, 16}));

    }

    @Test
    void test2() {
        final ArrayMerge am = new ArrayMerge();
        assertArrayEquals(
                new int[]{0, 1, 3, 4, 5, 11, 12, 13, 15, 16},
                am.merge(
                        new int[]{0, 4, 12, 16},
                        new int[]{1, 3, 5, 11, 13, 15}
                ));

    }

    @Test
    void test3() {
        final ArrayMerge am = new ArrayMerge();
        assertArrayEquals(
                new int[]{0, 4, 12, 16},
                am.merge(
                        new int[]{0, 4, 12, 16},
                        new int[]{}
                ));

    }

    @Test
    void test4() {
        final ArrayMerge am = new ArrayMerge();
        assertArrayEquals(
                new int[]{0},
                am.merge(
                        new int[]{0},
                        new int[]{}
                ));

    }

    @Test
    void test5() {
        final ArrayMerge am = new ArrayMerge();
        assertArrayEquals(
                new int[]{},
                am.merge(
                        new int[]{},
                        new int[]{}
                ));

    }

    @Test
    void testDups() {
        final ArrayMerge am = new ArrayMerge();
        assertArrayEquals(
                new int[]{0, 1, 1, 3, 4, 5, 11, 12, 13, 15, 16},
                am.merge(
                        new int[]{1, 3, 5, 11, 13, 15},
                        new int[]{0, 1, 4, 12, 16}));

    }
}