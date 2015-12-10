import de.due.ldsa.ts.TrackingService;
import de.due.ldsa.ts.TrackingServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrackingServiceTest {
    @Test
    public void testSomeLibraryMethod() {
        TrackingService classUnderTest = new TrackingServiceImpl();
        assertEquals("sayHello should return 'Hello from tracking-service'", "Hello from tracking-service", classUnderTest.sayHello());
    }
}
