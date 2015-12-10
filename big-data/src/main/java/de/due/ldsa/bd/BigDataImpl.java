package de.due.ldsa.bd;

import de.due.ldsa.db.Database;
import de.due.ldsa.db.DatabaseImpl;


public class BigDataImpl implements BigData {

    public String sayHello() {
        Database db = new DatabaseImpl();
        System.out.println(db.sayHello());
        return "Hello from big-data";
    }
}
