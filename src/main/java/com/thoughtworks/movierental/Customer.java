package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.movierental.HtmlUtils.*;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public List<Rental> getRental() {
    return rentals;
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

  public String htmlStatement() {
    String result = getAsHeading("Rental Record for " + getAsBold(getName()) + LINE_BREAK);

    for (Rental rental : rentals) {
      //show figures for this rental
      result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getRentAmount() + LINE_BREAK;
    }

    //add footer lines result
    result += "Amount owed is " + getAsBold(getTotalAmountOwed(rentals)) + LINE_BREAK;
    result += "You earned " + getAsBold(getTotalFrequentRenterPoints()) + " frequent renter points";

    return result;
  }

  public int getTotalFrequentRenterPoints() {
    int frequentRenterPoints = 0;

    for (Rental rental : rentals) {
      frequentRenterPoints += rental.frequentRenterPoints();
    }

    return frequentRenterPoints;
  }

}

