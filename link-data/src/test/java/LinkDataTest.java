import de.due.ldsa.ld.LinkData;
import de.due.ldsa.ld.LinkDataImpl;
import org.junit.Test;
import static org.junit.Assert.*;


public class LinkDataTest {
    @Test public void testSomeLibraryMethod() {
        LinkData classUnderTest = new LinkDataImpl();
        assertEquals("sayHello should return 'Hello from link-data'","Hello from link-data", classUnderTest.sayHello());
    }
}
