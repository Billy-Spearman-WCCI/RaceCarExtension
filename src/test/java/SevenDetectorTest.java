import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SevenDetectorTest {
    @Test
    void startWithNoZeros() {
        SevenDetector detector = new SevenDetector();
        assertEquals(SevenDetector.STATE.NO7, detector.state());
    }

    @Test
    void acceptNothing() {
        SevenDetector detector = new SevenDetector();
        detector.noMoreData();
        assertEquals(SevenDetector.STATE.FAILURE, detector.state());
    }

    @Test
    void accept7() {
        SevenDetector detector = new SevenDetector();
        detector.accept(7);
        assertEquals(SevenDetector.STATE.ONE7, detector.state());
    }

    @Test
    void accept8() {
        SevenDetector detector = new SevenDetector();
        detector.accept(8);
        assertEquals(SevenDetector.STATE.NO7, detector.state());
    }

    @Test
    void accept78() {
        SevenDetector detector = new SevenDetector();
        detector.accept(7);
        detector.accept(8);
        assertEquals(SevenDetector.STATE.TWO7, detector.state());
    }

    @Test
    void accept788() {
        SevenDetector detector = new SevenDetector();
        detector.accept(7);
        detector.accept(8);
        detector.accept(8);
        assertEquals(SevenDetector.STATE.NO7, detector.state());
    }

    @Test
    void accept787() {
        SevenDetector detector = new SevenDetector();
        detector.accept(7);
        detector.accept(8);
        detector.accept(7);
        assertEquals(SevenDetector.STATE.SUCCESS, detector.state());
    }

    @Test
    void accept7887() {
        SevenDetector detector = new SevenDetector();
        detector.accept(7);
        detector.accept(8);
        detector.accept(8);
        detector.accept(7);
        detector.noMoreData();
        assertEquals(SevenDetector.STATE.FAILURE, detector.state());
    }

    @Test
    void accept77() {
        SevenDetector detector = new SevenDetector();
        detector.accept(7);
        detector.accept(7);
        assertEquals(SevenDetector.STATE.SUCCESS, detector.state());
    }

    @Test
    void accept888() {
        SevenDetector detector = new SevenDetector();
        detector.accept(8);
        detector.accept(8);
        detector.accept(8);
        assertEquals(SevenDetector.STATE.NO7, detector.state());
    }

    @Test
    void accept88andDone() {
        SevenDetector detector = new SevenDetector();
        detector.accept(8);
        detector.accept(8);
        detector.noMoreData();
        assertEquals(SevenDetector.STATE.FAILURE, detector.state());
    }

    @Test
    void accept77andDone() {
        SevenDetector detector = new SevenDetector();
        detector.accept(7);
        detector.accept(7);
        detector.noMoreData();
        assertEquals(SevenDetector.STATE.SUCCESS, detector.state());
    }

    @Test
    void accept777andDone() {
        SevenDetector detector = new SevenDetector();
        detector.accept(7);
        detector.accept(7);
        detector.accept(7);
        detector.noMoreData();
        assertEquals(SevenDetector.STATE.SUCCESS, detector.state());
    }

    @Test
    void accept77888andDone() {
        SevenDetector detector = new SevenDetector();
        detector.accept(7);
        detector.accept(7);
        detector.accept(8);
        detector.accept(8);
        detector.accept(8);
        detector.noMoreData();
        assertEquals(SevenDetector.STATE.SUCCESS, detector.state());
    }
}