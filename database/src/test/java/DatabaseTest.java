import de.due.ldsa.db.Database;
import de.due.ldsa.db.DatabaseImpl;
import org.junit.Test;

import static org.junit.Assert.*;


public class DatabaseTest {
    @Test
    public void testSayHelloMethod() {
        Database classUnderTest = new DatabaseImpl();
        assertEquals("sayHello should return 'Hello form database'", "Hello form database", classUnderTest.sayHello());
    }
}
