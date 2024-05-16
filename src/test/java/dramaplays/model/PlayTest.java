package dramaplays.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayTest {

    @Test
    void testNullName() {
        assertThrows(Exception.class, () -> new Play(null, "1"));
    }

    @Test
    void testNullType() {
        assertThrows(Exception.class, () -> new Play("amirhossein", null));
    }

    @Test
    void testValues() {
        String name = "amirhossein";
        String type = "0";
        Play play = new Play(name, type);
        assertEquals(play.name, name);
        assertEquals(play.type, type);
    }

}
