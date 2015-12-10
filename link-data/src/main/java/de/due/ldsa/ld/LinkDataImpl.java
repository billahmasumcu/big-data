package de.due.ldsa.ld;


import de.due.ldsa.bd.BigData;
import de.due.ldsa.bd.BigDataImpl;


public class LinkDataImpl implements LinkData {
    public String sayHello() {
        BigData bigData = new BigDataImpl();
        System.out.println(bigData.sayHello());
        return "Hello from link-data";
    }
}
