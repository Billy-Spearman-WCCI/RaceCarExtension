import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OdometerTest {

    public static void main(String[] args) {
        Race.snoop(OdometerTest.class);
    }

    @Test
    public void testOdometerStartsAtZero() {
        Odometer odometer = new Odometer();
        assertEquals(0f, odometer.getCurrentMileage());
    }

    @Test
    public void testAddition() throws HackingException {
        Odometer odometer = new Odometer();
        odometer.increase(5);
        odometer.increase(100);
        assertEquals(105f, odometer.getCurrentMileage());
    }

    @Test
    public void testTampering() {
        Odometer odometer = new Odometer();

        // () -> {odometer.increase(-1);} is an "anonymous function" which is passed to
        // assertThrows for execution in a context which keeps track of whether an
        // HackingException has been called and complains if it isn't.
        assertThrows(HackingException.class, () -> {
            odometer.increase(-1);
        });
    }
}