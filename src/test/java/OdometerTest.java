import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OdometerTest {

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
        assertThrows(Exception.class, () -> {
            odometer.increase(-1);
        });
    }
}