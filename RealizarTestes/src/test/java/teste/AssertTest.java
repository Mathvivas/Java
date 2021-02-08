package teste;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertTest {

    @Test
    void testAssertArrayEquals() {
        byte[] esperado = "teste".getBytes();
        byte[] atual = "teste".getBytes();
        assertArrayEquals(esperado, atual);
    }

    @Test
    void testAssertEquals() {
        assertEquals("text", "text");
    }

    @Test
    void testAssertFalse() {
        assertFalse(false);
    }

    @Test
    void testAssertNotNull() {
        assertNotNull(new Object());
    }

    @Test
    void testAssertNotSame() {
        assertNotSame(new Object(), new Object());
    }

    @Test
    void testAssertNull() {
        assertNull(null);
    }

    @Test
    void testAssertSame() {
        Integer aNumber = Integer.valueOf(765);
        assertSame(aNumber, aNumber);
    }
}
