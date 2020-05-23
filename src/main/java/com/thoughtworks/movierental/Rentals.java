package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {

    double totalAmount() {
        double totalAmount = 0;
        for (Rental rental : this) {
            double rentalAmount = rental.amount();
            totalAmount += rentalAmount;
        }
        return totalAmount;
    }

    int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : this) {
            frequentRenterPoints += rental.frequentRenterPoints();
        }
        return frequentRenterPoints;
    }

}
