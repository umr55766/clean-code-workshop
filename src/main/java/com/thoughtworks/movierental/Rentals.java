package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Rentals {
    private Customer customer;
    private List<Rental> rentals;

    public Rentals(Customer customer) {
        this.customer = customer;
        rentals = new ArrayList<>();
    }

    protected List<Rental> getRentals() {
        return rentals;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;

        for (Rental rental : rentals) {
            frequentRenterPoints += rental.frequentRenterPoints();
        }

        return frequentRenterPoints;
    }

    public double getTotalAmountOwed() {
        double totalAmount = 0;

        for (Rental rental : rentals) {
            totalAmount += rental.getRentAmount();
        }

        return totalAmount;
    }
}
