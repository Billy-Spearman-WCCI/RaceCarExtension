import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OdometerTest {

    @Test
    public void testOdometerStartsAtZero() {
        Odometer odometer = new Odometer();
        assertEquals(0f, odometer.getCurrentMileage());
    }
}