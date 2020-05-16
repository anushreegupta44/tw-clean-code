package com.thoughtworks.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void shouldReturnStatement() {
        Customer customer = new Customer("Anushree");
        customer.addRental(new Rental(new Movie("Little Women", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("Doctor Strange", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("Loving Vincent", Movie.REGULAR), 3));
        customer.addRental(new Rental(new Movie("Hera Pheri", Movie.CHILDRENS), 5));
        assertEquals("Rental Record for Anushree\n" +
                "\tLittle Women\t1.5\n" +
                "\tDoctor Strange\t9.0\n" +
                "\tLoving Vincent\t3.5\n" +
                "\tHera Pheri\t4.5\n" +
                "Amount owed is 18.5\n" +
                "You earned 5 frequent renter points", customer.statement());
    }

}
