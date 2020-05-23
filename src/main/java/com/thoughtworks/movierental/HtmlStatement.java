package com.thoughtworks.movierental;

public class HtmlStatement {
    private final String name;
    private Rentals rentals;

    public HtmlStatement(String name, Rentals rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String htmlStatement() {
        return getHTMLHeader() + getHtmlBody() + getHtmlFooter();
    }

    private String getHtmlFooter() {
        String result = "Amount owed is <b>" + String.valueOf(rentals.totalAmount()) + "</b><br/>";
        result += "You earned <b>" + String.valueOf(rentals.frequentRenterPoints())
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
