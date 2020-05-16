package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return getHeader() + getStatementBody() + getStatementFooter();
    }

    private String getStatementFooter() {
        String result = "Amount owed is " + String.valueOf(totalAmount()) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints())
                + " frequent renter points";
        return result;
    }

    private String getStatementBody() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(rental.amount()) + "\n";
        }
        return result;
    }

    private String getHeader() {
        return "Rental Record for " + name + "\n";
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            double rentalAmount = rental.amount();
            totalAmount += rentalAmount;
        }
        return totalAmount;
    }

    private int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }


    public String htmlStatement() {
        return getHTMLHeader() + getHtmlBody() + getHtmlFooter();
    }

    private String getHtmlFooter() {
        String result = "Amount owed is <b>" + String.valueOf(totalAmount()) + "</b><br/>";
        result += "You earned <b>" + String.valueOf(frequentRenterPoints())
                + "</b> frequent renter points";
        return result;
    }

    private String getHtmlBody() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : rentals) {
            result.append(rental.getMovie().getTitle()).append(" <b>").append(String.valueOf(rental.amount())).append("</b><br/>");
        }
        return result.toString();
    }

    private String getHTMLHeader() {
        return "<h1>Rental Record for <b>" + name + "</b></h1><br/>";
    }
}

