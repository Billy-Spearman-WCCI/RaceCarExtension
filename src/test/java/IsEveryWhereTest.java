import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsEveryWhereTest {
    @Test
    void test() {
        IsEveryWhere o = new IsEveryWhere();
        assertFalse(o.isEverywhere(new int[]{3, 1}, 2));
    }

}