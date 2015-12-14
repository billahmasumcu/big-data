import org.junit.Test;
import static org.junit.Assert.assertEquals;

import de.due.ldsa.bd.DataSource;

public class DataSourceTest {
	private String data = "Hello World";
	
	@Test
	public void testSetAndGetSourceData() {
		DataSource source1 = new DataSource();	
		source1.setSourceData(data);
		
		DataSource source2 = new DataSource();	
		assertEquals(source2.getSourceData(), data);
	}
}
