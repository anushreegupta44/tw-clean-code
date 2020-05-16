package com.thoughtworks.movierental;

import java.util.List;

public class HtmlStatement {
    private final String name;
    private final int frequentRentalPoints;
    private final List<Rental> rentals;
    private final double totalAmount;

    public HtmlStatement(String name, int frequentRentalPoints, List<Rental> rentals, double totalAmount) {
        this.name = name;
        this.frequentRentalPoints = frequentRentalPoints;
        this.rentals = rentals;
        this.totalAmount = totalAmount;
    }

    public String htmlStatement() {
        return getHTMLHeader() + getHtmlBody() + getHtmlFooter();
    }

    String getHtmlFooter() {
        String result = "Amount owed is <b>" + String.valueOf(totalAmount) + "</b><br/>";
        result += "You earned <b>" + String.valueOf(frequentRentalPoints)
                + "</b> frequent renter points";
        return result;
    }

    String getHtmlBody() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentals) {
            result.append(rental.getMovie().getTitle()).append(" <b>").append(String.valueOf(rental.amount())).append("</b><br/>");
        }
        return result.toString();
    }

    String getHTMLHeader() {
        return "<h1>Rental Record for <b>" + name + "</b></h1><br/>";
    }
}
