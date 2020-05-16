package com.thoughtworks.movierental;

import java.util.List;

public class Statement {
    private final String name;
    private final double totalAmount;
    private final List<Rental> rentals;
    private final int frequentRentalPoint;

    public Statement(String name, double totalAmount, List<Rental> rentals, int frequentRentalPoint) {
        this.name = name;
        this.totalAmount = totalAmount;
        this.rentals = rentals;
        this.frequentRentalPoint = frequentRentalPoint;
    }

    public String statement() {
        return getHeader() + getStatementBody() + getStatementFooter();
    }

    String getStatementFooter() {
        String result = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRentalPoint)
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
