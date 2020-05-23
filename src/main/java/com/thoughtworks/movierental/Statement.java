package com.thoughtworks.movierental;

public class Statement {
    private final String name;
    private final Rentals rentals;

    public Statement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String statement() {
        return getHeader() + getStatementBody() + getStatementFooter();
    }

    String getStatementFooter() {
        String result = "Amount owed is " + String.valueOf(rentals.totalAmount()) + "\n";
        result += "You earned " + String.valueOf(rentals.frequentRenterPoints())
                + " frequent renter points";
        return result;
    }

    String getStatementBody() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(rental.amount()) + "\n";
        }
        return result;
    }

    String getHeader() {
        return "Rental Record for " + name + "\n";
    }
}
