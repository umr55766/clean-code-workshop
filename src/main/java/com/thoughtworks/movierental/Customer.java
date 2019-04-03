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

  public double getTotalAmountOwed(List<Rental> rentals) {
    double totalAmount = 0;

    for (Rental rental : rentals) {
      totalAmount += rental.getRentAmount();
    }

    return totalAmount;
  }

  public String statement() {
    String result = "Rental Record for " + getName() + "\n";

    for (Rental rental : rentals) {
      //show figures for this rental
      result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getRentAmount() + "\n";
    }

    //add footer lines result
    result += "Amount owed is " + getTotalAmountOwed(rentals) + "\n";
    result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

    return result;
  }

  private int getTotalFrequentRenterPoints() {
    int frequentRenterPoints = 0;

    for (Rental rental : rentals) {
      frequentRenterPoints += rental.frequentRenterPoints();
    }

    return frequentRenterPoints;
  }

}

