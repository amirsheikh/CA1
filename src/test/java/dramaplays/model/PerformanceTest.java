package dramaplays.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PerformanceTest {

    @Test
    void testPositiveAudience() {
        new Performance("0", 1);
    }

    @Test
    void testNegativeAudience() {
        assertThrows(Exception.class, () -> new Performance("0", -1));
    }

    @Test
    void testZeroAudience() {
        new Performance("0", 0);
    }

    @Test
    void testValues() {
        String playId = "0";
        int audience = 0;
        Performance performance = new Performance(playId, audience);
        assertEquals(playId, performance.playID);
        assertEquals(audience, performance.audience);

    }

    @Test
    void testNullPlayId() {
        assertThrows(Exception.class, () -> new Performance(null, -1));
    }

}
