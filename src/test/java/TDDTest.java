import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TDDTest {
    @Test
    public void test1() {
        TDD tdd = new TDD();
        assertEquals("1", tdd.say(1));
    }

    @Test
    public void test2() {
        TDD tdd = new TDD();
        assertEquals("2", tdd.say(2));
    }

    @Test
    public void test3() {
        TDD tdd = new TDD();
        assertEquals("Fizz", tdd.say(3));
    }

    @Test
    public void test5() {
        TDD tdd = new TDD();
        assertEquals("Buzz", tdd.say(5));
    }

    @Test
    public void test6() {
        TDD tdd = new TDD();
        assertEquals("Fizz", tdd.say(6));
    }

    @Test
    public void test7() {
        TDD tdd = new TDD();
        assertEquals("Qix", tdd.say(7));
    }

    @Test
    public void test10() {
        TDD tdd = new TDD();
        assertEquals("Buzz", tdd.say(10));
    }

    @Test
    public void test15() {
        TDD tdd = new TDD();
        assertEquals("FizzBuzz", tdd.say(15));
    }
}