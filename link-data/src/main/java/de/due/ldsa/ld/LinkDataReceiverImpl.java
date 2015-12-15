package de.due.ldsa.ld;

import de.due.ldsa.bd.DataProvider;
import de.due.ldsa.bd.DataSource;

public class LinkDataReceiverImpl implements LinkDataReceiver {

	@Override
	public void setData(Object obj) {
		DataSource dataSource = new DataProvider();
		dataSource.setSourceData(obj.toString());
	}

}
