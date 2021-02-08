package teste;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class ExceptionTest {

    @Test (expected = IndexOutOfBoundsException.class)
    public void empty() {
        new ArrayList<Object>().get(0);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
        List<Object> list = new ArrayList<Object>();

        thrown.expect(IndexOutOfBoundsException.class);
        list.get(0);
    }

//    @Test (expected = IndexOutOfBoundsException.class)
//    public void fail() {
//        List<String> lista = new ArrayList<String>();
//        lista.add("Matheus");
//        lista.get(0);
//    }
}
