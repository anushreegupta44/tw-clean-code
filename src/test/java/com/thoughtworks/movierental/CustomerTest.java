package com.thoughtworks.movierental;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer;

    @Before
    public void setup() {
        customer = new Customer("Anushree");
        customer.addRental(new Rental(new Movie("Little Women", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("Doctor Strange", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("Loving Vincent", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Hera Pheri", Movie.CHILDRENS), 5));

    }

    @Test
    public void shouldReturnStatement() {
        assertEquals("Rental Record for Anushree\n" +
                "\tLittle Women\t1.5\n" +
                "\tDoctor Strange\t9.0\n" +
                "\tLoving Vincent\t3.5\n" +
                "\tHera Pheri\t4.5\n" +
                "Amount owed is 18.5\n" +
                "You earned 5 frequent renter points", customer.statement());
    }

    @Test
    public void shouldReturnHTMLStatement() {
        assertEquals("<h1>Rental Record for <b>Anushree</b></h1><br/>" +
                "Little Women <b>1.5</b><br/>" +
                "Doctor Strange <b>9.0</b><br/>" +
                "Loving Vincent <b>3.5</b><br/>" +
                "Hera Pheri <b>4.5</b><br/>" +
                "Amount owed is <b>18.5</b><br/>" +
                "You earned <b>5</b> frequent renter points", customer.htmlStatement());
    }

}
