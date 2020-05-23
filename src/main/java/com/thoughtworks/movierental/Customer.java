package com.thoughtworks.movierental;

public class Customer {
    private final Rentals rentals = new Rentals();
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new Statement(name, rentals).statement();
    }


    public String htmlStatement() {
        return new HtmlStatement(name, rentals).htmlStatement();
    }

}

