import static org.junit.Assert.*;

import de.due.ldsa.bd.BigData;
import de.due.ldsa.bd.BigDataImpl;
import org.junit.Test;


public class BigDataTest {
    @Test
    public void testSayHelloMethod() {
        BigData classUnderTest = new BigDataImpl();
        assertEquals("sayHello should return 'Hello from big-data'", "Hello from big-data", classUnderTest.sayHello());
    }
}
